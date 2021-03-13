package com.wzk.booking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/6 - 13:58
 */
@RestController
@RequestMapping("/xiao")
public class TestController {
    @GetMapping("/aoaojiao")
    public String test(){
        return "guangguangguang";
    }

}
