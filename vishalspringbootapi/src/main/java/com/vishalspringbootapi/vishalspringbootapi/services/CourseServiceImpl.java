package com.vishalspringbootapi.vishalspringbootapi.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vishalspringbootapi.vishalspringbootapi.dao.CourseDao;
import com.vishalspringbootapi.vishalspringbootapi.service_entities.Course;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
//	List<Course> list;
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(11, "java", "This is Java"));
//		list.add(new Course(12, "Spring", "This is spring:"));
//		list.add(new Course(13,"SQL", "This is SQL Course"));
	}
	
	public List<Course> getCourses(){
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for(Course course:list)
//		{
//			if(course.getId() == courseId)
//			{
//				c=course;
//				break;
//			}
//		}
		return courseDao.getOne((int) courseId);
	}
	@Override
	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course) {
//		Course c=null;
//		for(Course course1 : list)
//		{
//			if(course1.getId() == course.getId())
//			{
//				course1.setTitle(course.getTitle());
//				course1.setDiscription(course.getDiscription());
//			}
//			c = course1;
//		}
		courseDao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(long courseId) {
		//list = this.list.stream().filter(e -> e.getId()!=courseId).collect(Collectors.toList());
		Course entity = courseDao.getById((int) courseId);
		courseDao.delete(entity);
	}

	
	

}
