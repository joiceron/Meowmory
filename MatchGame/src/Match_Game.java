import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Font;

public class Match_Game extends JFrame {

	Timer timer;
	Timer timer2;
	int milisec = 1000;
	Boolean hiIntensity = false;
	int counter = 0;
	int countr = 0;
	int control = 0;
	int mistakes = 0;
	int rightGuess = 0;

	List<Integer> fourRandomNum = null;
	List<Integer> CheckfourRandomNum = new ArrayList<>();;

	Level lvl = new Level();
	Colors color = new Colors();

	JLabel lblRed;
	JLabel lblBlue;
	JLabel lblYellow;
	JLabel lblGreen;

	JButton btnBlue;
	JButton btnGreen;
	JButton btnYellow;
	JButton btnRed;

	JLabel lblPoints;
	JLabel lblLevel;

	JButton playButton;

	int delay = 500; // milliseconds

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Match_Game dialog = new Match_Game();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 */
	public Match_Game() {
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method               :   	Match_Game()
		//
		// Method parameters    :		none
		//
		// Method returns       :		none
		//
		// Synopsis             :		This method call the Match_Game method.
		//
		// Modifications        :
		//									Date				Developer				Notes
		//									-----		 ---------------------	    ----------------
		//								  2023-05-01     	   Joice Ceron			 Initial Setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		setTitle("Match Game");
		setBounds(100, 100, 686, 526);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		ImageIcon play = null;
		play = new ImageIcon("buttons/PLAY.png");

		ImageIcon check = null;
		check = new ImageIcon("buttons/CHECK.png");

		// buttons

		playButton = new JButton("");
		playButton.setBackground(new Color(0, 0, 0));
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					//Start the game
				mistakes=0;
				OrderOfColors();
				timer.start();
				counter = 0;
				CheckfourRandomNum.clear();
				DisabledButtons(2);
				DisabledButtons(3);

			}
		});
		playButton.setIcon(play);
		playButton.setBounds(291, 397, 89, 46);
		contentPanel.add(playButton);
		playButton.setActionCommand("OK");
		getRootPane().setDefaultButton(playButton);

		JButton checkButton = new JButton("");
		checkButton.setBackground(new Color(0, 0, 0));
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		checkButton.setIcon(check);
		checkButton.setBounds(506, 376, 105, 44);
		contentPanel.add(checkButton);
		checkButton.setActionCommand("Cancel");
		checkButton.setVisible(false);

		lblRed = new JLabel("New label");
		lblRed.setIcon(color.getRedOff());
		lblRed.setBounds(57, 107, 130, 110);
		contentPanel.add(lblRed);

		lblGreen = new JLabel("New label");
		lblGreen.setIcon(color.getGreenOff());
		lblGreen.setBounds(337, 107, 130, 110);
		contentPanel.add(lblGreen);

		lblYellow = new JLabel("New label");
		lblYellow.setIcon(color.getYellowOff());
		lblYellow.setBounds(197, 107, 130, 110);
		contentPanel.add(lblYellow);

		lblBlue = new JLabel("New label");
		lblBlue.setIcon(color.getBlueOff());
		lblBlue.setBounds(477, 107, 130, 110);
		contentPanel.add(lblBlue);

		btnRed = new JButton("");
		btnRed.setEnabled(false);
		btnRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				btnRed.setIcon(color.redOff);
				if(btnRed.isEnabled()== true) {				//Input user answer
				CheckLights(0);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnRed.setIcon(color.redBright);
				if(btnRed.isEnabled()== true) {
				MakeSounds("red");
				}
			}
		});
		btnRed.setIcon(color.getRedOff());
		btnRed.setBounds(57, 237, 130, 110);
		contentPanel.add(btnRed);

		btnYellow = new JButton("");
		btnYellow.setEnabled(false);
		btnYellow.addMouseListener(new MouseAdapter() { 		
			@Override
			public void mouseReleased(MouseEvent e) {
				btnYellow.setIcon(color.yellowOff);
				if (btnYellow.isEnabled()== true){				//Input user answer
					CheckLights(1);
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnYellow.setIcon(color.yellowBright);
				if(btnRed.isEnabled()== true) {
				MakeSounds("sound01");
				}
			}
		});
		btnYellow.setIcon(color.yellowOff);
		btnYellow.setBounds(197, 237, 130, 110);
		contentPanel.add(btnYellow);

		btnGreen = new JButton("");
		btnGreen.setEnabled(false);
		btnGreen.addMouseListener(new MouseAdapter() {	
			@Override
			public void mousePressed(MouseEvent e) {
				btnGreen.setIcon(color.greenBright);
				if(btnRed.isEnabled()== true) {
				MakeSounds("green");
				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnGreen.setIcon(color.greenOff);
				if (btnGreen.isEnabled() == true) {		//Input user answer
					CheckLights(2);

				}


			}
		});
		btnGreen.setIcon(color.greenOff);
		btnGreen.setBounds(337, 237, 130, 110);
		contentPanel.add(btnGreen);

		btnBlue = new JButton("");
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBlue.setEnabled(false);
		btnBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnBlue.setIcon(color.blueBright);
				if(btnRed.isEnabled()== true) {
				MakeSounds("blue");
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnBlue.setIcon(color.blueOff);
				if (btnBlue.isEnabled() == true) { 		    	//Input user answer
					CheckLights(3);
				}
			}
		});
		btnBlue.setIcon(color.blueOff);
		btnBlue.setBounds(477, 237, 130, 110);
		contentPanel.add(btnBlue);

		lblLevel = new JLabel("Level: " + lvl.getLevel());
		lblLevel.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lblLevel.setBounds(67, 30, 168, 38);
		contentPanel.add(lblLevel);

		lblPoints = new JLabel("Points: " + lvl.getPoints());
		lblPoints.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoints.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lblPoints.setBounds(436, 30, 171, 38);
		contentPanel.add(lblPoints);

		timer = new Timer(delay, new ActionListener() {  			//Set timer for game events
			public void actionPerformed(ActionEvent evt) {

				if (hiIntensity == false) {

					if (fourRandomNum.get(counter) == 0) {
						lblRed.setIcon(color.redBright);
						MakeSounds("red");
					} else if (fourRandomNum.get(counter) == 1) {
						lblYellow.setIcon(color.yellowBright);
						MakeSounds("sound01");
					} else if (fourRandomNum.get(counter) == 2) {
						lblGreen.setIcon(color.greenBright);
						MakeSounds("green");
					} else if (fourRandomNum.get(counter) == 3) {
						lblBlue.setIcon(color.blueBright);
						MakeSounds("blue");
					}
					hiIntensity = true;

				} else if (hiIntensity == true) {
					if (fourRandomNum.get(counter) == 0) {
						lblRed.setIcon(color.redOff);
					} else if (fourRandomNum.get(counter) == 1) {
						lblYellow.setIcon(color.yellowOff);
					} else if (fourRandomNum.get(counter) == 2) {
						lblGreen.setIcon(color.greenOff);
					} else if (fourRandomNum.get(counter) == 3) {
						lblBlue.setIcon(color.blueOff);
					}
					hiIntensity = false;
					control = 1;
				}
				
				if (control == 1) {
					control = 0;
					counter++;
					if (counter == lvl.getNumOfColors()) {
						DisabledButtons(1);
						timer.stop();
						// disable buttons
					}
				}
			}
		});

	}// end constructor

	public void DisabledButtons(int DisBtns) {
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method               :   	DisabledButtons()
		//
		// Method parameters    :		int DisBtns
		//
		// Method returns       :		none
		//
		// Synopsis             :		This method set the buttons enabled or disabled.
		//
		// Modifications        :
		//									Date				Developer				Notes
		//									-----		 ---------------------	    ----------------
		//								  2023-05-02     	   Joice Ceron			 Initial Setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		if (DisBtns == 1) 
		{											//If the method obtain 1 as a parameter it set all color buttons enabled 
			btnRed.setEnabled(true);
			btnYellow.setEnabled(true);
			btnGreen.setEnabled(true);
			btnBlue.setEnabled(true);
		} else if (DisBtns == 2) {					//If the method obtain 2 as a parameter it set all color buttons disabled 
			btnRed.setEnabled(false);
			btnYellow.setEnabled(false);
			btnGreen.setEnabled(false);
			btnBlue.setEnabled(false);
		} else if (DisBtns == 3) {					//If the method obtain 3 as a parameter it set play button enabled
			playButton.setEnabled(false);
		} else {									//If the method obtain other number as a parameter it set play button enabled
			playButton.setEnabled(true);
		} 
	}

	public void CheckLights(int orderClick) {
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method               :   	CheckLights()
		//
		// Method parameters    :		integer orderClick
		//
		// Method returns       :		none
		//
		// Synopsis             :		This method check the input and tell the user if they win or loose.
		//
		// Modifications        :
		//									Date				Developer				Notes
		//									-----		 ---------------------	    ----------------
		//								  2023-05-01     	   Joice Ceron			 Initial Setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		mistakes = 0;      

		CheckfourRandomNum.add(orderClick);                                                               																				  
		if (CheckfourRandomNum.size() == lvl.getNumOfColors()) {                                        // If the check list is full, compare its contents to the randomly generated numbers              
		  
			for (countr = 0; countr < lvl.getNumOfColors(); countr++) {                                 // Loop through the check list and compare each number to the corresponding random number     
		  
				if (fourRandomNum.get(countr) != CheckfourRandomNum.get(countr)) {                        
					mistakes ++;																		// Increment the mistakes if the numbers do not match                      
				}                                                                                         
			}                                                                                             																				  
			if (mistakes > 0) {                                                                        	// If mistakes is greater than zero, the user guessed incorrectly                          
				
				lvl.getPointsDeducted();
				lvl.setPoints(lvl.getPoints() - lvl.getPointsDeducted()) ;							 	// Subtract points and display a message if points remain, or end the game if they do not 
				//if(lvl.getPoints()<0) {
				//	lblPoints.setText("Points: 0");    
				//} else {
				lblPoints.setText("Points: "+lvl.getPoints());   
				//}
				Level();
				if (lvl.getPoints() > -1) {                                                         	 	//If points are not below to zero the game will continue       
					MakeSounds("wrong");                                                                  
					JOptionPane.showMessageDialog(null, "You lose this match.");                          
					DisabledButtons(2);                                                                   
					DisabledButtons(4);   
				} else {                                                                                //If there are not more point the game will end
					MakeSounds("wrong");                                                                  
					JOptionPane.showMessageDialog(null, "You lose all your points! \nGood luck next time");                     
					JOptionPane.showMessageDialog(null, "Game Over! ");      
					DisabledButtons(2);                                                                   
					DisabledButtons(3);                                                                   
				}                                                                                         
			} else {       
				rightGuess++;
				lblLevel.setText("Level: " + lvl.getLevel());
				lvl.setPoints(lvl.getPoints()+ lvl.getPointsGiven());
				lblPoints.setText("Points: "+lvl.getPoints());  										// If the checker is zero, the user guessed correctly                                     
				Level();
				MakeSounds("win");
				JOptionPane.showMessageDialog(null, "You win this match.");
				DisabledButtons(2);
				DisabledButtons(4);
			}
		}
	}
	
	
