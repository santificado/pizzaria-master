package br.com.fiap.pizzaria.repositories;

import br.com.fiap.pizzaria.model.Cardapio;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends CrudRepository<Cardapio, Long> {

}