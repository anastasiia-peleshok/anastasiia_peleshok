package com.example.testtask;

//import org.hibernate.engine.internal.Collections;
import com.example.testtask.entity.DataRow;
import com.example.testtask.service.InnerJoinOperation;
import com.example.testtask.service.LeftJoinOperation;
import com.example.testtask.service.RightJoinOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class TesttaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesttaskApplication.class, args);
	}
}
