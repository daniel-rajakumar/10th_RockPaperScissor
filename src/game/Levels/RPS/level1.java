/**
 * Welcome to the level 1!
 * in this level there is no ai, nor mathrandom... 
 * good luck wining this level... NO LUCK NEEDED ;)
 */

package game.Levels.RPS;

/**
 * level1
 */
public class level1 {

    public static String AiChoice;
    public static int yourScore = 0, aiScore = 0;

    public static int rock = 0,
    paper = 0,
    scissor = 0;

    public String comment;
    game.comment com = new game.comment();


    public static void calc(String weapon) {
        switch (weapon) {
            case "1":
                AiChoice = "Scissor";
                scissor++;
            break;

            case "2":
                AiChoice = "Rock";
                rock++;
            break;

            case "3":
                AiChoice = "Paper";
                paper++;
            break;
        
            default: System.out.println("Oops! something gone wrong");
            break;
        }
    }

    public String winOrLose(String me, String ai) {
         if (me.equalsIgnoreCase("rock")){
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
            } else {
                return "someting went wrong";
            }

        } else if (me.equalsIgnoreCase("paper")){
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
            } else {
                return "someting went wrong";
            }

        } else if (me.equalsIgnoreCase("scissor")) {
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
            } else {
                return "someting went wrong";
            }
        } else {
            return "Try again, something went wrong";
        } 
    }

    public String scoreBoard() {
        return "  [Score: " + yourScore + " - " + aiScore + "]";
    }
}