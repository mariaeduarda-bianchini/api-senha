package com.example.demo.controller;

import com.example.demo.service.ValidacaoSenhaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/senha")
public class ValidacaoSenhaController {

    private final ValidacaoSenhaService validacaoSenhaService;

    public ValidacaoSenhaController(ValidacaoSenhaService validacaoSenhaService) {
        this.validacaoSenhaService = validacaoSenhaService;
    }

    @PostMapping("/validar")
    public boolean validarSenha(@RequestBody String senha) {
        return validacaoSenhaService.validarSenha(senha);
    }
}
