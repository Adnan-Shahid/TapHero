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
public class HighScores 
{
	static JFrame score;
	static JButton btnMenu;
	static JButton btnSearch;
	static JTextField txtSearch;
	static JLabel lblSearch;
	static JLabel lblTitle;
	static JLabel[] lblScores = new JLabel[5];
	static JLabel lblFirstN;
	static JLabel lblFirstS;
	static JLabel lblSecondN;
	static JLabel lblSecondS;
	static JLabel lblThirdN;
	static JLabel lblThirdS;
	static JLabel lblFourthN;
	static JLabel lblFourthS;
	static JLabel lblFifthN;
	static JLabel lblFifthS;
	
	public static int intSize;
	static Vector <String> vctrNames = new Vector();
	static Vector <Integer> vctrScores = new Vector();
	static BufferedReader readFile;
	static StringTokenizer strTokenComma;
	public static int intTempScore;
	public static String strTempName;
	public static boolean blnCheck = false;
	public static String strSearch;
	public static int intPosition;
	public static boolean blnExit = false;
	
	public static void Scores()
	{
		intSize = 0;
		vctrScores = new Vector();
		vctrNames = new Vector();
		
		//Making frame
		score = new JFrame("Clicker Hero");
	    score.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //Setting panel for entire frame 
	    JPanel contentPane = new JPanel();
	    contentPane.setOpaque(true);
	    contentPane.setBackground(Color.WHITE);	//White background color
	    contentPane.setLayout(null);	//Allows coordinate placing of objects
	    
	    //Title
	    lblTitle = new JLabel("High Scores");
	    lblTitle.setSize(210, 40);
        lblTitle.setLocation(320, 20);
        lblTitle.setFont(new Font("Elephant",Font.PLAIN,30));
        
        //reading values from the high scores text file
        //-----------------------------------------------------------------------------------------
        //getting the size (amount of lines within) the text file
		try {
			readFile = new BufferedReader (new FileReader ("HighScores.txt"));	//opens file
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			while ((readFile.readLine()) != null) //checks each line to read
			{
				intSize++;
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			readFile = new BufferedReader (new FileReader ("HighScores.txt"));
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//PLACING VALUES FROM THE TEXT FILE INTO THEIR RESPECTIVE VECTORS
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
				vctrNames.add((String) strTokenComma.nextElement());	//names vector
				vctrScores.add(Integer.parseInt((String) strTokenComma.nextElement()));	//scores vector
			 } 
			 
		}
        
		//Sorting values in text file
		QuickSort(0, intSize-1);
        
		
        
		//placing in the top 5 scores
		//first name
		lblFirstN = new JLabel();
		lblFirstN.setSize(210, 30);
        lblFirstN.setLocation(70, 100);
        lblFirstN.setFont(new Font("Elephant",Font.PLAIN,20));
        lblFirstN.setText(vctrNames.get(0));
        //first score
        lblFirstS = new JLabel();
		lblFirstS.setSize(210, 30);
        lblFirstS.setLocation(550, 100);
        lblFirstS.setFont(new Font("Elephant",Font.PLAIN,20));
        lblFirstS.setText("Score: " + (Integer.toString(vctrScores.get(0))));
        //second name
        lblSecondN = new JLabel();
		lblSecondN.setSize(210, 30);
        lblSecondN.setLocation(70, 150);
        lblSecondN.setFont(new Font("Elephant",Font.PLAIN,20));
        lblSecondN.setText(vctrNames.get(1));
        //second score
        lblSecondS = new JLabel();
		lblSecondS.setSize(210, 30);
        lblSecondS.setLocation(550, 150);
        lblSecondS.setFont(new Font("Elephant",Font.PLAIN,20));
        lblSecondS.setText("Score: " + (Integer.toString(vctrScores.get(1))));
        //third name
        lblThirdN = new JLabel();
		lblThirdN.setSize(210, 30);
        lblThirdN.setLocation(70, 200);
        lblThirdN.setFont(new Font("Elephant",Font.PLAIN,20));
        lblThirdN.setText(vctrNames.get(2));
        //third score
        lblThirdS = new JLabel();
		lblThirdS.setSize(210, 30);
        lblThirdS.setLocation(550, 200);
        lblThirdS.setFont(new Font("Elephant",Font.PLAIN,20));
        lblThirdS.setText("Score: " + (Integer.toString(vctrScores.get(2))));
        //fourth name
        lblFourthN = new JLabel();
		lblFourthN.setSize(210, 30);
        lblFourthN.setLocation(70, 250);
        lblFourthN.setFont(new Font("Elephant",Font.PLAIN,20));
        lblFourthN.setText(vctrNames.get(3));
        //fourth score
        lblFourthS = new JLabel();
		lblFourthS.setSize(210, 30);
        lblFourthS.setLocation(550, 250);
        lblFourthS.setFont(new Font("Elephant",Font.PLAIN,20));
        lblFourthS.setText("Score: " + (Integer.toString(vctrScores.get(3))));
        //fifth name
        lblFifthN = new JLabel();
		lblFifthN.setSize(210, 30);
        lblFifthN.setLocation(70, 300);
        lblFifthN.setFont(new Font("Elephant",Font.PLAIN,20));
        lblFifthN.setText(vctrNames.get(4));
        //fifth score
        lblFifthS = new JLabel();
		lblFifthS.setSize(210, 30);
        lblFifthS.setLocation(550, 300);
        lblFifthS.setFont(new Font("Elephant",Font.PLAIN,20));
        lblFifthS.setText("Score: " + (Integer.toString(vctrScores.get(4))));
        
        //Search Label
        lblSearch = new JLabel("Search for a name: ");
        lblSearch.setSize(210,30);
        lblSearch.setLocation(70, 450);
        lblSearch.setFont(new Font("Elephant",Font.PLAIN,20));

        //Search input field
        txtSearch = new JTextField();
        txtSearch.setSize(120,30);
        txtSearch.setLocation(260,450);
        
        //search button
        btnSearch = new JButton("Search");
        btnSearch.setSize(130,29);
        btnSearch.setLocation(380,450);
        btnSearch.setFont(new Font("Elephant",Font.PLAIN,20));
        
        //search action listener
        ButtonHandler2 onClick2 = new ButtonHandler2();
        btnSearch.addActionListener(onClick2);
	    
        

        
        
        
        
        
        
        
	    
	    
	    
	    
	    //Menu Button
        btnMenu = new JButton("Back to Menu");
        btnMenu.setSize(180,50);
        btnMenu.setLocation(595,505);
        btnMenu.setFont(new Font("Elephant",Font.PLAIN,20));
        ButtonHandler onClick = new ButtonHandler();
        btnMenu.addActionListener(onClick);
        if (Output.blnOpened == true)
		{
			btnMenu.setText("Exit");
		}
	    
        
        //Adding items to content pane for output
        contentPane.add(lblTitle);
        contentPane.add(btnMenu);
        contentPane.add(lblFirstN);
        contentPane.add(lblFirstS);
        contentPane.add(lblSecondN);
        contentPane.add(lblSecondS);
        contentPane.add(lblThirdN);
        contentPane.add(lblThirdS);
        contentPane.add(lblFourthN);
        contentPane.add(lblFourthS);
        contentPane.add(lblFifthN);
        contentPane.add(lblFifthS);
        contentPane.add(lblSearch);
        contentPane.add(txtSearch);
        contentPane.add(btnSearch);
        
        
	    
	    
        
        
	    //Placing content pane and enabling frame to be visible
        score.setContentPane(contentPane);
        score.setSize(800, 600);
        score.setLocationByPlatform(true);
        score.setVisible(true);
        //starting the window at middle of the screen
	    score.setLocationRelativeTo(null);
	}
	
	
	
