package team6;

import java.util.ArrayList;

import javax.swing.*;

/**
 * Class to implement the edit student user interface
 * 
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
	private JComboBox<Student> studentListCombo;
	private JLabel selectStudentLabel;
	private JTextField studentEmail;
	private JLabel studentEmailLabel;
	private JTextField studentID;
	private JLabel studentIDLabel;
	private JLabel alert;
	private ArrayList<Student> students;

	/**
	 * Creates new form EditStudent
	 */
	public EditStudentUI(ArrayList<Student> students) {
		this.students = students;
		initComponents();
	}

	/**
	 * Action handler for student list combo box
	 * 
	 * @param evt
	 *            event handler
	 */
	private void studentListComboActionPerformed(java.awt.event.ActionEvent evt) {
		// populate the text boxes with the existing student data
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
	 * Find appropriate information from fields and call the updateEditStudent
	 * method to update all object
	 * 
	 * @param evt
	 *            Event handler
	 */
	private void editStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// selected student index
		int currentIndex = studentListCombo.getSelectedIndex();

		int eStudentID = students.get(currentIndex).getStudentNumber();
		String eStudentEmail = students.get(currentIndex).getEmailAddress();

		// check if the first name is not empty
		if (firstName.getText().equals("")) {
			alert.setText("A student's first name must be entered");
		}
		// check if the last name is not empty
		else if (lastName.getText().equals("")) {
			alert.setText("A student's last name must be entered");
		} else {
			// check if the first name and last name are only characters
			for (int i = 0; i < firstName.getText().length(); i++) {
				if (!firstName.getText().matches("[a-zA-Z]+")) {
					alert.setText("Student's first name not valid format");
					return;
				}
			}
			for (int i = 0; i < lastName.getText().length(); i++) {
				if (!lastName.getText().matches("[a-zA-Z]+")) {
					alert.setText("Student's first name not valid format");
					return;
				}
			}
			// check if student ID is a number
			try {
				int studentIDInt = Integer.parseInt(studentID.getText());

				// check uniqueness of student ID and e-mail
				for (int i = 0; i < students.size(); i++) {
					if (studentIDInt == students.get(i).getStudentNumber()) {
						if (studentIDInt != students.get(currentIndex)
								.getStudentNumber()) {
							alert.setText("Student ID number already exists");
							return;
						}
					} else if (studentEmail.getText().equals(
							students.get(i).getEmailAddress())) {
						if (!studentEmail.getText().equals(
								students.get(currentIndex).getEmailAddress())) {
							alert.setText("Student email already exists");
							return;
						}
					}
				}

				// check e-mail format validity
				// check e-mail format validity
				if (!studentEmail.getText().equals("")) {
					boolean flag = true;
					int atPointer = -1;
					int dotPointer = -1;
					int atCounter = 0;
					int dotCounter = 0;
					String eAddress = studentEmail.getText();
					for (int i = 0; i < eAddress.length(); i++) {
						if (eAddress.charAt(i) == '@') {
							atPointer = i;
							atCounter++;
						} else if (eAddress.charAt(i) == '.') {
							dotPointer = i;
							dotCounter++;
						} else if (eAddress.charAt(i) == ' ') {
							flag = false;
						}
						if (atPointer < 1 && eAddress.charAt(i) == '@')
							flag = false;
						if (dotPointer == -1 && eAddress.charAt(i) == '.')
							flag = false;
					}

					if (atPointer > dotPointer || atCounter != 1 || dotCounter != 1 || dotPointer - atPointer <  2)
						flag = false;
			//		System.out.println("TEST: " + flag);
					if (flag) 
					{
						GradeBookUI.updateAddStudent(firstName.getText(),lastName.getText(), studentIDInt,studentEmail.getText());
					} 
					else 
					{
						alert.setText("email format not valid");
					}

				} else
					alert.setText("A student's email must be entered");
			} catch (NumberFormatException e) {
				alert.setText("Student ID must be a number");
			}
		}
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
		selectStudentLabel = new JLabel();
		studentListCombo = new JComboBox<Student>();
		alert = new JLabel();

		editStudentPane.setBorder(javax.swing.BorderFactory
				.createEtchedBorder());

		editStudentButton.setText("Update");
		editStudentButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						editStudentButtonActionPerformed(evt);
					}
				});

		// If the student list in the course is not empty, add the list of
		// students to student combo box
		if (!students.isEmpty()) {
			for (int i = 0; i < students.size(); i++)
				studentListCombo.addItem(students.get(i));
		} else
			alert.setText("This course has no students to edit");

		selectStudentLabel.setText("Select Student:");

		studentListCombo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				studentListComboActionPerformed(evt);
			}
		});

		firstNameLabel.setFont(new java.awt.Font("Arial", 0, 12));
		firstNameLabel.setText("First Name:");

		lastNameLabel.setFont(new java.awt.Font("Arial", 0, 12));
		lastNameLabel.setText("Last Name:");

		studentIDLabel.setFont(new java.awt.Font("Arial", 0, 12));
		studentIDLabel.setText("Student ID:");

		studentEmailLabel.setFont(new java.awt.Font("Arial", 0, 12));
		studentEmailLabel.setText("Email:");

		alert.setFont(new java.awt.Font("Tahoma", 1, 12));

		// user interface layout
		javax.swing.GroupLayout editStudentPaneLayout = new javax.swing.GroupLayout(
				editStudentPane);
		editStudentPane.setLayout(editStudentPaneLayout);
		editStudentPaneLayout
				.setHorizontalGroup(editStudentPaneLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								editStudentPaneLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												editStudentPaneLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																editStudentPaneLayout
																		.createSequentialGroup()
																		.addGroup(
																				editStudentPaneLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								firstNameLabel)
																						.addComponent(
																								lastNameLabel)
																						.addComponent(
																								studentIDLabel))
																		.addGap(30,
																				30,
																				30)
																		.addGroup(
																				editStudentPaneLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								firstName)
																						.addComponent(
																								lastName)
																						.addComponent(
																								studentID)))
														.addGroup(
																editStudentPaneLayout
																		.createSequentialGroup()
																		.addComponent(
																				studentEmailLabel)
																		.addGap(59,
																				59,
																				59)
																		.addGroup(
																				editStudentPaneLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								editStudentPaneLayout
																										.createSequentialGroup()
																										.addComponent(
																												alert,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												184,
																												Short.MAX_VALUE)
																										.addGap(18,
																												18,
																												18)
																										.addComponent(
																												editStudentButton))
																						.addComponent(
																								studentEmail))))
										.addContainerGap()));
		editStudentPaneLayout
				.setVerticalGroup(editStudentPaneLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								editStudentPaneLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												editStudentPaneLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																firstNameLabel)
														.addComponent(
																firstName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																20,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												editStudentPaneLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lastNameLabel)
														.addComponent(
																lastName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												editStudentPaneLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																studentIDLabel)
														.addComponent(
																studentID,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												editStudentPaneLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																studentEmailLabel)
														.addComponent(
																studentEmail,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												editStudentPaneLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																editStudentButton)
														.addComponent(alert))
										.addContainerGap(86, Short.MAX_VALUE)));

		editStudentPaneLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { alert, firstName, lastName,
						studentEmail, studentID });

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														editStudentPane,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		selectStudentLabel)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		studentListCombo,
																		0,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														selectStudentLabel)
												.addComponent(
														studentListCombo,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(editStudentPane,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap()));
	}
}
