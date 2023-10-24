package it.fabrick.test.implementations.external.feigninterface;


import it.fabrick.test.autogen.external.api.AccountApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "AccountApi", url = "https://sandbox.platfr.io")
public interface FeignAccountApiInterface extends AccountApi {
}
