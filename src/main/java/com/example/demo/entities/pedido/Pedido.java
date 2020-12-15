package com.example.demo.entities.pedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.factura.Factura;
import com.example.demo.entities.formaPago.FormaPago;
import com.example.demo.entities.persona.domicilio.Domicilio;
import com.example.demo.entities.persona.usuario.Cliente;
import com.example.demo.entities.persona.usuario.Cocinero;
import com.example.demo.entities.persona.usuario.Delivery;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pedido extends BaseEntity {

    private Date fecha;

    private int numero;

    private Date horaEstimadaFin;

    private Boolean conDelivery;
    
    private Float total;
    
    private Float precioFinal;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "pedidos",})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "pedidos",})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cocinero_id")
    private Cocinero cocinero;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "pedidos",})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "pedido",})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    
   

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "detallePedido_pedido")
    List<DetallePedido> detallesPedido = new ArrayList();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_domicilio_pedido")
    private Domicilio domicilio;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_pedido")
    private Estado estado;

    
    @OneToOne(fetch = FetchType.EAGER)
    private FormaPago formaPago;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getHoraEstimadaFin() {
        return horaEstimadaFin;
    }

    public void setHoraEstimadaFin(Date horaEstimadaFin) {
        this.horaEstimadaFin = horaEstimadaFin;
    }    

    public List<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Boolean getConDelivery() {
        return conDelivery;
    }

    public void setConDelivery(Boolean conDelivery) {
        this.conDelivery = conDelivery;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Cocinero getCocinero() {
		return cocinero;
	}

	public void setCocinero(Cocinero cocinero) {
		this.cocinero = cocinero;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Float getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(Float precioFinal) {
		this.precioFinal = precioFinal;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((cocinero == null) ? 0 : cocinero.hashCode());
        result = prime * result + ((conDelivery == null) ? 0 : conDelivery.hashCode());
        result = prime * result + ((delivery == null) ? 0 : delivery.hashCode());
        result = prime * result + ((detallesPedido == null) ? 0 : detallesPedido.hashCode());
        result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((factura == null) ? 0 : factura.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((horaEstimadaFin == null) ? 0 : horaEstimadaFin.hashCode());
        result = prime * result + numero;
        result = prime * result + ((precioFinal == null) ? 0 : precioFinal.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (cocinero == null) {
            if (other.cocinero != null)
                return false;
        } else if (!cocinero.equals(other.cocinero))
            return false;
        if (conDelivery == null) {
            if (other.conDelivery != null)
                return false;
        } else if (!conDelivery.equals(other.conDelivery))
            return false;
        if (delivery == null) {
            if (other.delivery != null)
                return false;
        } else if (!delivery.equals(other.delivery))
            return false;
        if (detallesPedido == null) {
            if (other.detallesPedido != null)
                return false;
        } else if (!detallesPedido.equals(other.detallesPedido))
            return false;
        if (domicilio == null) {
            if (other.domicilio != null)
                return false;
        } else if (!domicilio.equals(other.domicilio))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        if (factura == null) {
            if (other.factura != null)
                return false;
        } else if (!factura.equals(other.factura))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (horaEstimadaFin == null) {
            if (other.horaEstimadaFin != null)
                return false;
        } else if (!horaEstimadaFin.equals(other.horaEstimadaFin))
            return false;
        if (numero != other.numero)
            return false;
        if (precioFinal == null) {
            if (other.precioFinal != null)
                return false;
        } else if (!precioFinal.equals(other.precioFinal))
            return false;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        return true;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
	
    
}