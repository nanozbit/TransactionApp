package org.nanozbit.services.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "client")
@Component
@Data
public class ClientProperties {
    private String url;
}
