/**
 * welcome to RPSLS level 5
 * for reading the code purposes I did not use any methods inside rock()... 
 * for understanding how this ai works, just read rock() and maybe spock because spock is the special weapon.
 * level 5 ai... I added some physiology in it... 
 * good luck wining this level!
 */

package game.Levels.RPSLS;

/**
 * RPSLS
 * level5
 */

public class level5 { 

    static double chance = 100;//total %
    static int NumOfWeapons = 5;// # of weapons in (rock, paper, scissor, lizard, and spock)

    //weapons chances
    static double rock_Chance = 20,
    paper_Chance = 20,
    scissor_Chance = 20,
    lizard_Chance = 20,
    spock_Chance;// no value for spock... spock takes the reminding % 
    //(spock formula = 100 - (rock_Chance + paper_Chance + scissor_Chance + lizard_Chance))
 
    //data
    static double rock_Count = 0,
    paper_Count = 0,
    scissor_Count = 0,
    lizard_Count = 0,
    spock_Count = 0;
    
    //data (style of result)
    static double rep_win = 1,
    rep_tie = 1,
    rep_lose = 1;
    
    static double alt_win = 0,
    alt_tie = 0,
    alt_lose = 0;
    
    static double confident = 5,
    confident_value = 4;

    static double forget = 1;
    static int forgetValue = 2;
    
    //picking random number
    static double random;
    
    //static
    static String your_weapon,
    ai_weapon,
    result;
    
    //score
    public static double your_score = 0,
    ai_score = 0;
    
    //tracking history of players last move
    static String last_move = "none";
    static double history_result; 
    
    //balancing the % of chances 
    static int 
    win_max_chance = 35,
    win_max_value_stay = 30,
    lose_max_chance = 35,
    lose_max_value_stay = 30,
    
    tie_max_chance = 20,
    tie_max_value_stay = 20,
    tie_min_chance = 20,
    tie_min_value_stay= 20,
    
    win_min_chance = 5,
    win_min_value_stay = 10,
    lose_min_chance = 5,
    lose_min_value_stay = 10;

    //clac total overall % (win,tie,lose)
    static double win_pred,
    tie_pred,
    lose_pred;

    public static String comment;
    static game.comment com = new game.comment();

