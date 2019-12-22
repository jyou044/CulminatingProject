/********************************************************************************************************************************************************************
By: Jason You
Ms.Costin
January 17, 2018
The "Game of Knowledge" Program

This game is one where the user is given a set of questions that they have to answer based on knowledge.
The questions for each set are randomized and the users are given points depending on the type of word that he/she enters.
(E.g. If the question asks for a type of bird and the user enters a bird name that is unknown, then the user will be given points.)
However, the questions for each of the levels will be of varying difficulty. The questions in level 1 will be simple, the questions in level 2 will be of
intermediate level and the questions in level 3 will be hard. Also, the user will be asked to choose between three categories: technology, animals and general
knowledge.There are three levels and within these three levels, each level becoming increasingly difficult. If the user would like to quit the program, he/she
would enter the word "quit". When the user first enters the program, he/she will be given the choice of entering numbers 1-5: 1 is for level 1, 2 is for level 2,
3 is for level 3, 4 is for the help, and 5 is to exit the program.The program will be error trapped so that when the user doesn't input a proper value, a Frame
window will pop up prompting the user to re-enter the value.
********************************************************************************************************************************************************************/
// Import section of the program
import java.awt.*; // Imports the java.awt.* package
import hsa.*; // Import hsa.* package
import java.lang.*; // Import java.lang.*
import javax.swing.JOptionPane; // Import javax.swing.JOptionPane
import java.awt.Polygon; // Import the java.awt.Polygon package
import java.awt.Color; // Import the java.awt.Color package
import java.awt.*; // Import the java.awt.* package
import java.io.*; // Import java.io.* package
import javax.sound.sampled.AudioInputStream; // Import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.Clip; // Import javax.sound.sampled.Clip
import sun.audio.AudioData; // Import sun.audio.AudioData
import sun.audio.AudioPlayer; // Import sun.audio.AudioPlayer
import sun.audio.AudioStream; // Import sun.audio.AudioStream
import sun.audio.ContinuousAudioDataStream; // Import sun.audio.ContinuousAudioDataStream
import javax.sound.sampled.Clip; // Import javax.sound.sampled.Clip
import javax.sound.sampled.AudioFormat; // Import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioInputStream; // Import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem; // Import javax.sound.sampled.AudioSystem
import javax.sound.sampled.DataLine; // Import javax.sound.sampled.DataLine
import javax.sound.sampled.LineUnavailableException; // Import javax.sound.sampled.LineUnavailableException
import javax.sound.sampled.SourceDataLine; // Import javax.sound.sampled.SourceDataLine

/********************************************************************************************************************************************************************
VARIABLE DECLARATION
Variable Name                           Type                          Description
c                                       Console                       This variable is responsible for creating an object of the Console class.
menu                                    String                        This variable is responsible for getting the menu option that the user chooses.
gameName                                String                        This variable is responsible for getting the game name that the user uses.
linePos                                 Integer                       This variable stores the position of the cursor on the screen.
picture                                 Image                         This variale creates an object of the image class so that images can be used in the program.
highScores[]                            String                        This variable stores the high scores of the program.
questionFile                            String                        This variable stores the name of the question file (e.g. level 1 questions, level 2 questions,
								      etc.)
answerFile                              String                        This variable stores the name of the answer file (e.g. level 1 answers, level 2 answers, etc.)
lvlOneQuestions[]                       String                        This array stores the level 1 questions.
lvlTwoQuestions[]                       String                        This array stores the level 2 questions.
lvlThreeQuestions[]                     String                        This array stores the level 3 questions.
lvlOneAnswers[]                         String                        This array stores the level 1 answers.
lvlTwoAnswers[]                         String                        This array stores the level 2 answers.
lvlThreeAnswers[]                       String                        This array stores the level 3 answers.
positions[]                             Integer                       This array stores the numbers from 1-30 and is used to randomly generate the positions of the
								      questions
gameQuestions[]                         String                        This array stores the questions that will be used in the game
correctAnswers[]                        String                        This array stores the answers to the questions that are currently being used in the game.
clearScore                              String                        This variable stores whether or not the user would like to clear the high scores.
userAnswer                              String                        This variable stores the user answer in the game.
lvlVal                                  Integer                       This variable stores the level that the user is in so that the proper files can be read in.
userScore                               Integer                       This variable stores the user score in the game.
**********************************************************************************************************************************************************************/
public class Culminating_JasonYou extends IOException
{
    static Console c;           // The output console
    public static String menu; // Menu option
    public static String gameName; // Reads in the game name of the user
    public static int linePos; // Line position of the program.
    public static Image picture; // Gets the image
    public static String[] highScores = new String [33]; // Array to store the high scores
    public static String questionFile; // Stores the file name of the level
    public static String answerFile; // Stores the file name of the answer file
    public static String[] lvlOneQuestions = new String [30]; // Stores the level one questions
    public static String[] lvlTwoQuestions = new String [30]; // Stores the level two questions
    public static String[] lvlThreeQuestions = new String [30]; // Stores the level three questions
    public static String[] lvlOneAnswers = new String [30]; // Stores the level 1 answers
    public static String[] lvlTwoAnswers = new String [30]; // Stores the level 2 answers
    public static String[] lvlThreeAnswers = new String [30]; // Stores the level 3 answers
    public static int[] positions = new int [30]; // Stores the positions 1 to 30 and then randomly selects 10 numbers for the questions that will be used.
    // public static String[] gameAnswers = new String [10]; // Stores the game answers
    public static String[] gameQuestions = new String [10]; // This array stores the questions that will be used in the game
    public static String[] correctAnswer = new String [10]; // Temporarily Stores the game answer to compare
    public static String clearScore; // This variable stores the option to clear the scores or not.
    public static String userAnswer; // This variable stores the answer that the user enters
    public static int lvlVal; // Stores the level
    public static int userScore; // This stores the user's current score in the program

