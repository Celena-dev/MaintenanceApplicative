    package trivia;


    import static trivia.Game.NB_CASES;


    public class Player {
        private final String name;
        private int place = 1;
        private int purse = 0;
        private boolean inPenaltyBox = false;
        private boolean secondeChance = false;
        private int correctAnswers = 0;

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
            if (place > NB_CASES) place -= NB_CASES;
        }

        public void incrementPurse() {
            purse++;
        }

        public void setInPenaltyBox(boolean inPenaltyBox) {
            this.inPenaltyBox = inPenaltyBox;
        }

        // retourne vrai si le joueur a une seconde chance
        public boolean hasSecondChance() {
            return secondeChance;
        }

        // le joueur a une seconde chance
        public void giveSecondChance() {
            this.secondeChance = true;
        }

        // le joueur a utilisé sa seconde chance
        public void resetSecondChance() {
            this.secondeChance = false;
        }

        public int getCorrectAnswers() {
            return correctAnswers;
        }

        public void setCorrectAnswers() {
            this.correctAnswers ++;
        }

        public void setCorrectAnswers0() {
            this.correctAnswers = 0;
        }
    }
