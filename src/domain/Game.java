package domain;

public class Game implements Input {

	private boolean finishGame;

	private int timer;

	private GameBoard gameBoard;

	public Game() {
		this.finishGame = false;
		this.timer = 0;
		this.gameBoard = new Board(10, 10);
	}

	public void move() {
		while(!finishGame) {
			this.gameBoard.move();
			this.timer += 1;
		}
	}



	/**
	 * @see domain.Input#inputGame()
	 */
	public int[] inputGame() {
		return null;
	}

}
