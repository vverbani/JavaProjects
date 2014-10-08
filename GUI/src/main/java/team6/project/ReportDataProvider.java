package team6;
import java.util.*;

/**
 * The ReportDataProvider Class contains mock data that was used to put together the JasperReports Template
 * @version 1.0
 * @author Team 6 - UWO - CS2212
 * @since April 2 2014
 */

public class ReportDataProvider {

	/**
	 * This method provided mock data that was sent into JasperStudio.
	 * @return Colletion<ReportData> a collection object that holds mock course information
	 */
	public static Collection<ReportData> loadData() throws Exception{
		

		Course course;
		Student student;
		Collection<ReportData> data = new ArrayList<ReportData>();

		course = new Course("Into to Software Engineering", "CS2212B",
				"Winter 2014");
		student = new Student("Anne", "Doe", 250000000, "adoe@uwo.ca");

		course.addStudent(student);

		// create Grades and add to Student
		Grade grade1 = new Grade(75, "Asn 1", 20);
		Grade grade2 = new Grade(80, "Asn 2", 20);
		Grade grade3 = new Grade(60, "Asn 3", 20);
		Grade grade4 = new Grade(75, "Midterm", 20);
		Grade grade5 = new Grade(67, "Final", 20);
		student.addGrade(grade1);
		student.addGrade(grade2);
		student.addGrade(grade3);
		student.addGrade(grade4);
		student.addGrade(grade5);

		// create deliverables and add to Course
		Deliverable dev1 = new Deliverable("Asn 1", "Assignment", 20);
		Deliverable dev2 = new Deliverable("Asn 2", "Assignment", 20);
		Deliverable dev3 = new Deliverable("Asn 3", "Assignment", 20);
		Deliverable dev4 = new Deliverable("Midterm", "Exam", 20);
		Deliverable dev5 = new Deliverable("Final", "Exam", 20);
		course.addDeliverable(dev1);
		course.addDeliverable(dev2);
		course.addDeliverable(dev3);
		course.addDeliverable(dev4);
		course.addDeliverable(dev5);

		ReportData reportData = new ReportData(course, student, -1);
		data.add(reportData);

		// adds the remaining items to the collection
		for (int i = 0; i < course.getDeliverables().size(); i++) {
			if (course.getDeliverables().get(i) != null)
				data.add(new ReportData(course, student, i));
		}

		return data;
	}	//end loadData
}//end ReportDataProvider
