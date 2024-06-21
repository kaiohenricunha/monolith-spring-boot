package com.example.monolithspringboot.controller;

import com.example.monolithspringboot.entity.Course;
import com.example.monolithspringboot.service.CourseCacheService;
import com.example.monolithspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseCacheService courseCacheService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        Course cachedCourse = courseCacheService.getCachedCourse(id);
        if (cachedCourse != null) {
            return cachedCourse;
        }
        Course course = courseService.getCourseById(id);
        if (course != null) {
            courseCacheService.cacheCourse(course);
        }
        return course;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
