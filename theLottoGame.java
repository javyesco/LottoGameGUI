/**
 * Author: Luis J. Escobar
 * Computer Science Major
 * Language Used: JAVA
 * Last Update: December 31, 2019
 * 
 * Purpose: This code was originally 
 * made using Anonymous Classes; I wanted to make
 * the same code, but this time using GUI features.
 * 
 * What it does: This code generates a random number
 * between the values of 1000 && 9999, as a lottery would do;
 * the number is then compared with a number the user inputs
 * to determine whether the player won the game or not.
 * 
 * Adds for future: 
 * Wish to continue playing?
 */


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class theLottoGame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLottoInput;
	private JTextField txtLottoResult;
	private JTextField txtWonOrNot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					theLottoGame frame = new theLottoGame();
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
	public theLottoGame() {
		setTitle("Lottery Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 309);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Option");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Quit Game");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtLottoInput = new JTextField();
		txtLottoInput.setHorizontalAlignment(SwingConstants.CENTER);
		txtLottoInput.setFont(new Font("Calibri", Font.BOLD, 21));
		txtLottoInput.setBounds(10, 11, 260, 64);
		contentPane.add(txtLottoInput);
		txtLottoInput.setColumns(10);

		JButton btnGetResult = new JButton("Play");
		btnGetResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int randomNum;
					int input = Integer.parseInt(txtLottoInput.getText());
					Random rn = new Random();
					randomNum =  1000 + rn.nextInt(10000 - 1000);
					
					//BEEP SOUND
					java.awt.Toolkit.getDefaultToolkit().beep();
					
					//Input Exception Handling
					while(input<1000||input>9999) {
						txtLottoInput.setText("");
						JOptionPane.showMessageDialog(null, "The number you enterd is invalid. Please try again.");
						break;
					}
					
					//Random Number Exception Handling
					if(input < 1000 || input > 9999) {
						txtLottoResult.setText("");
					}else {
						txtLottoResult.setText("Winning Number: " + Integer.toString(randomNum));	
					}
					
					//Determines if you Won or Not
					if(input < 1000 || input > 9999) {
						txtWonOrNot.setText("");
					}else if(input == randomNum){
						txtWonOrNot.setText("You've Won!!!");
					}else {
						txtWonOrNot.setText("You've Lost. Try Again.");
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnGetResult.setBounds(280, 11, 120, 30);
		contentPane.add(btnGetResult);

		txtLottoResult = new JTextField();
		txtLottoResult.setHorizontalAlignment(SwingConstants.CENTER);
		txtLottoResult.setFont(new Font("Calibri", Font.BOLD, 19));
		txtLottoResult.setEditable(false);
		txtLottoResult.setBounds(10, 88, 390, 63);
		contentPane.add(txtLottoResult);
		txtLottoResult.setColumns(10);

		txtWonOrNot = new JTextField();
		txtWonOrNot.setHorizontalAlignment(SwingConstants.CENTER);
		txtWonOrNot.setFont(new Font("Calibri", Font.BOLD, 19));
		txtWonOrNot.setEditable(false);
		txtWonOrNot.setBounds(10, 162, 390, 63);
		contentPane.add(txtWonOrNot);
		txtWonOrNot.setColumns(10);
		
		//Try again button
		JButton btnTryAgain = new JButton("Try Again");
		btnTryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtLottoInput.setText("");
				txtLottoResult.setText("");
				txtWonOrNot.setText("");
			}
		});
		btnTryAgain.setBounds(280, 45, 120, 30);
		contentPane.add(btnTryAgain);
	}
}
