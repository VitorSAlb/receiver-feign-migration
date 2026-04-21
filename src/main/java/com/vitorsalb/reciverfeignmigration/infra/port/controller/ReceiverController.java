package com.vitorsalb.reciverfeignmigration.infra.port.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.vitorsalb.reciverfeignmigration.application.service.ReceiverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/receiver")
public class ReceiverController {

    @Autowired
    private ReceiverService receiverService;

    @PostMapping
    public ResponseEntity<JsonNode> receiveMessage(@RequestBody JsonNode message) {
        JsonNode json = receiverService.receiveMessage(message);
        return ResponseEntity.ok(json);
    }
}
