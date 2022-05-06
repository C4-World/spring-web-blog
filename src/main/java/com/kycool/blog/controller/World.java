package com.kycool.blog.controller;

import com.kycool.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
public class World {

    @GetMapping("/world")
    public String getWorld() {
        return "world";
    }

    @GetMapping("/error")
    public String error() {
        int i = 2 / 0;
        return "world";
    }
}
