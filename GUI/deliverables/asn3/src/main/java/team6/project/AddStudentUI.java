package team6;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Class the implement the user interface for adding students to the GradeBook
 * @author CS2212 - Team 6
 */
public class AddStudentUI extends javax.swing.JPanel {

	//Instance Variables
	private JButton addStudentButton;
	private JTextField firstName;
	private JLabel firstNameLabel;
	private JPanel jPanel11;
	private JTextField lastName;
	private JLabel lastNameLabel;
	private JTextField studentEmail;
	private JLabel studentEmailLabel;
	private JTextField studentID;
	private JLabel studentIDLabel;
	private JLabel selectCourseLabel;
	private JLabel alert;
	//private JComboBox<Course> courseListCombo;
	//private ArrayList<Course> courses;

	/**
	 * Creates new form AddStudent
	 * @param courses 	list of courses in the gradebook
	 */
	public AddStudentUI(ArrayList<Course> courses) {
		//this.courses = courses;
		initComponents();
	}
	
	/**
	 * Finds appropriate elements from fields and calls the updateAddStudent 
	 * method in order to add Student information
	 * @param evt	event handler
	 */
	private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {
		/*if (courseListCombo.getSelectedIndex() > 0) {
			int studentIDInt = Integer.parseInt(studentID.getText());
			GradeBookUI.updateAddStudent(firstName.getText(), lastName.getText(), studentIDInt, studentEmail.getText());
			alert.setText("The student has been added");
		}
		else
			alert.setText("A course must be selected");*/
			int studentIDInt = Integer.parseInt(studentID.getText());
			GradeBookUI.updateAddStudent(firstName.getText(), lastName.getText(), studentIDInt, studentEmail.getText());
	}

    /**
     * This method is called from within the constructor to initialize the form.
     */
	@SuppressWarnings("unchecked")                        
    private void initComponents() {

		// user interface elements
        jPanel11 = new javax.swing.JPanel();
        lastName = new javax.swing.JTextField();
        firstName = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        addStudentButton = new javax.swing.JButton();
        studentIDLabel = new javax.swing.JLabel();
        studentID = new javax.swing.JTextField();
        studentEmailLabel = new javax.swing.JLabel();
        studentEmail = new javax.swing.JTextField();
        selectCourseLabel = new javax.swing.JLabel();
        //courseListCombo = new javax.swing.JComboBox<Course>();
        alert = new javax.swing.JLabel();

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		selectCourseLabel.setText("Select Course:");
        /*
        // Add list of courses to combo box
        for (int i = 0; i < courses.size(); i++)
         courseListCombo.addItem(courses.get(i));
        
        courseListCombo.addActionListener(new java.awt.event.ActionListener() {
        	   public void actionPerformed(java.awt.event.ActionEvent evt) {
        	    courseListComboActionPerformed(evt);
        	   }
        	  });
*/
        firstNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        firstNameLabel.setText("First Name:");

        lastNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lastNameLabel.setText("Last Name:");

		// calls the event handler for add button
        addStudentButton.setText("Add");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        studentIDLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        studentIDLabel.setText("Student ID:");

        studentEmailLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        studentEmailLabel.setText("Email:");

        alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		// user interface layout
         javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(firstNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(firstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameLabel)
                            .addComponent(studentIDLabel)
                            .addComponent(studentEmailLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(addStudentButton))
                            .addComponent(studentEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIDLabel)
                    .addComponent(studentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentEmailLabel)
                    .addComponent(studentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addStudentButton)
                    .addComponent(alert, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {alert, firstName, lastName, studentEmail, studentID});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    /*.addGroup(layout.createSequentialGroup()
                        .addComponent(selectCourseLabel)
                        .addGap(11, 11, 11)
                        .addComponent(courseListCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))*/)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                /*.addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCourseLabel)
                    .addComponent(courseListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))*/
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
	
	/**
	* Action handler for populating the course list combo box
	* @param evt	event handler
	*/
	 private void courseListComboActionPerformed(java.awt.event.ActionEvent evt) {
		 }
}
