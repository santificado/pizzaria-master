package br.com.fiap.pizzaria.controller;

import br.com.fiap.pizzaria.model.Pedido;
import br.com.fiap.pizzaria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private PedidoRepository pedidoRepository;
    @GetMapping
    public List<Pedido> getClients() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido getClientById(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> {
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
                });
    }

    @PostMapping
    public Pedido createClient(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido updateClient(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        pedido.setNome(pedidoAtualizado.getNome());
        pedido.setEntrega(pedidoAtualizado.getEntrega());

        return pedidoRepository.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private PedidoRepository pedidoRepository;
    @GetMapping
    public List<Pedido> getOrders() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido getOrderById(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        pedido.setNome(pedidoAtualizado.getNome());
        pedido.setEntrega(pedidoAtualizado.getEntrega());

        return pedidoRepository.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}