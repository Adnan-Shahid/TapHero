import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
public class Game extends JFrame
{
	//VARIABLE DECLARATION
	static JFrame game;
	JPanel panel;
	static ImageIcon iconBackground;
	static JLabel lblBackground;
	static JLabel lblTest;
	static JLabel lblPlayer;
	static JLabel lblBossHealth1;
	static JLabel lblBossHealth2;
	static JLabel lblBossHealth3;
	static JLabel lblBossHealth4;
	static JLabel lblBossHealth5;
	static JLabel lblTime;
	static JLabel showscore;
	static JLabel showdmg;
	static JLabel showcrit;
	static JLabel showscoremult;
	static JLabel showdpc;
	
	//Shop purchases
	static JLabel lblMult;
	static JLabel lblCrit;
	static JLabel lblScoreMult;
	static JLabel lblEvolution;
	static JButton btnMult;
	static JButton btnCrit;
	static JButton btnScoreMult;
	static JButton btnEvolution;
	public static int intEvoPrice = 3000;
	public static int intMultPrice = 500;
	public static int intCritPrice = 500;
	public static int intScorePrice = 1000;
	public static int[] intPurchases = new int[4];
	
	
	public static boolean blnBossDeath1 = false;
	public static boolean blnBossDeath2 = false;
	public static boolean blnBossDeath3 = false;
	public static boolean blnBossDeath4 = false;
	public static boolean blnBossDeath5 = false;

	
	

	
	static JLabel[] lblHit = new JLabel[10000];

	
	static JLabel[] lblDamage;
	
	static JButton boss1;
	static JButton btnShop;
	
	
	public static int intHit = 0;
	
	static Timer tmrTimer1;
	public static boolean blnDeath = false;
	static Timer tmrDeath;
	static Timer tmrBossDeath1;
	static Timer tmrBossDeath2;
	static Timer tmrBossDeath3;
	static Timer tmrBossDeath4;
	static Timer tmrBossDeath5;
	public static int intBossDeath1 = 0;
	public static int intBossDeath2 = 0;
	public static int intBossDeath3 = 0;
	public static int intBossDeath4 = 0;
	public static int intBossDeath5 = 0;
	public static int intDeath = 0;
	static Timer tmrHit;
	
	public static int[] Counter = new int[10000];
	public static double dblDmg = 7;	//was previously 5
	public static int intScoreMult = 1;
	public static double dblTempDmg;
	public static double dblTempMult;
	public static double dblMult = 0;
	public static double dblCrit = 0;
	public static int intChance;
	public static int intEvolution = 1;
	public static double dblBossHealth = 670;
	public static double dblBossHealth2 = 670;
	public static double dblBossHealth3 = 670;
	public static double dblBossHealth4 = 670;
	public static double dblBossHealth5 = 670;
	public static int intLevel = 1;
	public static int intTime = 30;	//30
	public static double dblHealthSize = 670;
	public static double dblx = 670;
	public static int intScore = 0;
	public static boolean blnShop = false;
	//creating player here
	public static Player p1 = new Player(dblDmg, intEvolution, dblCrit);

	static JLayeredPane contentPaneG;
	
