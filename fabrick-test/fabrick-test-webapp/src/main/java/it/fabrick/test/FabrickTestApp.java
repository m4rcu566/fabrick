package it.fabrick.test;

import it.fabrick.test.implementations.external.feigninterface.FeignAccountApiInterface;
import it.fabrick.test.model.repository.HistoryTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration
@ComponentScan(basePackages = {"it.fabrick.test.autogen", "it.fabrick.test", "it.fabrick.test.impl"})
@AutoConfiguration
public class FabrickTestApp {

    public static void main(String[] args) {
        SpringApplication.run(FabrickTestApp.class, args);
    }

}
