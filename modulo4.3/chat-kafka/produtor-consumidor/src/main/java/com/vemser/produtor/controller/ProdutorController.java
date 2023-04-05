package com.vemser.produtor.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.vemser.produtor.dto.MensagemDTO;
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
    public void sendTo(@RequestParam List<NomeChat> chats, @RequestBody MensagemDTO mensagem) throws JsonProcessingException {
        for (NomeChat nome : chats) {
            produtorService.sendTo(mensagem, nome);
        }
    }
}