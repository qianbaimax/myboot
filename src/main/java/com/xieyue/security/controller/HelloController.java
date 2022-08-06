package com.xieyue.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author longchen
 * @version 2022/7/31 14:31:07
 */
@RestController
@RequestMapping("/v1")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
