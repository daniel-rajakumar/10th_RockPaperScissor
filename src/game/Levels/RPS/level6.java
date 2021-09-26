package game.Levels.RPS;

/**
 * level6
 */
public class level6 {

    public static String AiChoice;
    public static int yourScore = 0;
    public static int aiScore = 0;

    public static int rock = 0;
    public static int paper = 0;
    public static int scissor = 0;

    public String comment;

    game.comment com = new game.comment();

    public static void calc(String weapon) {

            if (weapon.equals("1")) {//rock
                AiChoice = "Paper";
                paper++;
                
            } else if (weapon.equals("2")) {//paper
                AiChoice = "Scissor";
                scissor++;
                
            } else if (weapon.equals("3")) {//scissor
                AiChoice = "Rock";
                rock++;
                 
            } else {
                System.out.println("Error something went wrong, please re-run the code, and report this issue.");
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