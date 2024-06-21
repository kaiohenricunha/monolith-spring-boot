package com.example.monolithspringboot.service;

import com.example.monolithspringboot.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CourseCacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String PREFIX = "Course::";

    public void cacheCourse(Course course) {
        redisTemplate.opsForValue().set(PREFIX + course.getId(), course);
    }

    public Course getCachedCourse(Long id) {
        return (Course) redisTemplate.opsForValue().get(PREFIX + id);
    }

    public void deleteCachedCourse(Long id) {
        redisTemplate.delete(PREFIX + id);
    }
}
