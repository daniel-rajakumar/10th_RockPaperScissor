//dec 17, 2019

/**
 * MAIN SOURCES I USED:
 * https://www.youtube.com/watch?v=lSgyFO7xoh0 - the idea for my ai
 * https://www.youtube.com/watch?v=rudzYPHuewc - human physiology idea for level 5
 * 
 * CLEAR_SCREEN() IDEA - https://stackoverflow.com/questions/2979383/java-clear-the-console (LINE 667 - 677)
 */

/**
 *  Write a program that allows the user to play a game of Rock-Paper-Scissors against the computer.
 *  The program should run 3 rounds and determine a winner based on a best of 3 series.
 *  You can use if statements to determine the winner after each round and after 3 games.
 *  However, you should be using Switch Statements as your main method of execution for the rest of the program.
 *  The program should output the round number before each match.
 *  The computer’s move can be determined by generating a random number between 1 and 3 -
 *  and correlating to the RPS throw (rock, paper, or scissors).
 *  This is your chance to be creative with your program! 
 * 
 * Apply a difficulty rating that will allow the computer to cheat on a certain percentage of turns.
 * Allow the user to enter the difficulty level at the beginning of the program. (Must affect program outcome in some way)
 * Extend game to be rock paper scissors lizard spock.
 */
package game;
import java.io.IOException;
import java.util.Scanner;

public class rockPaperScissor {

    static int TYPEWRITE_SPEED = 25, // if you don't want typewriting effort than just change this value to "0"
    ASK_QUESTION_DELAY = 1000;// this avoid people from spamming! (1000 = 1second). if you don't want any
                              // delay and want to spam... change this to "0"

    private static Scanner enter = new Scanner(System.in);

    static String level1 = "Everything is possiable(mercy)",
    level2 = "Careless(ai)",
    level3 = "Pure Luck(random)",
    level4 = "Tricky(ai)",
    level5 = "Dr. tricky(ai) :)",
    level6 = "Everything is impossiable(no mercy)";

    static double YOUR_SCORE, AI_SCORE;
    static String YOUR_CHOICE, AI_CHOICE, PATH, LEVEL_NUM, your_weapon;
    static int best_of;
    
    public static void main(String[] args) throws Exception {

        typewrite("Hello there, welcome to the game of Rock, Paper, Scissor!\n\n" , TYPEWRITE_SPEED);

        typewrite("Press 1 to start \n"  
                + "Press 2 for help/about/tips \n"
                + "enter: ",TYPEWRITE_SPEED);
        String main_menu = enter.nextLine();
        switch (main_menu) {
            case "1":
                //question#1
                CLEAR_SCREEN();
                typewrite("\n\nwhat kind of game would you like to play?\n" 
                                + "(1)Rock, Paper, Scissor\n"  
                                + "(2)Rock, Paper, Scissor, Lizard, Spock\n"
                                + "Enter the type of game: " , TYPEWRITE_SPEED);
        
                String gameType = enter.nextLine();
                switch (gameType) {
                    case "1"://RPS
                        PATH = "RPS";
                        question2();
                    break;
                    
                    case "2"://RPSLS
                        PATH = "RPSLS";
                        question2();
                    break;
                
                    default: System.out.println("Oops, something went wrong, please check your input");
                    break;
                }//game type switch ends  
            break;

            case "2":
                about info = new about();
                typewrite(info.help, TYPEWRITE_SPEED/2);
            break;
        
            default: typewrite("Oops try again", TYPEWRITE_SPEED);
            break;
        }


    }

