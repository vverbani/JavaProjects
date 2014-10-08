package team6.project;

import org.junit.Before;
import junit.framework.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class CourseTest
{
	// public Course(String courseTitle, String courseCode, String courseTerm) first set of tests
	private Course course;
	private String courseTitle = "Software Engineering";
	private String courseCode = "SoftEng";
	private String courseTerm = "Second Semester";
	
	// public void addDeliverable(String name, String type, double weight)  second set of test
	private String name = "Assignment";
	private String type = "One";
	private double weight = 15.9;
	
	@Before
	public void createCourse()
	{
		this.course = new Course(courseTitle, courseCode, courseTerm);
		
	}
	
	@Test
	public void testGettingCourseTitle()
	{
		
		Course course = new Course(courseTitle, courseCode , courseTerm);
		String result = course.getCourseTitle();
		Assert.assertEquals("Software Engineering", result);
	}
	@Test
	public void testGettingCourseCode()
	{
		
		Course course = new Course(courseTitle, courseCode , courseTerm);
		String result = course.getCourseCode();
		Assert.assertEquals("SoftEng", result);
	}
	@Test
	public void testGettingCourseTerm()
	{
		
		Course course = new Course(courseTitle, courseCode , courseTerm);
		String result = course.getCourseTerm();
		Assert.assertEquals("Second Semester", result);
	}
	@Test
	public void testSettingCourseTerm()
	{
		
		Course course = new Course(courseTitle, courseCode , courseTerm);
		course.setCourseTerm("2nd Semester");
		String result = course.getCourseTerm();
		Assert.assertEquals("2nd Semester", result);
	}
	@Test
	public void testSettingCourseCode()
	{
		
		Course course = new Course(" ", " ", " ");
		course.setCourseCode("cs2212");
		String result = course.getCourseCode();
		Assert.assertEquals("cs2212", result);
	}
	@Test
	public void testSettingCourseTitle()
	{
		
		Course course = new Course(courseTitle, courseCode , courseTerm);
		course.setCourseTitle("2212 Introduction to Software Engineering");
		String result = course.getCourseTitle();
		Assert.assertEquals("2212 Introduction to Software Engineering", result);
	}
	
}