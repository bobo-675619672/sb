package com.ts.wb.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.wb.model.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

}