	//QUICKSORT
	public static void QuickSort(int intLow, int intHigh)
	{
		if (vctrScores.size() == 0)
		{
			//blank
		}
		else if( 0  >= vctrScores.size() - 1)
		{
			//blank if statements
		}
		else
		{
			int intPivot = (int)vctrScores.get(intLow + (intHigh - intLow) / 2); //Gets the pivot out (AKA the k value)
			int l = intLow;
			int H = intHigh;
			
			while (l <= H)
			{
				while ((int)vctrScores.get(l) > intPivot)//All the numbers less than it	
				{
					l++;
				}
				while ((int)vctrScores.get(H) < intPivot) //All the numbers greater than it 
				{
					H--;
				}
				if (l <= H) //first partition
				{
					
					intTempScore = vctrScores.get(l); //Switching the values
					strTempName = vctrNames.get(l);
					vctrScores.set(l, vctrScores.get(H));
					vctrNames.set(l, vctrNames.get(H));
					vctrScores.set(H, intTempScore);
					vctrNames.set(H, strTempName);
					l++;
					H--;
				}
			}
			if (intLow < H) //Same thing it done with the smaller sublists (left and right size values of k)
			{
				QuickSort(intLow, H);
			}
			if (intHigh > l)
			{
				QuickSort(l, intHigh);
			}
			blnCheck = true;
		}
		
		
		if (blnCheck == true)
		{
			blnCheck = false;
					
		}
		
		
		
		
	
	}
	private static class ButtonHandler implements ActionListener	//when button is clicked,the game is ended 
	{
		public void actionPerformed(ActionEvent e)
		{
			//following code checks if the game has been played, if not and the user accesses the high scores, it will send the user back to the menu with the click of this button
			if (Output.blnOpened == false)
			{
				score.dispose();
				Output.Main();
			}
		
			
			//if the game has been started, exits the application
			if (Output.blnOpened == true)
			{
				System.exit(0);
			}
		}
	}
	
	private static class ButtonHandler2 implements ActionListener	//search button for a value in the text file of high scores
	{
		public void actionPerformed(ActionEvent e)
		{
			strSearch = txtSearch.getText();	//gets search input
			
			if (vctrNames.contains(strSearch))	//checks if the name is inside the text file or vector
			{
				//outputs position and name of the player searched
				intPosition = vctrNames.indexOf(strSearch);
				JOptionPane.showMessageDialog(null, "Player: " + strSearch + " was found and has a rank of " + (intPosition+1), "Search Found",JOptionPane.INFORMATION_MESSAGE); 
			}
			else 	//Output if there is no player with input name
			{
				
				JOptionPane.showMessageDialog(null, "There was no player found with this name", "Search not Found",JOptionPane.INFORMATION_MESSAGE); 
			}
		}
	}
}