    /*
    The title() method.
    This method is responsible for printing out the title () and clears the screen of the program.
    */
    private static void title ()
    {
	c.clear (); // Clears the screen
	c.setCursor (1, 30); // Sets the position of the cursor
	c.println ("The Game of Knowledge"); // Clears the screen and prints out the title "The Game of Knowledge"
    }


    /*
    The stopProgram () method.
    This method is responsible for pausing the program and waits for the user to press any character value to proceed in the program.
    */
    private static void stopProgram (int pos)
    {
	c.setCursor (pos, 1); // Sets the position of the "Enter any key to proceed" sentence
	c.println ("Enter any key to proceed: "); // Asks the user to enter any character value in order to proceed.
	c.getChar (); // Gets any character value from the user.
    }


    /*
    The loadImage (String pic) method.
    This method is responsible for loading the image that is needed in the program.
    */
    public static void loadImage (String pic)
    {
	picture = Toolkit.getDefaultToolkit ().getImage (pic);

	MediaTracker t = new MediaTracker (new Frame ()); // Creates an object of the MediaTracker class

	t.addImage (picture, 0); // Adds the picture

	try // Needed to catch any images while loading the image
	{
	    t.waitForAll ();
	}
	catch (InterruptedException e)
	{

	}
    }


    /*
    The displayImage (int posX, int posY) method.
    This method is responsible for accepting parameters that will allow the picture that the user
    wants to use on the screen.
    */
    public static void displayImage (int posX, int posY)
    {
	c.drawImage (picture, posX, posY, null); // Draws the picture on the screen (top left corner coordinates)
    }


    /*
    The main menu method
    This method is responsible for displaying the main menu of the program.
    The user will be prompted to choose options from 1-6. If the user inputs a value that is not 1,2,3,4,5, or 6, the user will be shown
    an error message window and be asked to enter a correct value.
    There is also an animated picture at the bottom.
    */
    public static void mainMenu ()
    {
	title (); // Clears screen
	linePos = 9; // This is the line position where the cursor will be reset to if the user doesn't input a proper menu option
	c.setCursor (2, 22); // Sets the position of the cursor
	c.println ("Welcome to the Game of Knowledge!");  // Title that tells the user that this is the game of knowledge
	loadImage ("menu.jpg"); // Loads the image

	// Main menu options
	c.println ("1- Level 1");  // Level 1 option
	c.println ("2- Level 2"); // Level 2 option
	c.println ("3- Level 3"); // Level 3 option
	c.println ("4- Help");    // Help option
	c.println ("5- High Scores"); // High Scores option
	c.println ("6- Exit");        // Exit option

	c.setColor (Color.white); // Sets the color of the erase to white
	for (int i = 0 ; i < 200 ; i++)
	{
	    c.drawRect (70 + i, 290 + i, 155, 155); // Draws the erase
	    displayImage (100 + i, 300); // Draws the image
	    try
	    {
		Thread.sleep (10); // Delays the animation
	    }
	    catch (Exception e)
	    {

	    }
	}
	while (true) // This while loop is responsible for errortrapping the user input so that when the user inputs a different value, he/she will be prompted to enter a correct menu choice
	{
	    c.setCursor (linePos, 1); // Sets the position of cursor
	    menu = c.readLine (); // Reads in a menu choice from the user
	    if ((menu.equals ("1")) || (menu.equals ("2")) || (menu.equals ("3")) || (menu.equals ("4")) || (menu.equals ("5")) || (menu.equals ("6")))
	    {
		break; // If one of the menu choices are met, then the program will exit.
	    }
	    else
	    {
		JOptionPane.showMessageDialog (null, "Please enter a menu choice! (1,2,3,4,5, or 6)", "ERROR!", JOptionPane.ERROR_MESSAGE); // Prints out an error message
		c.setCursor (linePos, 1); // Resets the position of the cursor to the original position.
		c.println (); // Prints out a line.
	    }
	}

    }


