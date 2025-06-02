package domain;

/**
 * The Game class represents the logic and state of a grid-based game,
 * specifically managing the snake, the apple, and game progression.
 * It interacts with a GameBoard instance to update the game state and
 * handle player inputs such as changing directions.
 */
public class Game {
	private boolean gameOver;
	private int score;
	private GameBoard gameBoard;
	private Direction currentDirection;

	/**
	 * Constructs a Game instance that initializes the game's state and its components.
	 *
	 * The method sets the game status to not over, initializes the score to zero, and
	 * creates a new game board with predefined dimensions. The starting direction
	 * of the player-controlled entity (e.g., snake) is set to move right.
	 */
	public Game() {
		this.gameOver = false;
		this.score = 0;
		this.gameBoard = new Board(20, 20);
		this.currentDirection = Direction.RIGHT;
	}

	/**
	 * Updates the game's state by progressing the game forward, including moving the snake,
	 * checking for apple consumption, and handling game-over conditions.
	 *
	 * This method performs the following operations:
	 * - If the game is not over, it moves the snake in the current direction by calling the
	 *   {@code move} method on {@code gameBoard}.
	 * - If the snake eats an apple after moving, the score is incremented, the snake grows
	 *   by one segment, and a new apple is created on the game board.
	 * - If the snake collides with an obstacle or itself (as determined by {@code gameBoard.move}),
	 *   the game ends by marking {@code gameOver} as {@code true}.
	 */
	public void update() {
		if (!gameOver) {
			gameOver = gameBoard.move(currentDirection);
			if (gameBoard.snakeAteApple()) {
				score++;
				gameBoard.growSnake();
				gameBoard.createApple();
			}
		}
	}

	/**
	 * Changes the current direction to the specified new direction if it is not opposite to the current direction.
	 *
	 * @param newDirection the direction to change to, provided as an instance of the {@code Direction} enum
	 */
	public void changeDirection(Direction newDirection) {
		if (!currentDirection.isOpposite(newDirection)) {
			currentDirection = newDirection;
		}
	}

	/**
	 * Checks if the game is over.
	 *
	 * This method returns the current status of the game, indicating whether it has ended.
	 * The state is determined by the game's internal logic, such as collision
	 * with obstacles or the snake colliding with itself.
	 *
	 * @return true if the game is over, false otherwise
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * Retrieves the current score of the game.
	 *
	 * The score represents the player's progress in the game,
	 * which increases when the snake eats an apple.
	 *
	 * @return the current score of the game
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Retrieves the current instance of the game board associated with the game.
	 *
	 * The game board is responsible for managing the grid-based layout of the game,
	 * including the positions of elements such as the snake and the apple. It serves
	 * as the central component through which game actions and state updates are performed.
	 *
	 * @return the current game board instance used by the game
	 */
	public GameBoard getGameBoard() {
		return gameBoard;
	}
}