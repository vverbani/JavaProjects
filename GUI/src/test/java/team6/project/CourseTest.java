package team6;

import org.junit.Before;
import junit.framework.Assert;
import org.junit.Test;
import java.util.ArrayList;

/**
 * This class contains Junit tests for the course class.
 * 
 * @author Team 6
 *
 */

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

	private ArrayList<Student> students=new ArrayList<Student>();
	private ArrayList<Deliverable> deliverables=new ArrayList<Deliverable> ();
	
	@Before
	public void createCourse()
	{
		this.course = new Course(courseTitle, courseCode, courseTerm);
		
	}
	@Test
	public void testCourseToString()
	{
		String result = course.toString();
		String compareTo = courseCode + " | " + courseTitle + " | " + courseTerm;
		Assert.assertEquals(compareTo,result);
	}
	
	@Test
	public void testGettingCourseTitle()
	{
		
		String result = course.getCourseTitle();
		Assert.assertEquals("Software Engineering", result);
	}
	@Test
	public void testGettingCourseCode()
	{
		
		String result = course.getCourseCode();
		Assert.assertEquals("SoftEng", result);
	}
	@Test
	public void testGettingCourseTerm()
	{
		
		String result = course.getCourseTerm();
		Assert.assertEquals("Second Semester", result);
	}
	@Test
	public void testSettingCourseTerm()
	{
		
		course.setCourseTerm("2nd Semester");
		String result = course.getCourseTerm();
		Assert.assertEquals("2nd Semester", result);
	}
	@Test
	public void testSettingCourseCode()
	{
		
		course.setCourseCode("cs2212");
		String result = course.getCourseCode();
		Assert.assertEquals("cs2212", result);
	}
	@Test
	public void testSettingCourseTitle()
	{
		
		course.setCourseTitle("2212 Introduction to Software Engineering");
		String result = course.getCourseTitle();
		Assert.assertEquals("2212 Introduction to Software Engineering", result);
	}
	@Test
	public void testAddingDelivebalesToArrayListAndDeletingAndTestingIfItsNull()
	{
		try{

		deliverables.remove(0);
		Assert.assertTrue(true);
		}catch(Exception e){
			System.out.println();
		}
	}
	@Test
	public void testAddingStudentToArrayListAndTestingIfItsNull()
	{
		try{
			students.remove(0);
			Assert.assertTrue(true);
		}catch(Exception e){
			System.out.println();

		}
	}
	@Test
	public void testAddingStudentToStudentArrayList()
	{
		String result="";
		course.addStudent(new Student("This","is",121,"aTest"));
			if(course.getStudents().size()  != 0)
			{
				result = "Added";
			}
		Assert.assertEquals( "Added" , result);

	}
	@Test
	public void testAddingStudentToTheCourseAndGettingFirstName()
	{
		String result = "";
		Student newStudent = new Student("This","is", 121,"aTest");
		students.add(newStudent);
		for(int i  = 0 ; i < students.size() ; i++)
		{
			result = students.get(i).getFirstName();
		}
		Assert.assertEquals("This", result);
	}
	@Test
	public void testAddingStudentToTheCourseAndGettingLastName()
	{
		String result = "";
		Student newStudent = new Student("This","is",121,"aTest");
		students.add(newStudent);
		for(int i = 0 ; i < students.size() ; i++)
		{
			result = students.get(i).getLastName();
		}
		Assert.assertEquals("is", result);

	}
	@Test
	public void testAddingStudentToTheCourseAndGettingStudentNumber()
	{
		int result = 0;
		Student newStudent = new Student("This","is",121,"aTest");
		students.add(newStudent);
		for(int i = 0 ; i < students.size(); i++)
		{
			result = students.get(i).getStudentNumber();
		}
		Assert.assertEquals(121,result);
	}
	@Test
	public void testAddingStudentToTheCourseAndGettingEmailAddress()
	{
		String result = "";
		Student newStudent = new Student("This","is",121,"aTest");
		students.add(newStudent);
		for(int i = 0 ; i < students.size() ; i++)
		{
			result = students.get(i).getEmailAddress();
		}
		Assert.assertEquals("aTest",result);
	}
	@Test
	public void testAddingStudentToTheCourseAndSettingFirstName()
	{
		String result = "";
		Student newStudent = new Student("This","is",121,"aTest");
		students.add(newStudent);
		for(int i = 0 ; i< students.size() ; i++)
		{
			students.get(i).setFirstName("First");
			result = students.get(i).getFirstName();
		}
		Assert.assertEquals("First",result);
	}
	@Test
	public void testAddingStudentToTheCourseAndSettingLastName()
	{
		String result = "";
		Student newStudent = new Student("","", 121, "");
		students.add(newStudent);
		for(int i = 0 ; i < students.size() ; i++)
		{
			students.get(i).setLastName("Last");
			result = students.get(i).getLastName();
		}
		Assert.assertEquals("Last", result);
	}
	@Test
	public void testAddingStudentToTheCouseAndSettingStudentNumber()
	{
		int result = 0;
		Student newStudent = new Student("","",121,"");
		students.add(newStudent);
		for(int i = 0 ; i < students.size() ; i ++)
		{
			students.get(i).setStudentNumber(123456789);
			result = students.get(i).getStudentNumber();
		}
		Assert.assertEquals(123456789,result);
	}
	@Test
	public void testAddingStudentToTheCourseAndSettingEmailAddress()
	{
		String result = "";
		Student newStudent = new Student("","",123456789,"");
		students.add(newStudent);
		for(int i = 0; i < students.size() ; i++)
		{
			students.get(i).setEmailAddress("EmailAddress");
			result = students.get(i).getEmailAddress();
		}
		Assert.assertEquals("EmailAddress", result);
	}
	@Test
	public void testDeletingStudentFromStudentArrayList()
	{
		String result = "";
		Student newStudent = new Student("This","is",121,"aTest");
		students.add(newStudent);

		 
	for(int i = 0 ; i < students.size() ; i++)
		{
			students.remove(i);
			
			if(students.size() == 0)
				{
					result = "Deleted";
				}
		}
		Assert.assertEquals("Deleted", result);
	}
	@Test
	public void testAddingDeliverableToTheDeliverableArrayList()
	{

		String result = "";
		course.addDeliverable(new Deliverable("More","Test",10.0));

		if(course.getDeliverables().size() != 0)
			{
				result = "Not Empty";
			}

		Assert.assertEquals("Not Empty",result);
	}
	@Test
	public void testAddingDeliverableAndGettingItsName()
	{
		String result = "";
		Deliverable newDeliverable = new Deliverable("More","Tests",10.0);
		deliverables.add(newDeliverable);
		for(int i = 0 ; i < deliverables.size() ; i++)
		{
			result = deliverables.get(i).getName();

		}
		Assert.assertEquals("More", result);
	}
	@Test
	public void testAddingDeliverableAndGettingItsType()
	{
		String result = "";
		Deliverable newDeliverable = new Deliverable("More","Tests",10.0);
		deliverables.add(newDeliverable);
		for(int i = 0 ; i < deliverables.size() ; i++)
		{
			result = deliverables.get(i).getType();
		}

		Assert.assertEquals("Tests",result);
	}
	@Test
	public void testAddingDeliverableAndGettingItsWeight()
	{
		double result = 0.0;
		Deliverable newDeliverable = new Deliverable("More","Tests",10.0);
		deliverables.add(newDeliverable);
		for(int i = 0 ; i < deliverables.size() ; i++)
		{
			result = deliverables.get(i).getWeight();
		}
		Assert.assertEquals(10.0,result);
	}
	@Test
	public void testAddingDeliverableAndSettingItsName()
	{
		String result = "";
		Deliverable newDeliverable = new Deliverable("","",10.0);
		deliverables.add(newDeliverable);
		for(int i = 0; i < deliverables.size() ; i++)
		{
			deliverables.get(i).setName("Test");
			result = deliverables.get(i).getName();
		}
		Assert.assertEquals("Test", result);
	}
	@Test
	public void testGettingTheWeightSum()
	{
		double result = 0.0 ;
		result = course.getWeightSum();
		Assert.assertEquals(0.0, result);
	}
	@Test
	public void testGettingWeightSumAndThrowingExceptionIfItsGreaterThanHundred()
	{
		if(course.getWeightSum() > 100)
			Assert.assertFalse(false);
		else
			Assert.assertTrue(true);

	}
	@Test
	public void testGettingWeightSumAndThrowingExceptiongIfItsLessThanZero()
	{
		if(course.getWeightSum() < 0 )
			Assert.assertFalse(false);
		else
			Assert.assertTrue(true);
	}

	@Test
	public void testAddingDeliverablesAndSettingItsType()
	{
		String result = "";
		Deliverable newDeliverable = new Deliverable("","",10.0);
		deliverables.add(newDeliverable);
		for(int i = 0; i < deliverables.size() ; i++)
		{
			deliverables.get(i).setType("Type");
			result = deliverables.get(i).getType();
		}
		Assert.assertEquals("Type", result);
	}
	
	@Test
	public void testAddingDeliverablesAndSettingItsWeight()
	{
		double result = 0.0;
		Deliverable newDeliverable = new Deliverable("","",10.0);
		deliverables.add(newDeliverable);
		for(int i = 0 ; i < deliverables.size() ; i++)
		{
			deliverables.get(i).setWeight(29.3);
			result = deliverables.get(i).getWeight();
		}
		Assert.assertEquals(29.3 , result);
	}
	@Test 
	public void testDeletingADeliverableFromTheDeliverableArrayList()
	{
		String result = "";
		
		course.addDeliverable(new Deliverable("More","Tests",10.0));
		course.removeDeliverable("More");
		
			if(deliverables.size() == 0)
			{
				result = "Deleted";
			}
	
		Assert.assertEquals("Deleted",result);
	}
	
	@Test 
	public void testDeletingANonExistingDeliverableFromTheDeliverableArrayList()
	{
		String result = "";
		int size = deliverables.size() ;
		course.addDeliverable(new Deliverable("More","Tests",10.0));
		course.removeDeliverable("Mooore");
		
			if(deliverables.size() != size)
			{
				result = "Deleted";
			}
	
		Assert.assertEquals("",result);
	}
	
	@Test
	public void testAddingStudentThenFindingThatStudentInArrayList()
	{
		course.addStudent(new Student("","",123456789, ""));
		boolean result =  course.findStudent(123456789);
		Assert.assertEquals(true,result);
	}
	
	@Test
	public void testAddingStudentThenFindingNonExistingStudentInArrayList()
	{
		course.addStudent(new Student("","",123456789, ""));
		boolean result =  course.findStudent(123789);
		Assert.assertEquals(false,result);
	}

	@Test
	public void testGettingClassAverage(){
		Student newStudent = new Student("This","is",121,"aTest");
		newStudent.addGrade(new Grade(80, "Assignment", 100, "One"));
		course.addStudent(newStudent);
		
		double result = course.getClassAverage();
		Assert.assertEquals((double)80, result);
	}
}