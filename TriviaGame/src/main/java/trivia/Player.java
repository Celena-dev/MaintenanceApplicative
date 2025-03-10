package trivia;


import static trivia.Game.NB_CASES;


public class Player {


    private final String name;
    private int place = 1;
    private int purse = 0;
    private boolean inPenaltyBox = false;


    public Player(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
    public int getPlace() {
        return place;
    }
    public int getPurse() {
        return purse;
    }
    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }


    public void move(int roll) {
        place = place + roll;
        if(place > NB_CASES) place -= NB_CASES;
    }


    public void incrementPurse() {
        purse++;
    }


    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }
}



