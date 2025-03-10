package trivia;


public enum Categories {
    POP("Pop"),
    SCIENCE("Science"),
    SPORTS("Sports"),
    ROCK("Rock"),
    GEOGRAPHIE("Géogrephie"),
    ;


    private final String stringValue;


    Categories(final String string) {
        stringValue = string;
    }


    @Override
    public String toString() {
        return stringValue;
    }
}



