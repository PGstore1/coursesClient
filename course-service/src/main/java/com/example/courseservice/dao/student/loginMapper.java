package com.example.courseservice.dao.student;

import com.example.coursecommon.dtos.studentDto;
import com.example.coursecommon.entitys.student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface loginMapper {
    @Select("select * from student where studentnumber=#{studentnumber} and password=#{password}")
    student login(studentDto studentDto);
}
