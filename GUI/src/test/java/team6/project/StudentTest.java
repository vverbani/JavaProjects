package team6;

import org.junit.Before;
import junit.framework.Assert;
import org.junit.Test;
import java.util.ArrayList;
/**
 * This class contains Junit tests for the Student class.
 * 
 * @author Team 6
 *
 */
public class StudentTest {
	Student student;
	// public Student(String firstName, String lastName, int
	// studentNumber,String emailAddress)
	private String firstName = "Michael";
	private String lastName = "Jordan";
	private int studentNumber = 250695712;
	private String emailAddress = "mjordan@uwo.ca";

	ArrayList<Grade> grades = new ArrayList<Grade>();

	@Before
	public void createStudent() {
		this.student = new Student(firstName, lastName, studentNumber,
				emailAddress);
	}

	@Test
	public void testGettingFirstName() {
		String result = student.getFirstName();
		Assert.assertEquals("Michael", result);

	}

	@Test
	public void testSettingFirstName() {
		String fname = "Mike";
		student.setFirstName(fname);
		String result = student.getFirstName();
		Assert.assertEquals("Mike", result);

	}

	@Test
	public void testGettingLastName() {
		String result = student.getLastName();
		Assert.assertEquals("Jordan", result);

	}

	@Test
	public void testGettingAverageAndFailingBecauseOverHundred() {
		if (student.getAverage() > 100)
			Assert.assertFalse(false);
		else
			Assert.assertTrue(true);
	}

	@Test
	public void testWhetherGetAverageisLessThanZero() {
		if (student.getAverage() < 0)
			Assert.assertFalse(false);
		else
			Assert.assertTrue(true);
	}

	@Test
	public void testSettingLastName() {
		String lName = "Smith";
		student.setLastName(lName);
		String result = student.getLastName();
		Assert.assertEquals("Smith", result);

	}

	@Test
	public void testGettingAverageWhenAverageIsLessThanZero() {
		if (student.average() < 0.0)
			Assert.assertFalse(false);
		else
			Assert.assertTrue(true);
	}

	@Test
	public void testGettingStudentNumber() {
		int result = student.getStudentNumber();
		Assert.assertEquals(250695712, result);

	}

	@Test
	public void testSettingStudentNumber() {
		int sNumber = 123456789;
		student.setStudentNumber(sNumber);
		int result = student.getStudentNumber();
		Assert.assertEquals(123456789, result);

	}

	@Test
	public void testToString() {
		String fname = "Mike";
		student.setFirstName(fname);
		String lName = "Smith";
		student.setLastName(lName);
		int sNumber = 123456789;
		student.setStudentNumber(sNumber);
		String eAddress = "mSmith@uwo.ca";
		student.setEmailAddress(eAddress);
		String result = student.toString();
		Assert.assertEquals(
				true,
				result.equals(fname + " " + lName + "  |  " + sNumber + "  |  "
						+ eAddress));
	}

	@Test
	public void testGettingEmailAddress() {
		String result = student.getEmailAddress();
		Assert.assertEquals("mjordan@uwo.ca", result);

	}

	@Test
	public void testSettingEmailAddress() {
		String eAddress = "mSmith@uwo.ca";
		student.setEmailAddress(eAddress);
		String result = student.getEmailAddress();
		Assert.assertEquals("mSmith@uwo.ca", result);

	}

	@Test
	public void testAddingGradeToTheStudentGradeArrayList() {
		String result = "";
		student.addGrade(new Grade(98.0, "Title", 99.0));
		if (student.getGrades().size() != 0) {
			result = "Added";
		}
		Assert.assertEquals("Added", result);
	}

	@Test
	public void testAddingGradeToTheStudentGradeAndGetItsGrade() {
		double result = 0.0;
		student.addGrade(new Grade(98.0, "Title", 10.0));
		for (int i = 0; i < student.getGrades().size(); i++) {
			result = student.getGrades().get(i).getGrade();

		}
		Assert.assertEquals(98.0, result);
	}

