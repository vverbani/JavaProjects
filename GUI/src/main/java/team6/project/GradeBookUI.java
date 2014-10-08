package team6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.*;
import java.util.prefs.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

/**
 * Class to implement the graphical user interface for the GradeBook project
 * 
 * @author UWO - CS2212 - Team 6
 * 
 */
public class GradeBookUI extends javax.swing.JFrame implements ActionListener,
		Serializable {

	/* ************************************************************
	 * Instance Variables
	 * ***********************************************************
	 */
	private JMenuItem addCourse;
	private JMenuItem addDeliverable;
	private JMenu addMenu;
	private JMenuItem addStudent;
	private static JComboBox<Course> courseList;
	private static JPanel coursePanel;
	private JMenuItem deleteCourse;
	private JMenuItem deleteDeliverable;
	private JMenu deleteMenu;
	private JMenuItem deleteStudent;
	private JMenuItem editCourse;
	private JMenuItem editDeliverable;
	private JMenu editMenu;
	private JMenuItem editStudent;
	private JMenuItem exportStudents;
	private JMenu fileMenu;
	private JMenu importExportMenu;
	private JMenuItem importStudents;
	private JMenuItem importCourse;
	private JMenuItem setup;
	private static JTabbedPane mainPanel;
	private JMenuBar mainToolbar;
	private JMenuItem openTable;
	private JMenuItem save;
	private JMenuItem export;
	private JMenuItem exit;
	private JLabel activeCourseLabel;
	private static JLabel alert;
	private static JPanel panel;
	private final String ICON_EXIT = "exit.png";
	private final String ICON_OPEN = "open.png";
	private final String ICON_SAVE = "save.png";
	private final String DEFAULT_ICON = "prof.png";
	private static ArrayList<Course> courses;
	private boolean isSaved = false;
	private static JFileChooser fc;
	private static double weightSum = 0;
	private JLabel copyright;
	private JPanel jPanel1;
	private static Preferences prefs;
	private static Properties props;

	/**
	 * Constructor for the GradeBook UI
	 */
	public GradeBookUI() {
		this.courses = new ArrayList<Course>();
		initComponents(); // initialize the graphical components
		loadData(); // loading saved data in
	}

	/**
	 * Creates a new tabbed pane
	 * 
	 * @param title
	 *            title of the new tabbed pane
	 * @param panel
	 *            panel to be opened in the body of the tab
	 */
	private static void createTab(String title, JPanel panel) {
		// check if a tab with the same title is already open
		int tabCount = mainPanel.getTabCount();
		for (int i = 0; i < tabCount; i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(title)) {

				return;
			}
		}

		mainPanel.addTab(title, panel);
		int index = mainPanel.indexOfTab(title);
		JPanel pnlTab = new JPanel(new GridBagLayout());
		pnlTab.setOpaque(false);
		JLabel lblTitle = new JLabel(title);
		JButton btnClose = new JButton("X");
		btnClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 4, 2,
				4));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;

		pnlTab.add(lblTitle, gbc);

		gbc.gridx++;
		gbc.weightx = 0;
		pnlTab.add(btnClose, gbc);

		mainPanel.setTabComponentAt(index, pnlTab);

		btnClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCloseActionPerformed(evt);
			}
		});

	}

	/**
	 * Handles the closing of the tabs
	 * 
	 * @param evt
	 *            event handler
	 */
	private static void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
		Component selected = mainPanel.getSelectedComponent();
		if (selected != null) {
			mainPanel.remove(selected);
		}
	}

	/**
	 * Creates and displays the addCourse frame
	 */
	private static void addCourse() {
		panel = new AddCourseUI(courses);
		createTab(" Add Course ", panel);
		mainPanel.setSelectedIndex(mainPanel.getTabCount() - 1);

	}

	/**
	 * Updates the list of courses, called by AddCourseUI
	 * 
	 * @param title
	 *            course title
	 * @param code
	 *            course code
	 * @param term
	 *            course term
	 */
	public static void updateAddCourse(String title, String code, String term) {

		courses.add(new Course(title, code, term));
		courseList.addItem(courses.get(courses.size() - 1));

		// close the tab when course is added
		Component selected = mainPanel.getSelectedComponent();
		if (selected != null) {
			mainPanel.remove(selected);
		}

		// Opens the spreadsheet if this is the first course created
		if (courses.size() == 1)
			openTable();
	}

	/**
	 * Creates and displays the addStudent frame
	 */
	private static void addStudent() {
		try {
			panel = new AddStudentUI(courses.get(courseList.getSelectedIndex())
					.getStudents());
			createTab(" Add Student ", panel);
			mainPanel.setSelectedIndex(mainPanel.getTabCount() - 1);
		} catch (Exception e) {
			alert.setText("Add a course to begin - Click 'Add -> Course'");
		}
	}

	/**
	 * Adds a student to the student list
	 * 
	 * @param c
	 *            index of the course which the student is a part of
	 * @param firstName
	 *            first name of the student
	 * @param lastName
	 *            last name of the student
	 * @param studentId
	 *            id of the student
	 * @param email
	 *            email of the student
	 */
	public static void updateAddStudent(String firstName, String lastName,
			int studentId, String email) {
		int a = courseList.getSelectedIndex();
		if (courseList.getItemCount() == 0)
			alert.setText("Create a course first - Click 'Add -> Course'");
		else {
			Student student = new Student(firstName, lastName, studentId, email);
			courses.get(courseList.getSelectedIndex()).addStudent(student);

			for (int i = 0; i < mainPanel.getTabCount(); i++) {
				String tabTitle = mainPanel.getTitleAt(i);
				if (tabTitle.equals(courses.get(courseList.getSelectedIndex())
						.toString())) {
					mainPanel.revalidate();
				}
			}

			// close the tab when student is added
			Component selected = mainPanel.getSelectedComponent();
			if (selected != null) {
				mainPanel.remove(selected);
			}
		}
		// close and reopen the tab to update the jtable
		String title = courses.get(courseList.getSelectedIndex()).toString();
		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(title)) {
				// remove outdated pane
				mainPanel.remove(courseList.getSelectedIndex());
				// reopen with updated data.
				panel = new JTableUI(courses.get(a), props);
				createTab(courses.get(a).toString(), panel);
			}
		}

	}

	/**
	 * Creates and displays the addDeliverable frame
	 */
	private static void addDeliverable() {
		try {
			panel = new AddDeliverableUI(courses.get(
					courseList.getSelectedIndex()).getWeightSum(), courses.get(
					courseList.getSelectedIndex()).getDeliverables());
			createTab(" Add Deliverable ", panel);
			mainPanel.setSelectedIndex(mainPanel.getTabCount() - 1);
		} catch (Exception e) {
			alert.setText("Add a course to begin - Click 'Add -> Course'");
		}
	}

	/**
	 * Used by outside classes to display alerts
	 */
	public static void setAlert(String m) {
		alert.setText(m);
	}

	/**
	 * Adds a deliverable to the deliverable list
	 * 
	 * @param c
	 * @param type
	 * @param name
	 * @param weight
	 */
	public static void updateAddDeliverable(String type, String name,
			double weight) {

		Deliverable dev = new Deliverable(name, type, weight);
		courses.get(courseList.getSelectedIndex()).addDeliverable(dev);
		int a = courseList.getSelectedIndex();
		
		
		
		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(courses.get(courseList.getSelectedIndex())
					.toString())) {

			}
		}

		// close the tab when course is added
		Component selected = mainPanel.getSelectedComponent();
		if (selected != null) {
			mainPanel.remove(selected);
		}

		// close and reopen the tab to update the jtable
		String title = courses.get(courseList.getSelectedIndex()).toString();
		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(title)) {
				// remove outdated pane
				mainPanel.remove(courseList.getSelectedIndex());
				// reopen with updated data.
				panel = new JTableUI(courses.get(a), props);
				createTab(courses.get(a).toString(), panel);
			}
		}

	}

	/**
	 * Creates and displays the Course editing frame
	 */
	private static void editCourse() {
		panel = new EditCourseUI(courses);
		createTab(" Edit Course ", panel);
		mainPanel.setSelectedIndex(mainPanel.getTabCount() - 1);
	}

	/**
	 * Performs course edit, called by EditCourseUI
	 * 
	 * @param c
	 *            index of the course to be edited
	 * @param title
	 *            updated course title
	 * @param code
	 *            updated course code
	 * @param term
	 *            updated course term
	 */
	public static void updateEditCourse(String title, String code, String term) {
		int c = courseList.getSelectedIndex(); // get index of the active course
		String oldTitle = courses.get(c).toString();
		courses.get(c).setCourseTitle(title);
		courses.get(c).setCourseCode(code);
		courses.get(c).setCourseTerm(term);

		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(oldTitle)) {
				mainPanel.revalidate();
			}
		}

		// close the tab when course is added
		mainPanel.repaint();

		Component selected = mainPanel.getSelectedComponent();
		if (selected != null) {
			mainPanel.remove(selected);
		}

		// close and reopen the tab to update the jtable
		title = courses.get(courseList.getSelectedIndex()).toString();
		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(oldTitle)) {
				// remove outdated pane
				mainPanel.remove(courseList.getSelectedIndex());
				// reopen with updated data.
				panel = new JTableUI(courses.get(c), props);
				createTab(courses.get(c).toString(), panel);
			}
		}

	}

	/**
	 * Creates and displays the Student editing frame
	 */
	private static void editStudent() {
		if (courses.get(courseList.getSelectedIndex()).getStudents().size() > 0) {
			panel = new EditStudentUI(courses
					.get(courseList.getSelectedIndex()).getStudents());
			createTab(" Edit Student ", panel);
			mainPanel.setSelectedIndex(mainPanel.getTabCount() - 1);
		}
	}

	/**
	 * Updates the information of a particular student in a course
	 * 
	 * @param s
	 *            index of the student selected
	 * @param c
	 *            index of the course selected
	 * @param firstName
	 *            updated student first name
	 * @param lastName
	 *            updated student last name
	 * @param studentId
	 *            updated student ID
	 * @param email
	 *            updated student e-mail
	 */
	public static void updateEditStudent(int s, String firstName,
			String lastName, int studentId, String email) {

		int c = courseList.getSelectedIndex(); // get index of the active course

		Course course = courses.get(c);
		Student student = course.getStudents().get(s);

		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setStudentNumber(studentId);
		student.setEmailAddress(email);

		// close the tab when course is added
		Component selected = mainPanel.getSelectedComponent();
		if (selected != null) {
			mainPanel.remove(selected);
		}
		// close and reopen the tab to update the jtable
		String title = courses.get(courseList.getSelectedIndex()).toString();
		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(title)) {
				// remove outdated pane
				mainPanel.remove(courseList.getSelectedIndex());
				// reopen with updated data.
				panel = new JTableUI(courses.get(c), props);
				createTab(courses.get(c).toString(), panel);
			}
		}

	}

	/**
	 * Creates and displays the Deliverable editing frame
	 */
	private static void editDeliverable() {
		if (courses.get(courseList.getSelectedIndex()).getDeliverables().size() > 0) {
			panel = new EditDeliverableUI(courses.get(
					courseList.getSelectedIndex()).getDeliverables(), courses
					.get(courseList.getSelectedIndex()).getWeightSum());
			createTab(" Edit Deliverable ", panel);
			mainPanel.setSelectedIndex(mainPanel.getTabCount() - 1);
		}
	}

	/**
	 * Updates the information of the particular deliverable in a course
	 * 
	 * @param c
	 *            index of the current selected
	 * @param d
	 *            index of the deliverable selected
	 * @param name
	 *            updated name of the deliverable
	 * @param weight
	 *            updated weight of the deliverable
	 * @param type
	 *            updated type of the deliverable
	 */
	public static void updateEditDeliverable(int d, String name, double weight,String type) 
	{
		try
		{
			int c = courseList.getSelectedIndex(); // get index of the active course

			Course course = courses.get(c);
			Deliverable deliverable = course.getDeliverables().get(d);

			deliverable.setName(name);
			deliverable.setType(type);
			deliverable.setWeight(weight);
/**
			// update the weight for all the students
			for (int i = 0; i < course.getStudents().size(); i++) 
			{
				System.out.println("size " +course.getStudents().get(i).getGrades().size());
				System.out.println("dsize" +d);
				course.getStudents().get(i).getGrades().get(d).setWeight(weight);
			}
**/
			// close the tab when course is added
			Component selected = mainPanel.getSelectedComponent();
			if (selected != null) {
				mainPanel.remove(selected);
			}
			
			// close and reopen the tab to update the jtable
			String title = courses.get(courseList.getSelectedIndex()).toString();
			for (int i = 0; i < mainPanel.getTabCount(); i++) {
				String tabTitle = mainPanel.getTitleAt(i);
				if (tabTitle.equals(title)) {
					// remove outdated pane
					mainPanel.remove(courseList.getSelectedIndex());
					// reopen with updated data.
					panel = new JTableUI(courses.get(c), props);
					createTab(courses.get(c).toString(), panel);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates and displays the Course deletion frame
	 */
	private static void deleteCourse() {
		panel = new DeleteCourseUI(courses.get(courseList.getSelectedIndex()));
		createTab(" Delete Course ", panel);
		mainPanel.setSelectedIndex(mainPanel.getTabCount() - 1);
	}

	/**
	 * Performs removal, called by DeleteCourseUI
	 * 
	 * @param c
	 *            index of the course selected
	 */
	public static void updateDeleteCourse() {
		int c = courseList.getSelectedIndex(); // get index of the active course
		String oldCourse = courses.get(c).toString();
		courseList.removeItemAt(c);
		courses.remove(c);

		// close the tab of the course if it's open.
		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(oldCourse)) {
				mainPanel.remove(c);
			}
		}

		// close the tab when course is added
		Component selected = mainPanel.getSelectedComponent();
		if (selected != null) {
			mainPanel.remove(selected);
		}
	}

	/**
	 * Creates and displays the Student deletion frame
	 */
	private static void deleteStudent() {
		panel = new DeleteStudentUI(courses.get(courseList.getSelectedIndex())
				.getStudents());
		createTab(" Delete Student ", panel);
		mainPanel.setSelectedIndex(mainPanel.getTabCount() - 1);
	}

	/**
	 * Deletes the particular student in the selected course
	 * 
	 * @param c
	 *            index of the course selected
	 * @param s
	 *            index of the student selected
	 */
	public static void updateDeleteStudent(int s) {
		int c = courseList.getSelectedIndex(); // get index of the active course

		Course course = courses.get(c);
		course.getStudents().remove(s);

		// close the tab when course is added
		Component selected = mainPanel.getSelectedComponent();
		if (selected != null) {
			mainPanel.remove(selected);
		}
		// close and reopen the tab to update the jtable
		String title = courses.get(courseList.getSelectedIndex()).toString();
		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(title)) {
				// remove outdated pane
				mainPanel.remove(courseList.getSelectedIndex());
				// reopen with updated data.
				panel = new JTableUI(courses.get(c), props);
				createTab(courses.get(c).toString(), panel);
			}
		}

	}

	/**
	 * Creates and displays the Deliverable deletion frame
	 */
	private static void deleteDeliverable() {
		panel = new DeleteDeliverableUI(courses.get(
				courseList.getSelectedIndex()).getDeliverables(), courses.get(
				courseList.getSelectedIndex()).getWeightSum());
		createTab(" Delete Deliverable ", panel);
		mainPanel.setSelectedIndex(mainPanel.getTabCount() - 1);
	}

	/**
	 * Performs removal of a Deliverable, called by DeleteDeliverableUI
	 * 
	 * @param c
	 *            the index of the course selected
	 * @param d
	 *            the index of the deliverable to be deleted
	 */
	public static void updateDeleteDeliverable(int d) {
		try{
		int c = courseList.getSelectedIndex(); // get index of the active course

		Course course = courses.get(c);
		
		weightSum = weightSum - course.getDeliverables().get(d).getWeight();
		course.getDeliverables().remove(d);

		// close the tab when course is added
		Component selected = mainPanel.getSelectedComponent();
		if (selected != null) {
			mainPanel.remove(selected);
		}
		// close and reopen the tab to update the jtable
		String title = courses.get(courseList.getSelectedIndex()).toString();
		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(title)) {
				// remove outdated pane
				mainPanel.remove(courseList.getSelectedIndex());
				// reopen with updated data.
				panel = new JTableUI(courses.get(c), props);
				createTab(courses.get(c).toString(), panel);
			}
		}
		}
		catch(Exception e)
		{
			
		}

	}

	/**
	 * import student grades from a csv file
	 * 
	 */
	private static void importStudents() {
		try{
		int a = courseList.getSelectedIndex();
		fc = new JFileChooser();
		Course old = courses.get(courseList.getSelectedIndex());
		// set filter to display only csv files
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"CSV file", "csv");
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(mainPanel);
		// if a file is opened then import the file
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String alertStr = fc.getSelectedFile().getName();
			alert.setText("File imported: " + alertStr);

			// we need to pass the current course into the CSV reader.
			int c = courseList.getSelectedIndex(); // get index of the active
													// course
			Course course = courses.get(c);

			CSVSuite reader = new CSVSuite(course, fc.getSelectedFile()
					.getAbsolutePath());
			course = reader.importCSV();
		}

		// compare the old course and the new one.
		boolean flag = false;
		// loop through the students
		for (int i = 0; i < 10; i++) {
			outerloop:
			// loop through the grades.
			for (int j = 0; j < 10; j++) {
				break outerloop;
			}
		}
		if (flag)
			alert.setText("studentNumberColumn not found");

		// close and reopen the tab to update the jtable
		String title = courses.get(courseList.getSelectedIndex()).toString();
		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(title)) {
				// remove outdated pane
				mainPanel.remove(courseList.getSelectedIndex());
				// reopen with updated data.
				panel = new JTableUI(courses.get(a), props);
				createTab(courses.get(a).toString(), panel);
			}
		}
		}
		catch(Exception e)
		{
			
		}
	}

	/**
	 * 
	 * export student grades in csv format
	 */
	private static void exportStudents() {
		try{
		fc = new JFileChooser();
		// opens a file chooser box to save the file
		int returnVal = fc.showSaveDialog(mainPanel);
		// if a file is opened then import the file
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			Course c = courses.get(courseList.getSelectedIndex());
			CSVSuite writer = new CSVSuite(c, fc.getSelectedFile()
					.getAbsolutePath());
			writer.exportCSV();
		}
		}
		catch(Exception e){
			
		}
	}

	/**
	 * import student data not grades to a course.
	 * 
	 */
	private static void importCourse() {
		try{
		fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(mainPanel);
		int a = courseList.getSelectedIndex();
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			Course c = courses.get(a);
			CSVSuite csv = new CSVSuite(c, fc.getSelectedFile()
					.getAbsolutePath());
			c = csv.importStudents();
		}

		// close and reopen the tab to update the jtable
		String title = courses.get(courseList.getSelectedIndex()).toString();
		for (int i = 0; i < mainPanel.getTabCount(); i++) {
			String tabTitle = mainPanel.getTitleAt(i);
			if (tabTitle.equals(title)) {
				// remove outdated pane
				mainPanel.remove(courseList.getSelectedIndex());
				// reopen with updated data.
				panel = new JTableUI(courses.get(a), props);
				createTab(courses.get(a).toString(), panel);
			}
		}
		}
		catch(Exception e)
		{
			
		}
	}

	/**
	 * this method opens a table for a given course. 
	 */
	 private static void openTable(){
		if(courseList.getSelectedIndex() >= 0){
			panel = new JTableUI(courses.get(courseList.getSelectedIndex()),props);
			createTab(courses.get(courseList.getSelectedIndex()).toString(), panel);
			mainPanel.setSelectedIndex(mainPanel.getTabCount()-1);

		}
	}

	/**
	 * this method closes the program
	 *
	 */
	public void exit() {
		if (!isSaved) {
			storeData();
			System.exit(0);
		} else
			System.exit(0);
	}

	/**
	 * loads the icon for the menu item
	 * 
	 */
	private ImageIcon loadIcon(String filename) {
		try {
			InputStream in = GradeBookUI.class.getClassLoader()
					.getResourceAsStream(filename);
			return new ImageIcon(ImageIO.read(in));
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Storing data when the save button is clicked
	 */
	private void storeData() {
		try {

			FileOutputStream fOut = new FileOutputStream("save_data.dat");
			ObjectOutputStream out = new ObjectOutputStream(fOut);
			out.writeObject(this.courses);
			out.close();
			fOut.close();
			isSaved = true;
			//System.out.println("file saved correctly");
		} catch (IOException e) {
			//System.out.println(e.toString());
		}
	}

	/**
	 * load the data into the program when the program initializes
	 */
	private void loadData() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"save_data.dat"));
			ArrayList<Course> listCourses = (ArrayList<Course>) in.readObject();

			// load in the data
			for (int i = 0; i < listCourses.size(); i++) {
				courses.add(listCourses.get(i));
				courseList.addItem(courses.get(courses.size() - 1));
			}

			// create a generic preferences dialogue for email settings.
			prefs = Preferences.userRoot().node(this.getClass().getName());
			prefs.put("mail.smtp.host", "localhost");
			prefs.put("smtp.username", "username");
			prefs.put("smtp.password", "value");
			prefs.put("mail.smtp.port", "1025");
			prefs.put("mail.smtp.auth", "true");
			prefs.put("mail.smtp.starttls.enable", "true");
			prefs.put("sender.name", "John Doe");
			prefs.put("sender.email", "jdoe@example.com");

			props.put("mail.smtp.host", "localhost");
			props.put("smtp.username", "username");
			props.put("smtp.password", "value");
			props.put("mail.smtp.port", "1025");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("sender.name", "John Doe");
			props.put("sender.email", "jdoe@example.com");

		//	System.out.println("Load Successful");
			in.close();
		} catch (IOException e) {
		//	System.out.println("Load Fail");
		} catch (ClassNotFoundException e) {
			//System.out.println("Load Fail");
		} 
	}

	/**
	 * creates an email setup tab to setup the emailing properties
	 * 
	 */
	private static void emailSetup() {
		panel = new SetupUI(prefs);
		createTab(" Email Setup ", panel);
		mainPanel.setSelectedIndex(mainPanel.getTabCount() - 1);

	}
	
	/**
	 * This method updates the email set up properties
	 * @param preferences the current set of preferences
	 */
	public static void updateEmailSetup(Preferences preferences){
		prefs = preferences;

		props.put("mail.smtp.host", prefs.get("mail.smtp.host", "localhost"));
		props.put("smtp.username", prefs.get("smtp.username", "username"));
		props.put("smtp.password", prefs.get("smtp.password", "password"));
		props.put("mail.smtp.port", prefs.get("mail.smtp.port", "1025"));
		props.put("sender.name", prefs.get("sender.name", "John Doe"));
		props.put("sender.email", prefs.get("sender.email", "jdoe@example.com"));

		Component selected = mainPanel.getSelectedComponent();
		if (selected != null) {
			mainPanel.remove(selected);
		}
	}

	/**
	 * Handles all actions performed by GradeBookUI menu bar
	 * 
	 * @param c
	 *            clicked area
	 */
	public void actionPerformed(ActionEvent c) {
		// update the isSaved flag -- this way after every action, the flag will
		// become false.
		isSaved = false;
		if ("addCourse".equals(c.getActionCommand()))
			addCourse();
		else if ("addStudent".equals(c.getActionCommand()))
			addStudent();
		else if ("addDeliverable".equals(c.getActionCommand()))
			addDeliverable();
		else if ("exit".equals(c.getActionCommand()))
			exit();
		else if ("importStudents".equals(c.getActionCommand()))
			importStudents();
		else if ("exportStudents".equals(c.getActionCommand()))
			exportStudents();
		else if ("importCourse".equals(c.getActionCommand()))
			importCourse();
		else if ("save".equals(c.getActionCommand()))
			storeData();
		else if ("emailSetup".equals(c.getActionCommand()))
			emailSetup();
		else if (courses.size() > 0) {
			if ("openTable".equals(c.getActionCommand()))
				openTable();
			if ("editCourse".equals(c.getActionCommand()))
				editCourse();
			else if ("editStudent".equals(c.getActionCommand()))
				editStudent();
			else if ("editDeliverable".equals(c.getActionCommand()))
				editDeliverable();
			else if ("deleteCourse".equals(c.getActionCommand()))
				deleteCourse();
			else if ("deleteStudent".equals(c.getActionCommand()))
				deleteStudent();
			else if ("deleteDeliverable".equals(c.getActionCommand()))
				deleteDeliverable();
		} else
			alert.setText("Add a course to begin - Click 'Add -> Course'");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	private void initComponents() {
		props = new Properties();
		coursePanel = new JPanel();
		courseList = new JComboBox();
		activeCourseLabel = new JLabel();
		mainPanel = new JTabbedPane();
		mainToolbar = new JMenuBar();
		fileMenu = new JMenu();
		openTable = new JMenuItem();
		export = new JMenuItem();
		save = new JMenuItem();
		exit = new JMenuItem();
		setup = new JMenuItem();
		addMenu = new JMenu();
		addCourse = new JMenuItem();
		addStudent = new JMenuItem();
		addDeliverable = new JMenuItem();
		editMenu = new JMenu();
		editCourse = new JMenuItem();
		editStudent = new JMenuItem();
		editDeliverable = new JMenuItem();
		deleteMenu = new JMenu();
		deleteCourse = new JMenuItem();
		deleteStudent = new JMenuItem();
		deleteDeliverable = new JMenuItem();
		importExportMenu = new JMenu();
		importStudents = new JMenuItem();
		exportStudents = new JMenuItem();
		importCourse = new JMenuItem();
		alert = new JLabel();
		copyright = new JLabel();
		jPanel1 = new JPanel();

		// Action command and listener for adding course
		addCourse.setActionCommand("addCourse");
		addCourse.addActionListener(this);

		// Action command and listener for adding student
		addStudent.setActionCommand("addStudent");
		addStudent.addActionListener(this);

		// Action command and listener for adding deliverable
		addDeliverable.setActionCommand("addDeliverable");
		addDeliverable.addActionListener(this);

		// Action command and listener for editing course
		editCourse.setActionCommand("editCourse");
		editCourse.addActionListener(this);

		// Action command and listener for editing student
		editStudent.setActionCommand("editStudent");
		editStudent.addActionListener(this);

		// Action command and listener for edit deliverable
		editDeliverable.setActionCommand("editDeliverable");
		editDeliverable.addActionListener(this);

		// Action command and listener for deleting course
		deleteCourse.setActionCommand("deleteCourse");
		deleteCourse.addActionListener(this);

		// Action command and listener for deleting student
		deleteStudent.setActionCommand("deleteStudent");
		deleteStudent.addActionListener(this);

		// Action command and listener for deleting deliverable
		deleteDeliverable.setActionCommand("deleteDeliverable");
		deleteDeliverable.addActionListener(this);

		// Action command and listener for import/export activities
		importStudents.setActionCommand("importStudents");
		importStudents.addActionListener(this);

		exportStudents.setActionCommand("exportStudents");
		exportStudents.addActionListener(this);

		importCourse.setActionCommand("importCourse");
		importCourse.addActionListener(this);

		// Action command and listener for saving course data
		save.setActionCommand("save");
		save.addActionListener(this);

		// Action command and listener for exiting program
		exit.setActionCommand("exit");
		exit.addActionListener(this);

		// Action command and listener for email setup
		setup.setActionCommand("emailSetup");
		setup.addActionListener(this);

		// Action command and listener for active course combo box
		courseList.setActionCommand("openTable");
		courseList.addActionListener(this);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(600, 600));
		setPreferredSize(new java.awt.Dimension(600, 400));

		coursePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		activeCourseLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		activeCourseLabel.setText("Active Course:");

		alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		copyright.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		copyright.setText("Team 6 - UWO");

		fileMenu.setBorder(javax.swing.BorderFactory.createCompoundBorder());
		fileMenu.setText("File");

		setup.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_E,
				java.awt.event.InputEvent.CTRL_MASK));
		setup.setText("Email Setup");
		fileMenu.add(setup);

		save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.CTRL_MASK));
		save.setIcon(loadIcon(ICON_SAVE));
		save.setText("Save");
		fileMenu.add(save);

		exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_X,
				java.awt.event.InputEvent.CTRL_MASK));
		exit.setIcon(loadIcon(ICON_EXIT));
		exit.setText("Exit");
		fileMenu.add(exit);

		mainToolbar.add(fileMenu);

		addMenu.setText("Add");

		addCourse.setText("Course");
		addMenu.add(addCourse);

		addStudent.setText("Student");
		addMenu.add(addStudent);

		addDeliverable.setText("Deliverable");
		addMenu.add(addDeliverable);

		mainToolbar.add(addMenu);

		editMenu.setText("Edit");

		editCourse.setLabel("Course");
		editMenu.add(editCourse);

		editStudent.setLabel("Student");
		editMenu.add(editStudent);

		editDeliverable.setText("Deliverable");
		editMenu.add(editDeliverable);

		mainToolbar.add(editMenu);

		deleteMenu.setText("Delete");

		deleteCourse.setText("Course");
		deleteMenu.add(deleteCourse);

		deleteStudent.setText("Student");
		deleteMenu.add(deleteStudent);

		deleteDeliverable.setText("Deliverable");
		deleteMenu.add(deleteDeliverable);

		mainToolbar.add(deleteMenu);

		importExportMenu.setText("Import/Export");

		importStudents.setText("Import Student Grades");
		importExportMenu.add(importStudents);

		exportStudents.setText("Export Student Grades");
		importExportMenu.add(exportStudents);

		importCourse.setText("Import Students");
		importExportMenu.add(importCourse);

		mainToolbar.add(importExportMenu);

		setJMenuBar(mainToolbar);

		this.setTitle("Professor Pro Version 1.0");

		javax.swing.GroupLayout coursePanelLayout = new javax.swing.GroupLayout(
				coursePanel);
		coursePanel.setLayout(coursePanelLayout);
		coursePanelLayout
				.setHorizontalGroup(coursePanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								coursePanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(activeCourseLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(courseList, 0, 214,
												Short.MAX_VALUE)
										.addContainerGap()));
		coursePanelLayout
				.setVerticalGroup(coursePanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(
								coursePanelLayout
										.createSequentialGroup()
										.addGap(1, 1, 1)
										.addGroup(
												coursePanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																courseList,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																22,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																activeCourseLabel))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(coursePanel,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(mainPanel)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(alert,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(copyright)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(coursePanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(mainPanel,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										150, Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														alert,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														17,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														copyright,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														17,
														javax.swing.GroupLayout.PREFERRED_SIZE))));

		layout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { alert, copyright });

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (!isSaved) {
					storeData();
					System.exit(0);
				} else
					System.exit(0);
			}
		});

		pack();
	}
}
