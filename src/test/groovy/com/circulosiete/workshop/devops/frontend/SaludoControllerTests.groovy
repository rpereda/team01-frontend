package com.circulosiete.workshop.devops.frontend

import org.springframework.ui.Model

import com.circulosiete.workshop.devops.frontend.service.BackendService
import com.circulosiete.workshop.devops.frontend.service.Saludo


import spock.lang.Specification

class SaludoControllerTests extends Specification {

    def 'probando controller'() {
        given:

        def saludo = new Saludo(nombre: 'Saludo de Prueba')

        BackendService service = Stub()
        service.getSaludo() >> saludo.getNombre()
        def controller = new SaludoController(service)

        Model model = Mock()

        when:
        controller.saludo(model)

        then:
        1 * model.addAttribute("saludo", saludo.getNombre())
    }
}
