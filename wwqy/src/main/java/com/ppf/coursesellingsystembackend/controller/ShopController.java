package com.ppf.coursesellingsystembackend.controller;


import com.ppf.coursesellingsystembackend.service.CourseService;
import com.ppf.coursesellingsystembackend.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Resource
    private CourseService courseService;

    @Resource
    private UserService userService;
}
