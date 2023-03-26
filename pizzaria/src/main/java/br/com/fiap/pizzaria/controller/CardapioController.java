package br.com.fiap.pizzaria.controller;

import br.com.fiap.pizzaria.repositories.CardapioRepository;
import br.com.fiap.pizzaria.model.Cardapio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pizzas")
public class CardapioController {
    @Autowired
    private CardapioRepository cardapioRepository;

    @PostMapping
    public Cardapio criarPizza(@RequestBody Cardapio cardapio) {
        return cardapioRepository.save(cardapio);
    }

    @GetMapping
    public Iterable<Cardapio> listarPizzas() {
        return cardapioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cardapio buscarPizza(@PathVariable Long id) {
        return cardapioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public Cardapio atualizarPizza(@PathVariable Long id, @RequestBody Cardapio cardapioAtualizado) {
        Cardapio cardapio = cardapioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        cardapio.setNome(cardapioAtualizado.getNome());
        cardapio.setID(cardapioAtualizado.getID());
        cardapio.setPreco(cardapioAtualizado.getPreco());
        cardapio.setTamanho(cardapioAtualizado.getTamanho());
        return cardapioRepository.save(cardapio);
    }

    @DeleteMapping("/{id}")
    public void deletarPizza(@PathVariable Long id) {
        cardapioRepository.deleteById(id);
    }
}
