package team6;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

/**
 * Class to create the Table Model
 * @author CS2212 - Team 6
 */
public class CourseTableModel extends AbstractTableModel {
	private String[] headers;
	private Object[][] rowData;
	private int rowNum, colNum;
	private Course course;
	
	public CourseTableModel(Course course){
		this.course = course;
	
		//Sets the header for the columns
		headers = new String[course.getDeliverables().size() + 2 +1];
		headers[0]="First Name";
		headers[1]="Last Name";
		for (int i = 0; i < course.getDeliverables().size(); i++)
			headers[i+2] = course.getDeliverables().get(i).getName();
		headers[course.getDeliverables().size() + 2] = "Average";
		
		//Populates the rows of the table
		rowNum = course.getStudents().size();
		colNum = headers.length;
		rowData = new Object[rowNum][colNum];
		for(int i = 0; i < course.getStudents().size(); i++){
			rowData[i][0] = course.getStudents().get(i).getFirstName();
			rowData[i][1] = course.getStudents().get(i).getLastName();
			
			//Does not populate average field, but populates grades
			for(int j = 0; j < course.getStudents().get(i).getGrades().size(); j++){
				String del = course.getStudents().get(i).getGrades().get(j).getDeliverable().getName();
				for(int k = 0; k < colNum; k++)
					if(headers[k].equals(del))
						rowData[i][k] = course.getStudents().get(i).getGrades().get(j).getGrade();
			}
		}	
	}
	
	public String getColumnName(int col) {
		return headers[col];
	}
	
	public int getRowCount(){
		return rowNum; 
	}
	
	public int getColumnCount(){
		return colNum;
	}
	
	public Object getValueAt(int row, int col){
		return rowData[row][col];
	}
	
	//All cells currently ditable
	public boolean isCellEditable(int row, int col){
		return true;
	}
	
	public void setValueAt(Object value, int row, int col){
		boolean c = false;
		for(int i = 0; i < course.getStudents().get(row).getGrades().size(); i++)
			if(course.getStudents().get(row).getGrades().get(i).getDeliverable().getName().equals(headers[col])){
				course.getStudents().get(row).getGrades().get(i).setGrade(Double.parseDouble(value.toString()));
				c = true;
			}
		if(!c)
			course.getStudents().get(row).addGrade(Double.parseDouble(value.toString()), course.getDeliverables().get(col-2));
			
		rowData[row][col] = value;
        fireTableCellUpdated(row, col);
	}
}