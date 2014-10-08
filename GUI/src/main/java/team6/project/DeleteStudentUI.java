package team6;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to implement the delete student user interface
 * 
 * @author CS2212 Team 6
 */
@SuppressWarnings("serial")
public class DeleteStudentUI extends javax.swing.JPanel {

	// Instance Variables
	private JButton deleteStudentButton;
	private JLabel firstName;
	private JLabel firstNameLabel;
	private JPanel jPanel12;
	private JLabel lastName;
	private JLabel lastNameLabel;
	private JLabel selectStudentLabel;
	private JLabel studentEmail;
	private JLabel studentEmailLabel;
	private JLabel studentID;
	private JLabel studentIDLabel;
	private JLabel alert;
	private JComboBox<Student> studentListCombo;
	private ArrayList<Student> students;

	/**
	 * Creates new form DeleteStudent
	 */
	public DeleteStudentUI(ArrayList<Student> students) {
		this.students = students;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		selectStudentLabel = new javax.swing.JLabel();
		studentListCombo = new javax.swing.JComboBox<Student>();
		jPanel12 = new javax.swing.JPanel();
		deleteStudentButton = new javax.swing.JButton();
		firstNameLabel = new javax.swing.JLabel();
		lastNameLabel = new javax.swing.JLabel();
		studentIDLabel = new javax.swing.JLabel();
		studentEmailLabel = new javax.swing.JLabel();
		firstName = new javax.swing.JLabel();
		lastName = new javax.swing.JLabel();
		studentID = new javax.swing.JLabel();
		studentEmail = new javax.swing.JLabel();
		alert = new javax.swing.JLabel();

		// If the student list in the course is not empty, add the list of
		// students to student combo box
		if (!students.isEmpty()) {
			for (int i = 0; i < students.size(); i++)
				studentListCombo.addItem(students.get(i));
		}

		selectStudentLabel.setText("Select Student:");

		studentListCombo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				studentListComboActionPerformed(evt);
			}
		});

		jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		deleteStudentButton.setText("Delete");
		deleteStudentButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						deleteStudentButtonActionPerformed(evt);
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

		firstName.setText("");

		lastName.setText("");

		studentID.setText("");

		studentEmail.setText("");

		alert.setFont(new java.awt.Font("Tahoma", 1, 12));

		// user interface layout

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(firstNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(firstName, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameLabel)
                            .addComponent(studentEmailLabel)
                            .addComponent(studentIDLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteStudentButton))
                            .addComponent(lastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstName))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastName))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIDLabel)
                    .addComponent(studentID))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentEmailLabel)
                    .addComponent(studentEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {firstName, lastName, studentEmail, studentEmailLabel, studentID});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectStudentLabel)
                        .addGap(18, 18, 18)
                        .addComponent(studentListCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectStudentLabel)
                    .addComponent(studentListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
	/**
	 * this method populates the labels with chosen student data when an action occurs on the pane. 
	 * @param evt
	 */
	private void studentListComboActionPerformed(java.awt.event.ActionEvent evt) {
		// populate the labels with the chosen student data
		firstName.setText(students.get(studentListCombo.getSelectedIndex())
				.getFirstName());
		lastName.setText(students.get(studentListCombo.getSelectedIndex())
				.getLastName());

		String studentIDStr = Integer.toString(students.get(
				studentListCombo.getSelectedIndex()).getStudentNumber());
		studentID.setText(studentIDStr);

		studentEmail.setText(students.get(studentListCombo.getSelectedIndex())
				.getEmailAddress());
	}

	/**
	 * Action handler for the delete student button
	 * 
	 * @param evt
	 *            event handler
	 */
	private void deleteStudentButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		GradeBookUI.updateDeleteStudent(studentListCombo.getSelectedIndex());
		alert.setText("The student has been deleted");
	}

}
