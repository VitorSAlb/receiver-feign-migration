package com.vitorsalb.reciverfeignmigration.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReceiverService {

    private final ObjectMapper objectMapper;

    public ReceiverService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonNode receiveMessage(JsonNode envelope) {
        ObjectNode payload = envelope != null && envelope.isObject() ? (ObjectNode) envelope : objectMapper.createObjectNode();

        ObjectNode metadados = payload.path("metadados").isObject() ? (ObjectNode) payload.get("metadados") : objectMapper.createObjectNode();

        metadados.put("receiverLDT", LocalDateTime.now().toString());
        metadados.put("sourceReceiver", "ReceiverService");

        return payload;
    }
}
