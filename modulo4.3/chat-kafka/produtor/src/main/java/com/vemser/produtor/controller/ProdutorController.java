package com.vemser.produtor.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.vemser.produtor.dto.NomeChat;
import com.vemser.produtor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/send-to")
    public void sendTo(@RequestParam List<NomeChat> chats, @RequestParam String mensagem) throws JsonProcessingException {
        for (NomeChat nome : chats) {
            produtorService.sendTo(mensagem, List.of(nome));
        }
    }
}