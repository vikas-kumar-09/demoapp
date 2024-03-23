package com.firstdemoApp.demoApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstdemoApp.demoApp.entities.Course;
import com.firstdemoApp.demoApp.services.CourseService;

// import com.firstdemoApp.demoApp.List;

@RestController
public class TestController {

    @Autowired
    private CourseService courseService;
    
    @GetMapping("/home")
    public String home(){

        return "Welcome to home page !!";
    }

    //get the courses all data
    @GetMapping("/courses")
    public List<Course> getCourses(){

        return this.courseService.getCourses();   
    }

    // get the course by Id
    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId){

        return this.courseService.getCourse(Long.parseLong(courseId));
    }
    
    // post the course (add new course : id, title, des)
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){

        return this.courseService.addCourse(course);
    }
    // update course using PUT request
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    // delete the course
    @DeleteMapping("/courses/{courseIs}")
    public ResponseEntity<HttpStatus> deleteCouse(@PathVariable String courseId){
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
