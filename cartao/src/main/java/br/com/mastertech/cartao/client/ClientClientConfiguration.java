package br.com.mastertech.cartao.client;

import feign.Feign;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class ClientClientConfiguration {

    @Bean
    ErrorDecoder getErrorDecoder() {
        return new ClienteClientErrorDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorator = FeignDecorators.builder()
                .withFallbackFactory(ClienteClientFallback::new)
                .build();

        return Resilience4jFeign.builder(decorator);
    }
}