    //Rock starts
    public static void rock() {
        spock_Chance = 100 - (rock_Chance + paper_Chance + scissor_Chance + lizard_Chance);//updating the spock's value
        rock_Count++;
        your_weapon = "rock";
            
        random = (int)(Math.random()*chance)+1; //select numbers randomly from 1 - 100


        if (random < rock_Chance) {//(for the first time it is 1 - 20%)
            ai_weapon = "rock";
            result = "tie";

            //CHECKS WHAT TYPE OF PLAYER YOU ARE(WHEATHER YOU ARE CHOOSING SAME WEAPON EVERYTIME OR CHANING WEAPON) {
            if (last_move.equalsIgnoreCase(your_weapon)) {
                rep_tie++;
            } else {
                alt_tie++;
            }
            //}CHECKS WHAT TYPE OF PLAYER YOU ARE, ENDS

        } else if (random < (rock_Chance + paper_Chance)){ //(for the first time it is 21 - 40%)
            ai_weapon = "paper";
            result = "lose";
            comment = com.rock_paper; 
            ai_score++;
            confident++;
            history_result = 0;

            if (last_move.equalsIgnoreCase(your_weapon)) {
                rep_lose++;
            } else {
                alt_lose++;
            }
            
        } else if (random < (rock_Chance + paper_Chance + scissor_Chance)){ //(for the first time it is 41 - 60%)
            ai_weapon = "scissor";
            result = "win";
            comment = com.rock_scissor;
            your_score++;
            confident -= 2;
            history_result = 1;

            if (last_move.equalsIgnoreCase(your_weapon)) {
                rep_win++;
            } else {
                alt_win++;
            }
            
        } else if (random < (rock_Chance + paper_Chance + scissor_Chance + lizard_Chance)){//(for the first time it is 61 - 80%)
            ai_weapon = "lizard";
            result = "win";
            comment = com.rock_lizard;
            your_score++;
            confident -= 2;
            history_result = 1;

            if (last_move.equalsIgnoreCase(your_weapon)) {
                rep_win++;
            } else {
                alt_win++;
            }

        } else { //else if (random > (rock_Chance + paper_Chance + scissor_Chance + lizard_Chance + spock_Chance)){//(for the first time it is 81 - 100%)
            ai_weapon = "spock";
            result = "lose";
            comment = com.rock_spock;
            ai_score++;
            confident++;
            history_result = 0;

            if (last_move.equalsIgnoreCase(your_weapon)) {
                rep_lose++;
            } else {
                alt_lose++;
            }//ends weapon
        }
        
        if(result.equalsIgnoreCase("lose")){//what happen if you lose(ai wins)
            //the player is choosing different weapon everytime... 
            //for-the-reason chance every weapon's chance opposite way 
            //(incress the lossing weapon chance & decress the wining weapon chances)
            if (alt_lose > rep_lose) {//if you are playing in alternate stype then do this....
                paper_Chance -= confident;//decress paper chance by confident lvl, so paper has less time to beat me.
                spock_Chance -= confident;//decress spock chance by confident lvl, so spock has less time to beat me.
                rock_Chance -= (confident/2.0);//incress a little bit of rock chance, so there could be atleast some draws there.
                scissor_Chance += confident /  confident_value;//incress a fraction of scissor chance by confident lvl, so scissor has higher chance to lose against me.
                lizard_Chance += confident / confident_value;//incress a fraction of lizrd chance by confident lvl, so spock has higher chance to lose against me.

             //physiology_lose{ // for level 5 i added human physiology to make the ai more powerful
            if (your_weapon.equalsIgnoreCase("rock")) {
                rock_Chance -= 0;
                paper_Chance += 0;
                scissor_Chance += 0;
                lizard_Chance += 0;
                spock_Chance += 0;
        
            } else if (your_weapon.equalsIgnoreCase("paper")) {
                rock_Chance -= 2;//
                paper_Chance -= 2;//
                scissor_Chance += 5;
                lizard_Chance += 5;
                spock_Chance += 5;
        
            } else if (your_weapon.equalsIgnoreCase("scissor")) {
                rock_Chance -= 2;//
                paper_Chance += 5;
                scissor_Chance -= 2;//
                lizard_Chance += 5;
                spock_Chance += 5;
                    
            } else if (your_weapon.equalsIgnoreCase("lizard")) {
                rock_Chance -= 2;//
                paper_Chance += 5;
                scissor_Chance += 5;
                lizard_Chance -= 2;//
                spock_Chance += 5;
                    
            } else if (your_weapon.equalsIgnoreCase("spock")) {
                rock_Chance -= 2;//
                paper_Chance += 5;
                scissor_Chance += 5;
                lizard_Chance += 5;
                spock_Chance -= 2;//
                    
             } else {
                    System.out.println("Something wrong");
                }
            //} physiology_lose ends

            } else if(rep_lose > alt_lose){//if you keep on using the same weapon then this happen...
                //the player is choosing the same weapon everytime... 
                //for-the-reason chance chance every weapon's chance in correct way...
                //(incress the wining wepon chance & decress the lossing weapon chance)
                paper_Chance += confident;//incress (win)
                spock_Chance += confident;//incress  (win)
                rock_Chance += (confident/2.0);//incress a bit (ai to draw)
                lizard_Chance -= confident / confident_value; //decress a bit (loss)
                scissor_Chance -= confident / confident_value;//decress a bit (loss)
            }
        }//ends lose
        
        if(result.equalsIgnoreCase("win")){//what happend if the player win...(ai lose)
            if (alt_win > rep_win) {// if you press rock and win, and your previous move was not rock then do this...
                paper_Chance -= confident;
                spock_Chance -= confident;
                rock_Chance -= (confident/2.0);
                scissor_Chance += confident / confident_value;
                lizard_Chance += confident / confident_value;

                //physiology_win{ // for level 5 i added human physiology to make the ai more powerful
                if (your_weapon.equalsIgnoreCase("rock")) {
                    rock_Chance += 0;
                    paper_Chance -= 0;
                    scissor_Chance -= 0;
                    lizard_Chance -= 0;
                    spock_Chance -= 0;
        
                } else if (your_weapon.equalsIgnoreCase("paper")) {
                    rock_Chance -= 2;
                    paper_Chance += 5;//
                    scissor_Chance -= 2;
                    lizard_Chance -= 2;
                    spock_Chance -= 2;
        
                } else if (your_weapon.equalsIgnoreCase("scissor")) {
                    rock_Chance -= 2;
                    paper_Chance -= 2;
                    scissor_Chance += 5;//
                    lizard_Chance -= 2;
                    spock_Chance -= 2;
                    
                } else if (your_weapon.equalsIgnoreCase("lizard")) {
                    rock_Chance -= 2;
                    paper_Chance -= 2;
                    scissor_Chance -= 2;
                    lizard_Chance += 5;//
                    spock_Chance -= 2;
                    
                } else if (your_weapon.equalsIgnoreCase("spock")) {
                    rock_Chance -= 2;
                    paper_Chance -= 2;
                    scissor_Chance -= 2;
                    lizard_Chance -= 2;
                    spock_Chance += 5;//
        
                } else {
                    System.out.println("Something wrong");
                }
                //} physiology_win ends

            } else if(rep_win > alt_win){//if you press the rock again and win then do this...
                paper_Chance += confident;//wining weapon
                spock_Chance += confident;//wining weapon
                rock_Chance += (confident/2.0);//tying weapon
                lizard_Chance -= confident / confident_value;//losing weapon
                scissor_Chance -= confident / confident_value;//losing weapon
            }
        }//ends wins

        if(result.equalsIgnoreCase("tie")){//bascailly (do/change) nothing if it is a (tie/draw)
            if (alt_tie > rep_tie) {
                spock_Chance += 0;//win
                paper_Chance += 0;//win
                rock_Chance += 0;//tie
                lizard_Chance -= 0;//lose
                scissor_Chance -= 0;//lose
                
            } else if(rep_tie > alt_tie){
                paper_Chance -= 0;//win
                spock_Chance += 0;//win
                rock_Chance -= 0;//tie
                scissor_Chance += 0;//lose
                lizard_Chance += 0;//lose
            }
        }//ends tie

        /**
         * this make ai forget the previous player's move so it won't fall on human's trap like...
         * we could play rock,rock,rock, for several time, then quicky change to scissor then win everysingle time againt ai
         */
        if (alt_win > (rep_win + forget)) {
            alt_win -= forgetValue;//-2
        } if (rep_win > (alt_win + forget)) {
            rep_win -= forgetValue;//-2
        } if (alt_tie > (rep_tie + forget)) {
            alt_tie -= forgetValue;//-2
        } if (rep_tie > (alt_tie + forget)) {
            rep_tie -= forgetValue;//-2
        } if (alt_lose > (rep_lose + forget)) {
            alt_lose -= forgetValue;//-2
        } if (rep_lose > (alt_lose + forget)) {
            rep_lose -= forgetValue;//-2
        }

        /** 
        * this prevent weapon's chance to reach extremely (high/low) like 100% or 0%
        * this keeps the game balanced and fair
        * but changing this do not affect the ai that much...
        * since human intelligence and artifical intelligence do NOT think as same
        */
        if (paper_Chance > win_max_chance) {
            paper_Chance = win_max_value_stay; 
        } if (paper_Chance < win_min_chance) {
             paper_Chance = win_min_value_stay;
        }

        if (spock_Chance > win_max_chance) {
            spock_Chance = win_max_value_stay; 
        } if (spock_Chance < win_min_chance) {
            spock_Chance = win_min_value_stay;
        }

        if (rock_Chance > tie_max_chance) {
            rock_Chance = tie_max_value_stay; 
        } if (rock_Chance < tie_min_chance) {
            rock_Chance = tie_min_value_stay;
        }

        if (scissor_Chance > lose_max_chance) {
            scissor_Chance = lose_max_value_stay; 
        } if (scissor_Chance < lose_min_chance) {
            scissor_Chance = lose_min_value_stay;
        }
        
        if (lizard_Chance > lose_max_chance) {
            lizard_Chance = lose_max_value_stay; 
        } if (lizard_Chance < lose_min_chance) {
            lizard_Chance = lose_min_value_stay;
        }

        /**
         * this prevent confident level to reach negative... 
         * if condifent level reach negative then the whole process goes in opposite way...
         */
        if (confident < 1) {
            confident = 2;
        }
        
        //track of history 
        last_move = "rock";

        //updating the spock chance... everytime the rounds ends
        spock_Chance = 100 - (rock_Chance + paper_Chance + scissor_Chance + lizard_Chance);

        //this shows what ai's overall predicted on this current move
        win_pred = (scissor_Chance + lizard_Chance);
        tie_pred = rock_Chance;
        lose_pred = (paper_Chance + spock_Chance);

        /**
         * to show what ai is thinking and some other useful while playing the game infomation
         */
        System.out.println("You choose [" + your_weapon + "] and I choose [" + ai_weapon + "] Result [" + result + "]<=>[" + your_score + "]"+"<=>"+"["+ai_score+"]");
        System.out.println(comment);
        System.out.println();
        System.out.println("rock:\t\t"        + rock_Chance    + "%");
        System.out.println("paper:\t\t"       + paper_Chance   + "%");
        System.out.println("scissor:\t"       + scissor_Chance + "%");
        System.out.println("lizard:\t\t"      + lizard_Chance  + "%");
        System.out.println("spock:\t\t"       +  spock_Chance  + "%");
        System.out.println("confident level:" + confident);
        System.out.println();
        System.out.println("Overall chances:(player's result predictions) ");
        System.out.println("win:\t\t"  + win_pred);
        System.out.println("tie:\t\t"  + tie_pred);
        System.out.println("lose:\t\t" + lose_pred);
        System.out.println();

    }//ends rock

