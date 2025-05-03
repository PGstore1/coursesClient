package com.example.courseservice.service.impl.student;

import com.example.coursecommon.Jwt.JwtUtils;
import com.example.coursecommon.Result.Result;
import com.example.coursecommon.dtos.studentDto;
import com.example.coursecommon.entitys.student;
import com.example.coursecommon.utils.MD5Utils;
import com.example.courseservice.service.student.loginService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.courseservice.dao.student.loginMapper;

import java.util.Map;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    private loginMapper loginMapper;
    @Override
    public Result login(studentDto studentDto) {
        if (StringUtils.isEmpty(studentDto.getStudentnumber()) || StringUtils.isEmpty(studentDto.getPassword()))
        {
            return Result.error("账号或密码不能为空");
        }
        String password = MD5Utils.encrypt(studentDto.getPassword());
        studentDto.setPassword(password);
        student student = loginMapper.login(studentDto);
        if (student == null)
        {
            return Result.error("账号或密码错误");
        }
        else
        {
            String token = JwtUtils.generateToken(studentDto.getStudentnumber());
            Map<String, Object> data = Map.of("token", token);
            return Result.success(data);
        }
    }
}
