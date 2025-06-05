package domain;

/**
 * The GameBoard interface defines the essential methods for creating and managing the game board
 * and its entities, such as the apple and the snake, in a grid-based game like Snake.
 */
public interface GameBoard {
	/**
	 * Creates a new apple and places it on the game board at a random unoccupied position.
	 * This method ensures that the new apple does not overlap with the positions occupied
	 * by the snake's body.
	 *
	 */
	public abstract void createApple();

	/**
	 * Initializes and places the snake on the game board.
	 * By default, the snake is created at a predefined position,
	 * typically at the center of the board. This method ensures that
	 * the*/
	public abstract void createSnake();

	/**
	 * Moves*/
	public abstract boolean move(Direction currentDirection);

	/**
	 * Updates the position of the apple on the game board. This method
	 * marks the specified coordinates on the game board to represent the
	 * apple's presence. Typically called after creating or repositioning
	 * an apple.
	 *
	 * @param x the x-coordinate of the apple's position on the game board
	 * @param y the y-coordinate of the apple's position on the game board
	 */
	public abstract void updateApple(int x, int y);

	/**
	 * Updates the game board to reflect the snake's presence at the specified coordinates.
	 * This method marks the provided position as occupied by the snake on the game board.
	 *
	 * @param x the x-coordinate of the snake's position*/
	public abstract void updateSnake(int x, int y);

	/**
	 * Checks if the snake has eaten the apple during the current game state.
	 *
	 * @return true if the snake's head position coincides with the apple's position, false otherwise
	 */
	public abstract boolean snakeAteApple();

	/**
	 * Increases the length of the snake by adding a new segment to its body.
	 * This method modifies the internal state of the snake to grow, typically after
	 * the snake consumes an apple. The new segment is added at the position
	 * where the tail previously was, thus extending the snake's body.
	 */
	public abstract void growSnake();

	/**
	 * Retrieves the current state of the game board as a 2D array of strings.
	 * Each element in the array represents a cell on the game board, which may
	 * contain identifiers such as "snake" or "apple", or may be null if the cell
	 * is empty.
	 *
	 * @return a 2D array of strings representing the current game board state
	 */
	public abstract String[][] getMap();

}
