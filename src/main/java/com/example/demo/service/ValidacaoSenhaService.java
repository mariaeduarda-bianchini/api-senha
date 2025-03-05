package com.example.demo.service;

import com.example.demo.exception.SenhaInvalidaException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ValidacaoSenhaService {
    private static final List<Character> CARACTERES_ESPECIAIS_LISTA = List.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');

    public boolean validarSenha(String senha) {
        if (senha == null || senha.isBlank()) {
            throw new SenhaInvalidaException("Senha inválida: vazia ou nula.");
        }

        senha = senha.replaceAll("^\"|\"$", "");

        if (senha.length() < 9) {
            throw new SenhaInvalidaException("Senha inválida: menos de 9 caracteres.");
        }

        boolean temDigito = false, temMinuscula = false, temMaiuscula = false, temEspecial = false;
        List<Character> caracteresUnicos = new ArrayList<>();

        for (char caracter : senha.toCharArray()) {
            if (caracteresUnicos.contains(caracter)) {
                throw new SenhaInvalidaException(String.format("Senha inválida: caractere repetido -> '%s'", caracter));
            }
            caracteresUnicos.add(caracter);

            if (Character.isDigit(caracter)) {
                temDigito = true;
            }
            if (Character.isLowerCase(caracter)) {
                temMinuscula = true;
            }
            if (Character.isUpperCase(caracter)) {
                temMaiuscula = true;
            }
            if (CARACTERES_ESPECIAIS_LISTA.contains(caracter)) {
                temEspecial = true;
            }
        }

        if (!(temDigito && temMinuscula && temMaiuscula && temEspecial)) {
            throw new SenhaInvalidaException("Senha inválida: não atende todas as regras.");
        }

        return true;
    }
}
