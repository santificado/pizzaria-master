package br.com.fiap.pizzaria.repositories;

import br.com.fiap.pizzaria.model.Pedido;
import org.springframework.stereotype.Repository;

@Repository

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
