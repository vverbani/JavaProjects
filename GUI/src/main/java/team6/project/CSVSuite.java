package team6;

import java.io.*;
import java.util.*;

/**
 * CSVSuite object class- creates a CSV utility object
 * @author CS2212 - Team 6 
 */
public class CSVSuite {

	/* ************************************************************
	 * Instance Variables *
	 * ************************************************************
	 */
	private Course course;
	private String fName;

	/**
	 * Constructor for CSV Suite
	 * 
	 * @param Course
	 *            c
	 * @param String
	 *            fileName
	 */
	public CSVSuite(Course c, String fileName) {
		course = c;
		fName = fileName;
	}// end constructor

	/**
	 * This method reads in the csv file specified by the fileName of the CSV
	 * Object Then it updates the marks of the students in the course
	 * accordingly.
	 * 
	 * @return Course- the same course object containing the updated student
	 *         grades.
	 */
	public Course importCSV() {
		try {
			CSVReader reader = new CSVReader(new FileReader(this.fName));
			String[] headers = reader.readNext();
			String[] nextLine;
			int stdIndex = -1;

			String[][] deliverableIndexes = new String[headers.length - 1][2];

			// find out what index the student numbers are at
			if (headers != null) {
				for (int i = 0; i < headers.length - 1; i++) {
					if (headers[i].equals("Student Number")) {
						stdIndex = i;
						break;
					}
				}
				if (stdIndex == -1) {
	//				System.out.println("Error: Student Numbers not found- please format the header as \"Student Number\"");
					return null;
				}
			}

			int j = 0;
			// find out what deliverables are being updated
			for (int i = 0; i < headers.length - 1; i++) {
				// if the current column name corresponds with the name of a
				// deliverable in the course...
				if (search(course, headers[i])) 
				{
					// in the first row, store the names of the deliverables
					deliverableIndexes[j][0] = headers[i]; 
					
					// in the second row, store the index value for reference from header
					deliverableIndexes[j][1] = Integer.toString(i);
					j++;
				}
			}

			for(int i = 0; i < deliverableIndexes.length; i++)
			{
				for(int a = 0; a < deliverableIndexes[0].length;j++)
				{
					
				}
			}
			
			// update the deliverables
			// while loop to update for each student
			int studentNumber;
			Student currStudent;
			ArrayList<Grade> currDeliverables;
			Grade currGrade;
			ArrayList<Student> sList = course.getStudents();
			int i = 0;

			// going through each student record in the csv
			while ((nextLine = reader.readNext()) != null) {
				studentNumber = Integer.parseInt(nextLine[stdIndex]);
				j = 0; // use j as a counter through the list of students

				// search through the student list for a match on student number
				while (j < sList.size()) {
					// when we've found it, we update the marks.
					if (sList.get(j).getStudentNumber() == studentNumber) {
						// getting the student and their grades list.
						currStudent = sList.get(j);
						currDeliverables = currStudent.getGrades();

						// iterating through the list of Grades, updating marks.
						for (int k = 0; k < currDeliverables.size(); k++) {
							// current grade is:
							currGrade = currDeliverables.get(k);
							// match title with the one in deliverableIndex
							for (int l = 0; l < deliverableIndexes[0].length; l++) {
								// update the mark.
								if (currGrade.getTitle().equals(
										deliverableIndexes[l][0])) {
									double d = Double
											.parseDouble(nextLine[Integer
													.parseInt(deliverableIndexes[l][1])]);
									currGrade.setGrade(d);
								}
							}
						}
						break;
					}

					j++;

					if (j == sList.size() ) {}
					//	System.out.println("Student Number not found- "+ studentNumber);
				}
			}
			//System.out.println("import complete.");
		} catch (Exception e) {
			// System.out.println("filereading failed");

		}
		return course;
	}// end importCSV

