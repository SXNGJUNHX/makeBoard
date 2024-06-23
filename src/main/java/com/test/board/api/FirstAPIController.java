package com.test.board.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstAPIController {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello";
    }
}
