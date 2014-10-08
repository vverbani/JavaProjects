package team6;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to implement the Edit Deliverable user interface
 * 
 * @author CS2212 - Team 6
 */
public class EditDeliverableUI extends javax.swing.JPanel {

	// Instance Variables
	private JLabel alert;
	private JComboBox<Deliverable> deliverableCombo;
	private JLabel deliverableLabel;
	private JButton editDeliverableButton;
	private JPanel jPanel11;
	private JTextField name;
	private JLabel nameLabel;
	private JTextField type;
	private JLabel typeLabel;
	private JTextField weight;
	private JLabel weightLabel;
	private ArrayList<Deliverable> deliverables;
	private JRadioButton assgnmtRBtn;
	private JRadioButton examRBtn;
	private ButtonGroup group;
	private double weightSum;

	/**
	 * Creates new form EditDeliverable
	 * 
	 * @param courses2
	 */
	public EditDeliverableUI(ArrayList<Deliverable> deliverables,
			double weightSum) {
		this.weightSum = weightSum;
		this.deliverables = deliverables;
		initComponents();
	}

	/**
	 * Action event handler for the edit button
	 * 
	 * @param evt
	 *            action event
	 */
	private void editDeliverableButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		// if no name is not is inserted, then show alert
		if (name.getText().equals(""))
			alert.setText("A deliverable name must be entered");
		else {
			try {
				double weightDouble = Double.parseDouble(weight.getText());
				// if the entered weight is greater than 0, add deliverable
				if (weightDouble > 0) {
					// if the total weight of all deliverable is not greater
					// than 100%, add deliverable
					weightSum = weightSum
							- deliverables.get(
									deliverableCombo.getSelectedIndex())
									.getWeight();
					if ((weightSum + weightDouble) <= 100) {
						// if assignment is selected, add deliverable
						if (assgnmtRBtn.isSelected()) {
							weightSum = weightSum
									- deliverables
											.get(deliverableCombo
													.getSelectedIndex())
											.getWeight() + weightDouble;
							GradeBookUI.updateEditDeliverable(
									deliverableCombo.getSelectedIndex(),
									name.getText(), weightDouble, "Assignment");
						}
						// if exam is selected, add deliverable
						else if (examRBtn.isSelected()) {
							weightSum = weightSum
									- deliverables
											.get(deliverableCombo
													.getSelectedIndex())
											.getWeight() + weightDouble;
							GradeBookUI.updateEditDeliverable(
									deliverableCombo.getSelectedIndex(),
									name.getText(), weightDouble, "Exam");
						}
						// if not type is selected, show alert
						else
							alert.setText("A deliverable's type must be selected");
					} else
						alert.setText("The weight of all deliverables is greater than 100%");
				} else
					alert.setText("The deliverable weight must be greater than zero");
			}
			// if the weight is parsed and it is not a number, catch exception
			// and show alert
			catch (NumberFormatException e) {
				alert.setText("A deliverable's weight must be a number");
			}
		}
	}

	/**
	 * Action method for the deliverable combo box
	 * 
	 * @param evt
	 *            action event
	 */
	private void deliverableComboActionPerformed(java.awt.event.ActionEvent evt) {
		// populate information of existing deliverable for user
		name.setText(deliverables.get(deliverableCombo.getSelectedIndex())
				.getName());
		type.setText(deliverables.get(deliverableCombo.getSelectedIndex())
				.getType());
		String weightStr = Double.toString(deliverables.get(
				deliverableCombo.getSelectedIndex()).getWeight());
		weight.setText(weightStr);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel11 = new JPanel();
		weight = new JTextField();
		name = new JTextField();
		nameLabel = new JLabel();
		weightLabel = new JLabel();
		editDeliverableButton = new JButton();
		typeLabel = new JLabel();
		type = new JTextField();
		alert = new JLabel();
		deliverableCombo = new JComboBox<Deliverable>();
		deliverableLabel = new JLabel();
		assgnmtRBtn = new JRadioButton();
		examRBtn = new JRadioButton();
		group = new ButtonGroup();

		jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		nameLabel.setFont(new java.awt.Font("Arial", 0, 12));
		nameLabel.setText("Name:");

		weightLabel.setFont(new java.awt.Font("Arial", 0, 12));
		weightLabel.setText("Weight (%):");

		editDeliverableButton.setText("Update");
		editDeliverableButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						editDeliverableButtonActionPerformed(evt);
					}
				});

		typeLabel.setFont(new java.awt.Font("Arial", 0, 12));
		typeLabel.setText("Type:");

		// If the deliverable list in the course is not empty, add the list of
		// deliverables to the combo box
		if (!deliverables.isEmpty()) {
			for (int i = 0; i < deliverables.size(); i++)
				deliverableCombo.addItem(deliverables.get(i));
		}

		deliverableLabel.setText("Select Deliverable: ");

		deliverableCombo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deliverableComboActionPerformed(evt);
			}
		});

		alert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		assgnmtRBtn.setText("Assignment");
		examRBtn.setText("Exam");

		// add radio buttons to the button group
		group.add(assgnmtRBtn);
		group.add(examRBtn);

		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(
				jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout
				.setHorizontalGroup(jPanel11Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel11Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																weightLabel)
														.addComponent(nameLabel)
														.addComponent(typeLabel))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel11Layout
																		.createSequentialGroup()
																		.addComponent(
																				alert,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				146,
																				Short.MAX_VALUE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				editDeliverableButton))
														.addComponent(weight)
														.addComponent(name)
														.addGroup(
																jPanel11Layout
																		.createSequentialGroup()
																		.addComponent(
																				assgnmtRBtn)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				examRBtn)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		jPanel11Layout
				.setVerticalGroup(jPanel11Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel11Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																name,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																20,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(nameLabel))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																weight,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																weightLabel))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(typeLabel)
														.addComponent(
																assgnmtRBtn)
														.addComponent(examRBtn))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																editDeliverableButton)
														.addComponent(alert))
										.addContainerGap(105, Short.MAX_VALUE)));

		jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { alert, name, weight });

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
														jPanel11,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		deliverableLabel)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		deliverableCombo,
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
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(deliverableLabel)
												.addComponent(
														deliverableCombo,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel11,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap()));
	}
}
