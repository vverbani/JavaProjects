package team6;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.util.prefs.*;

/**
 * Class to implement the user interface to allow for setting up the email
 * functionality of the program
 * 
 * @author Team 6 - UWO - CS2212
 */
public class SetupUI extends JPanel {

	
	
	//instance variables
	private JPanel mailSetup;
	private JTextField password;
	private JLabel passwordLbl;
	private JTextField port;
	private JLabel portLbl;
	private JTextField senderEmail;
	private JLabel senderEmailLbl;
	private JTextField senderName;
	private JLabel senderNameLbl;
	private JTextField server;
	private JLabel serverLbl;
	private JTextField username;
	private JLabel usernameLbl;
	private JButton saveBtn;
	private JLabel alert;
	private Preferences prefs;

	/**
	 * Creates new form setupUI
	 */
	public SetupUI(Preferences prefs) {
		this.prefs = prefs;
		initComponents();
	}//end SetupUI

	/**
	 * Save the email settings, updates the preferences in the Gradebook. 
	 * @param evt	event handler
	 * Save the email settings to a properties file in the resources folder
	 * 
	 * @param evt event handler
	 */
	private void saveEmailSettingsActionPerformed(java.awt.event.ActionEvent evt) {

		prefs.put("mail.smtp.host", server.getText());
		prefs.put("smtp.username", username.getText());
		prefs.put("smtp.password", password.getText());
		prefs.put("mail.smtp.port", port.getText());
		prefs.put("sender.name",senderName.getText());
		prefs.put("sender.email",senderEmail.getText());	
		
		GradeBookUI.updateEmailSetup(prefs);
	}

	/**
	 * Elements and action of the user interface of email setup
	 * 
	 */
	private void initComponents() {

		mailSetup = new JPanel();
		usernameLbl = new JLabel();
		username = new JTextField();
		passwordLbl = new JLabel();
		password = new JTextField();
		portLbl = new JLabel();
		port = new JTextField();
		senderNameLbl = new JLabel();
		senderEmailLbl = new JLabel();
		senderName = new JTextField();
		senderEmail = new JTextField();
		serverLbl = new JLabel();
		server = new JTextField();
		saveBtn = new JButton();
		alert = new JLabel();

		mailSetup.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		usernameLbl.setText("SMTP Username:");
		username.setText(prefs.get("smtp.username", "username"));

		passwordLbl.setText("SMTP Password: ");
		password.setText(prefs.get("smtp.password", "password"));

		portLbl.setText("SMTP Port: ");
		port.setText(prefs.get("mail.smtp.port", "1025"));

		senderNameLbl.setText("Sender Name:");
		senderName.setText(prefs.get("sender.name", "John Doe"));

		senderEmailLbl.setText("Sender Email:");
		senderEmail.setText(prefs.get("sender.email", "jdoe@example.com"));

		serverLbl.setText("SMTP Server:");
		server.setText(prefs.get("mail.smtp.host", "localhost"));

		saveBtn.setText("Save");
		saveBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveEmailSettingsActionPerformed(evt);
			}
		});

		alert.setFont(new java.awt.Font("Tahoma", 1, 11));

		javax.swing.GroupLayout mailSetupLayout = new javax.swing.GroupLayout(
				mailSetup);
		mailSetup.setLayout(mailSetupLayout);
		mailSetupLayout
				.setHorizontalGroup(mailSetupLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mailSetupLayout
										.createSequentialGroup()
										.addGroup(
												mailSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																passwordLbl)
														.addComponent(portLbl)
														.addComponent(
																senderNameLbl)
														.addComponent(
																senderEmailLbl)
														.addComponent(
																usernameLbl)
														.addComponent(serverLbl))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												mailSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																mailSetupLayout
																		.createSequentialGroup()
																		.addComponent(
																				alert,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				saveBtn))
														.addComponent(
																server,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																273,
																Short.MAX_VALUE)
														.addComponent(username)
														.addComponent(password)
														.addComponent(port)
														.addComponent(
																senderName)
														.addComponent(
																senderEmail))
										.addContainerGap()));

		mailSetupLayout
				.setVerticalGroup(mailSetupLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								mailSetupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												mailSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(serverLbl)
														.addComponent(
																server,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												mailSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																usernameLbl)
														.addComponent(
																username,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												mailSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																passwordLbl)
														.addComponent(
																password,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												mailSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(portLbl)
														.addComponent(
																port,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												mailSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																senderNameLbl)
														.addComponent(
																senderName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												mailSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																senderEmailLbl)
														.addComponent(
																senderEmail,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												mailSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(saveBtn)
														.addComponent(alert))
										.addContainerGap(58, Short.MAX_VALUE)));

		mailSetupLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { password, port, senderEmail,
						senderName, server, username });

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(mailSetup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(mailSetup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
	}//end initComponents
}//end SetupUI
