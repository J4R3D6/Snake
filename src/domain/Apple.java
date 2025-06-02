package domain;

/**
 * The Apple class represents the apple object in a grid-based game.
 *
 * This class tracks the position of an apple, which is represented by
 * its coordinates (x, y) on the grid. The position of the apple can
 * be retrieved or updated based on the game's logic.
 */
public class Apple {
	private int x;
	private int y;

	/**
	 * Constructs an Apple object with specific coordinates on the grid.
	 *
	 * @param x the x-coordinate of the apple
	 * @param y the y-coordinate of the apple
	 */
	public Apple(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Retrieves the x-coordinate of the apple.
	 *
	 * The x-coordinate represents the horizontal position of the apple on the*/
	public int getX() {
		return x;
	}

	/**
	 * Retrieves the y-coordinate of the apple.
	 *
	 * The y-coordinate represents the vertical position of the apple on the grid.
	 *
	 * @return the y-coordinate of the apple
	 */
	public int getY() {
		return y;
	}

	/**
	 * Updates the position of the apple on the grid.
	 *
	 * The new position is specified by the given x and y coordinates, which
	 * represent the horizontal and vertical positions, respectively.
	 *
	 * @param x the new x-coordinate of the apple
	 * @param y the new y-coordinate of the apple
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
}