    /*
    The gameName() method.
    This method is responsible for asking the user to enter a game name that is no longer than 9 characters.
    */
    private static void gameName ()
    {
	title (); // Clears the screen
	c.println ("Please enter a game name (No longer than 9 characters or 'user'): "); // Asks the user to enter a game name no longer than 9 characters
	while (true)
	{
	    c.setCursor (3, 1); // Sets the position of the cursor
	    gameName = c.readLine (); // Reads in the game name from the user
	    if (gameName.length () <= 9 & !gameName.equalsIgnoreCase ("user")) // If the game name is less than or equal to 9 characters long, then the loop is broken the game continues.
	    {
		break; // Breaks out of the loop
	    }
	    else // Error condition
	    {
		if (gameName.length () > 9) // If the user enters a game name longer than 9 characters 
		{
		    JOptionPane.showMessageDialog (null, "Please enter a name under 9 characters!", "ERROR!", JOptionPane.ERROR_MESSAGE); // Prints out an error message
		    c.setCursor (3, 1); // Resets the position of the cursor to the original position.
		    c.println (); // Prints out a line.
		}
		else // If the user enters a game name that is equal to user 
		{
		    JOptionPane.showMessageDialog (null, "Please enter a game name other than 'user'!", "ERROR!", JOptionPane.ERROR_MESSAGE); // Prints out an error message
		    c.setCursor (3, 1); // Resets the position of the cursor to the original position.
		    c.println (); // Prints out a line.
		}
	    }

	}
    }


    /*
    The scoreCalculator method
    This method is responsible for calculating the score of the user and determining whether or not the user's score is
    good or not. It gets the level of the user because the algorithm used to calculate the score for each level is different.
    Variable Name                     Type                  Description
    goodFlag                          Integer               This variable is a flag variable that when raised, will display the smiley face

    badFlag                           Integer               This variable is a flag variable that when raised, will display the sad face

    okFlag                            Integer               This variable is a flag variable that when raised, will display the expressionless face
    */
    private static void scoreCalculator (int level)
    {
	title (); // Clears the screen
	int goodFlag = 0, badFlag = 0, okFlag = 0; // Initializes all the flags to zero.
	switch (level) // Switch statement to see which level the user is in.
	{
	    case 1: // First case is when the user is in level 1
		if (userScore >= 8 & userScore <= 10) // This is the high score condition
		{
		    c.println ("Great job! Your score is high."); // Tells the user that he/she did a good job
		    goodFlag = 1; // Raises goodFlag
		}
		else if (userScore >= 5 & userScore < 8) // Average score condition
		{
		    c.println ("Your score is average."); // Tells the user that he/she has an average score
		    okFlag = 1; // Raises ok flag
		}
		else // Bad score condition
		{
		    c.println ("Your score is bad. Better luck next time!"); // Tells the user that he/she did a bad job
		    badFlag = 1; // Raises bad flag
		}
		break; // Breaks from switch statement

	    case 2: // Level 2 case
		if (userScore >= 16 & userScore <= 20) // This is the high score condition
		{
		    c.println ("Great job! Your score is high."); // Tells the user that he/she has a good score
		    goodFlag = 1; // Raises good flag
		}
		else if (userScore >= 10 & userScore < 16) // This is the average score condition
		{
		    c.println ("Your score is average."); // Tells the user that he/she has an average score
		    okFlag = 1; // Raises ok flag
		}
		else // Bad condition
		{
		    c.println ("Your score is bad. Better luck next time!"); // Tells the user he/she has a bad score
		    badFlag = 1; // Raises bad flag
		}
		break; // Breaks from switch statement
	    case 3:
		if (userScore >= 20 & userScore <= 30) // This is the high score condition
		{
		    c.println ("Great job! Your score is high."); // Tells the user he/she has a good score
		    goodFlag = 1; // Raises good flag
		}
		else if (userScore >= 15 & userScore < 20) // This is the average score condition
		{
		    c.println ("Your score is average"); // Tells the user he/she has an average score
		    okFlag = 1; // Raises ok flag
		}
		else // This is the bad score option
		{
		    c.println ("Your score is bad. Better luck next time!"); // Tells the user that he/she has a bad score
		    badFlag = 1; // Raises bad flag
		}
		break; // Breaks from switch statement
	}

	if (goodFlag == 1) // Good flag condition
	{
	    loadImage ("smileyface.jpg"); // Loads smiley face image
	    displayImage (300, 100); // Positions the smiley face on the screen
	}
	else if (okFlag == 1) // Ok flag condition
	{
	    loadImage ("Expressionlessface.jpg"); // loads the expressionless face
	    displayImage (300, 100); // Positions the expressionless face on the screen
	}
	else // Bad flag condition
	{
	    loadImage ("sadface.jpg"); // Loads the sad face
	    displayImage (300, 100); // Positions the expressionless face on the screen
	}
	stopProgram (20); // Pauses the program
    }


