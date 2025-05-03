package com.example.coursecommon.dtos;

import lombok.*;

@Data
@Getter
@Setter
public class studentDto {
    private String name;
    private String studentnumber;
    private String password;

    public studentDto(String name, String studentnumber, String password) {
        this.name = name;
        this.studentnumber = studentnumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
