package com.attendance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.attendance.mapper")
public class UnitAttendanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitAttendanceApplication.class, args);
    }

}
