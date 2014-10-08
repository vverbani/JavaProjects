package team6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 * Class to implement the graphical user interface for the GradeBook project
 * 
 * @author UWO - CS2212 - Team 6 (ATripleV)
 */
public class GradeBookUI extends javax.swing.JFrame implements ActionListener, Serializable {
  
  /* ************************************************************
   * Instance Variables
   ************************************************************ */
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
  private static JTabbedPane mainPanel;
  private JMenuBar mainToolbar;
  private JButton openCourseBtn;
  private JMenuItem save;
  private JLabel selectCourseLabel;
  private static JFrame frame;
  private static JPanel panel;
  private static ArrayList<Course> courses = new ArrayList<Course>();
  
  /**
   * Constructor for the GradeBook UI
   */
  public GradeBookUI() {
    //Create initial status of lists for use in GUI
    
    initComponents(); //initialize the graphical components
    loadData();   //loading saved data in
  }
  
  
  /**
   * Creates a new tabbed pane
   * @param title  title of the new tabbed pane
   * @param panel  panel to be opened in the body of the tab
   */
  private static void createTab(String title, JPanel panel) {
    mainPanel.addTab(title, panel);
    int index = mainPanel.indexOfTab(title);
    JPanel pnlTab = new JPanel(new GridBagLayout());
    pnlTab.setOpaque(false);
    JLabel lblTitle = new JLabel(title);
    JButton btnClose = new JButton("X");
    btnClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 4, 2, 4));
    
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
   * Creates and displays the addCourse frame
   */
  private static void addCourse() {
    panel = new AddCourseUI();
    createTab(" Add Course ", panel);
  }
  
  /**
   * Updates the list of courses, called by AddCourseUI
   * 
   * @param title course title
   * @param code course code
   * @param term course term
   */
  public static void updateAddCourse(String title, String code, String term) {
    courses.add(new Course(title, code, term));
    courseList.addItem(courses.get(courses.size() - 1));
    
  }
  
  /**
   * Creates and displays the addStudent frame
   */
  private static void addStudent() {
    panel = new AddStudentUI(courses);
    createTab(" Add Student ", panel);
  }
  
  /**
   * Adds a student to the student list
   * 
   * @param c  index of the course which the student is a part of
   * @param firstName  first name of the student
   * @param lastName  last name of the student
   * @param studentId  id of the student
   * @param email   email of the student
   */
  public static void updateAddStudent(String firstName, String lastName, int studentId, String email) {
	Course current = courses.get(courseList.getSelectedIndex());
    current.addStudent(firstName, lastName, studentId, email);
    
  }
  
  /**
   * Creates and displays the addDeliverable frame
   */
  private static void addDeliverable() {
    panel = new AddDeliverableUI(courses);
    createTab(" Add Deliverable ", panel);
  }
  
  /**
   * Adds a deliverable to the deliverable list
   * @param c
   * @param type
   * @param name
   * @param weight
   */
  public static void updateAddDeliverable(String type, String name, double weight) {
    Course current = courses.get(courseList.getSelectedIndex());
    current.addDeliverable(name, type, weight);
    
  }
  
  /**
   * Creates and displays the Course editing frame
   */
  private static void editCourse() {
    panel = new EditCourseUI(courses);
    createTab(" Edit Course ", panel);
  }
  
  /**
   * Performs course edit, called by EditCourseUI
   * 
   * @param c   index of the course to be edited
   * @param title  updated course title
   * @param code  updated course code
   * @param term  updated course term
   */
  public static void updateEditCourse(int c, String title, String code, String term) {
    if (!title.equals(""))
      courses.get(c).setCourseTitle(title);
    if (!code.equals(""))
      courses.get(c).setCourseCode(code);
    
    courses.get(c).setCourseTerm(term);
    
  }
  
  /**
   * Creates and displays the Student editing frame
   */
  private static void editStudent() {
    panel = new EditStudentUI(courses);
    createTab(" Edit Student ", panel);
  }
  
  /**
   * Updates the information of a particular student in a course
   * 
   * @param s  index of the student selected
   * @param c  index of the course selected
   * @param firstName  updated student first name
   * @param lastName  updated student last name
   * @param studentId  updated student ID
   * @param email   updated student e-mail
   */
  public static void updateEditStudent(int s, int c, String firstName, String lastName, int studentId, String email) {
    Course course = courses.get(c);
    Student student = course.getStudents().get(s);
    
    if (!student.getFirstName().equals(""))
      student.setFirstName(firstName);
    if (!student.getLastName().equals(""))
      student.setLastName(lastName);
    if (student.getStudentNumber() != 0)
      student.setStudentNumber(studentId);
    if (!student.getEmailAddress().equals(""))
      student.setEmailAddress(email);
    
    
  }
  
  /**
   * Creates and displays the Deliverable editing frame
   */
  private static void editDeliverable() {
    panel = new EditDeliverableUI(courses);
    createTab(" Edit Deliverable ", panel);
  }
  
  /**
   * Updates the information of the particular deliverable in a course
   * 
   * @param c  index of the current selected
   * @param d  index of the deliverable selected
   * @param name  updated name of the deliverable 
   * @param weight updated weight of the deliverable
   * @param type  updated type of the deliverable
   */
  public static void updateEditDeliverable(int c, int d, String name, double weight, String type) {
    Course course = courses.get(c);
    Deliverable deliverable = course.getDeliverables().get(d);
    
    if (!deliverable.getName().equals(""))
      deliverable.setName(name);
    if (!deliverable.getType().equals(""))
      deliverable.setType(type);
    if (deliverable.getWeight() != 0)
      deliverable.setWeight(weight);
    
    
  }
  
  /**
   * Creates and displays the Course deletion frame
   */
  private static void deleteCourse() {
    panel = new DeleteCourseUI(courses);
    createTab(" Delete Course ", panel);
  }
  
  /**
   * Performs removal, called by DeleteCourseUI
   * 
   * @param c  index of the course selected
   */
  public static void updateDeleteCourse(int c) {
    courseList.removeItemAt(c);
    courses.remove(c);
    
  }
  
  /**
   * Creates and displays the Student deletion frame
   */
  private static void deleteStudent() {
    panel = new DeleteStudentUI(courses);
    createTab(" Delete Student ", panel);
  }
  
  /**
   * Deletes the particular student in the selected course
   * 
   * @param c  index of the course selected
   * @param s  index of the student selected
   */
  public static void updateDeleteStudent(int c, int s) {
    Course course = courses.get(c);
    course.getStudents().remove(s);
    
  }
  
  /**
   * Creates and displays the Deliverable deletion frame
   */
  private static void deleteDeliverable() {
    panel = new DeleteDeliverableUI(courses);
    createTab(" Delete Deliverable ", panel);
  }
  
  /**
   * Performs removal of a Deliverable, called by DeleteDeliverableUI
   * 
   * @param c  the index of the course selected
   * @param d  the index of the deliverable to be deleted
   */
  public static void updateDeleteDeliverable(int c, int d) {
    Course course = courses.get(c);
    course.getDeliverables().remove(d);
    
  }
  
  /**
   * Handles the closing of the tabs
   * @param evt event handler
   */
  public static void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
    Component selected = mainPanel.getSelectedComponent();
    if (selected != null) {
      mainPanel.remove(selected);
    }
  }
  
  /**
   * Creates and displays the JTable frame in a new tab
   * @param evt		event handler
   */
  public static void openCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {
	if(courses.size() > 0){
	Course current = courses.get(courseList.getSelectedIndex());
	panel = new JTableUI(current);
	createTab(current.toString(), panel);
	}
  }
  
    /**
	* Action method for the course list combo box
	* @param evt	action event
	*/
    private void courseListActionPerformed(java.awt.event.ActionEvent evt) {

    } 
  
  /**
   * Handles all actions performed by GradeBookUI menu bar
   * 
   * @param c clicked area
   */
  public void actionPerformed(ActionEvent c) {
    if ("addCourse".equals(c.getActionCommand()))
      addCourse();
    else if ("addStudent".equals(c.getActionCommand()))
      addStudent();
    else if ("addDeliverable".equals(c.getActionCommand()))
      addDeliverable();
    else if ("editCourse".equals(c.getActionCommand()))
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
    else if("save".equals(c.getActionCommand()))
      storeData();
  }
  
  
  /**
   * This method is called from within the constructor to initialize the form.
   */
  private void initComponents() {
    
    coursePanel = new javax.swing.JPanel();
    selectCourseLabel = new javax.swing.JLabel();
    courseList = new javax.swing.JComboBox<Course>();
    openCourseBtn = new javax.swing.JButton();
    mainPanel = new javax.swing.JTabbedPane();
    mainToolbar = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    addMenu = new javax.swing.JMenu();
    editMenu = new javax.swing.JMenu();
    deleteMenu = new javax.swing.JMenu();
    
    // Action command and listener for adding course
    addCourse = new javax.swing.JMenuItem();
    addCourse.setActionCommand("addCourse");
    addCourse.addActionListener(this);
    
    // Action command and listener for adding student
    addStudent = new javax.swing.JMenuItem();
    addStudent.setActionCommand("addStudent");
    addStudent.addActionListener(this);
    
    // Action command and listener for adding deliverable
    addDeliverable = new javax.swing.JMenuItem();
    addDeliverable.setActionCommand("addDeliverable");
    addDeliverable.addActionListener(this);
    
    // Action command and listener for editing course
    editCourse = new javax.swing.JMenuItem();
    editCourse.setActionCommand("editCourse");
    editCourse.addActionListener(this);
    
    // Action command and listener for editing student
    editStudent = new javax.swing.JMenuItem();
    editStudent.setActionCommand("editStudent");
    editStudent.addActionListener(this);
    
    // Action command and listener for edit deliverable
    editDeliverable = new javax.swing.JMenuItem();
    editDeliverable.setActionCommand("editDeliverable");
    editDeliverable.addActionListener(this);
    
    // Action command and listener for deleting course
    deleteCourse = new javax.swing.JMenuItem();
    deleteCourse.setActionCommand("deleteCourse");
    deleteCourse.addActionListener(this);
    
    // Action command and listener for deleting student
    deleteStudent = new javax.swing.JMenuItem();
    deleteStudent.setActionCommand("deleteStudent");
    deleteStudent.addActionListener(this);
    
    // Action command and listener for deleting deliverable
    deleteDeliverable = new javax.swing.JMenuItem();
    deleteDeliverable.setActionCommand("deleteDeliverable");
    deleteDeliverable.addActionListener(this);
    
    importExportMenu = new javax.swing.JMenu();
    importStudents = new javax.swing.JMenuItem();
    exportStudents = new javax.swing.JMenuItem();
    
    // Action command and listener for saving course data
    save = new javax.swing.JMenuItem();
    save.setActionCommand("save");
    save.addActionListener(this);
    
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
    coursePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    setPreferredSize(new java.awt.Dimension(600, 600));
    
    selectCourseLabel.setText(" Select Course:");
	
	courseList.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            courseListActionPerformed(evt);
        }
    });
    
    openCourseBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    openCourseBtn.setText("Open");
	
	openCourseBtn.addActionListener(new java.awt.event.ActionListener() {
     public void actionPerformed(java.awt.event.ActionEvent evt) {
       openCourseBtnActionPerformed(evt);
      }
    });
    
    javax.swing.GroupLayout coursePanelLayout = new javax.swing.GroupLayout(coursePanel);
    coursePanel.setLayout(coursePanelLayout);
    coursePanelLayout.setHorizontalGroup(
                                         coursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursePanelLayout.createSequentialGroup()
                                                       .addComponent(selectCourseLabel)
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addComponent(courseList, 0, 317, Short.MAX_VALUE)
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addComponent(openCourseBtn))
                                        );
    coursePanelLayout.setVerticalGroup(
                                       coursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                         .addComponent(openCourseBtn)
                                         .addGroup(coursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                     .addComponent(courseList, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                     .addComponent(selectCourseLabel))
                                      );
    mainPanel.setMinimumSize(new java.awt.Dimension(300, 300));
    
    fileMenu.setBorder(javax.swing.BorderFactory.createCompoundBorder());
    fileMenu.setText("File");
    
    save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                                                           java.awt.event.KeyEvent.VK_S,
                                                           java.awt.event.InputEvent.CTRL_MASK));
    save.setMnemonic('S');
    save.setText("Save");
    fileMenu.add(save);
    
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
    
    editCourse.setText("Course");
    editMenu.add(editCourse);
    
    editStudent.setText("Student");
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
    
    importStudents.setText("Import Student List");
    importExportMenu.add(importStudents);
    
    exportStudents.setText("Export Student List");
    importExportMenu.add(exportStudents);
    
    mainToolbar.add(importExportMenu);
    
    setJMenuBar(mainToolbar);
    
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
                              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(coursePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mainPanel)
                             );
    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                          .addComponent(coursePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                          .addContainerGap())
                           );
    
    pack();
    
  }
  /**
   * Storing data when the save button is clicked
   */
  private void storeData()
  {
    try{
      
      FileOutputStream fOut = new FileOutputStream("save_data.dat");
      ObjectOutputStream out = new ObjectOutputStream(fOut);
      out.writeObject(this.courses);
      out.close(); 
      fOut.close();
      
      System.out.println("file saved correctly");
    }
    catch(IOException e)
    {
      System.out.println(e.toString());
    }
  }
  /**
   * load the data into the program when the program initializes
   */
  private void loadData() 
  {
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("save_data.dat"));
      ArrayList<Course> listCourses = (ArrayList<Course>) in.readObject();
      
      
      // load in the data
      for(int i =0; i < listCourses.size(); i++)
      {
      //  if(listCourses.get(i).getCourseCode().equals("----"))
       // {
        //}
       // else
        //{
          courses.add(listCourses.get(i));
          System.out.println(listCourses.get(i));
          courseList.addItem(courses.get(courses.size()-1));
        //}
      }
      
      
      System.out.println("Load Successful");
      in.close();  
    } catch (IOException e) {
      System.out.println("Load Fail");
    } catch (ClassNotFoundException e) {
      System.out.println("Load Fail");
    }
    finally{
      
    }
  }

}