    /*
    The initializePostions() method
    This method is responsible for initializing the positions of the questions in the array
    */
    private static void initializePositions ()
    {
	for (int i = 0 ; i < 30 ; i++) // for loop to initialize the positions
	{
	    positions [i] = i + 1; // initializes the positions
	}
    }


    /*
    The highScores() method.
    This method is responsible for displaying the high scores of the program
    */
    public static void highScoresDisplay ()
    {
	title (); // Clears the screen
	c.setCursor (2, 35); // Centers the position of the text
	c.println ("HIGH SCORES"); // Prints out "HIGH SCORES" on the screen
	c.print ("NAME"); // Prints out "NAMES" on the screen
	c.print (' ', 30); // Prints out 30 spaces
	c.print ("SCORE"); // Prints out scores
	c.print (' ', 20); // Prints out 20 spaces
	c.println ("LEVEL"); // Prints out the title "LEVEL"

	while (true) // While loop to display the scores and reset the scores if the user would like to
	{
	    c.setCursor (4, 1); // Sets the position of the cursor
	    for (int i = 0 ; i < 10 ; i++) // This prints out the scores (if there are placeholders, then no scores are printed out)
	    {
		c.print ((i + 1) + "."); // Prints out the number
		if (!highScores [i * 3].equals ("User")) // Checks to make sure that the placeholders are not in place
		{
		    c.print (highScores [i * 3], 30); // Prints out the name
		    c.print (highScores [i * 3 + 1], 25); // Prints out the score
		    c.println (highScores [i * 3 + 2]); // Prints out the level
		}
		else
		{
		    c.println (); // Prints out a line (If there are place holders)
		}
	    }

	    c.setCursor (18, 1); // Sets the cursor position
	    c.println ("Would you like to clear the high scores? (Y or N or 'Q' for Quit): "); // Asks the user to clear the high scores or not.
	    c.setCursor (19, 1); // Sets the cursor(for user input)
	    clearScore = c.readLine (); // Reads in user input
	    if (clearScore.equalsIgnoreCase ("Y")) // Checks to see if user input is Y (yes)
	    {
		initializeScores (); // Resets the scores
	    }
	    else if (clearScore.equalsIgnoreCase ("Q") | clearScore.equalsIgnoreCase ("N")) // Checks to see if the user input is q or n (quit or no)
	    {
		break; // Breaks from the loop
	    }
	    else // Error condition (Prints out an error message)
	    {
		JOptionPane.showMessageDialog (null, "Please enter a menu choice! (Y or N)", "ERROR!", JOptionPane.ERROR_MESSAGE); // Prints out an error message
		c.setCursor (19, 1); // Resets the position of the cursor to the original position.
		c.println (); // Prints out a line.
	    }
	}
	stopProgram (20); // Pauses the program so that the user can see the high scores
    }


    /*
    The resetScore() method
    This method is responsible for resetting the score of the user in the program.
    */
    private static void resetScore ()
    {
	userScore = 0; // Resets the user score to zero
    }


