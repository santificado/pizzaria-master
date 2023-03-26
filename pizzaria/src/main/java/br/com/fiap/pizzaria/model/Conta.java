package br.com.fiap.pizzaria.model;

import java.math.BigDecimal;

public class Conta {
    
    public String Nome;

    public String Endereco;

    public BigDecimal Telefone;

    public BigDecimal ID;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public BigDecimal getTelefone() {
        return Telefone;
    }

    public void setTelefone(BigDecimal telefone) {
        Telefone = telefone;
    }

    public BigDecimal getID() {
        return ID;
    }

    public void setID(BigDecimal iD) {
        ID = iD;
    }

    
}
