package team6.project;

import org.junit.Before;
import junit.framework.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class StudentTest
{
	Student student;
	//public Student(String firstName, String lastName, int studentNumber,String emailAddress)
	private String firstName = "Michael";
	private String lastName = "Jordan";
	private int studentNumber = 250695712;
	private String emailAddress = "mjordan@uwo.ca";
	
	@Before
	public void createStudent()
	{
		this.student = new Student(firstName, lastName, studentNumber, emailAddress);
	}
	
	@Test
	public void testGettingFirstName()
	{
		Student student = new Student(firstName,lastName,studentNumber,emailAddress);
		String result = student.getFirstName();
		Assert.assertEquals("Michael", result);
		
	}
	@Test
	public void testSettingFirstName()
	{
		String fname = "Mike";
		Student student = new Student(firstName,lastName,studentNumber,emailAddress);
		student.setFirstName(fname);
		String result = student.getFirstName();
		Assert.assertEquals("Mike", result);
		
	}
	@Test
	public void testGettingLastName()
	{
		Student student = new Student(firstName,lastName,studentNumber,emailAddress);
		String result = student.getLastName();
		Assert.assertEquals("Jordan", result);
		
	}
	@Test
	public void testSettingLastName()
	{
		String lName = "Smith";
		Student student = new Student(firstName,lastName,studentNumber,emailAddress);
		student.setLastName(lName);
		String result = student.getLastName();
		Assert.assertEquals("Smith", result);
		
	}
	@Test
	public void testGettingStudentNumber()
	{
		Student student = new Student(firstName,lastName,studentNumber,emailAddress);
		int result = student.getStudentNumber();
		Assert.assertEquals(250695712, result);
		
	}
	@Test
	public void testSettingStudentNumber()
	{
		int sNumber = 123456789;
		Student student = new Student(firstName,lastName,studentNumber,emailAddress);
		student.setStudentNumber(sNumber);
		int result = student.getStudentNumber();
		Assert.assertEquals(123456789, result);
		
	}
	@Test
	public void testGettingEmailAddress()
	{
		Student student = new Student(firstName,lastName,studentNumber,emailAddress);
		String result = student.getEmailAddress();
		Assert.assertEquals("mjordan@uwo.ca", result);
		
	}
	@Test
	public void testSettingEmailAddress()
	{
		String eAddress = "mSmith@uwo.ca";
		Student student = new Student(firstName,lastName,studentNumber,emailAddress);
		student.setEmailAddress(eAddress);
		String result = student.getEmailAddress();
		Assert.assertEquals("mSmith@uwo.ca", result);
		
	}
	
}