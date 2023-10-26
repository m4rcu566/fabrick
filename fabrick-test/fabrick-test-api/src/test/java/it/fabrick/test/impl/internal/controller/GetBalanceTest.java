package it.fabrick.test.impl.internal.controller;

import feign.FeignException;
import feign.Request;
import feign.Response;
import it.fabrick.test.BaseControllerTest;
import it.fabrick.test.autogen.internal.dtos.Error;
import it.fabrick.test.implementations.external.feigninterface.FeignAccountApiInterface;
import it.fabrick.test.model.dtos.Balance;
import it.fabrick.test.utils.JsonUtilsTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableFeignClients
public class GetBalanceTest extends BaseControllerTest {

    @MockBean
    private FeignAccountApiInterface feignAccountApiInterface;

    @Test
    public void getBalanceOk() throws Exception {

        String feignResponseMocked = mockResponseFeign();

        Balance mockResponseFeign = (Balance) JsonUtilsTest.stringToObject(feignResponseMocked, Balance.class, "payload");

        Mockito.when(feignAccountApiInterface.getBalance(anyLong(), anyString(), anyString(), anyString()))
                .thenReturn(ResponseEntity.ok(feignResponseMocked));

        String mockResponse = mockMvc.perform(get("/api/test/v1/account/{accountId}/balance", 14537780)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        Balance response = (Balance) JsonUtilsTest.stringToObject(mockResponse, Balance.class, "payload");

        assertEquals(mockResponseFeign.getAvailableBalance(), response.getAvailableBalance());
    }

    @Test
    public void getBalanceKoWrongAccountId() throws Exception {

        String aspectErroreCode = "REQ004";

        Mockito.when(feignAccountApiInterface.getBalance(anyLong(), anyString(), anyString(), anyString()))
                .thenThrow(FeignException.errorStatus("Method Name", Response.builder()
                        .status(400)
                        .reason("Bad Request")
                        .request(Request
                                .create(Request.HttpMethod.GET, "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}/balance", new HashMap<>(), null, null, null))
                        .body(mockResponseFeignError().getBytes())
                        .build()));

        String mockResponse = mockMvc.perform(get("/api/test/v1/account/{accountId}/balance", 1453778)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<Error> errors = Arrays.asList((Error[]) JsonUtilsTest.stringToObjectArray(mockResponse, Error[].class, "errors"));

        assertNotNull(errors);
        errors.stream().forEach(a->assertEquals(aspectErroreCode, a.getCode()));

    }

    private String mockResponseFeign() {
        return "{\n" +
                "    \"status\": \"OK\",\n" +
                "    \"error\": [],\n" +
                "    \"payload\": {\n" +
                "        \"date\": \"2023-10-17\",\n" +
                "        \"balance\": -56.36,\n" +
                "        \"availableBalance\": -56.36,\n" +
                "    }\n" +
                "}";
    }

    private String mockResponseFeignError() {
        return "{\n" +
                "    \"status\": \"KO\",\n" +
                "    \"errors\": [\n" +
                "        {\n" +
                "            \"code\": \"REQ004\",\n" +
                "            \"description\": \"Invalid account identifier\",\n" +
                "            \"params\": \"\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"payload\": {}\n" +
                "}";
    }
}
