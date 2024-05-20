package org.example.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

@Configuration
@EnableFeignClients(basePackages = "org.example.service")
public class FeignClientConfig {

    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String clientId;

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2AuthorizedClientManager clientManager) {
        return requestTemplate -> {
            var authorizedClient = clientManager.authorize(
                    OAuth2AuthorizeRequest.withClientRegistrationId("keycloak")
                            .principal(clientId)
                            .build()
            );
            if (authorizedClient != null) {
                var accessToken = authorizedClient.getAccessToken().getTokenValue();
                requestTemplate.header("Authorization", "Bearer " + accessToken);
            }
        };
    }
}
