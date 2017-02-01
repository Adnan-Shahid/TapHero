import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Timer;
public class GameEnd extends JFrame
{
	
	static JTextField txtName;
	static JButton btnSubmit;
	static JLabel lblName;
	static JLabel lblFScore;
	static JLabel lblEnd;
	
	static PrintWriter fileOut;
	static BufferedReader readFile;
	static StringTokenizer strTokenComma;
	static Vector <String> vctrNames = new Vector();
	static Vector <Integer> vctrScores = new Vector();
	public static int intSize;
	public static String strData;
	
	
	
	public static int intFScore;
	public static String strName;
	static JFrame end;
	public static void End()
	{
		intFScore = Game.intScore;
		//Making frame
		end = new JFrame("Clicker Hero");
	    end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //Setting panel for entire frame 
	    JPanel contentPane = new JPanel();
	    contentPane.setOpaque(true);
	    contentPane.setBackground(Color.WHITE);	//White background color
	    contentPane.setLayout(null);	//Allows coordinate placing of objects
	    
	    //title label
	    lblEnd = new JLabel("GAME COMPLETED");
	    lblEnd.setSize(210, 40);
        lblEnd.setLocation(145, 5);
        lblEnd.setFont(new Font("Impact",Font.PLAIN,20));
        lblEnd.setForeground(Color.RED);
        
	    //label for name
	    lblName = new JLabel("Please Enter your Name: ");
	    lblName.setSize(210, 40);
        lblName.setLocation(20, 50);
        lblName.setFont(new Font("Impact",Font.PLAIN,20));
        
        //Outputting the score
        lblFScore = new JLabel("Your Final Score: " + intFScore);
        lblFScore.setSize(210, 40);
        lblFScore.setLocation(20, 100);
        lblFScore.setFont(new Font("Impact",Font.PLAIN,20));
        
        //textfield for name input
        txtName = new JTextField("");
        txtName.setSize(205,30);
        txtName.setLocation(215,55);
        //txtInput.getText()
        
        //Submit button
        btnSubmit = new JButton("Submit");
        btnSubmit.setSize(200,50);
        btnSubmit.setLocation(140,150);
        btnSubmit.setFont(new Font("Impact",Font.PLAIN,20));
        btnSubmit.setBackground(Color.WHITE);
        btnSubmit.setBorderPainted(true);
        
        //actions listener for btnsubmit
        ButtonHandler onClick = new ButtonHandler();
        btnSubmit.addActionListener(onClick);
       
	    
	    
	    
	    //adding items to content pane for output
        contentPane.add(lblEnd);
	    contentPane.add(lblName);
	    contentPane.add(lblFScore);
	    contentPane.add(txtName);
	    contentPane.add(btnSubmit);
	    
	    
	    //reading file size
	    try {
			readFile = new BufferedReader (new FileReader ("HighScores.txt"));
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((readFile.readLine()) != null) 
			{
				intSize++;
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Creating a vector containing the file components
		
		try {
			readFile = new BufferedReader (new FileReader ("HighScores.txt"));
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < intSize;i++)
		{
			try {
				strTokenComma = new StringTokenizer(readFile.readLine(), ",");
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (strTokenComma.hasMoreElements()) //Goes until there are no more elements
			 {
				vctrNames.add((String) strTokenComma.nextElement());
				vctrScores.add(Integer.parseInt((String) strTokenComma.nextElement()));
			 } 
			 
		}
	    //an output for checking code to see if it works
		System.out.println(intSize);
	    
	    
	    
	    //Placing content pane and enabling frame to be visible
        end.setContentPane(contentPane);
        end.setSize(460, 260);
        end.setLocationByPlatform(true);
        end.setVisible(true);
        //starting the window at middle of the screen
	    end.setLocationRelativeTo(null);
	    
	    
	}
	
	private static class ButtonHandler implements ActionListener	//entering the user values into the text file
	{
		public void actionPerformed(ActionEvent e)
		{
			//if the user doesn't input a name, auto places one for him/her
			if (txtName.getText().equals(null) || txtName.getText().equals(""))
			{
				txtName.setText("Unknown");
			}
			//get user name
			strName = txtName.getText();
			
			
			
			
			
			//creating printwriter
			try {
				  fileOut = new PrintWriter (new FileWriter("HighScores.txt"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//getting to end of the lines
			for (int i = 0; i < intSize; i ++)
			{
				try{
				fileOut.println(vctrNames.get(i) +"," + vctrScores.get(i));
				}
				catch (Exception e1)
				{
					
				}
				//output to check code 
				System.out.println(i);
			}
			
			//placing in the new value of data
			strData = (txtName.getText() + "," + Integer.toString(intFScore));
			//checks if the data is printed properly
			System.out.println(strData);
			//adds data to file
			fileOut.println(strData);
			fileOut.close();
			//closes window and opens the high scores window
			end.dispose();
			HighScores.Scores();
			
		}
			
		
	}
}
