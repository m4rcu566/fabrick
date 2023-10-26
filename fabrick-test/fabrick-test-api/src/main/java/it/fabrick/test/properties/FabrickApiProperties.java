package it.fabrick.test.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "properties.fabrick.headers")
@Component
public class FabrickApiProperties {

    private String xTimeZone;
    private String authSchema;
    private String apiKey;

    public String getxTimeZone() {
        return xTimeZone;
    }

    public void setxTimeZone(String xTimeZone) {
        this.xTimeZone = xTimeZone;
    }

    public String getAuthSchema() {
        return authSchema;
    }

    public void setAuthSchema(String authSchema) {
        this.authSchema = authSchema;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
