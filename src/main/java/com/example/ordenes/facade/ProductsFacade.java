package com.example.ordenes.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductsFacade {

  @Value("${getProduct.url}")
  private String getProductUrl;

  @Autowired
  private  RestTemplate restTemplate;

  public boolean consultarDisponibilidad (int productoId,int cantidad){
    try{


      HttpHeaders headers = new HttpHeaders();
      headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
      HttpEntity<?> entity = new HttpEntity<>(headers);

      String urlTemplate = UriComponentsBuilder.fromHttpUrl(getProductUrl)
              .queryParam("productoId", "{productoId}")
              .queryParam("cantidad", "{cantidad}")
              .encode()
              .toUriString();

      Map<String, Integer> params = new HashMap<>();
      params.put("productoId", productoId);
      params.put("cantidad", cantidad);

      HttpEntity<Boolean> response = restTemplate.exchange(
              urlTemplate,
              HttpMethod.GET,
              entity,
              Boolean.class,
              params
      );


        return response.getBody();
    }catch (Exception e){
      System.out.println("ha ocurrido un error al consumir el endpoint");
      return false;
    }

  }



  public boolean actualizarStock(int productoId,int cantidad){
    try{


      HttpHeaders headers = new HttpHeaders();
      headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
      HttpEntity<?> entity = new HttpEntity<>(headers);

      String urlTemplate = UriComponentsBuilder.fromHttpUrl(getProductUrl)
              .queryParam("productoId", "{productoId}")
              .queryParam("cantidad", "{cantidad}")
              .encode()
              .toUriString();

      Map<String, Integer> params = new HashMap<>();
      params.put("productoId", productoId);
      params.put("cantidad", cantidad);

      HttpEntity<Boolean> response = restTemplate.exchange(
              urlTemplate,
              HttpMethod.PUT,
              entity,
              Boolean.class,
              params
      );


        return response.getBody();
    }catch (Exception e){
      System.out.println("ha ocurrido un error al consumir el endpoint");
      return false;
    }

  }



}
