package team6;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to implement the edit student user interface
 * @author CS2212 - Team 6
 */
public class EditStudentUI extends javax.swing.JPanel {
	
	 // Instance Variables
	 private JButton editStudentButton;
	 private JPanel editStudentPane;
	 private JTextField firstName;
	 private JLabel firstNameLabel;
	 private JTextField lastName;
	 private JLabel lastNameLabel;
	 private JComboBox<Course> courseListCombo;
	 private JComboBox<Student> studentListCombo;
	 private JLabel selectCourseLabel;
	 private JLabel selectStudentLabel;
	 private JTextField studentEmail;
	 private JLabel studentEmailLabel;
	 private JTextField studentID;
	 private JLabel studentIDLabel;
	 private JLabel alert;
	 private ArrayList<Course> courses;
	 private ArrayList<Student> students;

 /**
  * Creates new form EditStudent
  */
 public EditStudentUI(ArrayList<Course> courses) {
	 this.courses = courses;
	 initComponents();
 }

 /**
  * This method is called from within the constructor to initialize the form.
  */                       
 private void initComponents() {

     editStudentPane = new JPanel();
     editStudentButton = new JButton();
     firstName = new JTextField();
     lastName = new JTextField();
     studentID = new JTextField();
     studentEmail = new JTextField();
     firstNameLabel = new JLabel();
     lastNameLabel = new JLabel();
     studentIDLabel = new JLabel();
     studentEmailLabel = new JLabel();
     courseListCombo = new JComboBox<Course>();
     selectCourseLabel = new JLabel();
     selectStudentLabel = new JLabel();
     studentListCombo = new JComboBox<Student>();
     alert = new JLabel();

     editStudentPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

     editStudentButton.setText("Update");
     editStudentButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             editStudentButtonActionPerformed(evt);
         }
     });
     
     // Add list of courses to combo box
     for (int i = 0; i < courses.size(); i++)
      courseListCombo.addItem(courses.get(i));
     
     courseListCombo.addActionListener(new java.awt.event.ActionListener() {
     	   public void actionPerformed(java.awt.event.ActionEvent evt) {
     	    courseListComboActionPerformed(evt);
     	   }
     	  });

     selectCourseLabel.setText("Select Course:");

     selectStudentLabel.setText("Select Student:");

     studentListCombo.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             studentListComboActionPerformed(evt);
         }
     });

     firstNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
     firstNameLabel.setText("First Name:");

     lastNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
     lastNameLabel.setText("Last Name:");

     studentIDLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
     studentIDLabel.setText("Student ID:");

     studentEmailLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
     studentEmailLabel.setText("Email:");

     alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		// user interface layout
       javax.swing.GroupLayout editStudentPaneLayout = new javax.swing.GroupLayout(editStudentPane);
        editStudentPane.setLayout(editStudentPaneLayout);
        editStudentPaneLayout.setHorizontalGroup(
            editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editStudentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editStudentPaneLayout.createSequentialGroup()
                        .addGroup(editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel)
                            .addComponent(lastNameLabel)
                            .addComponent(studentIDLabel))
                        .addGap(30, 30, 30)
                        .addGroup(editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstName)
                            .addComponent(lastName)
                            .addComponent(studentID)))
                    .addGroup(editStudentPaneLayout.createSequentialGroup()
                        .addComponent(studentEmailLabel)
                        .addGap(59, 59, 59)
                        .addGroup(editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editStudentPaneLayout.createSequentialGroup()
                                .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(editStudentButton))
                            .addComponent(studentEmail))))
                .addContainerGap())
        );
        editStudentPaneLayout.setVerticalGroup(
            editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editStudentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIDLabel)
                    .addComponent(studentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentEmailLabel)
                    .addComponent(studentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editStudentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editStudentButton)
                    .addComponent(alert))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        editStudentPaneLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {alert, firstName, lastName, studentEmail, studentID});

        courseListCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseListComboActionPerformed(evt);
            }
        });

        selectCourseLabel.setText("Select Course:");

        selectStudentLabel.setText("Select Student:");

        studentListCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentListComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editStudentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectCourseLabel)
                            .addComponent(selectStudentLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentListCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(courseListCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCourseLabel)
                    .addComponent(courseListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectStudentLabel)
                    .addComponent(studentListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editStudentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
 }                                               

 /**
 * Action handler for course list combo box, populates the student list combo box
 * @param evt	event handler
 */
 private void courseListComboActionPerformed(java.awt.event.ActionEvent evt) {
	 if (courseListCombo.getSelectedIndex() > 0) {
		 int c = courseListCombo.getSelectedIndex();
		 Course course = courses.get(c);
		 students = course.getStudents();

		 // If the student list in the course is not empty, add the list of students to student combo box
		 if (!students.isEmpty()) {
			 for (int i = 0; i < students.size(); i++)
				 studentListCombo.addItem(students.get(i));

			 studentListCombo.addActionListener(new java.awt.event.ActionListener() {
				 public void actionPerformed(java.awt.event.ActionEvent evt) {
					 studentListComboActionPerformed(evt);
				 }
			 });
		 }
	 }
 }                                               

 /**
 * Action handler for student list combo box
 * @param evt	event handler
 */
 private void studentListComboActionPerformed(java.awt.event.ActionEvent evt) {
	 
 }                                             
 
 /**
  * Find appropriate information from fields and call the updateEditStudent
  * method to update all object
  * 
  * @param evt	Event handler
  */
 private void editStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {
	 if (courseListCombo.getSelectedIndex() > 0) {
		 if (studentListCombo.getSelectedIndex() >= 0) {
			 int studentIdInt = Integer.parseInt(studentID.getText());
			 GradeBookUI.updateEditStudent(studentListCombo.getSelectedIndex(), courseListCombo.getSelectedIndex(),
					 firstName.getText(), lastName.getText(), studentIdInt, studentEmail.getText());
			 alert.setText("The student has been edited");
		 }
		 // if no student is selected and button is pressed, show alert
		 else
			 alert.setText("A student must be selected");
  	}
	// if no course is selected and button is pressed, show alert
	 else
		 alert.setText("A course must be selected");
  }
}
