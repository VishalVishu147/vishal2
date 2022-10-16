package com.vishalspringbootapi.vishalspringbootapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishalspringbootapi.vishalspringbootapi.service_entities.Course;

public interface CourseDao extends JpaRepository<Course, Integer>{

}