    //question #2
    public static void question2() {
        CLEAR_SCREEN();
        typewrite("\n\nWhat level do you like to play?\n"  
                        +  "(1) " + level1 + "\n"
                        +  "(2) " + level2 + "\n"
                        +  "(3) " + level3 + "\n"
                        +  "(4) " + level4 + "\n"
                        +  "(5) " + level5 + "\n"
                        +  "(6) " + level6 + "\n"
                        +  "Enter the level: ", TYPEWRITE_SPEED);
        String gameLvl = enter.nextLine();
        switch (gameLvl) {
            case "1":
                LEVEL_NUM = "1";
                question3();
            break;
            
            case "2":
                LEVEL_NUM = "2";
                question3();
            break;
            
            case "3":
                LEVEL_NUM = "3";
                question3();
            break;
            
            case "4":
                LEVEL_NUM = "4";
                question3();
            break;
            
                
            case "5":
                LEVEL_NUM = "5";
                question3();
            break;  
            
            case "6":
                LEVEL_NUM = "6";
                question3();
            break;    
        
            default: System.out.println("Oops check your spelling");
            break;
        }
    }

    //question#3
    public static void question3() {
        CLEAR_SCREEN();
        typewrite("\n\nFirst to? ", TYPEWRITE_SPEED);
        best_of = enter.nextInt();
        enter.nextLine();
        do {
            switch (PATH) {
                case "RPS":
                    switch (LEVEL_NUM) {
                        case "1":
                            YOUR_SCORE = game.Levels.RPS.level1.yourScore;
                            AI_SCORE = game.Levels.RPS.level1.aiScore;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n");
                            your_weapon = enter.nextLine();
                            CLEAR_SCREEN();
                            RPS_lvl1(your_weapon);
                        break;

                        case "2":
                            YOUR_SCORE = game.Levels.RPS.level2.your_score;
                            AI_SCORE = game.Levels.RPS.level2.ai_score;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n");
                            RPS_lvl2();    
                        break;

                        case "3":
                            YOUR_SCORE = game.Levels.RPS.level3.yourScore;
                            AI_SCORE = game.Levels.RPS.level3.aiScore;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n");
                            your_weapon = enter.nextLine();
                            CLEAR_SCREEN();
                            RPS_lvl3(your_weapon);
                        break;

                        case "4":
                            YOUR_SCORE = game.Levels.RPS.level4.your_score;
                            AI_SCORE = game.Levels.RPS.level4.ai_score;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n");
                            RPS_lvl4(); 
                        break;

                        case "5":
                            YOUR_SCORE = game.Levels.RPS.level5.your_score;
                            AI_SCORE = game.Levels.RPS.level5.ai_score;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n");
                            RPS_lvl5();   
                        break;

                        case "6":
                            YOUR_SCORE = game.Levels.RPS.level6.yourScore;
                            AI_SCORE = game.Levels.RPS.level6.aiScore;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n");
                            your_weapon = enter.nextLine();
                            CLEAR_SCREEN();
                            RPS_lvl6(your_weapon);
                        break;
                    
                        default: System.out.println("Oops! somthing gone wrong");
                        break;
                    }
                break;

                case "RPSLS":
                    switch (LEVEL_NUM) {
                        case "1":
                            YOUR_SCORE = game.Levels.RPSLS.level1.yourScore;
                            AI_SCORE = game.Levels.RPSLS.level1.aiScore;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n" 
                                            +  "(4)Lizard   \n" 
                                            +  "(5)spock    \n");
                            your_weapon = enter.nextLine();
                            CLEAR_SCREEN();
                            RPSLS_lvl1(your_weapon);
                        break;

                        case "2":
                            YOUR_SCORE = game.Levels.RPSLS.level2.your_score;
                            AI_SCORE = game.Levels.RPSLS.level2.ai_score;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n" 
                                            +  "(4)Lizard   \n" 
                                            +  "(5)spock    \n");                                         
                            RPSLS_lvl2();      
                        break;

                        case "3":
                            YOUR_SCORE = game.Levels.RPSLS.level3.yourScore;
                            AI_SCORE = game.Levels.RPSLS.level3.aiScore;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n" 
                                            +  "(4)Lizard   \n" 
                                            +  "(5)spock    \n");
                            your_weapon = enter.nextLine();
                            CLEAR_SCREEN();
                            RPSLS_lvl3(your_weapon);
                        break;

                        case "4":
                            YOUR_SCORE = game.Levels.RPSLS.level4.your_score;
                            AI_SCORE = game.Levels.RPSLS.level4.ai_score;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n" 
                                            +  "(4)Lizard   \n" 
                                            +  "(5)spock    \n");
                            RPSLS_lvl4();                          
                        break;

