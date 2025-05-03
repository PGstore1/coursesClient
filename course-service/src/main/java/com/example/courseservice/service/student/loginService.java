package com.example.courseservice.service.student;

import com.example.coursecommon.Result.Result;
import com.example.coursecommon.dtos.studentDto;
import org.springframework.stereotype.Service;

@Service
public interface loginService {
    public Result login(studentDto studentDto);
}
