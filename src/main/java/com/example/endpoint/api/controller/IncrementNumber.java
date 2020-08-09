package com.example.endpoint.api.controller;

import com.example.endpoint.api.json.IncrementRequest;
import com.example.endpoint.service.IncrementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import static org.apache.logging.log4j.util.Strings.isEmpty;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IncrementNumber {
    private final IncrementService service;

    @GetMapping("/increment")
    public ResponseEntity<String> endpointA(@PathParam("number") String number) {
        if (isEmpty(number))
            return status(HttpStatus.BAD_REQUEST).build();

        return ok(service.increment(number));
    }


    @PostMapping("/setIncrementBy")
    public ResponseEntity<Object> endpointB(@RequestBody IncrementRequest request) {
        if (request.getIncrementBy() == null)
            return status(HttpStatus.BAD_REQUEST).build();

        service.setIncrementBy(request.getIncrementBy());

        return ok().build();
    }
}