	public static void GameGUI()
	{
		
		
				
		//making the game frame
		game = new JFrame("Clicker Hero");
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //sets frame at middle of screen
	    game.setLocationRelativeTo(null);
	    
	    //placing values in for amount of purchases = 1
	    for (int intCounterA = 0; intCounterA < 4; intCounterA++)
	    {
	    	intPurchases[intCounterA] = 1;
	    }
	    
	    //pause button
	    btnShop = new JButton("Pause");
        btnShop.setSize(150, 50);
        btnShop.setLocation(870, 20);
        btnShop.setFont(new Font("Algerian",Font.PLAIN,30));
        btnShop.setForeground(Color.WHITE);
        btnShop.setBackground(Color.BLACK);
        btnShop.setFocusPainted(false);
        
        //Shop Purchases
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        //label evolution
        lblEvolution = new JLabel("<html>Evolution:" + (intEvoPrice*intPurchases[0]) + " Score Points<br>Increase your damage per click by a lot!</html>", JLabel.CENTER);
        lblEvolution.setSize(300, 30);
        lblEvolution.setLocation(785, 113);
        lblEvolution.setForeground(Color.BLACK);
        lblEvolution.setFont(new Font("Algerian",Font.PLAIN,12));
        //button creator
        btnEvolution = new JButton("+");
        btnEvolution.setFont(new Font("Algerian",Font.PLAIN,15));
        btnEvolution.setSize(50,50);
        btnEvolution.setLocation(1015,80);
        btnEvolution.setBackground(Color.WHITE);
        btnEvolution.setFocusPainted(false);
        //actionhandler
        ButtonHandler4 onClick4 = new ButtonHandler4();
        btnEvolution.addActionListener(onClick4);
        
        
        //Damage Counter Increase with purchase of this
        lblMult = new JLabel("<html>Increase your damage per click<br>Cost: 500 Score Points<html>");
        lblMult.setSize(300, 30);
        lblMult.setLocation(805, 180);
        lblMult.setForeground(Color.BLACK);
        lblMult.setFont(new Font("Algerian",Font.PLAIN,12));
        //button creation
        btnMult = new JButton("+");
        btnMult.setFont(new Font("Algerian",Font.PLAIN,15));
        btnMult.setSize(50,50);
        btnMult.setLocation(1015,180);
        btnMult.setBackground(Color.WHITE);
        btnMult.setFocusPainted(false);
        //button actionhandler
        ButtonHandler3 onClick3 = new ButtonHandler3();
        btnMult.addActionListener(onClick3);
                
        //Critical Hit Chance
        lblCrit = new JLabel("<html>Increase critical hit chance<br>Cost: 500 Score Points<html>");
        lblCrit.setSize(300, 30);
        lblCrit.setLocation(805, 250);
        lblCrit.setForeground(Color.BLACK);
        lblCrit.setFont(new Font("Algerian",Font.PLAIN,12));
        
        //button creation
        btnCrit = new JButton("+");
        btnCrit.setFont(new Font("Algerian",Font.PLAIN,15));
        btnCrit.setSize(50,50);
        btnCrit.setLocation(1015,250);
        btnCrit.setBackground(Color.WHITE);
        btnCrit.setFocusPainted(false);
        
        //button actionhandler
        ButtonHandler5 onClick5 = new ButtonHandler5();
        btnCrit.addActionListener(onClick5);
        
        
        //Score Multiplier
        lblScoreMult = new JLabel("<html>Increase score multiplier <br>Cost: 1000 Score Points<html>");
        lblScoreMult.setSize(300, 30);
        lblScoreMult.setLocation(805, 320);
        lblScoreMult.setForeground(Color.BLACK);
        lblScoreMult.setFont(new Font("Algerian",Font.PLAIN,12));
        
        //button creation
        btnScoreMult = new JButton("+");
        btnScoreMult.setFont(new Font("Algerian",Font.PLAIN,15));
        btnScoreMult.setSize(50,50);
        btnScoreMult.setLocation(1015,320);
        btnScoreMult.setBackground(Color.WHITE);
        btnScoreMult.setFocusPainted(false);
        
        //button actionhandler
        ButtonHandler6 onClick6 = new ButtonHandler6();
        btnScoreMult.addActionListener(onClick6);
        
        //ENDSHOP
        //--------------------------------------------------------------------------------------------------
        
        //Creating and outputting output labels
        //this set of labels shows information that would be helpful to the user
        showscore = new JLabel("Score: " + intScore);
        showscore.setSize(110, 40);
        showscore.setLocation(890, 380);
        //showscore.setOpaque(true);
        showscore.setFont(new Font("Impact",Font.PLAIN,20));
        
        showdmg = new JLabel("Damage dealt: ");
        showdmg.setSize(200,30);
        showdmg.setLocation(805,410);
        //showdmg.setOpaque(true);
        showdmg.setFont(new Font("Impact",Font.PLAIN,15));
        
        showdpc = new JLabel("Damage per click: " + dblDmg);
        showdpc.setSize(200,30);
        showdpc.setLocation(805, 440);
        showdpc.setFont(new Font("Impact",Font.PLAIN,15));
        
        showcrit = new JLabel("Crit Bonus: " + dblCrit*10 + "%");
        showcrit.setSize(200,30);
        showcrit.setLocation(805, 470);
        showcrit.setFont(new Font("Impact",Font.PLAIN,15));
        
        showscoremult = new JLabel("Score Multiplier: x" + intScoreMult);
        showscoremult.setSize(200,30);
        showscoremult.setLocation(805, 500);
        showscoremult.setFont(new Font("Impact",Font.PLAIN,15));
        
        
        
        
        //100,30
        //900
	    
	    //sizing a label array
	    lblDamage = new JLabel[10000];
	    
	    //Timer for entire game
	    lblTime = new JLabel("" + intTime, JLabel.CENTER);
	    lblTime.setSize(70, 70);
        lblTime.setLocation(380, 50);
        lblTime.setForeground(Color.WHITE);
        
        lblTime.setFont(new Font("Algerian",Font.PLAIN,30));
	    
	    //initializing all timers
	    tmrTimer1 = new Timer();
	    tmrDeath = new Timer();
	    tmrBossDeath1 = new Timer();
	    tmrBossDeath2 = new Timer();
	    tmrBossDeath3 = new Timer();
	    tmrBossDeath4 = new Timer();
	    tmrBossDeath5 = new Timer();
	    tmrHit = new Timer();
	    
	    //placing zero values into a counter array
	    for (int intCounter = 0; intCounter < 9999; intCounter++)
	    {
	    	Counter[intCounter] = 0;
	    }
	    
	    //enabling the in game timer to run throughout the game
	    tmrTimer1.scheduleAtFixedRate(new TimerTask()
	    {
	    	public void run()
	    	{
	    		if (blnShop == false)
	    		{
	    			intTime--;	//output for time left
		    		lblTime.setText(("" + intTime));
		    		
		    		if (intTime == 0)	//stops time if game is over	- death animation 
		    		{
		    			lblPlayer.setIcon(new ImageIcon("explosion.gif"));
		    			Death();
		    			tmrTimer1.cancel();
		    			p1.setDmg(0);
		    			
		    			
		    			
		    		}
	    		}
	    	}
	    },0,1000);
	    
	    
	    
	    
	    
	    
	    
	    //Setting panel for entire frame 
	    contentPaneG = new JLayeredPane();
	    contentPaneG.setOpaque(true);
	    contentPaneG.setBackground(Color.WHITE);	//White background color
	    contentPaneG.setLayout(null);	//Allows coordinate placing of objects
	    
	    //Player Creation - the image
	    lblPlayer = new JLabel();
	    lblPlayer.setSize(300, 300);
        lblPlayer.setLocation(60, 357);
        lblPlayer.setIcon(new ImageIcon("play1.gif"));
        
        //test label
        lblTest = new JLabel("" + intScore);
        
        
        lblTest.setSize(300, 200);
        lblTest.setLocation(801, 457);
        lblTest.setOpaque(true);
        
	    
	    

       
        //boss
	    boss1 = new JButton();
        boss1.setSize(150, 100);
        boss1.setLocation(550, 467);
        //making button transparent and placing image on the button
        boss1.setIcon(new ImageIcon("crab.gif"));
        boss1.setRolloverIcon(new ImageIcon("crab.gif"));
        boss1.setOpaque(false);
        boss1.setContentAreaFilled(false);
        boss1.setBorder(null);
        boss1.setFocusPainted(false);
        
        //test
        lblBossHealth1 = new JLabel("");
        lblBossHealth1.setSize((int) dblHealthSize, 20);
        lblBossHealth1.setLocation(60, 30);
        lblBossHealth1.setOpaque(true);
        lblBossHealth1.setBackground(Color.GREEN);
        
        
        //setting a background
        lblBackground = new JLabel();
        lblBackground.setSize(800, 600);
        lblBackground.setLocation(0, 0);
        lblBackground.setIcon(new ImageIcon("hellarena.jpg"));
        
        
        //test
        /*lblTest = new JLabel("" + dblDmg);
        lblTest.setSize(300, 300);
        lblTest.setLocation(115, 100);
        lblTest.setOpaque(true);
        lblTest.setBackground(Color.YELLOW);*/
        
        
        //Button Clicks
        ButtonHandler onClick = new ButtonHandler();
        boss1.addActionListener(onClick);
        
        ButtonHandler2 onClick2 = new ButtonHandler2();
        btnShop.addActionListener(onClick2);
        

        
       
       //adding things to content pane 
        contentPaneG.add(btnShop);
        contentPaneG.add(lblTime);
        contentPaneG.add(boss1);
        contentPaneG.add(lblPlayer);
        contentPaneG.add(lblBossHealth1);
        //contentPaneG.add(lblTest);
        contentPaneG.add(lblEvolution);
        contentPaneG.add(btnEvolution);
        contentPaneG.add(lblMult);
        contentPaneG.add(btnMult);
        contentPaneG.add(lblCrit);
        contentPaneG.add(btnCrit);
        contentPaneG.add(lblScoreMult);
        contentPaneG.add(btnScoreMult);
        contentPaneG.add(showscore);
        contentPaneG.add(showdmg);
        contentPaneG.add(showdpc);
        contentPaneG.add(showcrit);
        contentPaneG.add(showscoremult);
        contentPaneG.add(lblBackground);
        
       
        
	    
        //creating the game frame
	    game.setContentPane(contentPaneG);
	    game.setSize(1100, 638);
	    game.setLocationByPlatform(true);
	    game.setVisible(true);
	    game.setLocationRelativeTo(null);
	}
	
	
	public static void Death()	//Death Animation
	{
		tmrDeath.scheduleAtFixedRate(new TimerTask()
	    {
	    	public void run()
	    	{
	    		lblPlayer.setIcon(new ImageIcon("explosion.gif"));
	    		intDeath++;
	    		
	    		if (intDeath == 2)	//stops time if game is over
	    		{
	    			lblPlayer.setIcon(null);
	    			tmrDeath.cancel();
	    			game.dispose();
	    			p1.setDmg(0);
	    			GameEnd.End();	//enters an end game menu
	    			
	    			
	    		}
	    	
	    	}
	    },0,1000);
	}
	//TEST CODE
	/*public static void Hit()	//creates an image for a small amount of time showing damage
	{
		
		
		tmrHit.scheduleAtFixedRate(new TimerTask()
	    {
	    	public void run()
	    	{
	    		Counter[intHit]+= 1;
	    		lblHit[intHit].setLocation(550, (450 - Counter[intHit]));
	    		
	    		if (Counter[intHit] >= 20)	//stops time if game is over
	    		{
	    			Counter[intHit] = 0;
	    			contentPaneG.remove(lblHit[intHit]);

	    			
	    			
	    		}
	    	
	    	}
	    },0,100);
		
		
		
		
		
		
		 
	}*/
	
