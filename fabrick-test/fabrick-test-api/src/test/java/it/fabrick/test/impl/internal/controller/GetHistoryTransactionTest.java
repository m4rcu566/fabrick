package it.fabrick.test.impl.internal.controller;

import feign.FeignException;
import feign.Request;
import feign.Response;
import it.fabrick.test.BaseControllerTest;
import it.fabrick.test.autogen.internal.dtos.Error;
import it.fabrick.test.implementations.external.feigninterface.FeignAccountApiInterface;
import it.fabrick.test.model.dtos.HistoryTransaction;
import it.fabrick.test.utils.JsonUtilsTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GetHistoryTransactionTest extends BaseControllerTest {

    @MockBean
    private FeignAccountApiInterface feignAccountApiInterface;

    @Test
    @Sql("file:src/test/resources/script/init_db.sql")
    public void getHistoryTransactionOk() throws Exception {

        String feignResponseMocked = mockResponseFeign();

        Mockito.when(feignAccountApiInterface.getTransactions(anyLong(), any(LocalDate.class), any(LocalDate.class), anyString(), anyString(), anyString()))
                .thenReturn(ResponseEntity.ok(feignResponseMocked));

        String mockResponse = mockMvc.perform(get("/api/test/v1/account/{accountId}/transactions", 14537780)
                        .param("fromDate", "2019-01-01")
                        .param("toDate","2019-04-01")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        List<HistoryTransaction> history = Arrays.asList((HistoryTransaction[]) JsonUtilsTest.stringToObjectArray(mockResponse, HistoryTransaction[].class, "payload"));

        assertNotNull(history);
        assertEquals(3, history.size());

    }

    @Test
    public void getHistoryTransactionKoErrorFormatDate() throws Exception {

        String aspectErroreCode = "REQ017";

        Mockito.when(feignAccountApiInterface.getTransactions(anyLong(), any(LocalDate.class), any(LocalDate.class), anyString(), anyString(), anyString()))
                .thenThrow(FeignException.errorStatus("Method Name", Response.builder()
                        .status(400)
                        .reason("Bad Request")
                        .request(Request
                                .create(Request.HttpMethod.GET, "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}/transactions", new HashMap<>(), null, null, null))
                        .body(mockResponseFeignError().getBytes())
                        .build()));

        String mockResponse = mockMvc.perform(get("/api/test/v1/account/{accountId}/transactions", 14537780)
                        .param("fromDate", "2020-01-01")
                        .param("toDate","2019-04-01")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<Error> response = Arrays.asList((Error[]) JsonUtilsTest.stringToObjectArray(mockResponse, Error[].class, "errors"));

        assertNotNull(response);
        response.stream().forEach(a->assertEquals(aspectErroreCode, a.getCode()));
    }

    private String mockResponseFeign() {
        return "{\n" +
                "    \"status\": \"OK\",\n" +
                "    \"error\": [],\n" +
                "    \"payload\": {\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"transactionId\": \"282831\",\n" +
                "                \"operationId\": \"00000000282831\",\n" +
                "                \"accountingDate\": \"2019-11-29\",\n" +
                "                \"valueDate\": \"2019-12-01\",\n" +
                "                \"type\": {\n" +
                "                    \"enumeration\": \"GBS_TRANSACTION_TYPE\",\n" +
                "                    \"value\": \"GBS_ACCOUNT_TRANSACTION_TYPE_0050\"\n" +
                "                },\n" +
                "                \"amount\": -343.77,\n" +
                "                \"currency\": \"EUR\",\n" +
                "                \"description\": \"PD VISA CORPORATE 10\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"transactionId\": \"1460159524001\",\n" +
                "                \"operationId\": \"19000191134336\",\n" +
                "                \"accountingDate\": \"2019-11-11\",\n" +
                "                \"valueDate\": \"2019-11-09\",\n" +
                "                \"type\": {\n" +
                "                    \"enumeration\": \"GBS_TRANSACTION_TYPE\",\n" +
                "                    \"value\": \"GBS_ACCOUNT_TRANSACTION_TYPE_0010\"\n" +
                "                },\n" +
                "                \"amount\": 854.00,\n" +
                "                \"currency\": \"EUR\",\n" +
                "                \"description\": \"BD LUCA TERRIBILE        DA 03268.49130         DATA ORDINE 09112019 COPERTURA VISA\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"transactionId\": \"398894\",\n" +
                "                \"operationId\": \"00000000398894\",\n" +
                "                \"accountingDate\": \"2019-01-31\",\n" +
                "                \"valueDate\": \"2019-02-01\",\n" +
                "                \"type\": {\n" +
                "                    \"enumeration\": \"GBS_TRANSACTION_TYPE\",\n" +
                "                    \"value\": \"GBS_ACCOUNT_TRANSACTION_TYPE_0050\"\n" +
                "                },\n" +
                "                \"amount\": -95.73,\n" +
                "                \"currency\": \"EUR\",\n" +
                "                \"description\": \"PD VISA CORPORATE 12\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
    }

    private String mockResponseFeignError() {
        return "{\n" +
                "    \"status\": \"KO\",\n" +
                "    \"errors\": [\n" +
                "        {\n" +
                "            \"code\": \"REQ017\",\n" +
                "            \"description\": \"Invalid date format\",\n" +
                "            \"params\": \"\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"payload\": {}\n" +
                "}";
    }
}
