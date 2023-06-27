package com.example.ordenes.facade;

import com.example.ordenes.model.pojo.OrdenEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderFacade {

    @Value("${getProduct.url}")
    private String getProductUrl;

    private final RestTemplate restTemplate;
    public void saveProduct(OrdenEntity ordenEntity) {

        try {
            restTemplate.postForObject(getProductUrl, ordenEntity, OrdenEntity.class);
        } catch (HttpClientErrorException e) {
            log.error("Client Error: {}, Product with ID {}", e.getStatusCode(), ordenEntity);

        }
    }
}
