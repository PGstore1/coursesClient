package com.example.courseservice.controller.student;

import com.example.coursecommon.Result.Result;
import com.example.coursecommon.dtos.studentDto;
import com.example.coursecommon.entitys.student;
import com.example.courseservice.service.student.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class studentLogin {
    @Autowired
    private loginService loginService;
    @PostMapping("/login")
    public Result login( studentDto student)
    {
//        System.out.println(student.getStudentnumber()+student.getPassword());
        return loginService.login(student);
    }
    @GetMapping("/logout")
    public Result logout()
    {
        return Result.success("退出成功");
    }
    @GetMapping("/getInfo")
    public String getInfo()
    {
        return "获取成功";
    }
}