    //starts paper
    public static void paper() {
        update_spock_Chance();
        paper_Count++;
        your_weapon = "paper";
        ROLL_THE_DICE();

        if (random < rock_Chance) {
            ai_weapon = "rock";
            comment = com.paper_rock;
            win();
        } else if (random < (rock_Chance + paper_Chance)){ 
            ai_weapon = "paper";
            tie();
        } else if (random < (rock_Chance + paper_Chance + scissor_Chance)){ 
            ai_weapon = "scissor";
            comment = com.paper_scissor;
            lose();
        } else if (random < (rock_Chance + paper_Chance + scissor_Chance + lizard_Chance)){
            ai_weapon = "lizard";
            comment = com.paper_lizard;
            lose();
        } else { 
            ai_weapon = "spock";
            comment = com.paper_spock;
            win();
        }

        if(result.equalsIgnoreCase("lose")){
            if (alt_lose > rep_lose) {
                scissor_Chance -= confident;//win
                lizard_Chance -= confident;//win
                paper_Chance -= (confident/2.0);//tie
                rock_Chance += confident / confident_value;//lose
                spock_Chance += confident / confident_value;//lose
                physiology_lose_paper();                
                
            } else if(rep_lose > alt_lose){
                scissor_Chance += confident;//win
                lizard_Chance += confident;//win
                paper_Chance += (confident/2.0);//tie
                rock_Chance -= confident / confident_value;//lose
                spock_Chance -= confident / confident_value;//lose
            }
        }

        if(result.equalsIgnoreCase("win")){
            if (alt_win > rep_win) {
                scissor_Chance -= confident;//win
                lizard_Chance -= confident;//win
                paper_Chance -= (confident/2.0);//tie
                rock_Chance += confident / confident_value;;//lose
                spock_Chance += confident / confident_value;;//lose
                physiology_win_paper();
                 
            } else if(rep_win > alt_win){
                scissor_Chance += confident;//win
                lizard_Chance += confident;//win
                paper_Chance += (confident/2.0);//win
                rock_Chance -= confident / confident_value;;//lose
                spock_Chance -= confident / confident_value;;//lose
            }
        }

        if(result.equalsIgnoreCase("tie")){
            if (alt_tie > rep_tie) {
                scissor_Chance += 0;//win
                lizard_Chance += 0;//win
                paper_Chance += 0;//tie
                rock_Chance -= 0;//lose
                spock_Chance -= 0;//lose
                
            } else if(rep_tie > alt_tie){
                scissor_Chance += 0;//win
                lizard_Chance -= 0;//win
                paper_Chance -= 0;//tie
                rock_Chance += 0;//lose
                spock_Chance += 0;//lose
            }
        }
        
       forget(forgetValue);
        
        if (spock_Chance > win_max_chance) {
            spock_Chance = win_max_value_stay; 
        } if (spock_Chance < win_min_chance) {
            spock_Chance = win_min_value_stay;
        }
        
        if (rock_Chance > win_max_chance) {
            rock_Chance = win_max_value_stay; 
        } if (rock_Chance < win_min_chance) {
            rock_Chance = win_min_value_stay;
        }
        
        if (paper_Chance > tie_max_chance) {
            paper_Chance = tie_max_value_stay; 
        } if (paper_Chance < tie_min_chance) {
                paper_Chance = tie_min_value_stay;
        }

        if (scissor_Chance > lose_max_chance) {
            scissor_Chance = lose_max_value_stay; 
        } if (scissor_Chance < lose_min_chance) {
            scissor_Chance = lose_min_value_stay;
        }
        
        if (lizard_Chance > lose_max_chance) {
            lizard_Chance = lose_max_value_stay; 
        } if (lizard_Chance < lose_min_chance) {
            lizard_Chance = lose_min_value_stay;
        }
        
        confident_limit();
        Update_last_move("paper");
        update_spock_Chance();
        win_pred = (rock_Chance + spock_Chance);
        tie_pred = paper_Chance;
        lose_pred = (lizard_Chance + scissor_Chance);
        status();
    }//ends paper