	/**
	 * This method creates a CSV file and saves the course data within it.
	 */
	public void exportCSV() {
		try {

			// creating the file if necessary, and then its corresponding writer
			File file = new File(fName);
			if (!file.exists())
				file.createNewFile();
			Writer wR = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file)));

			// containing the grades in order for each student.
			List<String[]> result = new ArrayList<String[]>();

			// turn the current course into an array of strings
			int size = course.getDeliverables().size();
			String[] deliverables = new String[size];
			String[] currentStudentData;
			Student currentStudent;

			// convert the list of deliverables to a string array
			for (int i = 0; i < course.getDeliverables().size(); i++) {
				deliverables[i] = course.getDeliverables().get(i).getName();
			}

			// the header array will contain data for the column names
			String[] header = new String[deliverables.length + 4];

			header[0] = "First Name";
			header[1] = "Last Name";
			header[2] = "Student Number";
			header[3] = "Email Address";
			int k=0;
			for (int i = 4; i < header.length; i++) 
			{
				header[i] = deliverables[k++];
			}

			// add the header into the writer.
			StringBuilder sBuilder = new StringBuilder();
			for (String s : header) 
			{
				sBuilder.append(s);
				sBuilder.append(",");
			}
			String s = sBuilder.toString();
			wR.write(s);
			wR.write("\n");
			
			int n =4;
			// for loop to parse through the arraylist of students
			for (int i = 0; i < course.getStudents().size(); i++) 
			{
				n=4;
				currentStudent = course.getStudents().get(i);
				currentStudentData = new String[header.length];
				currentStudentData[0] = currentStudent.getFirstName();
				currentStudentData[1] = currentStudent.getLastName();
				currentStudentData[2] = Integer.toString(currentStudent.getStudentNumber());
				currentStudentData[3] = currentStudent.getEmailAddress();
				
				for (int j = 0; j < currentStudent.getGrades().size(); j++) 
				{
					currentStudentData[n++] = Double.toString(currentStudent.getGrades().get(j).getGrade());
				}
				result.add(currentStudentData);
			}

			// now convert each string array in the list into a string, and then
			// write it to the

			for (String[] curr : result) 
			{
				sBuilder = new StringBuilder();

				for (String a : curr) {
					sBuilder.append("\"");
					sBuilder.append(a);
					sBuilder.append("\"");
					sBuilder.append(",");
				}

				s = sBuilder.toString();
				wR.write(s);
				wR.write("\n");
			}

			wR.close();
			// System.out.println("export complete.");
		} 
		catch (Exception e) 
		{
			File file = new File(fName);
			// System.out.println("error- export failed");
		}
	}

	/**
	 * This method imports a list of students
	 * 
	 * @return the updated course of students
	 */
	public Course importStudents() {
		try {
			CSVReader reader = new CSVReader(new FileReader(this.fName));

			String[] nextLine = reader.readNext();
			String firstName;
			String lastName;
			String email;
			int studentNumber;
			Student s;

			while (nextLine != null) {
				firstName = nextLine[10];
				lastName = nextLine[11] + " " + nextLine[9]; // appending the
																// middle name
																// and last name
																// together
				studentNumber = Integer.parseInt(nextLine[8]);
				email = nextLine[13];

				// check first to make sure student number isn't already in
				// there.
				if (!course.findStudent(studentNumber)) {
					Student student = new Student(firstName, lastName,
							studentNumber, email);
					course.addStudent(student);
				} else {
					//System.out.println("student number " + studentNumber
					//		+ " was already found");
					//System.out.println(firstName + " " + lastName
					//		+ " was not added to the course");
				}
				nextLine = reader.readNext();
			}
			reader.close();
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("filereading failed");
		}
		return course;
	}

	/**
	 * A helper method that helps find a certain deliverable within the
	 * specified course.
	 * 
	 * @param c
	 *            the course being searched
	 * @param src
	 *            the search query
	 * @return a boolean value that determines whether or not the string has
	 *         been found.
	 */
	public boolean search(Course c, String src) {
		ArrayList<Deliverable> deliverables = c.getDeliverables();
		int i = 0;
		while (i < deliverables.size()) {
			if (deliverables.get(i).getName().equals(src)) {
				return true;
			}
			i++;
		}
		return false;
	}// end search

}// end CSVSuite
