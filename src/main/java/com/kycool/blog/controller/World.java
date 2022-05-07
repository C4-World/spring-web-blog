package com.kycool.blog.controller;

import com.kycool.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ResponseResult
public class World {

    @GetMapping("/world")
    public String getWorld() {
        log.info("----this recording world log");
        return "world";
    }

    @GetMapping("/error")
    public String error() {
        int i = 2 / 0;
        return "world";
    }
}