                        case "5"://RPSLS DONE
                            YOUR_SCORE = game.Levels.RPSLS.level5.your_score;
                            AI_SCORE = game.Levels.RPSLS.level5.ai_score;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n" 
                                            +  "(4)Lizard   \n" 
                                            +  "(5)spock    \n");
                            RPSLS_lvl5();                          
                        break;

                        case "6":
                            YOUR_SCORE = game.Levels.RPSLS.level6.yourScore;
                            AI_SCORE = game.Levels.RPSLS.level6.aiScore;
                            System.out.println("(1)Rock     \n" 
                                            +  "(2)Paper    \n" 
                                            +  "(3)Scissor  \n" 
                                            +  "(4)Lizard   \n" 
                                            +  "(5)spock    \n");
                            your_weapon = enter.nextLine();
                            CLEAR_SCREEN();
                            RPSLS_lvl6(your_weapon);
                        break;
                    
                        default: System.out.println("Oops! somthing gone wrong");
                        break;
                    }
                break;
            
                default: System.out.println("something gone wrong");
                break;
            }
        wait(ASK_QUESTION_DELAY);//I set this to delay 1s
        System.out.println("+----------------+----------------+----------------+----------------+----------------+----------------+----------------");

        } while ((best_of > YOUR_SCORE) && (best_of > AI_SCORE));

        if (YOUR_SCORE > AI_SCORE) {
            CLEAR_SCREEN();
            System.out.println("Congurations! You win!");
            typewrite(winner_award, (TYPEWRITE_SPEED/3));
        } else if (AI_SCORE > YOUR_SCORE) {
            CLEAR_SCREEN();
            System.out.println("Congurations! You lose!");
            typewrite(loser_award, (TYPEWRITE_SPEED/3));
        } else {
            System.out.println("TIE!");
        }
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////STARTS METHODS//////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////Rock paper scissor PATH////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void RPS_lvl1(String weapon) {

        game.Levels.RPS.level1.calc(your_weapon);
        String AiChoice = game.Levels.RPS.level1.AiChoice;
        game.Levels.RPS.level1 lvl1 = new game.Levels.RPS.level1();

        if(your_weapon.equals("1")){//i choose rock
            weapon = "Rock";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl1.winOrLose(weapon, AiChoice) + "}==" + lvl1.scoreBoard() + "\n"
                                + lvl1.comment + "\n");
    
        } else if(your_weapon.equals("2")) {//i choose paper
            weapon = "Paper";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl1.winOrLose(weapon, AiChoice) + "}==" + lvl1.scoreBoard() + "\n"
                                + lvl1.comment + "\n");
    
        } else if(your_weapon.equals("3")){//i choose scissor
            weapon = "Scissor";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl1.winOrLose(weapon, AiChoice) + "}==" + lvl1.scoreBoard() + "\n"
                                + lvl1.comment + "\n");
    
        } else {
            System.out.println("uh-oh... check your spelling");
        }
    }

    public static void RPS_lvl2() {
        your_weapon = enter.nextLine();
        CLEAR_SCREEN();
        if (your_weapon.equals("1")) {
            game.Levels.RPS.level2.rock();
            
        } else if (your_weapon.equals("2")) {
            game.Levels.RPS.level2.paper();
            
        } else if (your_weapon.equals("3")) {
            game.Levels.RPS.level2.scissor();

        } else {
            System.out.println("Oops, something gone wrong");
        }
    }
    
    public static void RPS_lvl3(String weapon) {
        game.Levels.RPS.level3.luck();
        String AiChoice = game.Levels.RPS.level3.AiChoice;
        game.Levels.RPS.level3 lvl3 = new game.Levels.RPS.level3();

        if(your_weapon.equals("1")){//i choose rock
            game.Levels.RPS.level3.luck();
            weapon = "Rock";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl3.winOrLose(weapon, AiChoice) + "}==" + lvl3.scoreBoard() + "\n"
                                + lvl3.comment + "\n");
    
        } else if(your_weapon.equals("2")) {//i choose paper
            game.Levels.RPS.level3.luck();
            weapon = "Paper";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl3.winOrLose(weapon, AiChoice) + "}==" + lvl3.scoreBoard() + "\n"
                                + lvl3.comment + "\n");

        } else if(your_weapon.equals("3")){//i choose scissor
            game.Levels.RPS.level3.luck();
            weapon = "Scissor";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl3.winOrLose(weapon, AiChoice) + "}==" + lvl3.scoreBoard() + "\n"
                                + lvl3.comment + "\n");

        } else {
            System.out.println("uh-oh... please check your spelling");
        }
    }

    public static void RPS_lvl4() {
        your_weapon = enter.nextLine();
        CLEAR_SCREEN();
        if (your_weapon.equals("1")) {
            game.Levels.RPS.level4.rock();
            
        } else if (your_weapon.equals("2")) {
            game.Levels.RPS.level4.paper();
            
        } else if (your_weapon.equals("3")) {
            game.Levels.RPS.level4.scissor();

        } else {
            System.out.println("Oops, something gone wrong");
        }
    }

    public static void RPS_lvl5() {
        your_weapon = enter.nextLine();
        CLEAR_SCREEN();
        if (your_weapon.equals("1")) {
            game.Levels.RPS.level5.rock();
            
        } else if (your_weapon.equals("2")) {
            game.Levels.RPS.level5.paper();
            
        } else if (your_weapon.equals("3")) {
            game.Levels.RPS.level5.scissor();

        } else {
            System.out.println("Oops, something gone wrong");
        }
    }


    
    public static void RPS_lvl6(String weapon) {

        game.Levels.RPS.level6.calc(your_weapon);
        String AiChoice = game.Levels.RPS.level6.AiChoice;
        game.Levels.RPS.level6 lvl6 = new game.Levels.RPS.level6();

        if(your_weapon.equals("1")){//i choose rock
            weapon = "Rock";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl6.winOrLose(weapon, AiChoice) + "}==" + lvl6.scoreBoard() + "\n"
                                + lvl6.comment + "\n");
                                
        } else if(your_weapon.equals("2")) {//i choose paper
            weapon = "Paper";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl6.winOrLose(weapon, AiChoice) + "}==" + lvl6.scoreBoard() + "\n"
                                + lvl6.comment + "\n");

        } else if(your_weapon.equals("3")){//i choose scissor
            weapon = "Scissor";
             System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl6.winOrLose(weapon, AiChoice) + "}==" + lvl6.scoreBoard() + "\n"
                                + lvl6.comment + "\n");

        } else {
            System.out.println("uh-oh... check your spelling");
        }
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////Rock paper scissor lizard spock PATH///////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void RPSLS_lvl1(String weapon) {

        game.Levels.RPSLS.level1.calc(your_weapon);
        String AiChoice = game.Levels.RPSLS.level1.AiChoice;
        game.Levels.RPSLS.level1 lvl1 = new game.Levels.RPSLS.level1();

        if(your_weapon.equals("1")){//i choose rock
            weapon = "Rock";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl1.winOrLose(weapon, AiChoice) + "}==" + lvl1.scoreBoard() + "\n"
                                + lvl1.comment + "\n");

        } else if(your_weapon.equals("2")) {//i choose paper
            weapon = "Paper";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl1.winOrLose(weapon, AiChoice) + "}==" + lvl1.scoreBoard() + "\n"
                                + lvl1.comment + "\n");

        } else if(your_weapon.equals("3")){//i choose scissor
            weapon = "Scissor";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl1.winOrLose(weapon, AiChoice) + "}==" + lvl1.scoreBoard() + "\n"
                                + lvl1.comment + "\n");

        } else if(your_weapon.equals("4")){//i choose scissor
            weapon = "Lizard";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl1.winOrLose(weapon, AiChoice) + "}==" + lvl1.scoreBoard() + "\n"
                                + lvl1.comment + "\n");

        } else if(your_weapon.equals("5")){//i choose scissor
            weapon = "Spock";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl1.winOrLose(weapon, AiChoice) + "}==" + lvl1.scoreBoard() + "\n"
                                + lvl1.comment + "\n");

        } else {
            System.out.println("uh-oh... check your spelling");
        }
    }
    
    public static void RPSLS_lvl2() {
        your_weapon = enter.nextLine();
        CLEAR_SCREEN();
        if (your_weapon.equals("1")) {
            game.Levels.RPSLS.level2.rock();
            
        } else if (your_weapon.equals("2")) {
            game.Levels.RPSLS.level2.paper();
            
        } else if (your_weapon.equals("3")) {
            game.Levels.RPSLS.level2.scissor();

        } else if (your_weapon.equals("4")) {
            game.Levels.RPSLS.level2.lizard();
            
        } else if (your_weapon.equals("5")) {
            game.Levels.RPSLS.level2.spock();
            
        } else {
            System.out.println("Oops, something gone wrong");
        }
    }

    public static void RPSLS_lvl3(String weapon) {
        game.Levels.RPSLS.level3.luck();
        String AiChoice = game.Levels.RPSLS.level3.AiChoice;
        game.Levels.RPSLS.level3 lvl3 = new game.Levels.RPSLS.level3();

        if(your_weapon.equals("1")){//i choose rock
            game.Levels.RPSLS.level3.luck();
            weapon = "Rock";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl3.winOrLose(weapon, AiChoice) + "}==" + lvl3.scoreBoard() + "\n"
                                + lvl3.comment + "\n");

        } else if(your_weapon.equals("2")) {//i choose paper
            game.Levels.RPSLS.level3.luck();
            weapon = "Paper";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl3.winOrLose(weapon, AiChoice) + "}==" + lvl3.scoreBoard() + "\n"
                                + lvl3.comment + "\n");

        } else if(your_weapon.equals("3")){//i choose scissor
            game.Levels.RPSLS.level3.luck();
            weapon = "Scissor";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl3.winOrLose(weapon, AiChoice) + "}==" + lvl3.scoreBoard() + "\n"
                                + lvl3.comment + "\n");

        } else if(your_weapon.equals("4")) {//i choose lizard
            game.Levels.RPSLS.level3.luck();
            weapon = "Paper";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl3.winOrLose(weapon, AiChoice) + "}==" + lvl3.scoreBoard() + "\n"
                                + lvl3.comment + "\n");

        } else if(your_weapon.equals("5")) {//i choose spock
            game.Levels.RPSLS.level3.luck();
            weapon = "Paper";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl3.winOrLose(weapon, AiChoice) + "}==" + lvl3.scoreBoard() + "\n"
                                + lvl3.comment + "\n");
        } else {
            System.out.println("uh-oh... please check your spelling");
        }
    }

    public static void RPSLS_lvl4() {
        your_weapon = enter.nextLine();
        CLEAR_SCREEN();
        if (your_weapon.equals("1")) {
            game.Levels.RPSLS.level4.rock();
            
        } else if (your_weapon.equals("2")) {
            game.Levels.RPSLS.level4.paper();
            
        } else if (your_weapon.equals("3")) {
            game.Levels.RPSLS.level4.scissor();

        } else if (your_weapon.equals("4")) {
            game.Levels.RPSLS.level4.lizard();
            
        } else if (your_weapon.equals("5")) {
            game.Levels.RPSLS.level4.spock();
            
        } else {
            System.out.println("Oops, something gone wrong");
        }
    }
    
    
    public static void RPSLS_lvl5() {
        your_weapon = enter.nextLine();
        CLEAR_SCREEN();
        if (your_weapon.equals("1")) {
            game.Levels.RPSLS.level5.rock();
            
        } else if (your_weapon.equals("2")) {
            game.Levels.RPSLS.level5.paper();
            
        } else if (your_weapon.equals("3")) {
            game.Levels.RPSLS.level5.scissor();

        } else if (your_weapon.equals("4")) {
            game.Levels.RPSLS.level5.lizard();
            
        } else if (your_weapon.equals("5")) {
            game.Levels.RPSLS.level5.spock();
            
        } else {
            System.out.println("Oops, something gone wrong");
        }
    }
    
    public static void RPSLS_lvl6(String weapon) {

        game.Levels.RPSLS.level6.calc(your_weapon);
        String AiChoice = game.Levels.RPSLS.level6.AiChoice;
        game.Levels.RPSLS.level6 lvl6 = new game.Levels.RPSLS.level6();

        if(your_weapon.equals("1")){//i coose rock
            weapon = "Rock";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl6.winOrLose(weapon, AiChoice) + "}==" + lvl6.scoreBoard() + "\n"
                                + lvl6.comment + "\n");

        } else if(your_weapon.equals("2")) {//i choose paper
            weapon = "Paper";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl6.winOrLose(weapon, AiChoice) + "}==" + lvl6.scoreBoard() + "\n"
                                + lvl6.comment + "\n");

        } else if(your_weapon.equals("3")){//i choose scissor
            weapon = "Scissor";
            System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl6.winOrLose(weapon, AiChoice) + "}==" + lvl6.scoreBoard() + "\n"
                                + lvl6.comment + "\n");

        } else if(your_weapon.equals("4")){//i choose scissor
            weapon = "Lizard";
             System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl6.winOrLose(weapon, AiChoice) + "}==" + lvl6.scoreBoard() + "\n"
                                + lvl6.comment + "\n");

        } else if(your_weapon.equals("5")){//i choose scissor
            weapon = "Spock";
             System.out.println("you choose " + weapon + " and I choose " + AiChoice + "=={" + lvl6.winOrLose(weapon, AiChoice) + "}==" + lvl6.scoreBoard() + "\n"
                                + lvl6.comment + "\n");

        } else {
            System.out.println("uh-oh... check your spelling");
        }
    }

    public static void typewrite(String name, int speed) {
        for (int i = 0; i < name.length(); i++) {
            System.out.printf("%c", name.charAt(i));

            try{
                Thread.sleep(speed);//(1 = 1ms)=(1000 = 1s) 
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void wait(int time) {
        try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    public static void CLEAR_SCREEN(){  
        try {
            if (System.getProperty("os.name").contains("Windows")){//checking the OS wheater it is windows
                new ProcessBuilder("cmd", "/c", "cls" /**giving access to java to invoking command(local/build-in commands) */).inheritIO().start(/**i gave access to java to invok cmd, now this check wheater cmd is a valid command system and creates a new process attribute */).waitFor(/**this let this thread to wait until the next process begans */);
            } else{
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
            //none
        }
    } 

    private static String 
        loser_award =
            "     (  )   (   )  )\n"
        +  "      ) (   )  (  ( \n"     
        +  "      ( )  (    ) ) \n"
        +  "      _____________ \n"
        +  "     <_____________> ____\n"
        +  "     |             |/ _  \\ \n"
        +  "     |    JAVA       | | | \n"
        +  "     |   COFFEE      |_| | \n"
        +  "  ___|             |\\____/  \n"
        +  " /    \\___________/    \\ \n"
        +  " \\_____________________/ \n"
        +  "\n",

        winner_award = 
        "     _______________ \n"
        +"    |++++|     |####| \n"
        +"    |++++|     |####| \n"
        +"    |++++|     |####| \n"
        +"    \\++++|     |####/\n"
        +"     \\+++|     |###/ \n"
        +"      `++|_____|##' \n"
        +"           (O) \n"
        +"        .-'''''-. \n"
        +"      .'  * * *  `. \n"
        +"     :  *       *  : \n"
        +"    : ~ C H A M P ~ : \n"
        +"    : ~ A W A R D ~ : \n"
        +"     :  *       *  : \n"
        +"      `.  * * *  .' \n"
        +"        `-.....-' \n"
        +" \n";
    
}//ends rock paper scissor game :)

