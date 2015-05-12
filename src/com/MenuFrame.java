package com;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MenuFrame extends JFrame implements ActionListener {

	private JTextField nameP1;// Name of player 1;
	private JTextField nameP2;// Name of player 2;
	private JLabel nameP1Lbl;// Name of player 1 label;
	private JLabel nameP2Lbl;// Name of player 2 label;
	private JButton confirm;
	private ArrayList<JRadioButton> radioButtonsP1;
	private ArrayList<JRadioButton> radioButtonsP2;
	private ButtonGroup btn1 = new ButtonGroup();
	private ButtonGroup btn2 = new ButtonGroup();
	private Color color1;
	private Color color2;

	public MenuFrame() {
		super("JTank");
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		GridBagConstraints gc = new GridBagConstraints();
		setSize(500, 500);
		radioButtonsP1 = new ArrayList<>();
		radioButtonsP2 = new ArrayList<>();

		nameP1 = new JTextField(10);
		nameP2 = new JTextField(10);
		nameP1Lbl = new JLabel("Player 1:");
		nameP2Lbl = new JLabel("Player 2:");
		confirm = new JButton("Play!");

		radioButtonsP1.add(new JRadioButton("Red"));
		radioButtonsP1.add(new JRadioButton("Blue"));
		radioButtonsP1.add(new JRadioButton("Green"));

		btn1.add(radioButtonsP1.get(0));
		btn1.add(radioButtonsP1.get(1));
		btn1.add(radioButtonsP1.get(2));

		radioButtonsP2.add(new JRadioButton("Red"));
		radioButtonsP2.add(new JRadioButton("Blue"));
		radioButtonsP2.add(new JRadioButton("Green"));

		btn2.add(radioButtonsP2.get(0));
		btn2.add(radioButtonsP2.get(1));
		btn2.add(radioButtonsP2.get(2));

		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 1;

		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 0;
		add(nameP1Lbl, gc);

		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 1;
		add(nameP1, gc);

		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 0;
		add(nameP2Lbl, gc);

		gc.weighty = 1;
		gc.gridx = 1;
		gc.gridy = 1;
		add(nameP2, gc);

		// gc.gridy = 2;
		// gc.gridx = 1;
		// gc.anchor = GridBagConstraints.CENTER;
		// add(confirm, gc);
		//
		gc.gridx = 0;
		gc.gridy = 2;
		add(radioButtonsP1.get(0), gc);

		gc.gridx = 0;
		gc.gridy = 3;
		add(radioButtonsP1.get(1), gc);

		gc.gridx = 0;
		gc.gridy = 4;
		add(radioButtonsP1.get(2), gc);

		gc.gridx = 1;
		gc.gridy = 2;
		add(radioButtonsP2.get(0), gc);

		gc.gridx = 1;
		gc.gridy = 3;
		add(radioButtonsP2.get(1), gc);

		gc.gridx = 1;
		gc.gridy = 4;
		add(radioButtonsP2.get(2), gc);

		gc.gridx = 1;
		gc.gridy = 5;
		add(confirm, gc);

		confirm.addActionListener(this);
		setVisible(true);
		setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		dispose();
		if (radioButtonsP1.get(0).isSelected()) {
			color1 = Color.RED;
		} else if (radioButtonsP1.get(1).isSelected()) {
			color1 = Color.BLUE;
		} else if(radioButtonsP1.get(2).isSelected()) {
			color1 = Color.GREEN;
		}
		if (radioButtonsP2.get(0).isSelected()) {
			color2 = Color.RED;
		} else if (radioButtonsP2.get(1).isSelected()) {
			color2 = Color.BLUE;
		} else if(radioButtonsP2.get(2).isSelected()) {
			color2 = Color.GREEN;
		}
		Game.getGame(nameP1.getText(), nameP2.getText(), color1,
				color2);
	}

}
