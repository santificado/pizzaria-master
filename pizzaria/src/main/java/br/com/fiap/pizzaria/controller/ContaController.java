package br.com.fiap.pizzaria.controller;

import br.com.fiap.pizzaria.model.Conta;
import br.com.fiap.pizzaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Conta> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Conta getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada"));
    }

    @PostMapping
    public Conta createUser(@RequestBody Conta conta) {
        return userRepository.save(conta);
    }

    @PutMapping("/{id}")
    public Conta updateUser(@PathVariable Long id, @RequestBody Conta updatedUser) {
        Conta conta = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada"));

        conta.setNome(updatedUser.getNome());
        conta.setEndereco(updatedUser.getEndereco());
        conta.setTelefone(updatedUser.getTelefone());

        return userRepository.save(conta);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}