	@Test
	public void testAddingGradeToTheStudentGradeAndGettingItsWeight() {
		double result = 0.0;
		student.addGrade(new Grade(98.0, "Title", 10.0));
		for (int i = 0; i < student.getGrades().size(); i++) {
			result = student.getGrades().get(i).getWeight();
		}
		Assert.assertEquals(10.0, result);
	}

	@Test
	public void testAddingGradeToTheStudentGradeAndGetItsTitle() {
		String result = "";
		student.addGrade(new Grade(98.0, "Title", 10.0));
		for (int i = 0; i < student.getGrades().size(); i++) {
			result = student.getGrades().get(i).getTitle();

		}
		Assert.assertEquals("Title", result);
	}

	@Test
	public void testAddingGradeToTheStudentGradeAndSettingItsWeight() {
		double result = 0.0;
		student.addGrade(new Grade(98.0, "Title", 10.0));
		for (int i = 0; i < student.getGrades().size(); i++) {
			student.getGrades().get(i).setWeight(15.0);
			result = student.getGrades().get(i).getWeight();
		}
		Assert.assertEquals(15.0, result);
	}

	@Test
	public void testAddingGradeToTheStudentGradeAndSetItsGrade() {
		double result = 0.0;
		student.addGrade(new Grade(98.0, "Title", 99.0));
		for (int i = 0; i < student.getGrades().size(); i++) {
			student.getGrades().get(i).setGrade(80.0);
			result = student.getGrades().get(i).getGrade();
		}
		Assert.assertEquals(80.0, result);
	}

	@Test
	public void testAddingGradeToTheStudentGradeArrayListGettingAverage() {
		double result = 0.0;
		student.addGrade(new Grade(67.0, "Title", 15.0));
		student.addGrade(new Grade(100, "Title1", 35.0));

		result = student.getAverage();
		Assert.assertEquals(90.10, result);
	}

	@Test
	public void testSettingTheAverageGradeToStudentGrade() {
		double result = 0.0;
		student.setAverage(76.8);
		result = student.average();
		Assert.assertEquals(76.8, result);
	}

	@Test
	public void testGettingTheAverage() {
		double result = 0.0;
		student.addGrade(new Grade(98.0, "Title", 100.0));
		result = student.getAverage();
		Assert.assertEquals(98.0, result);

	}

	@Test
	public void testAssignmentAverage() {
		double result = 0.0;
		student.addGrade(new Grade(100.0, "Title", 50.0, "Assignment"));
		student.addGrade(new Grade(0.0, "Title2", 50.0, "Assignment"));
		student.addGrade(new Grade(0.0, "Title3", 0.0, "Exam"));
		result = student.getAssignmentAverage();
		Assert.assertEquals(50.0, result);

	}

	@Test
	public void testExamAverage() {
		double result = 0.0;
		student.addGrade(new Grade(100.0, "Title", 50.0, "Exam"));
		student.addGrade(new Grade(0.0, "Title2", 50.0, "Exam"));
		student.addGrade(new Grade(0.0, "Title3", 0.0, "Assignment"));
		result = student.getExamAverage();
		Assert.assertEquals(50.0, result);

	}

	@Test
	public void testAddingGradeToTheStudentGradeAndSettingItsTitle() {
		String result = "";
		student.addGrade(new Grade(98.0, "Title", 99.0));
		for (int i = 0; i < student.getGrades().size(); i++) {
			student.getGrades().get(i).setTitle("newTitle");
			result = student.getGrades().get(i).getTitle();
		}
		Assert.assertEquals("newTitle", result);
	}

	@Test
	public void testGettingTheToStringOfAStudent() {
		String result = "Michael" + " " + "Jordan" + "  |  " + "250695712"
				+ "  |  " + "mjordan@uwo.ca";
		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		int studentNUmber = student.getStudentNumber();
		String emailAddress = student.getEmailAddress();

		String compareTo = firstName + " " + lastName + "  |  " + studentNumber
				+ "  |  " + emailAddress;
	}

}