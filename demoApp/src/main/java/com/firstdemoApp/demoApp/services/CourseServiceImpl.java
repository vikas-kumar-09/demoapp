
 package com.firstdemoApp.demoApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.firstdemoApp.demoApp.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

List<Course> list;

public CourseServiceImpl() {
    
    list  = new ArrayList<>();
    list.add(new Course(123, "Java", "Java is fun"));
    list.add(new Course(111, "Maths", "maths is good"));
    list.add(new Course(123, "English", "English is fun language"));
}

public List<Course> getCourses(){
    return list;
}

@Override
public Course getCourse(long courseId) {
   
    Course c = null;
    for(Course course : list){

        if(course.getId() == courseId){
            c = course;
            break;
        }
    }
    return c;  
}

@Override
public Course addCourse(Course course) {
   list.add(course);
   return course;
} 
}