    /*
    The help method.
    The help method is responsible for displaying the rules of the program.
    */
    public static void help ()
    {
	title (); // Clears the screen
	loadImage ("Jeopardy.jpg"); // Loads the jeopardy image
	displayImage (10, 248); // Displays the jeopardy image on the screen
	c.setColor (Color.black); // Sets the colour of the text to black
	c.setFont (new Font ("TimesRoman", Font.PLAIN, 12)); // Sets the font type to times new roman
	c.drawString ("Welcome to the Game of Knowledge.", 10, 80); // Prints out the position of the strings
	c.drawString ("This game has three levels with questions of different categories with varying levels", 10, 120);
	c.drawString ("There is a high score list that displays the high scores that the user has.", 10, 160);
	c.drawString ("You will be awarded points based on how many questions you get right. Type the keyword 'quit' in any level", 10, 200);
	c.drawString ("If you would like to exit that level.", 10, 240);
	stopProgram (21); // Pauses the program and asks the user to press any character value to proceed
    }


    /*
    The readQuestionFiles () method
    This method is responsible for reading in the questions from the files as well as the answers from the answer file.
    Variable Name                                 Type                          Description
    i                                             BufferedReader                An object of the BufferedReader class and needed for the reading in
										of questions from the question file
    k                                             BufferedReader                An object of the BufferedReader class and needed for the reading in
										of answers from the answer file
    */
    private static void readQuestionFiles ()
    {
	BufferedReader i; // Creates an object of the BufferedReader class
	BufferedReader k; // Creates an object of the BufferedReader class
	try
	{
	    i = new BufferedReader (new FileReader (questionFile)); // Reads in the question file
	    k = new BufferedReader (new FileReader (answerFile)); // Reads in the answer file
	    if (lvlVal == 1) // Level 1 condition
	    {
		for (int j = 0 ; j < 30 ; j++) // Loop that runs thirty times to store the questions and the answers in an array 
		{
		    lvlOneQuestions [j] = i.readLine (); // reads in the level one questions
		    lvlOneAnswers [j] = k.readLine (); // reads in the level one answers
		}
	    }
	    else if (lvlVal == 2) // Level 2 condition
	    {
		for (int j = 0 ; j < 30 ; j++) // Loop that runs thirty times to store the questions and the answers in an array 
		{
		    lvlTwoQuestions [j] = i.readLine (); // reads in the level two questions
		    lvlTwoAnswers [j] = k.readLine ();   // reads in the level two answers
		}
	    }
	    else // Level 3 condition
	    { 
		for (int j = 0 ; j < 30 ; j++) // Loop that runs 
		{
		    lvlThreeQuestions [j] = i.readLine (); // reads in the level three questions
		    lvlThreeAnswers [j] = k.readLine ();   // reads in the level three answers
		}
	    }
	    i.close (); // Closes the question file
	    k.close (); // Closes the answer file
	}
	catch (IOException e)  // Catches IOException error
	{

	}
    }


    /*
    The fileReader(int lvl) method.
    This method is responsible for getting the level that the user is in and then initializing the fileName variable to
    the file that needs to be read in.
    */
    private static void fileReader (int lvl)
    {
	switch (lvl) // Switch statement to see which files have to be called
	{
	    case 1: //
		questionFile = "level1.txt"; // Level 1 questions
		answerFile = "level1Answers.txt"; // Level 1 answers
		break; // Breaks from the switch statement

	    case 2:
		questionFile = "level2.txt"; // Level 2 questions
		answerFile = "level2Answers.txt"; // Level 2 answers
		break; // Breaks from the switch statement

	    case 3:
		questionFile = "level3.txt"; // Level 3 questions
		answerFile = "level3Answers.txt"; // Level 3 answers
		break; // Breaks from the switch statement
	}
	readQuestionFiles (); // Calls the readQuestionFiles() method to read in the answer and question files
    }


