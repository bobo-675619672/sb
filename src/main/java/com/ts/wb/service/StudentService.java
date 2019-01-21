package com.ts.wb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.wb.annotation.Food;
import com.ts.wb.model.dao.StudentDao;
import com.ts.wb.model.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Food(name = "name")
	private String food;
	
	public List<Student> getStudent() {
		studentDao.findAll();
		return null;
	}
	
}
