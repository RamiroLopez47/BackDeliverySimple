package com.example.demo.repositories.pedido;

import com.example.demo.entities.pedido.Pedido;
import com.example.demo.entities.persona.usuario.Usuario;
import com.example.demo.entities.stock.Articulo;
import com.example.demo.entities.plato.Plato;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	//@Query("select p FROM Plato p WHERE p.categoriaPlato.denominacion=?1")
	/*
	 * @Query("select p FROM Pedido p WHERE p.estado_pedido =?1 AND p.pedido_cliente =?2"
	 * ) Pedido findByEstadoAndEmail(String estado, Long id);
	 */
	@Query("SELECT p FROM Pedido p WHERE p.estado.denominacion =?1")
	List<Pedido> findByEstado(String estado);
	
	@Query( value = "SELECT * FROM pedido WHERE estado_pedido = (SELECT id FROM estado WHERE denominacion = 'ESPERANDO_ASIGNACION') ORDER BY fecha ASC LIMIT 1",
			nativeQuery = true)
	Pedido findLatestDate();
	
	@Query("SELECT p FROM Pedido p WHERE p.delivery.email =?1 AND p.estado.denominacion =?2")
	
	List<Pedido> findPedidosByEmailOfDeliveryAndEstado(String email, String estado);
	
	@Query(value = "SELECT * FROM pedido WHERE estado_pedido = ( SELECT id FROM estado WHERE estado.denominacion = 'esperando_asignacion' ) OR estado_pedido = ( SELECT id FROM estado WHERE estado.denominacion = 'esperando_cliente' ) OR estado_pedido = ( SELECT id FROM estado WHERE estado.denominacion = 'esperando_repartidor' )",
			nativeQuery = true)
	List<Pedido> findColumnEsperandoAsignacion();
	
	@Query(value = "SELECT * FROM pedido WHERE estado_pedido = ( SELECT id FROM estado WHERE estado.denominacion = 'cocina' ) "			
			+ "OR estado_pedido = ( SELECT id FROM estado WHERE estado.denominacion = 'preparando' )",
			nativeQuery = true)
	List<Pedido> findColumnCocina();
	
	@Query(value = "SELECT * FROM pedido WHERE estado_pedido = ( SELECT id FROM estado WHERE estado.denominacion = 'en_camino' ) "			
			+ "OR estado_pedido = ( SELECT id FROM estado WHERE estado.denominacion = 'entregado' )",
			nativeQuery = true)
	List<Pedido> findColumnDelivery();

	@Query(value = "SELECT * FROM Pedido WHERE fecha BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Pedido> findBetweenDates(String fecha1, String fecha2);
	
	@Query(value = "SELECT COUNT(*) FROM pedido WHERE cliente_id = ?1", nativeQuery = true)
	int findPedidosCliente(int id);

	
	
	
	
}