    /*
    The scoreUpdate(String userName, int scoreVal, int level) method.
    This method is responsible for updating the score file and sorting the scores in the high scores file
    Variable Name                      Type                  Description
    t[]                                String Array          This array is responsible for temporarily storing the most recent user game name, score, and level.
    */
    private static void scoreUpdate (String userName, int scoreVal, int level)
    {
	String[] t = new String [3]; //Needed to temporarily store the three values so that they can be compared with the other values in the file
	highScores [30] = userName; // Sets the 30th array indice to the userName
	highScores [31] = Integer.toString (scoreVal); // Sets the 31th array indice to the score value of the user
	highScores [32] = Integer.toString (level); // Sets the 32th array indice to the level that the user is in
	for (int i = 1 ; i < 11 ; i++) // Uses bubble sort to sort the scores
	{
	    for (int j = 10 ; j >= i ; j--)
	    {
		if ((Integer.parseInt (highScores [((j - 1) * 3 + 1)])) < Integer.parseInt (highScores [j * 3 + 1])) // Compares the values
		{
		    t [0] = highScores [j * 3]; // Temporarily stores the name value
		    t [1] = highScores [j * 3 + 1]; // Temporarily stores the score value of the user
		    t [2] = highScores [j * 3 + 2]; // Temporarily stores the level value

		    highScores [j * 3] = highScores [(j - 1) * 3]; // Switches the name values
		    highScores [j * 3 + 1] = highScores [(j - 1) * 3 + 1]; // Switches the score values
		    highScores [j * 3 + 2] = highScores [(j - 1) * 3 + 2]; // Switches the level values

		    highScores [(j - 1) * 3] = t [0]; // Switches the name values
		    highScores [(j - 1) * 3 + 1] = t [1]; // Switches the score values
		    highScores [(j - 1) * 3 + 2] = t [2]; // Switches the level values
		}
	    }
	}

	PrintWriter score; // Creates an object of the PrintWriter class
	try // Try catch statement needed to catch any errors and write the scores to the file
	{
	    score = new PrintWriter (new FileWriter ("highScores.txt"));
	    for (int i = 0 ; i < 11 ; i++)
	    {
		score.println (highScores [i * 3]); // Name placeholder
		score.println (highScores [i * 3 + 1]); // Score placeholder
		score.println (highScores [i * 3 + 2]); // Level Placeholder
	    }

	    score.close (); // Closes the file
	}
	catch (FileNotFoundException e)  // Catch FileNotFoundException error
	{
	    initializeScores (); // If file is not found, then the scores are initialized
	}
	catch (IOException e)  // Catch IOException error
	{

	}
    }


    /*
    The initializeScores() method
    This method is responsible for resetting the scores
    */
    private static void initializeScores ()
    {
	for (int i = 0 ; i < 10 ; i++)
	{
	    highScores [i * 3] = "User"; // Name placeholder
	    highScores [(i * 3) + 1] = "0"; // Score placeholder
	    highScores [(i * 3) + 2] = "1"; // Level Placeholder
	}

    }


    /*
    This prints out the score on the screen as the user is playing the game.
    */
    private static void scorePrint ()
    {
	c.setColor (Color.black); // Sets the colour
	c.setFont (new Font ("TimesRoman", Font.PLAIN, 18)); // Sets the font
	c.drawString ("SCORE: " + userScore, 10, 250); // Live prints the score on the screen
    }



    /*
    The levelOne() method.
    This method is responsible for creating the level one method.
    It works by first calling the fileReader() method which will then read in the questions from the level one file.
    Then, the positions are initialized and then the question positions are randomly generated. After the position has been taken,
    a placeholder (0) is placed so that that question position will not be used again. The loop then breaks once 10 random unique positions
    have been chosen. Then, the user will be asked to answer trivia questions. The user will be told immediately afterwards if he/she got the
    correct answer. At the end, a score screen will be shown telling the user whether or not he/she got a good or bad score.
    */
    public static void levelOne ()
    {
	int tempNum; // Needed to randomize the numbers (Stores the randomized indice position)
	gameName (); // Gets the game name from the user
	resetScore (); // Resets the user score to zero
	lvlVal = 1; // Sets level to one
	fileReader (lvlVal); // Tells the fileReader method that the user is currently in level one so that the correct file is read in.
	int count = 0; // checks to make sure that all the questions are randomized properly
	initializePositions (); // Intiailizes the positions so that the position of the questions can be reset again

	while (true) // Randomly stores the questions from the database of level one questions
	{
	    tempNum = (int) (Math.random () * 30); // Randomly generates a number
	    if (positions [tempNum] != 0) // Checks for the position of the arrays that are not equal to zero (zeros are placed in the positions where the
		//numbers have already been chosen)
		{
		    gameQuestions [count] = lvlOneQuestions [tempNum]; // Initializes the gameQuestion array
		    correctAnswer [count] = lvlOneAnswers [tempNum]; // Initializes the correctAnswer array
		    positions [tempNum] = 0; // Sets the position to zero so that there are no duplicate answers
		    count++; // Increases the count
		}
	    if (count > 9) // When the count is greater than 9, the loop will end
	    {
		break; // Breaks out of the loop
	    }
	}


	for (int i = 0 ; i < 10 ; i++) // For loop needed to display the questions and get the user input
	{
	    title (); // Clears the screen
	    scorePrint (); // Prints the score on the screen
	    c.print (gameQuestions [i]); // Prints out the question
	    userAnswer = c.readLine (); // Reads in the user input
	    if (userAnswer.equalsIgnoreCase ("Quit")) // The quit condition
	    {
		break; // Quits from the level
	    }
	    if (userAnswer.equalsIgnoreCase (correctAnswer [i])) // correct answer condition
	    {
		c.println ("Correct"); // The user is told that he/she got the correct answer
		userScore++; // User score increments by 1
	    }
	    else // Wrong condition
	    {
		c.println ("Wrong"); // Tells the user he/she is wrong
	    }
	    c.println (); // Prints out a line
	    stopProgram (10); // Pauses the program until the user presses any key to continue
	}
	scoreCalculator (lvlVal); // Prints out how well the user did in the game
	scoreUpdate (gameName, userScore, lvlVal); // Updates the scores in the high score file
    }


