package br.com.fiap.pizzaria.repositories;

import br.com.fiap.pizzaria.model.Conta;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Conta, Long> {
}
