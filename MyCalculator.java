package calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MyCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton MRButton;
	private JButton MSButton;
	private JButton MplusButton;
	private JButton MminusButton;
	private JButton deleteButton;
	private JButton clearButton;
	private JButton leftParent;
	private JButton rightParent;
	private JButton sevenButton;
	private JButton eightButton;
	private JButton nineButton;
	private JButton divButton;
	private JButton fourButton;
	private JButton fiveButton;
	private JButton sixButton;
	private JButton timesButton;
	private JButton oneButton;
	private JButton twoButton;
	private JButton threeButton;
	private JButton minusButton;
	private JButton zeroButton;
	private JButton dotButton;
	private JButton plusButton;
	private JButton equalButton;
	
	
	private static Double memory =  0.0 ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operations frame = new Operations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyCalculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 416, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton MCButton = new JButton("MC");
		MCButton.setBackground(Color.YELLOW);
		MCButton.setBounds(10, 47, 77, 23);
		contentPane.add(MCButton);
		MCButton.addActionListener((e) ->
		{
			memory = 0.0 ; 
		});
		
		MRButton = new JButton("MR");
		MRButton.setBounds(97, 47, 77, 23);
		contentPane.add(MRButton);
		MRButton.addActionListener((e) ->
		{
			
			textField.setText(memory.toString()); ; 
		});
		
		MSButton = new JButton("MS");
		MSButton.setBounds(181, 47, 77, 23);
		contentPane.add(MSButton);
		MSButton.addActionListener((e) ->
		{
			String s = textField.getText() ; 
			String t = Postfix.result(Infix.infixToPostix(s)) ; 
			Double d = Double.parseDouble(t) ; 
			Double rounded = Math.round(d * 100.0) / 100.0 ; 
			String result = rounded.toString() ; 
			memory = Double.parseDouble(result) ; 
		});
		
		MplusButton = new JButton("M+");
		MplusButton.setBounds(268, 47, 77, 23);
		contentPane.add(MplusButton);
		MplusButton.addActionListener((e) ->
		{
			String s = textField.getText() ; 
			String t = Postfix.result(Infix.infixToPostix(s)) ; 
			Double d = Double.parseDouble(t) ; 
			Double rounded = Math.round(d * 100.0) / 100.0 ; 
			String result = rounded.toString() ; 
			
			memory+=Double.parseDouble(result) ; 
		});
		
		MminusButton = new JButton("M-");
		MminusButton.setBounds(355, 47, 77, 23);
		contentPane.add(MminusButton);
		MminusButton.addActionListener((e) ->
		{
			String s = textField.getText() ; 
			String t = Postfix.result(Infix.infixToPostix(s)) ; 
			Double d = Double.parseDouble(t) ; 
			Double rounded = Math.round(d * 100.0) / 100.0 ; 
			String result = rounded.toString() ; 
			memory-= Double.parseDouble(result) ; 
		});
		
		deleteButton = new JButton("DEL");
		deleteButton.setBounds(10, 79, 164, 23);
		contentPane.add(deleteButton);
		deleteButton.addActionListener((e) ->
		{
			if(textField.getText().length()>1)
			{
				String s1 = textField.getText().substring(0, textField.getText().length()-1) ; 
				textField.setText(s1);
			}
			else textField.setText("");
			
		
		});
		
		clearButton = new JButton("C");
		clearButton.setBounds(181, 79, 77, 23);
		contentPane.add(clearButton);
		clearButton.addActionListener((e) ->
		{
			
			textField.setText("");
			
		
		});
		
		leftParent = new JButton("(");
		leftParent.setBounds(268, 81, 77, 23);
		contentPane.add(leftParent);
		leftParent.addActionListener((e) ->
		{
			String s = textField.getText()+"(" ; 
			textField.setText(s);
		});
		
		rightParent = new JButton(")");
		rightParent.setBounds(355, 81, 77, 23);
		contentPane.add(rightParent);
		rightParent.addActionListener((e) ->
		{
			String s = textField.getText()+")" ; 
			textField.setText(s);
		});
		
		sevenButton = new JButton("7");
		sevenButton.setBounds(10, 111, 77, 23);
		contentPane.add(sevenButton);
		sevenButton.addActionListener((e) ->
		{
			String s = textField.getText()+"7" ; 
			textField.setText(s);
		});
		
		eightButton = new JButton("8");
		eightButton.setBounds(97, 113, 77, 23);
		contentPane.add(eightButton);
		eightButton.addActionListener((e) ->
		{
			String s = textField.getText()+"8" ; 
			textField.setText(s);
		});
		
		nineButton = new JButton("9");
		nineButton.setBounds(181, 113, 77, 23);
		contentPane.add(nineButton);
		nineButton.addActionListener((e) ->
		{
			String s = textField.getText()+"9" ; 
			textField.setText(s);
		});
		
		divButton = new JButton("/");
		divButton.setBounds(268, 111, 77, 23);
		contentPane.add(divButton);
		divButton.addActionListener((e) ->
		{
			String s = textField.getText()+"/" ; 
			textField.setText(s);
		});
		
		fourButton = new JButton("4");
		fourButton.setBounds(10, 147, 77, 23);
		contentPane.add(fourButton);
		fourButton.addActionListener((e) ->
		{
			String s = textField.getText()+"4" ; 
			textField.setText(s);
		});
		
		fiveButton = new JButton("5");
		fiveButton.setBounds(97, 147, 77, 23);
		contentPane.add(fiveButton);
		fiveButton.addActionListener((e) ->
		{
			String s = textField.getText()+"5" ; 
			textField.setText(s);
		});
		
		sixButton = new JButton("6");
		sixButton.setBounds(181, 147, 77, 23);
		contentPane.add(sixButton);
		sixButton.addActionListener((e) ->
		{
			String s = textField.getText()+"6" ; 
			textField.setText(s);
		});
		
		timesButton = new JButton("*");
		timesButton.setBounds(268, 145, 77, 23);
		contentPane.add(timesButton);
		timesButton.addActionListener((e) ->
		{
			String s = textField.getText()+"*" ; 
			textField.setText(s);
		});
		
		oneButton = new JButton("1");
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		oneButton.addActionListener((e) ->
		{
			String s = textField.getText()+"1" ; 
			textField.setText(s);
		});
		oneButton.setBounds(10, 181, 77, 25);
		contentPane.add(oneButton);
		
		twoButton = new JButton("2");
		twoButton.setBounds(97, 181, 77, 25);
		contentPane.add(twoButton);
		twoButton.addActionListener((e) ->
		{
			String s = textField.getText()+"2" ; 
			textField.setText(s);
		});
		
		threeButton = new JButton("3");
		threeButton.setBounds(181, 181, 77, 25);
		contentPane.add(threeButton);
		threeButton.addActionListener((e) ->
		{
			String s = textField.getText()+"3" ; 
			textField.setText(s);
		});
		
		minusButton = new JButton("-");
		minusButton.setBounds(268, 179, 77, 27);
		contentPane.add(minusButton);
		minusButton.addActionListener((e) ->
		{
			String s = textField.getText()+"-" ; 
			textField.setText(s);
		});
		
		zeroButton = new JButton("0");
		zeroButton.setBounds(10, 217, 164, 25);
		contentPane.add(zeroButton);
		zeroButton.addActionListener((e) ->
		{
			String s = textField.getText()+"0" ; 
			textField.setText(s);
		});
		
		dotButton = new JButton(".");
		dotButton.setBounds(181, 217, 77, 25);
		contentPane.add(dotButton);
		dotButton.addActionListener((e) ->
		{
			String s = textField.getText()+"." ; 
			textField.setText(s);
		});
		
		plusButton = new JButton("+");
		plusButton.setBounds(268, 217, 77, 25);
		contentPane.add(plusButton);
		plusButton.addActionListener((e) ->
		{
			String s = textField.getText()+"+" ; 
			textField.setText(s);
		});
		
		equalButton = new JButton("=");
		equalButton.setBounds(355, 111, 77, 131);
		contentPane.add(equalButton);
		equalButton.addActionListener((e) ->
		{
			String s = textField.getText() ; 
			String t = Postfix.result(Infix.infixToPostix(s)) ; 
			Double d = Double.parseDouble(t) ; 
			Double rounded = Math.round(d * 100.0) / 100.0 ; 
			String result = rounded.toString() ; 
			textField.setText(result);

		});
		
	}
}
