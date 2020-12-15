package com.example.demo.controllers.pdf;

import com.example.demo.services.pdf.PdfService;
import com.example.demo.utilities.pdf.PdfBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pdf")
public class PdfResource {
@Autowired
private PdfService pdfService;
    public static final String PDFS = "/pdfs";

    @GetMapping(value="/test",produces = {"application/pdf", "application/json"})
    public ResponseEntity<?> pdf(@RequestParam String idFactura) {
        return ResponseEntity.status(HttpStatus.OK).body(pdfService.crearPdf(idFactura));
    }
    /*
    @GetMapping("/crear")
    public ResponseEntity<?> crearPdf() {
        return ResponseEntity.status(HttpStatus.OK).body(pdfService.crearPdf());

    }
    */
}
