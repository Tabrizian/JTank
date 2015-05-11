package com;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuFrame extends JFrame {

	private JTextField nameP1;// Name of player 1;
	private JTextField nameP2;// Name of player 2;
	private JLabel nameP1Lbl;// Name of player 1 label;
	private JLabel nameP2Lbl;// Name of player 2 label;
	private JColorChooser colorChooserUI;

	public MenuFrame() {
		super("JTank");
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		GridBagConstraints gc = new GridBagConstraints();
		setSize(500, 500);

		colorChooserUI = new JColorChooser();
		nameP1 = new JTextField(10);
		nameP2 = new JTextField(10);
		nameP1Lbl = new JLabel("Player 1:");
		nameP2Lbl = new JLabel("Player 2:");

		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 0;
		gc.gridy = 0;
		add(nameP1Lbl, gc);

		
		gc.gridx = 0;
		gc.gridy = 1;
		add(nameP1, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		add(nameP2Lbl, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		add(nameP2, gc);

		setVisible(true);
		setResizable(false);

	}

}
