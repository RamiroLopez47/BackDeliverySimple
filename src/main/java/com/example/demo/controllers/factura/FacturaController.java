package com.example.demo.controllers.factura;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.factura.Factura;
import com.example.demo.services.email.EmailService;
import com.example.demo.services.factura.FacturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/factura")
public class FacturaController extends BaseController<Factura, FacturaService> {
  
    @Autowired
  private  EmailService emailService;
    @PostMapping("/enviar")
	public ResponseEntity<?> sendEmail(@RequestParam(value = "") String destinatario,@RequestParam(value = "") String asunto,@RequestParam(value = "") String mensaje,@RequestParam(value = "") String idFactura,@RequestParam(value = "") String nombreArchivo) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(emailService.enviarEmail(destinatario,asunto,mensaje,nombreArchivo,idFactura));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error al enviar email: \"" + e.getMessage() + "\"}");
		}
	}

}