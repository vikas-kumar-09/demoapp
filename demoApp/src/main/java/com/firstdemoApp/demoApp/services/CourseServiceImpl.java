
 package com.firstdemoApp.demoApp.services;

// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collector;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdemoApp.demoApp.Dao.CourseDao;
import com.firstdemoApp.demoApp.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

// List<Course> list;
@Autowired
private CourseDao courseDao;

public CourseServiceImpl() {
    
    // list  = new ArrayList<>();
    // list.add(new Course(123, "Java", "Java is fun"));
    // list.add(new Course(111, "Maths", "maths is good"));
    // list.add(new Course(123, "English", "English is fun language"));


}

public List<Course> getCourses(){
    return courseDao.findAll();
}

@SuppressWarnings("deprecation")
@Override
public Course getCourse(long courseId) {
   
    // Course c = null;
    // for(Course course : list){

    //     if(course.getId() == courseId){
    //         c = course;
    //         break;
    //     }
    // }
    return courseDao.getOne(courseId);
}

@Override
public Course addCourse(Course course) {
//    list.add(course);
   courseDao.save(course);
   return course;
} 
@Override
public Course updateCourse(Course course){

    // list.forEach(e ->{
    //      if(e.getId() == course.getId()){
    //         e.setTitle(course.getTitle());
    //         e.setDes(course.getDes());
    //      }
    // });

    courseDao.save(course);

    return course;
}

@SuppressWarnings("deprecation")
@Override
public void deleteCourse(long parseLong) {
    // list = list.stream()
    //            .filter(e -> e.getId() != parseLong)
    //            .collect(Collectors.toList());
    
    Course entity = courseDao.getOne(parseLong);
    courseDao.delete(entity);

}
}