package game;

/**
 * comment
 */
public class comment {

    public String 
    rock = "✊",
    paper = "✋",
    scissor = "✌",
    lizard = "🤏",
    spock = "🖖",
    
    rock_scissor = "your " + rock + " breaks ai's " + scissor,
    rock_lizard = "your " + rock + " crushes ai's " + lizard,//

    paper_rock = "your " + paper + " covers ai's " + rock,
    paper_spock = "your " + paper + " disproves ai's " + spock,//
        
    scissor_paper = "your " + scissor + " cuts ai's " + paper,
    scissor_lizard = "your " + scissor + " decapitates ai's " + lizard,//
        
    lizard_spock = "your " + lizard + " poisons ai's " + spock,
    lizard_paper = "your " + lizard + " eats ai's " + paper,
        
    spock_scissor = "your " + spock + " smashes ai's " + scissor,
    spock_rock = "your " + spock + " vaporizes ai's " + rock,
    
    //lose 
    rock_paper = "your " + rock + " gets covered by ai's " + paper,
    rock_spock = "your " + rock + " gets vaporized by ai's " + spock,
    
    paper_scissor = "your " + paper + " gets cut by ai's " + scissor,
    paper_lizard = "your " + paper + " gets eaten by ai's " + lizard,
    
    scissor_spock = "your " + scissor + " gets smashed by ai's " + spock,
    scissor_rock = "your " + scissor + " gets broken by ai's " + rock,
    
    lizard_rock = "your " + lizard + " gets crushed by ai's " + rock,//
    lizard_scissor = "your " + lizard + " gets decapitated by ai's " + scissor,//
    
    spock_lizard = "your " + spock + " gets poisoned by ai's " + lizard,
    spock_paper = "your " + spock + " gets disproven by ai's " + paper;//
    
}