package it.fabrick.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
        classes = {BaseContextTestConfiguration.class}
)
@AutoConfigureMockMvc
public abstract class BaseControllerTest {

    @Autowired
    public MockMvc mockMvc;
}