	private static class ButtonHandler implements ActionListener	//when player clicks on the boss decreases it's health
	{
		public void actionPerformed(ActionEvent e)
		{
			
			//lblTest.setText("Damage" + p1.getDmg() + "Boss1:" + dblBossHealth + " " + dblBossHealth2);
			//Counter = 0;
			/*lblHit[intHit] = new JLabel("");
			lblHit[intHit].setSize(30,30);
			lblHit[intHit].setLocation(550, 450);
			lblHit[intHit].setOpaque(true);
			lblHit[intHit].setBackground(Color.BLACK);
			contentPaneG.add(lblHit[intHit]);
			contentPaneG.moveToFront(lblHit[intHit]);

			Hit();*/
			
			//-----------------------------------------------------------------------------------
			//Above is test code
			//activates crit method - fixes a bug in code
			Crit();
			
			
			//EXPLANATION FOR FOLLOWING DAMAGE CODE
			//upon click, if the variable dblBossHealth =0 (the first health bar - green), activates a boss death method
			//with each click, it checks if it was a critical hit, with a critical hit, increases all damage dealt by 2
			//upon click does a damage calculation using player damage value, player evolution value and boss health bar
			//With each click it changes a label to show damage done to the boss
			//When damage is done the label size decreases
			
			if (intLevel == 1)
			{
				if(dblBossHealth < 0)	//when boss dies in level 1
				{
					if (blnBossDeath1 == false)
					{
						intLevel++;
						//increase score
						intScore = intScore + (((intLevel*1000) + intTime*50)*intScoreMult);	
						showscore.setText("Score: " + intScore);
						//enables boss death animation
						blnBossDeath1 = true;
						BossDeath1();
						boss1.setEnabled(false);
					}
				}
				if (Crit() == true)	//adds crit damage
				{
					dblBossHealth = dblBossHealth-((p1.getDmg())*(p1.getEvolution()*2));
					lblBossHealth1.setText((""));
					lblBossHealth1.setSize((int) dblBossHealth, 20);
					showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()*2));
				}
				else if (Crit() == false)	//damaging the boss with each click - no crit
				{
					dblBossHealth = dblBossHealth-((p1.getDmg())*(p1.getEvolution()));
					lblBossHealth1.setText((""));
					lblBossHealth1.setSize((int) dblBossHealth, 20);
					showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()));
				}
				
			}
			else if (intLevel == 2)	//for level 2
			{
				if(dblBossHealth < 0)	//when final boss hp bar is 0
				{
					if (blnBossDeath2 == false)
					{
						//increase score
						intLevel++;
						intScore = intScore + (((intLevel*1000) + intTime*50)*intScoreMult);	
						showscore.setText("Score: " + intScore);
						//enables boss death animation
						blnBossDeath2 = true;
						BossDeath2();
						boss1.setEnabled(false);
					}
				}
				
				//second boss health bar
				if (Crit() == true)	//damaging the boss with each click - with crit
				{
					if (dblBossHealth2 > 0)
					{
						dblBossHealth2 = dblBossHealth2-((p1.getDmg())*(p1.getEvolution()*2));
						lblBossHealth2.setSize((int)(dblBossHealth2), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()*2));
					}
					else if (dblBossHealth2 <= 0)	//damaging boss with crit 
					{
						dblBossHealth = dblBossHealth-((p1.getDmg())*(p1.getEvolution()*2));
						lblBossHealth1.setSize((int) (dblBossHealth), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()*2));
					}
				}
				else if (Crit() == false)
				{
					//second boss health bar
					if (dblBossHealth2 > 0)
					{
						dblBossHealth2 = dblBossHealth2-((p1.getDmg())*(p1.getEvolution()));
						lblBossHealth2.setSize((int)(dblBossHealth2), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()));
					}
					else if (dblBossHealth2 <= 0)
					{
						dblBossHealth = dblBossHealth-((p1.getDmg())*(p1.getEvolution()));
						lblBossHealth1.setSize((int) (dblBossHealth), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()));
					}
				}
	
			}
			
			else if (intLevel == 3)	//for level 3
			{
				if(dblBossHealth < 0)	//when boss dies 
				{
					if (blnBossDeath3 == false)
					{
						//increase score
						intLevel++;
						intScore = intScore + (((intLevel*1000) + intTime*50)*intScoreMult);	
						showscore.setText("Score: " + intScore);
						//enables boss death animation
						blnBossDeath3 = true;
						BossDeath3();
						boss1.setEnabled(false);
					}
				}
				
				//first boss health bar
				if (Crit() == true)	//damaging the boss with each click - with crit
				{
					if (dblBossHealth3 > 0)
					{
						dblBossHealth3 = dblBossHealth3-((p1.getDmg())*(p1.getEvolution()*2));
						lblBossHealth3.setSize((int)(dblBossHealth3), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()*2));
					}
					else if (dblBossHealth3 <= 0 && dblBossHealth2 >= 0)	//damaging boss with crit 
					{
						dblBossHealth2 = dblBossHealth2-((p1.getDmg())*(p1.getEvolution()*2));
						lblBossHealth2.setSize((int) (dblBossHealth2), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()*2));
					}
					else if (dblBossHealth2 <= 0)
					{
						dblBossHealth = dblBossHealth-((p1.getDmg())*(p1.getEvolution()*2));
						lblBossHealth1.setSize((int) (dblBossHealth), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()*2));
					}
				}
				else if (Crit() == false)
				{
					if (dblBossHealth3 > 0)
					{
						dblBossHealth3 = dblBossHealth3-((p1.getDmg())*(p1.getEvolution()));
						lblBossHealth3.setSize((int)(dblBossHealth3), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()));
					}
					else if (dblBossHealth3 <= 0 && dblBossHealth2 >= 0)	
					{
						dblBossHealth2 = dblBossHealth2-((p1.getDmg())*(p1.getEvolution()));
						lblBossHealth2.setSize((int) (dblBossHealth2), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()));
					}
					else if (dblBossHealth2 <= 0)
					{
						dblBossHealth = dblBossHealth-((p1.getDmg())*(p1.getEvolution()));
						lblBossHealth1.setSize((int) (dblBossHealth), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()));
					}
				}
	
			}
			
			else if (intLevel == 4)	//for level 4
			{
				if(dblBossHealth < 0)	//when boss dies 
				{
					if (blnBossDeath4 == false)
					{
						//increase score
						intLevel++;
						intScore = intScore + (((intLevel*1000) + intTime*50)*intScoreMult);	
						showscore.setText("Score: " + intScore);
						//enables boss death animation
						blnBossDeath4 = true;
						BossDeath4();
						boss1.setEnabled(false);
					}
				}
				
				//first boss health bar
				if (Crit() == true)	//damaging the boss with each click - with crit
				{
					if (dblBossHealth4 > 0)
					{
						dblBossHealth4 = dblBossHealth4-(((p1.getDmg())*(p1.getEvolution()*2))/2);
						lblBossHealth4.setSize((int)(dblBossHealth4), 20);
						showdmg.setText("Damage dealt: " + ((p1.getDmg())*(p1.getEvolution()*2)/2));
					}
					else if (dblBossHealth4 <= 0 && dblBossHealth3 >= 0)	//damaging boss with crit 
					{
						dblBossHealth3 = dblBossHealth3-(((p1.getDmg())*(p1.getEvolution()*2))/2);
						lblBossHealth3.setSize((int) (dblBossHealth3), 20);
						showdmg.setText("Damage dealt: " + ((p1.getDmg())*(p1.getEvolution()*2))/2);
					}
					else if (dblBossHealth3 <= 0 && dblBossHealth2 >= 0)
					{
						dblBossHealth2 = dblBossHealth2-((p1.getDmg())*(p1.getEvolution()*2));
						lblBossHealth2.setSize((int) (dblBossHealth2), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()*2));
					}
					else if (dblBossHealth2 <= 0)
					{
						dblBossHealth = dblBossHealth-((p1.getDmg())*(p1.getEvolution()*2));
						lblBossHealth1.setSize((int) (dblBossHealth), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()*2));
					}
				}
				else if (Crit() == false)
				{
					if (dblBossHealth4 > 0)
					{
						dblBossHealth4 = dblBossHealth4-(((p1.getDmg())*(p1.getEvolution()))/2);
						lblBossHealth4.setSize((int)(dblBossHealth4), 20);
						showdmg.setText("Damage dealt: " + ((p1.getDmg())*(p1.getEvolution())/2));
					}
					else if (dblBossHealth4 <= 0 && dblBossHealth3 >= 0)	//damaging boss with crit 
					{
						dblBossHealth3 = dblBossHealth3-(((p1.getDmg())*(p1.getEvolution()))/2);
						lblBossHealth3.setSize((int) (dblBossHealth3), 20);
						showdmg.setText("Damage dealt: " + ((p1.getDmg())*(p1.getEvolution()))/2);
					}
					else if (dblBossHealth3 <= 0 && dblBossHealth2 >= 0)
					{
						dblBossHealth2 = dblBossHealth2-((p1.getDmg())*(p1.getEvolution()));
						lblBossHealth2.setSize((int) (dblBossHealth2), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()));
					}
					else if (dblBossHealth2 <= 0)
					{
						dblBossHealth = dblBossHealth-((p1.getDmg())*(p1.getEvolution()));
						lblBossHealth1.setSize((int) (dblBossHealth), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()));
					}
				}
				
				
	
			}
			
			else if (intLevel == 5)	//for level 5
			{
				if(dblBossHealth < 0)	//when boss dies 
				{
					if (blnBossDeath5 == false)
					{
						//increase score
						intLevel++;
						intScore = intScore + (((intLevel*1000) + intTime*50)*intScoreMult);
						//adding score for finishing the game
						intScore+=10000; 
						showscore.setText("Score: " + intScore);
						//enables boss death animation
						blnBossDeath5 = true;
						BossDeath5();
						boss1.setEnabled(false);
					}
				}
				
				//first boss health bar
				if (Crit() == true)	//damaging the boss with each click - with crit
				{
					if (dblBossHealth5 > 0)
					{
						dblBossHealth5 = dblBossHealth5-(((p1.getDmg())*(p1.getEvolution()*2))/4);
						lblBossHealth5.setSize((int)(dblBossHealth5), 20);
						showdmg.setText("Damage dealt: " + ((p1.getDmg())*(p1.getEvolution()*2)/4));
					}
					else if (dblBossHealth5 <= 0 && dblBossHealth4 >= 0)	//damaging boss with crit 
					{
						dblBossHealth4 = dblBossHealth4-(((p1.getDmg())*(p1.getEvolution()*2))/2);
						lblBossHealth4.setSize((int) (dblBossHealth4), 20);
						showdmg.setText("Damage dealt: " + ((p1.getDmg())*(p1.getEvolution()*2))/2);
					}
					else if (dblBossHealth4 <= 0 && dblBossHealth3 >= 0)
					{
						dblBossHealth3 = dblBossHealth3-(((p1.getDmg())*(p1.getEvolution()*2))/2);
						lblBossHealth3.setSize((int) (dblBossHealth3), 20);
						showdmg.setText("Damage dealt: " + ((p1.getDmg())*(p1.getEvolution()*2))/2);
					}
					else if (dblBossHealth3 <= 0 && dblBossHealth2 >= 0)
					{
						dblBossHealth2 = dblBossHealth2-((p1.getDmg())*(p1.getEvolution()*2));
						lblBossHealth2.setSize((int) (dblBossHealth2), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()*2));
					}
					else if (dblBossHealth2 <= 0)
					{
						dblBossHealth = dblBossHealth-((p1.getDmg())*(p1.getEvolution()*2));
						lblBossHealth1.setSize((int) (dblBossHealth), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()*2));
					}
				}
				else if (Crit() == false)	//damaging boss with each hit no crit
				{
					if (dblBossHealth5 > 0)
					{
						dblBossHealth5 = dblBossHealth5-(((p1.getDmg())*(p1.getEvolution()))/4);
						lblBossHealth5.setSize((int)(dblBossHealth5), 20);
						showdmg.setText("Damage dealt: " + ((p1.getDmg())*(p1.getEvolution())/4));
					}
					else if (dblBossHealth5 <= 0 && dblBossHealth4 >= 0)	
					{
						dblBossHealth4 = dblBossHealth4-(((p1.getDmg())*(p1.getEvolution()))/2);
						lblBossHealth4.setSize((int) (dblBossHealth4), 20);
						showdmg.setText("Damage dealt: " + ((p1.getDmg())*(p1.getEvolution()))/2);
					}
					else if (dblBossHealth4 <= 0 && dblBossHealth3 >= 0)
					{
						dblBossHealth3 = dblBossHealth3-(((p1.getDmg())*(p1.getEvolution()))/2);
						lblBossHealth3.setSize((int) (dblBossHealth3), 20);
						showdmg.setText("Damage dealt: " + ((p1.getDmg())*(p1.getEvolution()))/2);
					}
					else if (dblBossHealth3 <= 0 && dblBossHealth2 >= 0)
					{
						dblBossHealth2 = dblBossHealth2-((p1.getDmg())*(p1.getEvolution()));
						lblBossHealth2.setSize((int) (dblBossHealth2), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()));
					}
					else if (dblBossHealth2 <= 0)
					{
						dblBossHealth = dblBossHealth-((p1.getDmg())*(p1.getEvolution()));
						lblBossHealth1.setSize((int) (dblBossHealth), 20);
						showdmg.setText("Damage dealt: " + (p1.getDmg())*(p1.getEvolution()));
					}
				}
				
			}
			
			
			
			
			//lblTest.setVisible(false);
			
			
		}
	}
	

	private static class ButtonHandler2 implements ActionListener	//SHOP
	{
		public void actionPerformed(ActionEvent e)
		{
			if (blnShop == false)	//pauses game
			{
				boss1.setEnabled(false);
				blnShop = true;
				btnShop.setFont(new Font("Algerian",Font.PLAIN,10));
				btnShop.setText("Press again to play");
				//preventing player from attack while game is paused
				dblTempDmg = dblDmg;
				dblDmg = 0;
				dblTempMult = dblMult;
				dblMult = 0;
				//sets the image when pausing, fixes a bug when the boss disappears
				if (intLevel == 2)
				{
					boss1.setIcon(new ImageIcon("frog.gif"));
			        boss1.setRolloverIcon(new ImageIcon("frog.gif"));
				}
				else if (intLevel == 3)
				{
					boss1.setIcon(new ImageIcon("lion.gif"));
			        boss1.setRolloverIcon(new ImageIcon("lion.gif"));
				}
				else if (intLevel == 4)
				{
					boss1.setIcon(new ImageIcon("gloo.gif"));
			        boss1.setRolloverIcon(new ImageIcon("gloo.gif"));
				}
				else if (intLevel == 5)
				{
					boss1.setIcon(new ImageIcon("dragon.gif"));
			        boss1.setRolloverIcon(new ImageIcon("dragon.gif"));
				}
				
			}
			else if (blnShop == true)	//restarts the game
			{
				
				boss1.setEnabled(true);
				blnShop = false;
				btnShop.setFont(new Font("Algerian",Font.PLAIN,30));
				btnShop.setText("Shop");
				dblDmg = dblTempDmg;
				dblMult = dblTempMult;
				
				if (intLevel == 2)
				{
					boss1.setIcon(new ImageIcon("frog.gif"));
			        boss1.setRolloverIcon(new ImageIcon("frog.gif"));
				}
			}
			
		}
	}
	
	private static class ButtonHandler3 implements ActionListener	//Increase damage per click
	{
		public void actionPerformed(ActionEvent e)
		{
			if (intPurchases[1] == 1)
			{
				if (intScore >= (intMultPrice))	//buying a tap counter increaser
				{
					p1.setDmg(p1.getDmg() + 2);
					
					intScore = intScore - (intMultPrice);	//decreasing score for the purchase
					intPurchases[1]++;	//increasing cost
					lblMult.setText("<html>Increase your damage per click<br>Cost:" + (intMultPrice + (intPurchases[1]*100)) + " Score Points<html>");
					showscore.setText("Score: " + intScore);	//setting text
					showdpc.setText("Damage per click: " + p1.getDmg());
					
				}
			}
			else if (intPurchases[1] > 1)
			{
				if (intScore >= (intMultPrice + (intPurchases[1]*100)))	//buying a tap counter increaser
				{
					p1.setDmg(p1.getDmg() + 2);
					
					intScore = intScore - (intMultPrice + (intPurchases[1]*100));
					intPurchases[1]+=2;
					lblMult.setText("<html>Increase your damage per click<br>Cost:" + (intMultPrice + (intPurchases[1]*100)) + " Score Points<html>");
					showscore.setText("Score: " + intScore);
					showdpc.setText("Damage per click: " + p1.getDmg());
					
				}
			}
			
			
		}
	}
	
	private static class ButtonHandler4 implements ActionListener	//when player clicks on the boss decreases it's health
	{
		public void actionPerformed(ActionEvent e)
		{
			if (intScore >= (intEvoPrice*intPurchases[0]))	//buying a tap counter increaser
			{
				if (p1.getEvolution() == 1)
				{
					p1.setEvolution(p1.getEvolution() + 1);	//adding evolution level
					intScore = intScore - (intEvoPrice*intPurchases[0]);
					
					intPurchases[0]++;	//increases cost
					lblEvolution.setText("<html>Evolution:" + (intEvoPrice*intPurchases[0]) + " Score Points<br>Increase your damage per click by a lot!</html>");
					lblPlayer.setSize(300, 300);
			        lblPlayer.setLocation(30, 325);
			        lblPlayer.setIcon(new ImageIcon("office.gif"));	//changes image to show evolution
			        showscore.setText("Score: " + intScore);
				}
				else if (p1.getEvolution() == 2)
				{
					p1.setEvolution(p1.getEvolution() + 1);
					intScore = intScore - (intEvoPrice*intPurchases[0]);
					lblEvolution.setText("<html>Evolution: No Purchases left");
					lblEvolution.setLocation(760, 113);
					intPurchases[0]++;
					lblPlayer.setSize(300, 300);
			        lblPlayer.setLocation(70, 315);
			        lblPlayer.setIcon(new ImageIcon("kungfu.gif"));	//make smaller
			        btnEvolution.setEnabled(false); //cancel the button
			        showscore.setText("Score: " + intScore);
				}
				
			}
		}
	}
	
	private static class ButtonHandler5 implements ActionListener	//Increase critical hit chance
	{
		public void actionPerformed(ActionEvent e)
		{
			if (intScore >= (intCritPrice*intPurchases[2]))
			{
				if (dblCrit < 6)
				{
					dblCrit++;	//increase crit chance
					intScore = intScore - (intCritPrice*intPurchases[2]);	//purchasing using score points
					intPurchases[2]++;	//increase cost
					//output
					lblCrit.setText("<html>Increase critical hit chance<br>Cost: " + intCritPrice*intPurchases[2] + "Score Points<html>");
					showscore.setText("Score: " + intScore);
					showcrit.setText("Crit Bonus: " + dblCrit*10 + "%");
				}
				else if (dblCrit >= 6)	//prevents crit from reaching an impossible percent
				{
					btnCrit.setEnabled(false);
					lblCrit.setText("<html>Increase critical chance:<br>No Purchases Left</html>");
					lblCrit.setLocation(830, 250);
					showscore.setText("Score: " + intScore);
					showcrit.setText("Crit Bonus: " + dblCrit*10 + "%");
				}
			}
			
		}
	}
	
	private static class ButtonHandler6 implements ActionListener	//Increase score multiplier
	{
		public void actionPerformed(ActionEvent e)
		{
			if (intScore >= (intScorePrice*intPurchases[3]))
			{
				intScoreMult++;	//increasing score mult
				intScore = intScore - (intScorePrice*intPurchases[3]);	//decreasing score for purchase
				intPurchases[3]+=2;	//increasing cost
				lblScoreMult.setText("<html>Increase score multiplier <br>Cost: " + intScorePrice*intPurchases[3] + "<html>");
				showscore.setText("Score: " + intScore);
				showscoremult.setText("Score Multiplier:  x" + intScoreMult);
			}
		}
	}
	
	
	public static boolean Crit()	//crit chance checker
	{
		intChance = (int)(Math.random()*(10-dblCrit) + 1);	//has a chance to crit
		
		if (intChance == 2)	//returns true if critical strike and false if not
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	//All of the following BossDeath_ codes are the same, excluding the fifth boss death
	public static void BossDeath1()	//boss 1 death
	{
		boss1.setIcon(new ImageIcon("explosion.gif"));	//changing boss image to show death
        boss1.setRolloverIcon(new ImageIcon("explosion.gif"));
        tmrBossDeath1.scheduleAtFixedRate(new TimerTask()
	    {
	    	public void run()
	    	{
	    		
	    		intBossDeath1++;
	    		
	    		if (intBossDeath1 == 2)	//stops death animation and goes to next level
	    		{
	    			Level2();
	    			tmrBossDeath1.cancel();
	    			
	    			
	    		}
	    	
	    	}
	    },0,1000);
	}
	public static void BossDeath2()	//second boss death
	{
		boss1.setIcon(new ImageIcon("explosion.gif"));
        boss1.setRolloverIcon(new ImageIcon("explosion.gif"));
        tmrBossDeath2.scheduleAtFixedRate(new TimerTask()
	    {
	    	public void run()
	    	{
	    		
	    		intBossDeath2++;
	    		
	    		if (intBossDeath2 == 2)	
	    		{
	    			Level3();
	    			tmrBossDeath2.cancel();
	    			
	    			
	    		}
	    	
	    	}
	    },0,1000);
	}
	
	public static void BossDeath3()	//third
	{
		boss1.setIcon(new ImageIcon("explosion.gif"));
        boss1.setRolloverIcon(new ImageIcon("explosion.gif"));
        tmrBossDeath3.scheduleAtFixedRate(new TimerTask()
	    {
	    	public void run()
	    	{
	    		
	    		intBossDeath3++;
	    		
	    		if (intBossDeath3 == 2)	
	    		{
	    			Level4();
	    			tmrBossDeath3.cancel();
	    			
	    			
	    		}
	    	
	    	}
	    },0,1000);
	}
	
	public static void BossDeath4()	//fourth
	{
		boss1.setIcon(new ImageIcon("explosion.gif"));
        boss1.setRolloverIcon(new ImageIcon("explosion.gif"));
        tmrBossDeath4.scheduleAtFixedRate(new TimerTask()
	    {
	    	public void run()
	    	{
	    		
	    		intBossDeath4++;
	    		
	    		if (intBossDeath4 == 2)	
	    		{
	    			Level5();
	    			tmrBossDeath4.cancel();
	    			
	    			
	    		}
	    	
	    	}
	    },0,1000);
	}
	
	public static void BossDeath5()	//fifth boss death
	{
		boss1.setIcon(new ImageIcon("explosion.gif"));
        boss1.setRolloverIcon(new ImageIcon("explosion.gif"));
        tmrBossDeath5.scheduleAtFixedRate(new TimerTask()
	    {
	    	public void run()
	    	{
	    		
	    		intBossDeath5++;
	    		
	    		if (intBossDeath5 == 2)	
	    		{
	    			//ends the game frame and enters a the end game window - cancels all timers
	    			game.dispose();
	    			GameEnd.End();
	    			tmrTimer1.cancel();
	    			tmrBossDeath5.cancel();
	    			
	    			
	    			
	    		}
	    	
	    	}
	    },0,1000);
	}
	
	//All of the Level_ code is the same with a change of image and adding a health bar
	public static void Level2()	//setting hp and resetting values for level 2
	{
		//enables boss to be clicked
		boss1.setEnabled(true);
		intBossDeath1 = 0;	//bug fix
		//changing boss image
		boss1.setIcon(new ImageIcon("frog.gif"));
        boss1.setRolloverIcon(new ImageIcon("frog.gif"));
        //creating the boss button/editing the size
        boss1.setSize(150, 150);
        boss1.setLocation(550, 430);
        //adding/resetting variable values
        dblBossHealth = 670;
        dblBossHealth2 = 670;
        //setting boss hp bar size
        lblBossHealth1.setSize((int) dblBossHealth, 20);
        //resetting time
        intTime = 30;
        //creating the new health bar and placing it
        lblBossHealth2 = new JLabel("");
        lblBossHealth2.setSize((int) dblBossHealth2, 20);
        lblBossHealth2.setLocation(60, 30);
        lblBossHealth2.setOpaque(true);
        lblBossHealth2.setBackground(Color.YELLOW);
        //adding the new health bar to the content pane
        contentPaneG.add(lblBossHealth2);
        contentPaneG.moveToFront(lblBossHealth2);
	}
	
	public static void Level3()	//setting hp and resetting values for level 3
	{
		boss1.setEnabled(true);
		intBossDeath1 = 0;
		boss1.setIcon(new ImageIcon("lion.gif"));
        boss1.setRolloverIcon(new ImageIcon("lion.gif"));
        boss1.setSize(150, 150);
        boss1.setLocation(550, 430);
        dblBossHealth = 670;
        dblBossHealth2 = 670;
        dblBossHealth3 = 670;
        intTime = 30;
        
        lblBossHealth1.setSize((int) dblBossHealth, 20);
        
        lblBossHealth2.setSize((int) dblBossHealth2, 20);
        lblBossHealth2.setLocation(60, 30);
        lblBossHealth2.setOpaque(true);
        lblBossHealth2.setBackground(Color.YELLOW);
        contentPaneG.moveToFront(lblBossHealth2);
        
        lblBossHealth3 = new JLabel("");
        lblBossHealth3.setSize((int) dblBossHealth3, 20);
        lblBossHealth3.setLocation(60, 30);
        lblBossHealth3.setOpaque(true);
        lblBossHealth3.setBackground(Color.ORANGE);
        contentPaneG.add(lblBossHealth3);
        contentPaneG.moveToFront(lblBossHealth3);
		
	}
	
	public static void Level4()	//setting hp and resetting values for level 4
	{
		boss1.setEnabled(true);
		intBossDeath1 = 0;
		boss1.setIcon(new ImageIcon("gloo.gif"));
        boss1.setRolloverIcon(new ImageIcon("gloo.gif"));
        boss1.setSize(170, 190);
        boss1.setLocation(550, 390);
        dblBossHealth = 670;
        dblBossHealth2 = 670;
        dblBossHealth3 = 670;
        dblBossHealth4 = 670;
        intTime = 30;
        
        lblBossHealth1.setSize((int) dblBossHealth, 20);
        
        lblBossHealth2.setSize((int) dblBossHealth2, 20);
        lblBossHealth2.setLocation(60, 30);
        lblBossHealth2.setOpaque(true);
        lblBossHealth2.setBackground(Color.YELLOW);
        contentPaneG.moveToFront(lblBossHealth2);
        
        
        lblBossHealth3.setSize((int) dblBossHealth3, 20);
        lblBossHealth3.setLocation(60, 30);
        lblBossHealth3.setOpaque(true);
        lblBossHealth3.setBackground(Color.ORANGE);
        contentPaneG.moveToFront(lblBossHealth3);
        
        lblBossHealth4 = new JLabel("");
        lblBossHealth4.setSize((int) dblBossHealth4, 20);
        lblBossHealth4.setLocation(60, 30);
        lblBossHealth4.setOpaque(true);
        lblBossHealth4.setBackground(Color.MAGENTA);
        contentPaneG.add(lblBossHealth4);
        contentPaneG.moveToFront(lblBossHealth4);
	}
	
	public static void Level5()	//setting hp and resetting values for level 5
	{
		boss1.setEnabled(true);
		intBossDeath1 = 0;
		boss1.setIcon(new ImageIcon("dragon.gif"));
        boss1.setRolloverIcon(new ImageIcon("dragon.gif"));
        boss1.setSize(300, 300);
        boss1.setLocation(480, 285);
        dblBossHealth = 670;
        dblBossHealth2 = 670;
        dblBossHealth3 = 670;
        dblBossHealth4 = 670;
        dblBossHealth5 = 670;
        intTime = 30;
        
        lblBossHealth1.setSize((int) dblBossHealth, 20);
        
        lblBossHealth2.setSize((int) dblBossHealth2, 20);
        lblBossHealth2.setLocation(60, 30);
        lblBossHealth2.setOpaque(true);
        lblBossHealth2.setBackground(Color.YELLOW);
        contentPaneG.moveToFront(lblBossHealth2);
        
        
        lblBossHealth3.setSize((int) dblBossHealth3, 20);
        lblBossHealth3.setLocation(60, 30);
        lblBossHealth3.setOpaque(true);
        lblBossHealth3.setBackground(Color.ORANGE);
        contentPaneG.moveToFront(lblBossHealth3);
        
        lblBossHealth4.setSize((int) dblBossHealth4, 20);
        lblBossHealth4.setLocation(60, 30);
        lblBossHealth4.setOpaque(true);
        lblBossHealth4.setBackground(Color.MAGENTA);
        contentPaneG.moveToFront(lblBossHealth4);
         
        lblBossHealth5 = new JLabel("");
        lblBossHealth5.setSize((int) dblBossHealth5, 20);
        lblBossHealth5.setLocation(60, 30);
        lblBossHealth5.setOpaque(true);
        lblBossHealth5.setBackground(Color.DARK_GRAY);
        
        contentPaneG.add(lblBossHealth5);
        contentPaneG.moveToFront(lblBossHealth5);
        
        
	}
}
	
