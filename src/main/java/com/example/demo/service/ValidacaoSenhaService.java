package com.example.demo.service;

import com.example.demo.exception.SenhaInvalidaException;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class ValidacaoSenhaService {
    private static final Set<Character> CARACTERES_ESPECIAIS = Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');

    public boolean validarSenha(String senha) {
        if (senha == null || senha.isBlank()) {
            throw new SenhaInvalidaException("Senha inválida: vazia ou nula.");
        }

        senha = senha.replaceAll("^\"|\"$", "");

        if (senha.length() < 9) {
            throw new SenhaInvalidaException("Senha inválida: menos de 9 caracteres.");
        }

        boolean temDigito = false, temMinuscula = false, temMaiuscula = false, temEspecial = false;
        Set<Character> caracteresUnicos = new HashSet<>();

        for (char ch : senha.toCharArray()) {
            if (!caracteresUnicos.add(ch)) {
                throw new SenhaInvalidaException("Senha inválida: caractere repetido -> '" + ch + "'");
            }
            if (Character.isDigit(ch)) temDigito = true;
            if (Character.isLowerCase(ch)) temMinuscula = true;
            if (Character.isUpperCase(ch)) temMaiuscula = true;
            if (CARACTERES_ESPECIAIS.contains(ch)) temEspecial = true;
        }

        if (!(temDigito && temMinuscula && temMaiuscula && temEspecial)) {
            throw new SenhaInvalidaException("Senha inválida: não atende todas as regras.");
        }

        return true;
    }
}

