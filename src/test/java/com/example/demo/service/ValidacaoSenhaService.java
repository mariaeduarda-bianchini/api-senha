package com.example.demo.service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidacaoSenhaServiceTest {

    private final ValidacaoSenhaService validacaoSenhaService = new ValidacaoSenhaService();

    @Test
    void deveValidarSenhaCorreta() {

        String senhaValida = "Senha@123";

        assertTrue(validacaoSenhaService.validarSenha(senhaValida));
    }

    @Test
    void deveRetornarFalseParaSenhaComMenosDe9Caracteres() {

        String senhaInvalida = "12345";

        assertFalse(validacaoSenhaService.validarSenha(senhaInvalida));
    }

    @Test
    void deveRetornarFalseParaSenhaSemMaiuscula() {

        String senhaInvalida = "senha@123";

        assertFalse(validacaoSenhaService.validarSenha(senhaInvalida));
    }

    @Test
    void deveRetornarFalseParaSenhaSemNumero() {

        String senhaInvalida = "Senha@abc";

        assertFalse(validacaoSenhaService.validarSenha(senhaInvalida));
    }

    @Test
    void deveRetornarFalseParaSenhaSemCaracterEspecial() {

        String senhaInvalida = "Senha123";

        assertFalse(validacaoSenhaService.validarSenha(senhaInvalida));
    }

    @Test
    void deveRetornarFalseParaSenhaComCaractereRepetido() {

        String senhaInvalida = "Senhaa@123";

        assertFalse(validacaoSenhaService.validarSenha(senhaInvalida));
    }
}