    //starts scissor
    public static void scissor() {
        update_spock_Chance();
        scissor_Count++;
        your_weapon = "scissor"; 
        ROLL_THE_DICE();
        
        if (random < rock_Chance) {
            ai_weapon = "rock";
            comment = com.scissor_rock;
            lose();
        } else if (random < (rock_Chance + paper_Chance)){ 
            ai_weapon = "paper";
            comment = com.scissor_paper;
            win();
        } else if (random < (rock_Chance + paper_Chance + scissor_Chance)){ 
            ai_weapon = "scissor";
            tie();
        } else if (random < (rock_Chance + paper_Chance + scissor_Chance + lizard_Chance)){
            ai_weapon = "lizard";
            comment = com.scissor_lizard;
            win();
        } else { 
            ai_weapon = "spock";
            comment = com.scissor_spock;
            lose();
        }
        
        if(result.equalsIgnoreCase("lose")){
            if (alt_lose > rep_lose) {
                spock_Chance -= confident;//win
                rock_Chance -= confident;//win
                scissor_Chance -= (confident/2.0);//tie
                paper_Chance += confident / confident_value;//lose
                lizard_Chance += confident / confident_value;//lose
                physiology_lose_scissor();//added
                
            } else if(rep_lose > alt_lose){
                spock_Chance += confident;//win
                rock_Chance += confident;//win
                scissor_Chance += (confident/2.0);//tie
                paper_Chance -= confident / confident_value;//lose
                lizard_Chance -= confident / confident_value;//lose
            }
        }
    
        if(result.equalsIgnoreCase("win")){
            if (alt_win > rep_win) {
                spock_Chance -= confident;//win
                rock_Chance -= confident;//win
                scissor_Chance -= (confident/2.0);//tie
                paper_Chance += confident / confident_value;//lose
                lizard_Chance += confident / confident_value;//lose
                physiology_win_scissor();//added
                    
            } else if(rep_win > alt_win){
                spock_Chance += confident;//win
                rock_Chance += confident;//win
                scissor_Chance += (confident/2.0);//win
                paper_Chance -= confident / confident_value;//lose
                lizard_Chance -= confident / confident_value;//lose
            }
        }

        if(result.equalsIgnoreCase("tie")){
            if (alt_tie > rep_tie) {
                spock_Chance += 0;//win
                rock_Chance += 0;//win
                scissor_Chance += 0;//tie
                paper_Chance -= 0;//lose
                lizard_Chance -= 0;//lose
                
            } else if(rep_tie > alt_tie){
                spock_Chance += 0;//win
                rock_Chance -= 0;//win
                scissor_Chance -= 0;//tie
                paper_Chance += 0;//lose
                lizard_Chance += 0;//lose
            }
        }

     forget(forgetValue);

        if (lizard_Chance > win_max_chance) {
            lizard_Chance = win_max_value_stay; 
        } if (lizard_Chance < win_min_chance) {
            lizard_Chance = win_min_value_stay;
        }
        
        if (paper_Chance > win_max_chance) {
            paper_Chance = win_max_value_stay; 
        } if (paper_Chance < win_min_chance) {
            paper_Chance = win_min_value_stay;
        }
        
        if (scissor_Chance  > tie_max_chance) {
            scissor_Chance = tie_max_value_stay; 
        } if (scissor_Chance  < tie_min_chance) {
            scissor_Chance  = tie_min_value_stay;
        }

        if (rock_Chance > lose_max_chance) {
            rock_Chance = lose_max_value_stay; 
        } if (rock_Chance < lose_min_chance) {
            rock_Chance = lose_min_value_stay;
        }
        
        if (spock_Chance > lose_max_chance) {
            spock_Chance = lose_max_value_stay; 
        } if (spock_Chance < lose_min_chance) {
            spock_Chance = lose_min_value_stay;
        }

        //
        confident_limit();
        Update_last_move("scissor");
        update_spock_Chance();
        win_pred = (paper_Chance + lizard_Chance);
        tie_pred = scissor_Chance;
        lose_pred = (spock_Chance + rock_Chance);
        status();
    }//ends scissor
    
