package trivia;


public interface IGame {


	boolean canStart();

	boolean add(String playerName);


	void roll(int roll);


	boolean handleCorrectAnswer();


	boolean wrongAnswer();


}



