package team6;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import javax.activation.*;
import java.net.URL;
import javax.mail.*;
import javax.mail.internet.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.xml.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Class to create the JTable and allow for grade report creation and emailing capabilitie
 * @author Team 6 - CS 2212 - UWO
 */
public class JTableUI extends javax.swing.JPanel {

	//instance variables

	private JLabel alert;
	private JButton emailBtn;
	private JButton reportBtn;
	private JScrollPane scrollPane;
	private JTable table;
	private Course course;
	private Properties properties;
	private final static String REPORT_NAME = "grade-report";

	/**
	 * This constructor creates the course table for the GUI
	 * @param course the course data
	 * @param properties the properties for email settings
	 */
	public JTableUI(Course course, Properties properties) {
		this.course = course;
		this.properties = properties;
		initComponents();
	}

	/**
	 *Loads the JRXML file for the report to be generated
	 *@param String the file name for the JRXML.
	 */
	public static InputStream loadResources(String filename) {

		return App.class.getClassLoader().getResourceAsStream(filename);
	}

	/**
	 *This method is triggered when the report generation button is pressed
	 *It will create a PDF and HTML copy of a student's grade report
	 */
	private void reportBtnActionPerformed(java.awt.event.ActionEvent evt) {

		try {
			alert.setText("");
			ArrayList<Student> studentReports = new ArrayList<Student>();

			// add the selected recipients to the recipient array
			int[] selectedRows = table.getSelectedRows();
			// check if no students are selected
			if (selectedRows.length != 0) {
				// for all the selected rows, add the students to an array
				for (int i = 0; i < selectedRows.length; i++) {
					Student student = course.getStudents().get(selectedRows[i]);
					studentReports.add(student);
				}
				
				// for all the students in the array, build the report
				for (int i = 0; i < studentReports.size(); i++) {
					Student cStudent = studentReports.get(i);
					String reportName = ""	+ studentReports.get(i).getStudentNumber();
					InputStream reportStream = loadResources(REPORT_NAME+ ".jrxml");

					InputStream logoStream = loadResources("prof.png");
					BufferedImage logo = ImageIO.read(logoStream);

					Collection<ReportData> reportData = new ArrayList<ReportData>();
					reportData.add(new ReportData(course, cStudent, -1));

					for (int j = 0; j < course.getDeliverables().size(); j++) {
						if (course.getDeliverables().get(j) != null)
							reportData.add(new ReportData(course, cStudent, j));
					}

					JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
							reportData);

					Map<String, Object> parameters = new HashMap<String, Object>();
					parameters.put("logo", logo);

					JasperDesign jasperDesign = JRXmlLoader.load(reportStream);

					JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
					
					File file = new File(reportName + "-grades.pdf");
					if(file.exists())
						file.delete();
					JasperExportManager.exportReportToPdfFile(jasperPrint, reportName + "-grades.pdf");				
				}
			} else {
				alert.setText("No students have been selected");
			}
		} catch (Exception e) {
			alert.setText("An error occurred while generating reports");
		}
	}

	/**
	 * Emails the selected students their grade report, displays an error is a
	 * report has not been created for the student selected
	 * 
	 * @param evt
	 *            Event Handler
	 */
	private void emailBtnActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			ArrayList<Student> recipients = new ArrayList<Student>();

			// add the selected recipients to the recipient array
			int[] selectedRows = table.getSelectedRows();
			
			selectedRows.toString();
			// check if no students are selected
			if (selectedRows.length != 0) {
				for (int i = 0; i < selectedRows.length; i++) {
					recipients.add(course.getStudents().get(selectedRows[i]));
				}
				
				int errorCount = 0;
				// send an e-mail to each student selected
				for (int i = 0; i < recipients.size(); i++) {
					Student current = recipients.get(i);
					EmailHelper email = new EmailHelper(course, current, properties);
					Session session = email.getSession(properties);
					int error = email.sendMessage(properties, session);
					if (error == 2)
						alert.setText("Error occurred while attempting to send; attachment DNE");
					else
						errorCount = errorCount + error;
				}
				if (errorCount == 0)
					alert.setText("");
				else
					alert.setText("Email failed for " + errorCount
							+ " student(s). Attachment N/A.");
			} else {
				alert.setText("No students have been selected");
			}

		} catch (Exception e) {
			alert.setText("Error occurred while attempting to send; please check SMTP settings.");
		}
	}

	/**
	 * Constructor that receives the active course as its parameter Creates a
	 * CourseTableModel and displays it
	 */
	private void initComponents() {

		reportBtn = new JButton();
		emailBtn = new JButton();
		alert = new JLabel();

		// Create a JTable using a new instance of a CourseTableModel
		table = new JTable(new CourseTableModel(course));
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);

		reportBtn.setText("Build Report(s)");
		reportBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				reportBtnActionPerformed(evt);
			}
		});

		emailBtn.setText("Email Grade Report(s)");
		emailBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				emailBtnActionPerformed(evt);
			}
		});

        alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailBtn))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(emailBtn)
                        .addComponent(reportBtn))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {alert, emailBtn, reportBtn});

    }//end initComponents


}//end JTableUI