    //starts lizard
    public static void lizard() {
        update_spock_Chance();
        lizard_Count++;
        your_weapon = "lizard";
        ROLL_THE_DICE();
        
        if (random < rock_Chance) {
            ai_weapon = "rock";
            comment = com.lizard_rock;
            lose();
        } else if (random < (rock_Chance + paper_Chance)){ 
            ai_weapon = "paper";
            comment = com.lizard_paper;
            win();
        } else if (random < (rock_Chance + paper_Chance + scissor_Chance)){ 
            ai_weapon = "scissor";
            comment = com.lizard_scissor;
            lose();
        } else if (random < (rock_Chance + paper_Chance + scissor_Chance + lizard_Chance)){
            ai_weapon = "lizard";
            tie();
        } else { 
            ai_weapon = "spock";
            comment = com.lizard_spock;
            win();
        }
        
        if(result.equalsIgnoreCase("lose")){
            if (alt_lose > rep_lose) {
                scissor_Chance -= confident;//win
                rock_Chance -= confident;//win
                lizard_Chance -= (confident/2.0);//tie
                paper_Chance += confident / confident_value;//lose
                spock_Chance += confident / confident_value;//lose
                physiology_lose_lizard();//added
            
            } else if(rep_lose > alt_lose){
                scissor_Chance += confident;//win
                rock_Chance += confident;//win
                lizard_Chance += (confident/2.0);//tie
                paper_Chance -= confident / confident_value;//lose
                spock_Chance -= confident / confident_value;//lose
            }
        }
    
        if(result.equalsIgnoreCase("win")){
            if (alt_win > rep_win) {
                scissor_Chance -= confident;//win
                rock_Chance -= confident;//win
                lizard_Chance -= (confident/2.0);//tie
                paper_Chance += confident / confident_value;//lose
                spock_Chance += confident / confident_value;//lose
                physiology_win_lizard();//added
                    
            } else if(rep_win > alt_win){
                scissor_Chance += confident;//win
                rock_Chance += confident;//win
                lizard_Chance += (confident/2.0);//tie
                paper_Chance -= confident / confident_value;//lose
                spock_Chance -= confident / confident_value;//lose
            }
        }

        if(result.equalsIgnoreCase("tie")){
            if (alt_tie > rep_tie) {
                scissor_Chance += 0;//win
                rock_Chance += 0;//win
                lizard_Chance += 0;//tie
                paper_Chance -= 0;//lose
                spock_Chance -= 0;//lose
                
            } else if(rep_tie > alt_tie){
                scissor_Chance += 0;//win
                rock_Chance -= 0;//win
                lizard_Chance -= 0;//tie
                paper_Chance += 0;//lose
                spock_Chance += 0;//lose
            }
        }

        forget(forgetValue);

        if (spock_Chance > win_max_chance) {
            spock_Chance = win_max_value_stay; 
        } if (spock_Chance < win_min_chance) {
            spock_Chance = win_min_value_stay;
        }
        
        if (paper_Chance > win_max_chance) {
            paper_Chance = win_max_value_stay; 
        } if (paper_Chance < win_min_chance) {
            paper_Chance = win_min_value_stay;
        }
        
        if (lizard_Chance  > tie_max_chance) {
            lizard_Chance = tie_max_value_stay; 
        } if (lizard_Chance  < tie_min_chance) {
            lizard_Chance  = tie_min_value_stay;
        }

        if (rock_Chance > lose_max_chance) {
            rock_Chance = lose_max_value_stay; 
        } if (rock_Chance < lose_min_chance) {
            rock_Chance = lose_min_value_stay;
        }
        
        if (scissor_Chance > lose_max_chance) {
            scissor_Chance = lose_max_value_stay; 
        } if (scissor_Chance < lose_min_chance) {
            scissor_Chance = lose_min_value_stay;
        }
        
        confident_limit();
        Update_last_move("lizard");
        update_spock_Chance();
        win_pred = (paper_Chance + spock_Chance);
        tie_pred = lizard_Chance;
        lose_pred = (scissor_Chance + rock_Chance);
        status();
    }//ends lizard
    

