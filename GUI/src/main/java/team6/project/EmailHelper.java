package team6;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.*;
import javax.activation.*;
import java.net.URL;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Email Helper to enable emailing of grade reports to students
 * 
 * @author Team 6 - CS2212 - UWO
 */
public class EmailHelper {

	private Student student;
	private Course course;
	private Properties props;

	/**
	 * Constructor for creating an e-mail helper to send e-mails to students
	 * 
	 * @param course
	 *            the course related to the students and grades
	 * @param student
	 *            the student to be emailed
	 */
	public EmailHelper(Course course, Student student, Properties props) {
		this.course = course;
		this.student = student;
		this.props = props;
	}

	/**
	 * Gets the current session
	 * 
	 * @param properties
	 *            mailer properties
	 * @return the current session
	 */
	public static Session getSession(final Properties properties) {

		Session session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {

						String username = properties
								.getProperty("smtp.username");
						String password = properties
								.getProperty("smtp.password");
						return new PasswordAuthentication(username, password);
					}
				});

		return session;
	}

	/**
	 * Sends the e-mail to a student with grade report attached
	 * 
	 * @return String the student name of any failed email attempts
	 * @throws Exception
	 */
	public int sendMessage(Properties properties, Session session) {

		try {
			Message msg = new MimeMessage(session);
			String senderName = properties.getProperty("sender.name");
			String senderEmail = properties.getProperty("sender.email");

			String host = properties.getProperty("smtp.host");
			//System.out.println(host);
			String port = properties.getProperty("mail.smtp.port");
		//	System.out.println(port);
			
			Address sender = new InternetAddress(senderEmail, senderName);
			msg.setFrom(sender);

			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					student.getEmailAddress()));

			String studentName = student.getFirstName() + " "
					+ student.getLastName();
			msg.setSubject("Grades Report for " + studentName);

			Multipart multiPart = new MimeMultipart();

			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello " + studentName
					+ ",  \n\nPlease find attached your grade report for "
					+ course.getCourseCode() + "-" + course.getCourseTitle()
					+ ". \n\nSincerely, \n" + senderName);

			// add attached to e-mail
			MimeBodyPart fileAttachmentPart = new MimeBodyPart();
			String studentNum = "" + student.getStudentNumber();
			File attachment = new File(studentNum + "-grades.pdf");
			if (!attachment.exists())
				return 1;
			else {

				// throws exception if attachmentURL is null,
				// aka a report has not been created for the student being emailed
				DataSource source = new FileDataSource(attachment);
				fileAttachmentPart.setDataHandler(new DataHandler(source));
				fileAttachmentPart.setFileName(studentNum + "-grades.pdf");
				multiPart.addBodyPart(fileAttachmentPart);

				multiPart.addBodyPart(textPart);

				msg.setContent(multiPart);

				Transport.send(msg);
				return 0;
			}
		} catch (Exception e) {
			return 2;
		}
	}

}