    /*
    The levelTwo () method.
    This method is responsible for creating the level one method.
    It works by first calling the fileReader() method which will then read in the questions from the level two file.
    Then,the positions are initialized and then the question positions are randomly generated. After the position has been taken,
    a placeholder(0)is placed so that that question position will not be used again. The loop then breaks once 10 random unique positions
    havebeenchosen.Then,the user will be asked to answer trivia questions. The user will be told immediately afterwards if he/she got the
    correctanswer.At the end, a score screen will be shown telling the user whether or not he/she got a good or bad score.
    */
    public static void levelTwo ()
    {
	gameName (); // Gets the game name from the user
	resetScore (); // Resets the game score
	int tempNum; // Randomizes the number
	int count = 0; // Count is responsible for making sure that 10 unique questions are randomized
	lvlVal = 2; // Sets the level to 2
	fileReader (lvlVal); // Tells the fileReader method that the user is in level 2
	initializePositions (); // Initializes the positions
	while (true) // Randomly stores the questions from the database of level one questions
	{
	    tempNum = (int) (Math.random () * 30); // Stores the randomized number between 0 to 30
	    if (positions [tempNum] != 0) // Makes sure that the place holder zero has not been put
	    {
		gameQuestions [count] = lvlTwoQuestions [tempNum]; // Initializes the gameQuestions[] array
		correctAnswer [count] = lvlTwoAnswers [tempNum]; // Initializes the correctAnswer[] array
		count++; // Increments count
		positions [tempNum] = 0; // Sets the position to zero so that that number will not be used again
	    }

	    if (count > 9) // Checks to see if the count is greater than 9
	    {
		break; // Breaks from the loop
	    }

	}


	for (int i = 0 ; i < 10 ; i++) // Prints out eh questions on the screen
	{
	    title (); // Clears the screen
	    scorePrint (); // Prints the score on the screen
	    c.println (gameQuestions [i]); // Prints out the game questions
	    userAnswer = c.readLine (); // Reads in the user input
	    if (userAnswer.equalsIgnoreCase ("Quit")) // Quit condition
	    {
		break; // Breaks from the loop
	    }
	    if (userAnswer.equalsIgnoreCase (correctAnswer [i])) // Correct answer condition
	    {
		c.println ("Correct"); // Prints that the user got the correct answer
		userScore += 2; // Increments user score by 2
	    }
	    else // Wrong condition
	    {
		c.println ("Wrong"); // Tells the user that he/she got the wrong answer
	    }
	    c.println (); // Prints a line
	    stopProgram (10); // Pauses the program until the user enter any key to continue
	}
	scoreCalculator (lvlVal); // Prints out whether or not the user has done a good job
	scoreUpdate (gameName, userScore, lvlVal); // Updates the score file
    }


