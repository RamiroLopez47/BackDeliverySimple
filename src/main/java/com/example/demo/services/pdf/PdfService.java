package com.example.demo.services.pdf;

import java.io.FileNotFoundException;
import java.util.Optional;

import com.example.demo.entities.factura.Factura;
import com.example.demo.entities.pedido.Pedido;
import com.example.demo.repositories.factura.FacturaRepository;
import com.example.demo.services.factura.FacturaService;
import com.example.demo.services.pedido.PedidoService;
import com.example.demo.utilities.pdf.PdfBuilder;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdfService {

  @Autowired
  FacturaRepository facturaRepository;
  @Autowired
  PedidoService pedidoService;
  /*
   * public static final String destino = "E:/pdfs/primer.pdf";
   * 
   * public boolean crearPdf() {
   * 
   * try{ PdfWriter pdfWriter= new PdfWriter(destino); PdfDocument pdfDocument=
   * new PdfDocument(pdfWriter); Document document = new Document(pdfDocument);
   * document.add(new Paragraph("Este es un parrafo")); document.close(); return
   * true; }catch(Exception e){ return false; }
   * 
   * 
   * 
   * }
   */

  public byte[] crearPdf(String idFactura) {
    Long id = Long.parseLong(idFactura);
    Optional<Factura> facturaOp = facturaRepository.findById(id);
 Factura factura= facturaOp.get();
double formaPagoCantidad=factura.getPedido().getFormaPago().getCantidadPagado();
 String formaPago= factura.getPedido().getFormaPago().getClass().toString();

double total=pedidoService.calcularTotal(factura.getPedido());
double precioFinal = total;
double vuelto= 0; 

if (!factura.getPedido().getConDelivery()) {
	precioFinal = precioFinal * 0.9;
}

vuelto = formaPagoCantidad - precioFinal;

 if(formaPago.contains("Efectivo")){
   formaPago="EFECTIVO";
 }else{
   formaPago="TARJETA";
 }
 //Pedido pedido= factura.getPedido();
 String descuento= String.valueOf(factura.getDescuento());
 //String fecha= String.valueOf(factura.getFecha());
 //String formaPago=(factura.getFormaPago().getClass().toString());

 String numero= String.valueOf(factura.getNumero());
 //String nroPedido= String.valueOf(factura.getPedido().getNumero());

    return new PdfBuilder("/pdfs")
  .paragraphEmphasized("EL BUEN SABOR").line()
  .paragraph("Av. Las Heras 2020, Ciudad Mendoza Argentina")
  .paragraph("Inicio de Actividades 21/11/2017"
          + "Ingresos Brutos 913-203020"
          + "Nro Estab 04-23503845-234-2343 ST01"+
          "Cuit Nro.:23-5020202020-1"+
          "IVA RESPONSABLE INSCRIPTO"+
          "A CONSUMIDOR FINAL"+
          "NRO 141").line()
          .paragraph(String.valueOf(factura.getFecha()))
  .barCode("8015187008499").line()
  .qrCode("http://localhost:4200/home").line()
  .image("src/main/java/com/example/demo/chau.jpg").line() 
  .table(20, 10, 15, 15)
.rowsDetallePedido(factura.getPedido())
  //.tableCell(descuento, numero,descuento, numero)
  .tableColumnsHeader("Denominacion.", "Cantidad", "Precio", "Subtotal")
  .tableColspanRight("TOTAL:  "+String.valueOf(total))
  .tableColspanRight("FINAL:  "+String.valueOf(precioFinal))
  .build()
  .line()
  .paragraph(formaPago+'\t'+"                               "+
		  "                                    "+
		  formaPagoCantidad)
  .line()
  .paragraph("Su Vuelto"+"                                              "+
		  "                            "+
		  vuelto)
  .line()
  .paragraph("Defensa al Consumidor Mza 0800-444-2222")
  
  
  .build();
}
}