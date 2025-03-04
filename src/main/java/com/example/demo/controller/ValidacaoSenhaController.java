package com.example.demo.controller;

import com.example.demo.service.ValidacaoSenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/senha")
public class ValidacaoSenhaController {
    @Autowired
    private ValidacaoSenhaService validacaoSenhaService;

    @PostMapping("/validar")
    public boolean validarSenha(@RequestBody String senha) {
        return validacaoSenhaService.validarSenha(senha);
    }
}
