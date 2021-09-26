/**
 * Welcome to level 3!
 * in this level there is no ai... BUT random.math included
 * good luck wining this level... Yes you need a lot of luck :) 
 */

package game.Levels.RPSLS;


/**
 * guess
 */
public class level3 {
    
    public static String AiChoice;
    public static int yourScore = 0;
    public static int aiScore = 0;

    static int rock = 0,
    paper = 0,
    scissor = 0,
    lizard = 0,
    spock = 0;

    public String comment;
    game.comment com = new game.comment();
    
    public static void luck() {

        double picking = (int)(Math.random()*5) + 1;// 1 - 5

        switch ((int)picking) {
            case 1:
                AiChoice = "Rock";
                rock++;  
            break;

            case 2:
                AiChoice = "Paper";
                paper++;
            break;

            case 3:
                AiChoice = "Scissor";
                scissor++;
            break;

            case 4:
                AiChoice = "Lizard";
                lizard++;
            break;

            case 5:
                AiChoice = "Spock";
                spock++;
            break;
        
            default: System.out.println("Error something went wrong, please re-run the code, and report this issue.");
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
}