    /*
    The levelThree () method.
    This method is responsible for creating the level three method.
    It works by first calling the fileReader() method which will then read in the questions from the level three file.
    Then,the positions are initialized and then the question positions are randomly generated. After the position has been taken,
    a placeholder(0)is placed so that that question position will not be used again. The loop then breaks once 10 random unique positions
    have been chosen.Then,the user will be asked to answer trivia questions. The user will be told immediately afterwards if he/she got the
    correctanswer.At the end, a score screen will be shown telling the user whether or not he/she got a good or bad score.
    */
    public static void levelThree ()
    {
	gameName (); // Reads in the game name from the user
	resetScore (); // Resets the user score
	int tempNum; // This variable is needed to randomize the numbers of the array indices
	lvlVal = 3; // Sets the level to 3
	int count = 0; // Counts the position in the array
	fileReader (lvlVal); // Calls the fileReader method and responsible for reading in the correct level three questions and answers
	initializePositions (); // Intializes the positions from 1-30 so that 10 unique array indice positions can be taken in

	while (true) // Randomly stores the questions from the database of level one questions
	{
	    tempNum = (int) (Math.random () * 30); // Randomizes a number between 0 and 30
	    if (positions [tempNum] != 0) // Checks to make sure that the position is not 0.
	    {
		gameQuestions [count] = lvlThreeQuestions [tempNum]; // Initializes the game questions array
		correctAnswer [count] = lvlThreeAnswers [tempNum]; // Initializes the answer array
		count++; // Increments the value of count
		positions [tempNum] = 0; // Sets the value at the specific position to zero
	    }

	    if (count > 9) // If condition that checks to make sure that the count value is greater than 9
	    {
		break; // Breaks from the loop
	    }

	}


	for (int i = 0 ; i < 10 ; i++) // For loop to print out the questions and read in the user input
	{
	    title (); // Clears the screen
	    scorePrint (); // Prints the score on the screen
	    c.println (gameQuestions [i]); // Prints out the game questions on the screen
	    userAnswer = c.readLine (); // Reads in user input
	    if (userAnswer.equalsIgnoreCase ("Quit")) // Quit option
	    {
		break; // Breaks from the loop
	    }
	    if (userAnswer.equalsIgnoreCase (correctAnswer [i])) // correct condition
	    {
		c.println ("Correct"); // Prints out correct on the screen
		userScore += 3; // Increments the user score by 3.
	    }
	    else // Wrong condition
	    {
		c.println ("Wrong"); // Prints out that the user is wrong
	    }
	    c.println (); // Prints out a line
	    stopProgram (10); // Pauses the program until the user inputs any value to condition
	}
	scoreCalculator (lvlVal); // Calls the scoreCalculator method. This method is responsible for printing whether or not the user has a good score or not.
	scoreUpdate (gameName, userScore, lvlVal); // The score file is updated with the new score
    }


    /*
    The goodBye() method.
    This method is responsible for displaying the goodbye method at the end of the game.
    */
    public static void goodBye ()
    {
	title (); // Clears the screen
	c.setColor (Color.blue); // Sets the colour of the text to black
	c.setFont (new Font ("TimesRoman", Font.PLAIN, 20)); // Sets the font type to times new roman
	c.drawString ("Thank you for playing the Game of Knowledge!", 10, 80); // Prints out the position of the strings
	loadImage ("Goodbye.jpg"); // Loads the goodbye image
	displayImage (10, 258); // Loads the display image
	stopProgram (10); // Pauses the program
	c.close (); // Closes the program
    }


    /*
    The main method
    The main method is responsible for running the main program.
    Depending on the menu choice that the user chooses, the user will be directed to different parts of the
    program.
    */
    public static void main (String[] args) throws Exception // Throws an exception (for the audio)
    {
	c = new Console (); // Creates a new Console
	initializeScores (); // Initializes the score array so that data can be sent to the score file

	String filename = "girls_just_wanna_have_fun.wav"; // Stores the name of the audio file
	InputStream in = new FileInputStream (new File (filename)); // Creates an object of the InputStraeam file
	AudioStream audioStream = new AudioStream (in); // Creates an object of the AudioStream file


	while (true) // This while loop is responsible for running the main program (Based on the menu choices chosen by the user)
	{
	    AudioPlayer.player.start (audioStream); // Plays the music
	    mainMenu (); // Main menu
	    if (menu.equals ("1")) // Menu option 1
	    {
		levelOne (); // Level one method
	    }
	    else if (menu.equals ("2")) // Menu option 2
	    {
		levelTwo (); // Level Two Method
	    }
	    else if (menu.equals ("3")) // Menu option 3
	    {
		levelThree (); // Level Three Method
	    }
	    else if (menu.equals ("4")) // Menu option 4
	    {
		help (); // Help method
	    }
	    else if (menu.equals ("5")) // Menu option 5
	    {
		highScoresDisplay (); // High Scores
	    }
	    else // Menu option 6
	    {
		break; // Exits loop
	    }
	}
	AudioPlayer.player.stop (audioStream); // Stops the music
	goodBye (); // Goodbye option
    } // Culimating_JasonYou class
}
