package team6;

import java.util.ArrayList;
import javax.swing.*;

/**
 * Class to implement the delete deliverable user interface
 * 
 * @author CS2212 - Team 6
 */
public class DeleteDeliverableUI extends javax.swing.JPanel {

	// Instance Variables
	private JLabel alert;
	private JButton deleteDeliverableButton;
	private JComboBox<Deliverable> deliverableCombo;
	private JLabel deliverableLabel;
	private JPanel jPanel11;
	private JLabel name;
	private JLabel nameLabel;
	private JLabel type;
	private JLabel typeLabel;
	private JLabel weight;
	private JLabel weightLabel;
	private ArrayList<Deliverable> deliverables;
	private double weightSum;

	/**
	 * Creates new form DeleteDeliverable
	 */
	public DeleteDeliverableUI(ArrayList<Deliverable> deliverables,
			double weightSum) {
		this.weightSum = weightSum;
		this.deliverables = deliverables;
		initComponents();
	}

	/**
	 * Action event handler for the delete button
	 * 
	 * @param evt
	 *            action event
	 */
	private void deleteDeliverableButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		weightSum = weightSum
				- deliverables.get(deliverableCombo.getSelectedIndex())
						.getWeight();
		GradeBookUI
				.updateDeleteDeliverable(deliverableCombo.getSelectedIndex());
		alert.setText("The deliverable has been deleted");
	}

	/**
	 * Action method for the deliverable combo box to display the info of the
	 * object selected
	 * 
	 * @param evt
	 *            action event
	 */
	private void deliverableComboActionPerformed(java.awt.event.ActionEvent evt) {
		// populate information of deliverable to be deleted for user
		name.setText(deliverables.get(deliverableCombo.getSelectedIndex())
				.getName());
		type.setText(deliverables.get(deliverableCombo.getSelectedIndex())
				.getType());
		String weightStr = Double.toString(deliverables.get(
				deliverableCombo.getSelectedIndex()).getWeight())
				+ "%";
		weight.setText(weightStr);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		deliverableCombo = new JComboBox<Deliverable>();
		deliverableLabel = new JLabel();
		jPanel11 = new JPanel();
		nameLabel = new JLabel();
		weightLabel = new JLabel();
		deleteDeliverableButton = new JButton();
		typeLabel = new JLabel();
		alert = new JLabel();
		name = new JLabel();
		weight = new JLabel();
		type = new JLabel();

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

		jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		nameLabel.setFont(new java.awt.Font("Arial", 0, 12));
		nameLabel.setText("Name:");

		weightLabel.setFont(new java.awt.Font("Arial", 0, 12));
		weightLabel.setText("Weight:");

		deleteDeliverableButton.setText("Delete");
		deleteDeliverableButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						deleteDeliverableButtonActionPerformed(evt);
					}
				});

		typeLabel.setFont(new java.awt.Font("Arial", 0, 12));
		typeLabel.setText("Type:");

		alert.setFont(new java.awt.Font("Tahoma", 1, 12));

		// user interface layout
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
														.addComponent(typeLabel)
														.addComponent(nameLabel))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel11Layout
																		.createSequentialGroup()
																		.addComponent(
																				alert,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				deleteDeliverableButton))
														.addComponent(
																name,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																321,
																Short.MAX_VALUE)
														.addComponent(
																weight,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																type,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
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
														.addComponent(nameLabel)
														.addComponent(name))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																weightLabel)
														.addComponent(weight))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(typeLabel)
														.addComponent(type))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel11Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																deleteDeliverableButton,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																alert,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap(113, Short.MAX_VALUE)));

		jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { name, type, typeLabel, weight });

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
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
												javax.swing.GroupLayout.Alignment.LEADING)
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
