package com.example.demo.services.persona.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dtos.ClienteDTO;
import com.example.demo.dtos.ClientePedidoDTO;
import com.example.demo.entities.pedido.Pedido;
import com.example.demo.entities.persona.usuario.Cliente;
import com.example.demo.repositories.pedido.PedidoRepository;
import com.example.demo.repositories.persona.usuario.ClienteRepository;
import com.example.demo.services.BaseService;
import com.example.demo.services.pedido.PedidoService;
import com.example.demo.services.plato.PlatoService;

@Service
public class ClienteService extends BaseService<Cliente, ClienteRepository> {
@Autowired
private PedidoService pedidoService;

@Autowired
private PlatoService platoService;

    public Cliente findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

	public ClienteDTO getCantidadPlatos(String fecha1,String fecha2, String email) {
        ClienteDTO clienteDTO=  new ClienteDTO();
        
        List<Pedido> pedidos = pedidoService.findBetweenDates(fecha1, fecha2);   
        List<Pedido>pedidosCliente= seleccionarPedidosDelCliente(pedidos,email);
        
        Cliente cliente = findByEmail(email);
        
        clienteDTO.setPlatosDTO(platoService.calcularCantidadPlatos(pedidosCliente));
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setId(cliente.getId());
		return clienteDTO;
	}

    private List<Pedido> seleccionarPedidosDelCliente(List<Pedido> pedidos, String email) {
        List<Pedido>pedidosCliente= new ArrayList();
        for(Pedido pedido : pedidos){
           if(pedido.getCliente().getEmail().equals(email)){
pedidosCliente.add(pedido);
           }
       }
       return pedidosCliente;
    }

	public List<ClienteDTO> getCantidadPlatosOfClientes(String fechaInicio, String fechaFin) {
        List<ClienteDTO> clientesDTO= new ArrayList();
        List<Pedido> pedidos = pedidoService.findBetweenDates(fechaInicio, fechaFin);   

        for(Cliente cliente : repository.findAll()){
            clientesDTO.add(getCantidadPlatos( cliente.getEmail(),pedidos));
        }
            return clientesDTO;
    }
	public ClienteDTO getCantidadPlatos( String email, List<Pedido> pedidos) {
        ClienteDTO clienteDTO=  new ClienteDTO();
        
        List<Pedido>pedidosCliente= seleccionarPedidosDelCliente(pedidos,email);
        
        Cliente cliente = findByEmail(email);
        
        clienteDTO.setPlatosDTO(platoService.calcularCantidadPlatos(pedidosCliente));
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setId(cliente.getId());
		return clienteDTO;
	}

	public List<ClientePedidoDTO> getCantidadPedidosAgrupados(String fechaInicio, String fechaFin) {
        List<ClientePedidoDTO> clientesPedidosDTO= new ArrayList();
        List<Pedido> pedidos = pedidoService.findBetweenDates(fechaInicio, fechaFin);   
       
        for(Cliente cliente : repository.findAll()){
            ClientePedidoDTO clientePedido= new ClientePedidoDTO();
            clientePedido.setPedidos(seleccionarPedidosDelCliente(pedidos, cliente.getEmail()));
           clientePedido.setNombre(cliente.getNombre());
           clientePedido.setApellido(cliente.getApellido());
            clientesPedidosDTO.add(clientePedido);
        }
        return clientesPedidosDTO;
	}
}
