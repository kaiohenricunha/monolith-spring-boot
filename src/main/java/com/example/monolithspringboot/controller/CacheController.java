package com.example.monolithspringboot.controller;

import com.example.monolithspringboot.entity.Course;
import com.example.monolithspringboot.service.CourseCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses/cache")
public class CacheController {

    @Autowired
    private CourseCacheService courseCacheService;

    @PostMapping
    public ResponseEntity<Void> cacheCourse(@RequestBody Course course) {
        courseCacheService.cacheCourse(course);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCachedCourse(@PathVariable Long id) {
        Course course = courseCacheService.getCachedCourse(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCachedCourse(@PathVariable Long id) {
        courseCacheService.deleteCachedCourse(id);
        return ResponseEntity.noContent().build();
    }
}
