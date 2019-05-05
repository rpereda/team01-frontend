package com.circulosiete.workshop.devops.frontend.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BackendService {
  private final RestTemplate restTemplate;

  public BackendService() {
    this.restTemplate = new RestTemplate();
  }

  public String getSaludo() {
    String saludoServiceURI =
            Strings.isNotBlank(System.getenv("BACKEND_SERVICE_URL")) ? System.getenv("BACKEND_SERVICE_URL"): "http://localhost:8090";
    saludoServiceURI += "/v1/saludos";

    ResponseEntity<Saludo> response = restTemplate.getForEntity(saludoServiceURI, Saludo.class);
    return response.getBody().getNombre();
  }
}
