package team6;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to implement the edit course user interface
 * @author CS2212 - Team 6
 *
 */
public class EditCourseUI extends javax.swing.JPanel {
	
	 // Instance Variables
	 private JComboBox<Course> courseListCombo;
	 private JButton editCourseButton;
	 private JTextField courseCode;
	 private JLabel courseCodeLabel;
	 private JComboBox<Course> courseTermCombo;
	 private JLabel courseTermLabel;
	 private JTextField courseTitle;
	 private JLabel courseTitleLabel;
	 private JPanel jPanel7;
	 private JLabel selectCourseLabel;
	 private JLabel alert;
	 private ArrayList<Course> courses;

 /**
  * Creates new form EditCourse
  */
 public EditCourseUI(ArrayList<Course> courses) {
	 this.courses = courses;
	 initComponents();
 }

 /**
  * This method is called from within the constructor to initialize the form.
  */
 @SuppressWarnings("unchecked")
 private void initComponents() {

  selectCourseLabel = new JLabel();
  courseListCombo = new JComboBox<Course>();
  jPanel7 = new JPanel();
  courseTermLabel = new JLabel();
  courseTermCombo = new JComboBox<Course>();
  courseTitle = new JTextField();
  courseCode = new JTextField();
  courseCodeLabel = new JLabel();
  courseTitleLabel = new JLabel();
  editCourseButton = new JButton();
  alert = new JLabel();

  selectCourseLabel.setText("Select Course:");

  // Add list of courses to combo box
  for (int i = 0; i < courses.size(); i++)
   courseListCombo.addItem(courses.get(i));

  courseListCombo.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    courseListComboActionPerformed(evt);
   }
  });

  jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

  courseTermLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
  courseTermLabel.setText("Course Term:");

  courseTermCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
    "Spring 2013", "Winter 2014", "Summer 2014", "Spring 2014" }));

  courseCodeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
  courseCodeLabel.setText("Course Code:");

  courseTitleLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
  courseTitleLabel.setText("Course Title: ");

  editCourseButton.setText("Update");
  editCourseButton.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    editCourseButtonActionPerformed(evt);
   }
  });

  alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		// user interface layout
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
                        .addComponent(editCourseButton)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(courseTitle)
                            .addComponent(courseCode)
                            .addComponent(courseTermCombo, 0, 244, Short.MAX_VALUE))
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
                    .addComponent(courseTermCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editCourseButton)
                    .addComponent(alert))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {alert, courseCode, courseTitle});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectCourseLabel)
                .addGap(18, 18, 18)
                .addComponent(courseListCombo, 0, 277, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCourseLabel)
                    .addComponent(courseListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(245, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
 }

 /**
 * Action handler for course list combo box
 * @param evt	event handler
 */
 private void courseListComboActionPerformed(java.awt.event.ActionEvent evt) {

 }

 /**
  * Find appropriate information from fields and call the updateEditCourse
  * method
  * 
  * @param evt	event handler
  */
 private void editCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {
	 if (courseListCombo.getSelectedIndex() > 0) {
		 String[] s = new String[] { "Spring 2013", "Winter 2014", "Summer 2014", "Spring 2014" };
		 String term = s[courseTermCombo.getSelectedIndex()];
		 GradeBookUI.updateEditCourse(courseListCombo.getSelectedIndex(), courseTitle.getText(), courseCode.getText(), term);
		 alert.setText("The course has been updated");
	 }
	 // if no course was selected in the course combo box, show alert
	 else
		 alert.setText("You must select a course to update");
 }
}
