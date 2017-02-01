import java.awt.Color;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Output 
{
	static JFrame frame;
	public static boolean blnOpened = false;
	static JFrame instructions;
	//static JFrame game;

	static void Main()	//initial startup menu
	{
		//Making frame
		frame = new JFrame("Clicker Hero");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    
	    //Setting panel for entire frame 
	    JPanel contentPane = new JPanel();
	    contentPane.setOpaque(true);
	    contentPane.setBackground(Color.WHITE);	//White background color
	    contentPane.setLayout(null);	//Allows coordinate placing of objects
	    
	    
	    //Title label
        JLabel label1 = new JLabel("Welcome to Clicker Hero!", JLabel.CENTER);
        label1.setSize(500, 300);
        label1.setLocation(150, 50);
        label1.setFont(new Font("Serif",Font.BOLD,30));
        label1.setForeground(Color.RED);
        
        //Play game button
        JButton play = new JButton("Play Game");
        play.setFont(new Font("Times New Roman",Font.BOLD,15));
        play.setSize(170, 30);
        play.setLocation(315, 250);
        
        //play.setOpaque(false);
        //play.setContentAreaFilled(false);
        //play.setBorderPainted(false);
        
        //Instructions
        JButton instructions = new JButton("Instructions");
        instructions.setSize(170, 30);
        instructions.setLocation(315, 290);
        instructions.setFont(new Font("Times New Roman",Font.BOLD,15));
        
        //High score
        JButton scores = new JButton("High Scores");
        scores.setSize(170, 30);
        scores.setLocation(315, 330);
        scores.setFont(new Font("Times New Roman",Font.BOLD,15));
        
        //Exit
        JButton exit = new JButton("Exit");
        exit.setSize(170, 30);
        exit.setLocation(315, 370);
        exit.setFont(new Font("Times New Roman",Font.BOLD,15));
        
        
        //Adding things to frame or content pane
        contentPane.add(label1);
        contentPane.add(play);
        contentPane.add(instructions);
        contentPane.add(scores);
        contentPane.add(exit);
        
        //Button Clicks
        ButtonHandler onClick = new ButtonHandler();	//play
        play.addActionListener(onClick);
        
        ButtonHandler2 onClick2 = new ButtonHandler2();	//instructions
        instructions.addActionListener(onClick2);
        
        
        
        ButtonHandler4 onClick4 = new ButtonHandler4();	//scores
        scores.addActionListener(onClick4);
        
        ButtonHandler5 onClick5 = new ButtonHandler5();	//exit
        exit.addActionListener(onClick5);
        
        
        
        
        
        //Placing content pane and enabling frame to be visible
        frame.setContentPane(contentPane);
        frame.setSize(800, 600);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
      //starting the window at middle of the screen
	    frame.setLocationRelativeTo(null);
        
        
        
        
	}
	
	private static class ButtonHandler implements ActionListener	//plays the game
	{
		public void actionPerformed(ActionEvent e)
		{
			//confirms that game has been opened
			blnOpened = true;
			frame.dispose();	//gets rid of current window
			Game.GameGUI();	//opens game window
		}
	}
	
	private static class ButtonHandler2 implements ActionListener	//Opens instructions window when clicked
	{
		public void actionPerformed(ActionEvent e)
		{
			frame.dispose();
			Instructions();
			//Instructions();
		}
	}
	
	private static class ButtonHandler5 implements ActionListener	//Exits the game
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------------
	private static void Instructions()	//intructions screen
	{
		//Making frame
		instructions = new JFrame("Clicker Hero");
	    instructions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //starting the window at middle of the screen
	    instructions.setLocationRelativeTo(null);
	    
	    //Setting panel for entire frame 
	    JPanel contentPane = new JPanel();
	    contentPane.setOpaque(true);
	    contentPane.setBackground(Color.WHITE);	//White background color
	    contentPane.setLayout(null);	//Allows coordinate placing of objects
	    
	    //Title
	    JLabel label1 = new JLabel("Instructions", JLabel.CENTER);
        label1.setSize(300, 50);
        label1.setLocation(290, 5);
        label1.setFont(new Font("Showcard Gothic",Font.BOLD,30));
        
        //actual instructions image
        JLabel label2 = new JLabel("image", JLabel.CENTER);
        label2.setSize(900, 600);
        label2.setLocation(0, 0);
        label2.setIcon(new ImageIcon("Instructions.png"));
        
        //instructions text based off of image
        JLabel label3 = new JLabel("image");
        label3.setSize(900, 200);
        label3.setLocation(10, 550);
        label3.setFont(new Font("Elephant",Font.BOLD,15));
        label3.setText("<html>1. This is the boss health bar, click on the boss to reduce it<br>2.This is the time left in the game, beat the boss before the timer hits 0 or you will lose, the faster you win the higher your score<br>3. This is you, evolve for a cooler version<br>4. This is the boss, click on him to defeat him<br>5. This is the Pause button, press it if you need a break<br>6. These are the shop options, read the descriptions on them<br>7. This is your score, you spend this to buy upgrades to your character<br>    Note: Your high score revolves around your score, so use your points wisely or you won't get a good score<br>8. These items show your damage dealt, damage per click, critical hit chance, and your score multiplier<html>");
        
        //Final label - overall instructions
        JLabel label4 = new JLabel("");
        label4.setSize(900, 100);
        label4.setLocation(10, 750);
        label4.setFont(new Font("Elephant",Font.BOLD,15));
        label4.setText("<html>Quick instructions<br>Click the boss to deal damage, defeat him before the time runs out!<br>You can purchase items from the shop to the right<br>Beware, buying items uses your score, so you can't get a good highscore!</html>");
        
        //Button to go back to menu
        JButton menu = new JButton("Go Back to Menu");
        menu.setSize(170, 100);
        menu.setLocation(700, 750);
        menu.setFont(new Font("Times New Roman",Font.BOLD,15));
        
        //Button Clicks
        ButtonHandler3 onClick3 = new ButtonHandler3();
        menu.addActionListener(onClick3);
        
        
        
      //Adding things to frame or content pane
        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(label1);
        contentPane.add(label4);
        contentPane.add(menu);
        
	    //setting frame size and location
	    instructions.setContentPane(contentPane);
        instructions.setSize(920, 900);
        instructions.setLocationByPlatform(true);
        instructions.setVisible(true);
        instructions.setLocationRelativeTo(null);
        
        
	}
	
	private static class ButtonHandler3 implements ActionListener	//goes back to menu
	{
		public void actionPerformed(ActionEvent e)
		{
			instructions.dispose();
			
			Main();
		}
	}
	
	private static class ButtonHandler4 implements ActionListener	//enters the high scores
	{
		public void actionPerformed(ActionEvent e)
		{
			frame.dispose();
			HighScores.Scores();
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)	//Allows program to play
	{
		
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				Main();
			}
		});
	}
}
