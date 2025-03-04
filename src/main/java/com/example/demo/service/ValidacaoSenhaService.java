package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class ValidacaoSenhaService {
    private static final Set<Character> CARACTERES_ESPECIAIS = Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');

    public boolean validarSenha(String senha) {
        if (senha == null || senha.length() < 9) {
            System.out.println("Senha inválida: menos de 9 caracteres.");
            return false;
        }

        senha = senha.replaceAll("^\"|\"$", "");

        boolean temDigito = false, temMinuscula = false, temMaiuscula = false, temEspecial = false;
        Set<Character> caracteresUnicos = new HashSet<>();

        for (char ch : senha.toCharArray()) {
            if (!caracteresUnicos.add(ch)) {
                System.out.println("Senha inválida: caractere repetido -> " + ch);
                return false;
            }
            if (Character.isDigit(ch)) temDigito = true;
            if (Character.isLowerCase(ch)) temMinuscula = true;
            if (Character.isUpperCase(ch)) temMaiuscula = true;
            if (CARACTERES_ESPECIAIS.contains(ch)) temEspecial = true;
        }

        System.out.println("temDigito: " + temDigito);
        System.out.println("temMinuscula: " + temMinuscula);
        System.out.println("temMaiuscula: " + temMaiuscula);
        System.out.println("temEspecial: " + temEspecial);

        boolean senhaValida = temDigito && temMinuscula && temMaiuscula && temEspecial;
        if (!senhaValida) {
            System.out.println("Senha inválida: não atende todas as regras.");
        }

        return senhaValida;
    }
}
