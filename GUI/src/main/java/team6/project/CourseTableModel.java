package team6;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.io.*;

/**
 * Class to create the Table Model
 * 
 * @author CS2212 - Team 6
 */
public class CourseTableModel extends AbstractTableModel implements
		Serializable {
	private String[] headers;
	private Object[][] rowData;
	private int rowNum, colNum;
	private Course course;

	/**
	 * Constructor initalizes the table model. Sets the column titles and
	 * populates the table with the students
	 */
	public CourseTableModel(Course course) {
		this.course = course;

		// Sets the header for the columns
		headers = new String[course.getDeliverables().size() + 3 + 3];
		headers[0] = "First Name";
		headers[1] = "Last Name";
		headers[2] = "Student Number";
		for (int i = 0; i < course.getDeliverables().size(); i++)
			headers[i + 3] = course.getDeliverables().get(i).getName();
		headers[course.getDeliverables().size() + 5] = "Average";
		headers[course.getDeliverables().size() + 4] = "Exam Average";
		headers[course.getDeliverables().size() + 3] = "Assignment Average";

		// Populates the rows of the table
		rowNum = course.getStudents().size();
		colNum = headers.length;
		rowData = new Object[rowNum][colNum];
		for (int i = 0; i < course.getStudents().size(); i++) {
			rowData[i][0] = course.getStudents().get(i).getFirstName();
			rowData[i][1] = course.getStudents().get(i).getLastName();
			rowData[i][2] = course.getStudents().get(i).getStudentNumber();

			// Does not populate average field, but populates grades
			for (int j = 0; j < course.getStudents().get(i).getGrades().size(); j++) {
				String del = course.getStudents().get(i).getGrades().get(j)
						.getTitle();
				for (int k = 3; k < colNum; k++)
					if (headers[k].equals(del)) {
						rowData[i][k] = course.getStudents().get(i).getGrades()
								.get(j).getGrade();
					}
			}

			rowData[i][colNum - 1] = this.course.getStudents().get(i)
					.getAverage();
			rowData[i][colNum - 2] = this.course.getStudents().get(i)
					.getExamAverage();
			rowData[i][colNum - 3] = this.course.getStudents().get(i)
					.getAssignmentAverage();
			if (Double.isNaN(this.course.getStudents().get(i).getAverage()))
				rowData[i][colNum - 1] = 0.0;
			if (Double.isNaN(this.course.getStudents().get(i).getExamAverage()))
				rowData[i][colNum - 2] = 0.0;
			if (Double.isNaN(this.course.getStudents().get(i)
					.getAssignmentAverage()))
				rowData[i][colNum - 3] = 0.0;
		}
	}

	/**
	 * Returns column name
	 */
	public String getColumnName(int col) {
		return headers[col];
	}

	/**
	 * Returns number of rows in table, same as number of students
	 */
	public int getRowCount() {
		return rowNum;
	}

	/**
	 * Returns number of columns
	 */
	public int getColumnCount() {
		return colNum;
	}

	/**
	 * Returns the value at the specified table index
	 */
	public Object getValueAt(int row, int col) {
		return rowData[row][col];
	}

	/**
	 * Determines which cells are editable Only grades are editable
	 */
	public boolean isCellEditable(int row, int col) {
		if (col > 2 && col < (colNum - 3))
			return true;
		return false;
	}

	/**
	 * Updates JTable display to show edited value Updates value for the student
	 */
	public void setValueAt(Object value, int row, int col) {
		// Make sure the input value is a number
		try {
			Double.parseDouble(value.toString());
		} catch (Exception E) {
			GradeBookUI.setAlert("Please enter a number");
			return;
		}
		// Update appropriate grade for the student
		boolean c = false;

		for (int i = 0; i < course.getStudents().get(row).getGrades().size(); i++)
			if (course.getStudents().get(row).getGrades().get(i).getTitle()
					.equals(headers[col])) {
				course.getStudents().get(row).getGrades().get(i)
						.setGrade(Double.parseDouble(value.toString()));
				c = true;
			}
		if (!c) {
			Grade grade = new Grade(Double.parseDouble(value.toString()),
					headers[col], course.getDeliverables().get(col - 3)
							.getWeight(), course.getDeliverables().get(col - 3)
							.getType());
			course.getStudents().get(row).addGrade(grade);
		}

		// Update display
		rowData[row][col] = value;
		fireTableCellUpdated(row, col);
		if (course.getStudents().get(row).getAverage() == Double.NaN) {
			//System.out.println("NaN: "+ course.getStudents().get(row).getAverage());
			rowData[row][colNum - 1] = 0;
		} else
			rowData[row][colNum - 1] = course.getStudents().get(row)
					.getAverage();
		fireTableCellUpdated(row, colNum - 1);

		if (course.getStudents().get(row).getExamAverage() == Double.NaN) {
			//System.out.println("NaN: "	+ course.getStudents().get(row).getExamAverage());
			rowData[row][colNum - 2] = 0;
		} else
			rowData[row][colNum - 2] = course.getStudents().get(row)
					.getExamAverage();
		fireTableCellUpdated(row, colNum - 2);

		if (course.getStudents().get(row).getAssignmentAverage() == Double.NaN) {
			//System.out.println("NaN: "	+ course.getStudents().get(row).getAssignmentAverage());
			rowData[row][colNum - 3] = 0;
		} else
			rowData[row][colNum - 3] = course.getStudents().get(row)
					.getAssignmentAverage();
		fireTableCellUpdated(row, colNum - 3);
	}
}