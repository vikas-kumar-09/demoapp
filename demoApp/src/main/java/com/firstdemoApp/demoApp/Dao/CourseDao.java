package com.firstdemoApp.demoApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstdemoApp.demoApp.entities.Course;

// Dao or repository both are same 
public interface CourseDao extends JpaRepository<Course, Long>{

}
