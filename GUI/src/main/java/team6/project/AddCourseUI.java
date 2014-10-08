package team6;

import java.util.ArrayList;

import javax.swing.*;

/**
 * Class to implement the user interface to add a course to the GradeBook
 * @author Team 6 - UWO - CS2212
 */
public class AddCourseUI extends javax.swing.JPanel {

	// Instance Variables
	private JButton addCourseButton;
	private JTextField courseCode;
	private JLabel courseCodeLabel;
	private JComboBox<Course> courseCombo;
	private JLabel courseTermLabel;
	private JTextField courseTitle;
	private JLabel courseTitleLabel;
	private JPanel jPanel7;
	private JLabel alert;
	private ArrayList<Course> courses;

	/**
	 * Creates new form AddCourse
	 */
	public AddCourseUI(ArrayList<Course> courses) {
		this.courses = courses;
		initComponents();
	}
	
	/**
	 * Find appropriate information from fields and call the updateAddCourse
	 * method
	 * 
	 * @param evt
	 */
	private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String[] s = new String[] { "Spring 2013", "Winter 2014",
				"Summer 2014", "Spring 2014", "Winter 2015", "Summer 2015" };
		String term = s[courseCombo.getSelectedIndex()];
		if (courseTitle.getText().equals(""))
			alert.setText("A course title must be entered");
		else if (courseCode.getText().equals(""))
			alert.setText("A course code must be entered");
		else if(find(courseTitle.getText()))
		{
			String a = courseTitle.getText() + " (1)";
			while(find(a))
			{
				a = a + " (1)";
			}
			GradeBookUI.updateAddCourse(a, courseCode.getText(), term);
		}
		else {
			GradeBookUI.updateAddCourse(courseTitle.getText(), courseCode.getText(), term);	
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel7 = new JPanel();
		courseTermLabel = new JLabel();
		courseCombo = new JComboBox<Course>();
		courseTitle = new JTextField();
		courseCode = new JTextField();
		courseCodeLabel = new JLabel();
		courseTitleLabel = new JLabel();
		addCourseButton = new JButton();
		alert = new JLabel();

		jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		courseTermLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		courseTermLabel.setText("Course Term:");

		courseCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Spring 2013", "Winter 2014", "Summer 2014", "Spring 2014" }));

		courseCodeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		courseCodeLabel.setText("Course Code:");

		courseTitleLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
		courseTitleLabel.setText("Course Title: ");

		addCourseButton.setText("Add");
		addCourseButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addCourseButtonActionPerformed(evt);
			}
		});

        alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseTermLabel)
                    .addComponent(courseCodeLabel)
                    .addComponent(courseTitleLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(addCourseButton)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(courseTitle)
                            .addComponent(courseCode)
                            .addComponent(courseCombo, 0, 238, Short.MAX_VALUE))
                        .addGap(12, 12, 12))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseCodeLabel)
                    .addComponent(courseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseTitleLabel)
                    .addComponent(courseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseTermLabel)
                    .addComponent(courseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {alert, courseCode, courseTitle});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
	}
	/**
	 * Find a course title 
	 * @param s the string being searched for
	 * @return boolean- depending on whether or not the string was found in the course list.
	 */
	private boolean find(String s)
	{
		for(int i = 0; i < courses.size(); i++)
		{
			if(s.equals(courses.get(i).getCourseTitle()))
				return true;
		}
		return false;
	}
}