    //starts spock
    /**
     * all of the codes in here changes a bit because spock takes the remaining chances...
     */
    public static void spock() {
        update_spock_Chance();
        spock_Count++;
        your_weapon = "spock";
        ROLL_THE_DICE();
        
        if (random < rock_Chance) {
            ai_weapon = "rock";
            comment = com.spock_rock;
            lose();
        } else if (random < (rock_Chance + paper_Chance)){ 
            ai_weapon = "paper";
            comment = com.spock_paper;
            win();
        } else if (random < (rock_Chance + paper_Chance + scissor_Chance)){ 
            ai_weapon = "scissor";
            comment = com.spock_scissor;
            lose();
        } else if (random < (rock_Chance + paper_Chance + scissor_Chance + lizard_Chance)){
            ai_weapon = "lizard";
            comment = com.spock_lizard;
            win();
        } else { 
            ai_weapon = "spock";
            tie();
        }
        
        if(result.equalsIgnoreCase("lose")){
            if (alt_lose > rep_lose) {
                paper_Chance += (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//win
                lizard_Chance += (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//win
                spock_Chance += (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//tie
                scissor_Chance -= (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//lose
                rock_Chance -= (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//lose
                physiology_lose_spock();//added
                
            } else if(rep_lose > alt_lose){
                paper_Chance -= (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//win
                lizard_Chance -= (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//win
                spock_Chance -= (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//tie
                scissor_Chance += (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//lose
                rock_Chance += (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//lose
            }
        }
    
        if(result.equalsIgnoreCase("win")){
            if (alt_win > rep_win) {
                paper_Chance += (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//win
                lizard_Chance += (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//win
                spock_Chance += (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//tie
                scissor_Chance -= (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//lose
                rock_Chance -= (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//lose
                physiology_win_spock();//added
                
            } else if(rep_win > alt_win){
                paper_Chance -= (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//win
                lizard_Chance -= (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//win
                spock_Chance -= (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//tie
                scissor_Chance += (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//lose
                rock_Chance += (confident)*((NumOfWeapons-1.0)/NumOfWeapons);//lose
            }
        }

        if(result.equalsIgnoreCase("tie")){
            if (alt_tie > rep_tie) {
                paper_Chance += 0;//win
                lizard_Chance += 0;//win
                spock_Chance += 0;//tie
                scissor_Chance -= 0;//lose
                rock_Chance -= 0;//lose
                
            } else if(rep_tie > alt_tie){
                paper_Chance += 0;//win
                lizard_Chance -= 0;//win
                spock_Chance -= 0;//tie
                scissor_Chance += 0;//lose
                rock_Chance += 0;//lose
            }
        }

        forget(forgetValue);
        
        if (lizard_Chance > win_max_chance) {
            lizard_Chance = win_max_value_stay; 
        } if (lizard_Chance < win_min_chance) {
            lizard_Chance = win_min_value_stay;
        }
        
        if (paper_Chance > win_max_chance) {
            paper_Chance = win_max_value_stay; 
        } if (paper_Chance < win_min_chance) {
            paper_Chance = win_min_value_stay;
        }
        
        if (spock_Chance  > tie_max_chance) {
            spock_Chance = tie_max_value_stay; 
        } if (spock_Chance  < tie_min_chance) {
            spock_Chance  = tie_min_value_stay;
        }
        
        if (rock_Chance > lose_max_chance) {
            rock_Chance = lose_max_value_stay; 
        } if (rock_Chance < lose_min_chance) {
            rock_Chance = lose_min_value_stay;
        }
        
        if (scissor_Chance > lose_max_chance) {
            scissor_Chance = lose_max_value_stay; 
        } if (scissor_Chance < lose_min_chance) {
            scissor_Chance = lose_min_value_stay;
        }
        
        confident_limit();
        Update_last_move("spock");
      //  update_spock_Chance();
        win_pred = (scissor_Chance + rock_Chance);
        tie_pred = spock_Chance;
        lose_pred = (paper_Chance + lizard_Chance);
        status();
    }//ends lizard


/************************************************************************************************************** */
/************************************************************************************************************** */
/*********************************************[STARTS METHODS]************************************************* */
/************************************************************************************************************** */
/************************************************************************************************************** */

    public static void win() {
        result = "win";
        your_score++;
        confident -= 2;
        history_result = 1;

        if (last_move.equalsIgnoreCase(your_weapon)) {
            rep_win++;
        } else {
            alt_win++;
        }
    }

    public static void lose() {
        result = "lose";
        ai_score++;
        confident++;
        history_result = 0;

        if (last_move.equalsIgnoreCase(your_weapon)) {
            rep_lose++;
        } else {
            alt_lose++;
        }
    }

    public static void tie() {
        result = "tie";

        if (last_move.equalsIgnoreCase(your_weapon)) {
            rep_tie++;
        } else {
            alt_tie++;
        }
    }

    public static void forget(int ForgetValue) {
        if (alt_win > (rep_win + forget)) {
            alt_win -= ForgetValue;
        } if (rep_win > (alt_win + forget)) {
            rep_win -= ForgetValue;
        } if (alt_tie > (rep_tie + forget)) {
            alt_tie -= ForgetValue;
        } if (rep_tie > (alt_tie + forget)) {
            rep_tie -= ForgetValue;
        } if (alt_lose > (rep_lose + forget)) {
            alt_lose -= ForgetValue;
        } if (rep_lose > (alt_lose + forget)) {
            rep_lose -= ForgetValue;
        }
    }

    public static void status() {
        System.out.println("You choose [" + your_weapon + "] and I choose [" + ai_weapon + "] Result [" + result + "]<=>[" + your_score + "]"+"<=>"+"["+ai_score+"]");
        System.out.println(comment); 
        System.out.println();
        System.out.println("rock:\t\t"        + rock_Chance    + "%");
        System.out.println("paper:\t\t"       + paper_Chance   + "%");
        System.out.println("scissor:\t"       + scissor_Chance + "%");
        System.out.println("lizard:\t\t"      + lizard_Chance  + "%");
        System.out.println("spock:\t\t"       +  spock_Chance  + "%");
        System.out.println("confident level:" + confident);
        System.out.println();
        System.out.println("Overall chances:(player's result predictions) ");
        System.out.println("win:\t\t"  + win_pred);
        System.out.println("tie:\t\t"  + tie_pred);
        System.out.println("lose:\t\t" + lose_pred);
        System.out.println();
    }

    public static void update_spock_Chance() {
        spock_Chance = 100 - (rock_Chance + paper_Chance + scissor_Chance + lizard_Chance);
    }

    public static void ROLL_THE_DICE() {
        random = (int)(Math.random()*chance)+1; //1 - 100;
    }

    public static void Update_last_move(String move) {
        last_move = move;
    }

    public static void confident_limit() {
        if (confident < 1) {
            confident = 2;
            
        }
    }

    

    ///////////////////////////////////////////////////////////////////////////
    //////////////////////////////PHYSIOLOGY WIN///////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public static void physiology_win_paper() {
        int incress = 5;
        int decress = 2;
        if (your_weapon.equalsIgnoreCase("rock")) {
            rock_Chance += incress;//
            paper_Chance -= decress;
            scissor_Chance -= decress;
            lizard_Chance -= decress;
            spock_Chance -= decress;

        } else if (your_weapon.equalsIgnoreCase("paper")) {
            rock_Chance -= 0;
            paper_Chance += 0;////
            scissor_Chance -= 0;
            lizard_Chance -= 0;
            spock_Chance -= 0;

        } else if (your_weapon.equalsIgnoreCase("scissor")) {
            rock_Chance -= decress;
            paper_Chance -= decress;//
            scissor_Chance += incress;//
            lizard_Chance -= decress;
            spock_Chance -= decress;
            
        } else if (your_weapon.equalsIgnoreCase("lizard")) {
            rock_Chance -= decress;
            paper_Chance -= decress;//
            scissor_Chance -= decress;
            lizard_Chance += incress;//
            spock_Chance -= decress;
            
        } else if (your_weapon.equalsIgnoreCase("spock")) {
            rock_Chance -= decress;
            paper_Chance -= decress;//
            scissor_Chance -= decress;
            lizard_Chance -= decress;
            spock_Chance += incress;//

        } else {
            System.out.println("Something wrong");

        }
    }

    public static void physiology_win_scissor() {
        int incress = 5;
        int decress = 2;
        if (your_weapon.equalsIgnoreCase("rock")) {
            rock_Chance += incress;//
            paper_Chance -= decress;
            scissor_Chance -= decress;//
            lizard_Chance -= decress;
            spock_Chance -= decress;

        } else if (your_weapon.equalsIgnoreCase("paper")) {
            rock_Chance -= decress;
            paper_Chance += incress;//
            scissor_Chance -= decress;//
            lizard_Chance -= decress;
            spock_Chance -= decress;

        } else if (your_weapon.equalsIgnoreCase("scissor")) {
            rock_Chance -= 0;
            paper_Chance -= 0;
            scissor_Chance += 0;////
            lizard_Chance -= 0;
            spock_Chance -= 0;
            
        } else if (your_weapon.equalsIgnoreCase("lizard")) {
            rock_Chance -= decress;
            paper_Chance -= decress;
            scissor_Chance -= decress;//
            lizard_Chance += incress;//
            spock_Chance -= decress;
            
        } else if (your_weapon.equalsIgnoreCase("spock")) {
            rock_Chance -= decress;
            paper_Chance -= decress;
            scissor_Chance -= decress;//
            lizard_Chance -= decress;
            spock_Chance += incress;//

        } else {
            System.out.println("Something wrong");

        }
    }

    public static void physiology_win_lizard() {
        int incress = 5;
        int decress = 2;
        if (your_weapon.equalsIgnoreCase("rock")) {
            rock_Chance += incress;//
            paper_Chance -= decress;
            scissor_Chance -= decress;
            lizard_Chance -= decress;//
            spock_Chance -= decress;

        } else if (your_weapon.equalsIgnoreCase("paper")) {
            rock_Chance -= decress;
            paper_Chance += incress;//
            scissor_Chance -= decress;
            lizard_Chance -= decress;//
            spock_Chance -= decress;

        } else if (your_weapon.equalsIgnoreCase("scissor")) {
            rock_Chance -= decress;
            paper_Chance -= decress;
            scissor_Chance += incress;//
            lizard_Chance -= decress;//
            spock_Chance -= decress;
            
        } else if (your_weapon.equalsIgnoreCase("lizard")) {
            rock_Chance -= 0;
            paper_Chance -= 0;
            scissor_Chance -= 0;
            lizard_Chance += 0;////
            spock_Chance -= 0;
            
        } else if (your_weapon.equalsIgnoreCase("spock")) {
            rock_Chance -= decress;
            paper_Chance -= decress;
            scissor_Chance -= decress;
            lizard_Chance -= decress;//
            spock_Chance += incress;//

        } else {
            System.out.println("Something wrong");

        }
    }

    public static void physiology_win_spock() {
        int incress = 5;
        int decress = 2;
        if (your_weapon.equalsIgnoreCase("rock")) {
            rock_Chance += incress;//
            paper_Chance -= decress;
            scissor_Chance -= decress;
            lizard_Chance -= decress;
            spock_Chance -= decress;//

        } else if (your_weapon.equalsIgnoreCase("paper")) {
            rock_Chance -= decress;
            paper_Chance += incress;//
            scissor_Chance -= decress;
            lizard_Chance -= decress;
            spock_Chance -= decress;//

        } else if (your_weapon.equalsIgnoreCase("scissor")) {
            rock_Chance -= decress;
            paper_Chance -= decress;
            scissor_Chance += incress;//
            lizard_Chance -= decress;
            spock_Chance -= decress;//
            
        } else if (your_weapon.equalsIgnoreCase("lizard")) {
            rock_Chance -= decress;
            paper_Chance -= decress;
            scissor_Chance -= decress;
            lizard_Chance += incress;//
            spock_Chance -= decress;//
            
        } else if (your_weapon.equalsIgnoreCase("spock")) {
            rock_Chance -= 0;
            paper_Chance -= 0;
            scissor_Chance -= 0;
            lizard_Chance -= 0;
            spock_Chance += 0;////

        } else {
            System.out.println("Something wrong");

        }
    }

    /***************************************************************************/
    
    ///////////////////////////////////////////////////////////////////////////
    //////////////////////////////PHYSIOLOGY LOSE//////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public static void physiology_lose_paper() {
        int incress = 5;
        int decress = 2;
        if (your_weapon.equalsIgnoreCase("rock")) {
            rock_Chance -= decress;//
            paper_Chance -= decress;//
            scissor_Chance += incress;
            lizard_Chance += incress;
            spock_Chance += incress;
    
        } else if (your_weapon.equalsIgnoreCase("paper")) {
            rock_Chance -= 0;
            paper_Chance -= 0;////
            scissor_Chance += 0;
            lizard_Chance += 0;
            spock_Chance += 0;
    
        } else if (your_weapon.equalsIgnoreCase("scissor")) {
            rock_Chance += incress;
            paper_Chance -= decress;//
            scissor_Chance -= decress;//
            lizard_Chance += incress;
            spock_Chance += incress;
            
        } else if (your_weapon.equalsIgnoreCase("lizard")) {
            rock_Chance += incress;
            paper_Chance -= decress;//
            scissor_Chance += incress;
            lizard_Chance -= decress;//
            spock_Chance += incress;
            
        } else if (your_weapon.equalsIgnoreCase("spock")) {
            rock_Chance += incress;
            paper_Chance -= decress;//
            scissor_Chance += incress;
            lizard_Chance += incress;
            spock_Chance -= decress;//
            
        } else {
            System.out.println("Something wrong");

        }
    }

    public static void physiology_lose_scissor() {
        int incress = 5;
        int decress = 2;
        if (your_weapon.equalsIgnoreCase("rock")) {
            rock_Chance -= decress;//
            paper_Chance += incress;
            scissor_Chance -= decress;//
            lizard_Chance += incress;
            spock_Chance += incress;
    
        } else if (your_weapon.equalsIgnoreCase("paper")) {
            rock_Chance += incress;
            paper_Chance -= decress;//
            scissor_Chance -= decress;//
            lizard_Chance += incress;
            spock_Chance += incress;
    
        } else if (your_weapon.equalsIgnoreCase("scissor")) {
            rock_Chance -= 0;
            paper_Chance += 0;
            scissor_Chance -= 0;////
            lizard_Chance += 0;
            spock_Chance += 0;
            
        } else if (your_weapon.equalsIgnoreCase("lizard")) {
            rock_Chance += incress;
            paper_Chance += incress;
            scissor_Chance -= decress;//
            lizard_Chance -= decress;//
            spock_Chance += incress;
            
        } else if (your_weapon.equalsIgnoreCase("spock")) {
            rock_Chance += incress;
            paper_Chance += incress;
            scissor_Chance -= decress;//
            lizard_Chance += incress;
            spock_Chance -= decress;//
            
        } else {
            System.out.println("Something wrong");

        }
    }

    public static void physiology_lose_lizard() {
        int incress = 5;
        int decress = 2;
        if (your_weapon.equalsIgnoreCase("rock")) {
            rock_Chance -= decress;//
            paper_Chance += incress;
            scissor_Chance += incress;
            lizard_Chance -= decress;//
            spock_Chance += incress;
    
        } else if (your_weapon.equalsIgnoreCase("paper")) {
            rock_Chance += incress;
            paper_Chance -= decress;//
            scissor_Chance += incress;
            lizard_Chance -= decress;//
            spock_Chance += incress;
    
        } else if (your_weapon.equalsIgnoreCase("scissor")) {
            rock_Chance += incress;
            paper_Chance += incress;
            scissor_Chance -= decress;//
            lizard_Chance -= decress;//
            spock_Chance += incress;
            
        } else if (your_weapon.equalsIgnoreCase("lizard")) {
            rock_Chance -= 0;
            paper_Chance += 0;
            scissor_Chance += 0;
            lizard_Chance -= 0;////
            spock_Chance += 0;
            
        } else if (your_weapon.equalsIgnoreCase("spock")) {
            rock_Chance += incress;
            paper_Chance += incress;
            scissor_Chance += incress;
            lizard_Chance -= decress;//
            spock_Chance -= decress;//
            
        } else {
            System.out.println("Something wrong");

        }
    }

    public static void physiology_lose_spock() {
        int incress = 5;
        int decress = 2;
        if (your_weapon.equalsIgnoreCase("rock")) {
            rock_Chance -= decress;//
            paper_Chance += incress;
            scissor_Chance += incress;
            lizard_Chance += incress;
            spock_Chance -= decress;//
    
        } else if (your_weapon.equalsIgnoreCase("paper")) {
            rock_Chance += incress;
            paper_Chance -= decress;//
            scissor_Chance += incress;
            lizard_Chance += incress;
            spock_Chance -= decress;//
    
        } else if (your_weapon.equalsIgnoreCase("scissor")) {
            rock_Chance += incress;
            paper_Chance += incress;
            scissor_Chance -= decress;//
            lizard_Chance += incress;
            spock_Chance -= decress;//
            
        } else if (your_weapon.equalsIgnoreCase("lizard")) {
            rock_Chance += incress;
            paper_Chance += incress;
            scissor_Chance += incress;
            lizard_Chance -= decress;//
            spock_Chance -= decress;//
            
        } else if (your_weapon.equalsIgnoreCase("spock")) {
            rock_Chance -= 0;
            paper_Chance += 0;
            scissor_Chance += 0;
            lizard_Chance += 0;
            spock_Chance -= 0;////
            
        } else {
            System.out.println("Something wrong");

        }
    }
}//ends level5