package team6;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 * Class to create the JTable
 * @author Vinayak
 */
public class JTableUI extends javax.swing.JPanel {

	private JPanel panel;
	private ArrayList<Course> courses;
	private JTable tblCourse;
	
	public JTableUI(Course course) {
        super(new GridLayout(1,0));
		/*this.courses = course;

		courses.add(new Course("a","b","c"));
		courses.get(0).addDeliverable("bb","Assignment",0.23);
		courses.get(0).addDeliverable("bb","Assignment",0.23);
		courses.get(0).addDeliverable("bb","Assignment",0.23);
		courses.get(0).addStudent("a","b",1234,"c");
		courses.get(0).addStudent("a","b",423,"c");
		courses.get(0).addStudent("a","b",1243534,"c");
		courses.get(0).addStudent("b","b",12634234,"c");
		
        final JTable table = new JTable(new CourseTableModel(courses.get(0)));*/
		final JTable table = new JTable(new CourseTableModel(course));
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

	
}