public void Level () {
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method               :   	Level()
		//
		// Method parameters    :		none
		//
		// Method returns       :		none
		//
		// Synopsis             :		This method  the level of the game.
		//
		// Modifications        :
		//									Date				Developer				Notes
		//									-----		 ---------------------	    ----------------
		//								  2023-05-08     	   Joice Ceron			 Initial Setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	
	if (rightGuess == 4) {										//If user hit four times the color pattern, the level will increase and the number of colors
		lvl.setLevel(lvl.getLevel()+1);
		lblLevel.setText("Level: " + lvl.getLevel());
		lvl.setNumOfColors(lvl.getNumOfColors()+1);
		
		
		lvl.setPointsDeducted(lvl.getPointsDeducted()*2);		//Duplicate the points deduced
		lvl.setPointsGiven(lvl.getPointsGiven()*2);				//Duplicate the points given
		
		rightGuess = 0;											//reset the variable
	}
}

	public void MakeSounds (String audio) {
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method               :   	MakeSounds()
		//
		// Method parameters    :		String audio
		//
		// Method returns       :		none
		//
		// Synopsis             :		This method call the audio file and play sounds.
		//
		// Modifications        :
		//									Date				Developer				Notes
		//									-----		 ---------------------	    ----------------
		//								  2023-05-08     	   Joice Ceron			 Initial Setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		

		String dingLocation = "Audio/"+audio+".wav";                                       // Define the file location for the audio file to play                              
		 
	    
		try {                                                                               
			File dingFile = new File(dingLocation);                                       	// Create a file object for the audio file                                      

																						    
			AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);     // Get an audio input stream for the file                                       

																						    
			Clip dingSound = AudioSystem.getClip();                                        	// Get a clip object for the audio file                                         

																						    
			dingSound.open(dingAudioFile);                                                 	// Open the clip with the audio input stream                                    

																						    
			dingSound.start();                                                             	// Start playing the clip                                                       

																						    
		} catch (Exception e) {                                                             
			JOptionPane.showMessageDialog(null, "Problem playing sound: " + e );           	// If there is an exception, show an error message                              

		}

	}

	public void TurnOffLights() {

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method               :   	TurnOffLights()
		//
		// Method parameters    :		none
		//
		// Method returns       :		none
		//
		// Synopsis             :		This method set all the label at beginning images.
		//
		// Modifications        :
		//									Date				Developer				Notes
		//									-----		 ---------------------	    ----------------
		//								  2023-05-01     	   Joice Ceron			 Initial Setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		lblRed.setIcon(color.getRedOff());             // Set "off" icon for red label

		lblBlue.setIcon(color.getBlueOff());            // Set "off" icon for blue label  
					
		lblYellow.setIcon(color.getYellowOff());        // Set "off" icon for yellow label   
				
		lblGreen.setIcon(color.getGreenOff());          // Set "off" icon for green label   
	}

	public void OrderOfColors() {
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method               :   	OrderOfColors()
		//
		// Method parameters    :		none
		//
		// Method returns       :		none
		//
		// Synopsis             :		This method put a random sequence in an array of 4.
		//
		// Modifications        :
		//									Date				Developer				Notes
		//									-----		 ---------------------	    ----------------
		//								  2023-05-01     	   Joice Ceron			 Initial Setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		// TODO Auto-generated constructor stub

		fourRandomNum = new ArrayList<>();											// Creating a new ArrayList called fourRandomNum
		Random randomList = new Random();             							    // Creating a new Random object named randomList
		for (int counter = 0; counter < lvl.getNumOfColors(); counter++) {			// Starting a for loop to shuffle
			int randomIndex = randomList.nextInt(4);								// Generating a random number between 0 and 
			/*
			 * while (fourRandomNum.contains(randomIndex)) { randomIndex =
			 * randomList.nextInt(4); }
			 */
			fourRandomNum.add(randomIndex);											//Adding the random numbers to the list 
		}
	}

}// end class
