package com.vishalspringbootapi.vishalspringbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vishalspringbootapi.vishalspringbootapi.service_entities.Course;
import com.vishalspringbootapi.vishalspringbootapi.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;
	
	//Get all Courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	//Get Single course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	//Add New Course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	
	//Update the Course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);
	}
	
	//Delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> DeleteCourse(@PathVariable String courseId) 
	{
		try {
			
			 this.courseService.deleteCourse(Long.parseLong(courseId));
			 return new ResponseEntity<>(HttpStatus.OK); 
		    }
		    catch(Exception e)
			{
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
}
