package br.com.mastertech.cartao.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class ClientClientConfiguration {

    @Bean
    ErrorDecoder getErrorDecoder() {
        return new ClienteClientErrorDecoder();
    }
}
