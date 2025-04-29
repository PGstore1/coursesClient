package com.example.courseservice.controller;
import com.example.coursecommon.utils.commonUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/test")
    public String test(){
        return commonUtils.getRandomString(4);
    }
}
