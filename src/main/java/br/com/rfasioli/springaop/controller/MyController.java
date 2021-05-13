package br.com.rfasioli.springaop.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import br.com.rfasioli.springaop.aspect.IOActions;
import br.com.rfasioli.springaop.service.MyService;

@RestController
@RequestMapping(path = "/")
public class MyController {

    private final MyService myService;

    public MyController(final MyService myService) {
        this.myService = myService;
    }

    @GetMapping("")
    public String hello() {
        return myService
                .serve("Teste")
                .toString();
    }

    @IOActions(args = {"0"})
    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody final String payload) {
        return ResponseEntity.of(Optional.of("Hello"));
    }

}
