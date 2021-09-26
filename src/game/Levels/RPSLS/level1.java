/**
 * Welcome to the level 1!
 * in this level there is no ai, nor mathrandom... 
 * good luck wining this level... NO LUCK NEEDED ;)
 */

package game.Levels.RPSLS;

/**
 * level1
 */
public class level1 {

    public static String AiChoice;
    public static int yourScore = 0, aiScore = 0;

    public static int rock = 0 ,
    paper = 0, 
    scissor = 0, 
    lizard = 0,
    spock = 0;

    static double random;

    public String comment;
    game.comment com = new game.comment();

    public static void calc(String weapon) {
        switch (weapon) {
            case "1"://rock
                ROLL_THE_DICE();
                switch ((int)random) {
                    case 1:
                        AiChoice = "Scissor";
                        scissor++;
                    break;
                    
                    case 2:
                        AiChoice = "Lizard";
                        lizard++;
                    break;

                    default: System.out.println("ERROR! something gone wrong, please try again");
                    break;
                }
            break;

            case "2"://paper
                ROLL_THE_DICE();
                switch ((int)random) {
                    case 1:
                        AiChoice = "Rock";
                        rock++;
                    break;
                    
                    case 2:
                        AiChoice = "Spock";
                        spock++;
                    break;

                    default: System.out.println("ERROR! something gone wrong, please try again");
                    break;
                }
                break;
                
            case "3"://scissor
                ROLL_THE_DICE();
                switch ((int)random) {
                    case 1:
                        AiChoice = "Paper";
                        paper++;
                    break;
                    
                    case 2:
                        AiChoice = "Lizard";
                        lizard++;
                    break;

                    default: System.out.println("ERROR! something gone wrong, please try again");
                    break;
                }
            break;
                    
            case "4"://lizard
                ROLL_THE_DICE();
                switch ((int)random) {
                    case 1:
                        AiChoice = "Paper";
                        paper++;
                    break;
                    
                    case 2:
                        AiChoice = "Spock";
                        spock++;
                    break;

                    default: System.out.println("ERROR! something gone wrong, please try again");
                    break;
                }
            break;
                        
            case "5"://spock
                ROLL_THE_DICE();
                switch ((int)random) {
                    case 1:
                        AiChoice = "Scissor";
                        scissor++;
                    break;
                    
                    case 2:
                        AiChoice = "Rock";
                        rock++;
                    break;

                    default: System.out.println("ERROR! something gone wrong, please try again");
                    break;
                }
            break;
        
            default: System.out.println("Oops! something gone wrong");
            break;
        }
    }

    public String winOrLose(String me, String ai) {
         if (me.equalsIgnoreCase("rock")){//rock
            if (ai.equalsIgnoreCase("rock")) {
                return "tie";

            } else if (ai.equalsIgnoreCase("paper")){
                aiScore++;
                comment = com.rock_paper;
                return "lose";

            } else if (ai.equalsIgnoreCase("scissor")){
                yourScore++;
                comment = com.rock_scissor;
                return "win";

            } else if (ai.equalsIgnoreCase("lizard")){
                yourScore++;
                comment = com.rock_lizard;
                return "win";

            } else if (ai.equalsIgnoreCase("spock")){
                aiScore++;
                comment = com.rock_spock;
                return "lose";

            } else {
                return "someting went wrong";
            }

        } else if (me.equalsIgnoreCase("paper")){//paper
            if (ai.equalsIgnoreCase("rock")) {
                yourScore++;
                comment = com.paper_rock;
                return "win";

            } else if (ai.equalsIgnoreCase("paper")){
                return "tie";

            } else if (ai.equalsIgnoreCase("scissor")){
                aiScore++;
                comment = com.paper_scissor;
                return "lose"; 
                
            } else if (ai.equalsIgnoreCase("lizard")){
                aiScore++;
                comment = com.rock_lizard;
                return "lose";

            } else if (ai.equalsIgnoreCase("spock")){
                yourScore++;
                comment = com.paper_spock;
                return "win";

            } else {
                return "someting went wrong";
            }

        } else if (me.equalsIgnoreCase("scissor")) {//scissor
            if (ai.equalsIgnoreCase("rock")) {
                aiScore++;
                comment = com.scissor_rock;
                return "lose";

            } else if (ai.equalsIgnoreCase("paper")){
                yourScore++;
                comment = com.scissor_paper;
                return "win";

            } else if (ai.equalsIgnoreCase("scissor")){
                return "tie";

            } else if (ai.equalsIgnoreCase("lizard")){
                yourScore++;
                comment = com.scissor_lizard;
                return "win";

            } else if (ai.equalsIgnoreCase("spock")){
                aiScore++;
                comment = com.scissor_spock;
                return "lose";

            } else {
                return "someting went wrong";
            }
        } else if (me.equalsIgnoreCase("lizard")) {//lizard
            if (ai.equalsIgnoreCase("rock")) {
                aiScore++;
                comment = com.lizard_rock;
                return "lose";

            } else if (ai.equalsIgnoreCase("paper")){
                yourScore++;
                comment = com.lizard_paper;
                return "win";

            } else if (ai.equalsIgnoreCase("scissor")){
                aiScore++;
                comment = com.lizard_scissor;
                return "lose";

            } else if (ai.equalsIgnoreCase("lizard")){
                return "tie";

            } else if (ai.equalsIgnoreCase("spock")){
                yourScore++;
                comment = com.lizard_spock;
                return "win";

            } else {
                return "someting went wrong";
            }
        } else if (me.equalsIgnoreCase("spock")) {//spock
            if (ai.equalsIgnoreCase("rock")) {
                yourScore++;
                comment = com.spock_rock;
                return "win";

            } else if (ai.equalsIgnoreCase("paper")){
                aiScore++;
                comment = com.spock_paper;
                return "lose";

            } else if (ai.equalsIgnoreCase("scissor")){
                yourScore++;
                comment = com.spock_scissor;
                return "win";

            } else if (ai.equalsIgnoreCase("lizard")){
                aiScore++;
                comment = com.spock_lizard;
                return "lose";

            } else if (ai.equalsIgnoreCase("spock")){
                return "tie";

            } else {
                return "someting went wrong";
            }//ends spock
        } else {
            return "Try again, something went wrong";
        } 
    }

    public String scoreBoard() {
        return "  [Score: " + yourScore + " - " + aiScore + "]";
    }

    public static void ROLL_THE_DICE() {
        random = (int)(Math.random()*2)+1; //1 - 2;
    }
}