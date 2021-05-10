package br.com.rfasioli.springaop.controller;

import br.com.rfasioli.springaop.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyController {

    private final MyService myService;

    public MyController(final MyService myService) {
        this.myService = myService;
    }

    @GetMapping("")
    public String hello() {
        myService.serve();
        return "Hello!";
    }
}
