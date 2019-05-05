package com.circulosiete.workshop.devops.frontend;

import com.circulosiete.workshop.devops.frontend.service.BackendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaludoController {

  private final BackendService service;

  public SaludoController(BackendService service) {
    this.service = service;
  }

  @GetMapping("/saludo")
  public String saludo(Model model) {
    String saludo = service.getSaludo();
    model.addAttribute("saludo", saludo);
    return "saludo";
  }
}
