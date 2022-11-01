package test;

import javax.swing.JFrame ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MyGUI extends JFrame implements ActionListener{
	private JLabel promot =new JLabel("Weighted Score");
	private JLabel promot1 =new JLabel("Total Points");
	private JLabel promot2 =new JLabel("percentage");
	private JLabel promot3 =new JLabel("earned points");
	private JTextField inputPercentage=new JTextField(15);
	private JTextField inputTotalP=new JTextField(15);
	private JTextField inputEarnedP=new JTextField(15);
	private JTextArea display=new JTextArea(10,20);
	private JButton convert=new JButton("Click to calculate score!");
	public MyGUI() {
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(promot1);
		getContentPane().add(inputTotalP);
		getContentPane().add(promot2);
		getContentPane().add(inputPercentage);
		getContentPane().add(promot3);
		getContentPane().add(inputEarnedP);
		getContentPane().add(convert);
		getContentPane().add(promot);
		getContentPane().add(display);
		convert.addActionListener(this);
		inputPercentage.addActionListener(this);
		inputTotalP.addActionListener(this);
		inputEarnedP.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		weighted_grades wg=new weighted_grades();
		wg.setPointTotal(Double.valueOf(inputTotalP.getText()));
		wg.setAssignPercentage(Double.valueOf(inputPercentage.getText()));
		wg.setEarnedPoints(Double.valueOf(inputEarnedP.getText()));
		double totalGrades=wg.weightedGrade();
		display.append(Double.toString(totalGrades));
		inputTotalP.setText("");
		inputPercentage.setText("");
		inputEarnedP.setText("");
		
	}
	public static void main(String[] args) {
		MyGUI c=new MyGUI();
		c.setSize(300, 400);
		c.setVisible(true);
		c.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
}