package com.example.demo.services.pedido;

import com.example.demo.dtos.PlatoDTO;
import com.example.demo.entities.pedido.DetallePedido;
import com.example.demo.entities.pedido.Pedido;
import com.example.demo.entities.persona.usuario.Cliente;
import com.example.demo.entities.persona.usuario.Cocinero;
import com.example.demo.repositories.pedido.PedidoRepository;
import com.example.demo.services.BaseService;
import com.example.demo.services.persona.usuario.ClienteService;
import com.example.demo.services.persona.usuario.CocineroService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

import org.hibernate.annotations.SourceType;
import org.hibernate.query.criteria.internal.path.ListAttributeJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class PedidoService extends BaseService<Pedido, PedidoRepository> {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private CocineroService cocineroService;

	// ======FUNCIONES ==========

	public Pedido getCarrito(String email) throws Exception {

		try {
			// Buscar el cliente por el emai
			Cliente cliente = this.clienteService.findByEmail(email);

			// Recorrer buscando el pedido que este en carrito
			for (Pedido pedido : cliente.getPedidos()) {

				if (pedido.getEstado().getDenominacion().toLowerCase().equals("carrito")) {
					// Si encuentra el carrito retornarlo
					return pedido;
				}
			}

			// Si no encuentra el carrito crear uno nuevo
			Pedido nuevoCarrito = new Pedido();
			// setearle su tipo de envio
			nuevoCarrito.setConDelivery(false);
			// setearle el estado a "carrito"
			nuevoCarrito.setEstado(this.estadoService.getByDenominacion("CARRITO"));
			// le seteamos el cliente porque la relacion es bidireccional
			nuevoCarrito.setCliente(cliente);
			// guardarlo y almacenar la referencia
			nuevoCarrito = this.repository.save(nuevoCarrito);

			// Agregarle a cliente ese nuevo pedido en estado carrito
			cliente.getPedidos().add(nuevoCarrito);

			// actualizar el cliente puesto que tiene un nuevo pedido
			cliente = this.clienteService.update(cliente.getId(), cliente);

			// Vuelve a recorrer la lista buscando el nuevo pedido en estado "carrito"
			for (Pedido pedido : cliente.getPedidos()) {
				if (pedido.getEstado().getDenominacion().toLowerCase().equals("carrito")) {
					// esta vez siempre deberia encontrarlo
					return pedido;
				}
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return new Pedido();
	}

	public List<Pedido> findByEstado(String denominacion) throws Exception {
		try {
			return this.repository.findByEstado(denominacion);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Pedido getLatestDate() throws Exception {
		try {
			return this.repository.findLatestDate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Pedido> findPedidosByEmailOfDeliveryAndEstado(String email, String estado) {
		return this.repository.findPedidosByEmailOfDeliveryAndEstado(email, estado);

	}

	public List<Pedido> findPedidosByEmailOfCocineroAndEstado(String email, String estado) throws Exception {
		List<Pedido> pedidosCocinero = cocineroService.findByEmail(email).getPedidos();
		List<Pedido> pedidosCocineroByEstado = new ArrayList();

		for (Pedido pedido : pedidosCocinero) {
			if (pedido.getEstado().getDenominacion().equals(estado)) {
				pedidosCocineroByEstado.add(pedido);
			}
		}

		return pedidosCocineroByEstado;

	}

	public List<Pedido> findByColumn(Integer numero) throws Exception {
		try {
			switch (numero) {
				case 1:

					break;
				case 2:
					return this.repository.findColumnEsperandoAsignacion();
				case 3:
					return this.repository.findColumnCocina();
				case 4:
					return this.repository.findColumnDelivery();
				default:
					break;
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return null;
	}

	public double calcularTotal(Pedido pedido) {
		double total = 0;

		for (DetallePedido detalle : pedido.getDetallesPedido()) {
			total += detalle.getCantidad() * detalle.getPlato().getPrecioVenta();
		}

		return total;
	}

	public ArrayList<Double> datosCocina() throws Exception {
		List<Cocinero> cocinerosActivos = this.cocineroService.cocinerosActivos();
		List<Pedido> pedidosEnCocina = this.repository.findColumnCocina();

		Double cocineros = Double.valueOf(cocinerosActivos.size());

		Double sumatoriaTiempoEspera = 0.0;

		for (Pedido pedido : pedidosEnCocina) {
			Date fechaFin = pedido.getHoraEstimadaFin();
			Date fechaIni = pedido.getFecha();
			Double tiempoEsperado = Math.floor((fechaFin.getTime() - fechaIni.getTime()) / 60000);
			sumatoriaTiempoEspera += tiempoEsperado;
		}

		ArrayList<Double> resultado = new ArrayList<Double>();
		resultado.add(cocineros);
		resultado.add(sumatoriaTiempoEspera);

		return resultado;
	}

	public List<Pedido> findBetweenDates(String fecha1, String fecha2) {
		/*
		 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 * 
		 * Date f1=null; Date f2=null; try { return
		 * this.repository.findBetweenDates(fecha1,fecha2); } catch (Exception e) {
		 * throw new Exception(e.getMessage()); }
		 */
		List<Pedido> pedidos = repository.findBetweenDates(fecha1, fecha2);

			return pedidos;
		


	}

}