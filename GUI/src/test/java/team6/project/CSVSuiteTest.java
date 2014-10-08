package team6;

import org.junit.Before;
import junit.framework.Assert;
import org.junit.Test;
import java.util.ArrayList;
/**
 * This class contains Junit tests for the CSVSuite class.
 * 
 * @author Team 6
 *
 */
public class CSVSuiteTest {
	private Course c = new Course("Computer Logic", "CS2212B", "Spring 2013");
	Student s1 = new Student("Allan", "Yan", 250000000, "ayan@uwo.ca");
	Student s2 = new Student("Valmir", "Verbani", 250000001, "vverbani@uwo.ca");
	Student s3 = new Student("Vanessa", "Seguin", 250000002, "vseguin@uwo.ca");
	// Deliverables deliverable = ("Assignment","Two",35.0);
	private CSVSuite suite;
	private String fName = "src/test/resources/test.csv";

	@Before
	public void createCSV() {
		this.suite = new CSVSuite(c, fName);
		c.addStudent(new Student("Allan", "Yan", 250000000, "ayan@uwo.ca"));
		c.getStudents().get(0).addGrade(new Grade(35.0, "Test", 10.0));
		c.addStudent(new Student("Valmir", "Verbani", 250000001,
				"vverbani@uwo.ca"));
		c.addStudent(new Student("Vanessa", "Seguin", 250000002,
				"vseguin@uwo.ca"));
		c.addDeliverable(new Deliverable("Assignment", "Two", 35.0));

		suite.exportCSV();

		c = suite.importStudents();
	}

	// ////////TESTS/////////////////////

	// the first four tests will check to make sure that a student's data has
	// been imported properly.

	@Test
	public void testAddingStudentToCourseAddingGradesToStudentAndGettingGrade() {
		double result = c.getStudents().get(0).getGrades().get(0).getGrade();
		Assert.assertEquals(35.0, result);
	}

	@Test
	public void testAddingStudentToCourseAddingGradesToStudentAndGettingTitle() {
		String result = c.getStudents().get(0).getGrades().get(0).getTitle();
		Assert.assertEquals("Test", result);
	}

	@Test
	public void testAddingStudentToCourseAddingGradesToStudentAndGettingWeight() {
		double result = c.getStudents().get(0).getGrades().get(0).getWeight();
		Assert.assertEquals(10.0, result);
	}

	@Test
	public void testAddingDeliverableToCourse() {
		boolean test = false;
		c.addDeliverable(new Deliverable("Assignment", "Two", 35.0));
		if (c.getDeliverables().size() > 0) {
			test = true;
		}
		Assert.assertEquals(true, test);
	}

	@Test
	public void testImportingDeliverableAndSearchingForIt() {
		boolean test = false;
		test = suite.search(c, "Assignment");
		Assert.assertEquals(true, test);
	}

	@Test
	public void testImportingDeliverableAndSearchingForWrongOne() {
		boolean test = false;
		test = suite.search(c, "Exam");
		Assert.assertEquals(false, test);
	}

	@Test
	public void testImportStudentStudentNumber() {
		c = suite.importStudents();
		int result = c.getStudents().get(0).getStudentNumber();
		Assert.assertEquals(250000000, result);

	}

	@Test
	public void testImportStudentAndGettingSecondStudentStudentNumber() {
		// c = suite.importStudents();
		int result = c.getStudents().get(1).getStudentNumber();
		Assert.assertEquals(250000001, result);
	}

	@Test
	public void testImportStudentAndGettingThirdStudentNumber() {
		// c = suite.importStudents();
		int result = c.getStudents().get(2).getStudentNumber();
		Assert.assertEquals(250000002, result);
	}

	@Test
	public void testImportStudentandGettingFirstStudentFirstName() {
		// c = suite.importStudents();
		String result = c.getStudents().get(0).getFirstName();
		Assert.assertEquals("Allan", result);
	}

	@Test
	public void testImportStudentandGettingSecondStudentFirstName() {
		// c = suite.importStudents();
		String result = c.getStudents().get(1).getFirstName();
		Assert.assertEquals("Valmir", result);
	}

	@Test
	public void testImportStudentandGettingThirdStudentFirstName() {
		// c = suite.importStudents();
		String result = c.getStudents().get(2).getFirstName();
		Assert.assertEquals("Vanessa", result);
	}

	@Test
	public void testImportStudentAndGettingFirstStudentLastName() {
		// c = suite.importStudents();
		String result = c.getStudents().get(0).getLastName();
		Assert.assertEquals("Yan", result);
	}

	@Test
	public void testImportStudentAndGettingSecondStudentLastName() {
		// c = suite.importStudents();
		String result = c.getStudents().get(1).getLastName();
		Assert.assertEquals("Verbani", result);
	}

	@Test
	public void testImportStudentAndGettingThirdStudentLastName() {
		// c = suite.importStudents();
		String result = c.getStudents().get(2).getLastName();
		Assert.assertEquals("Seguin", result);
	}

}// end CSVTest