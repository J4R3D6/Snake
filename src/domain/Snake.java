package domain;

import java.util.LinkedList;

/**
 * The Snake class represents a snake in a grid-based game.
 * It manages the snake's body, movement, growth, and collision detection.
 */
public class Snake {
	private LinkedList<int[]> body;
	private boolean shouldGrow;

	/**
	 * Constructs a Snake object with an initial position on a grid.
	 *
	 * The snake is initialized with a single segment at the specified position,
	 * and it is not set to grow initially.
	 *
	 * @param x the x-coordinate of the initial position of the snake
	 * @param y the y-coordinate of the initial position of the snake
	 */
	public Snake(int x, int y) {
		this.body = new LinkedList<>();
		this.body.add(new int[]{x, y});
		this.shouldGrow = false;
	}

	/**
	 * Moves the snake to a new position on the grid and handles its growth based on specific conditions.
	 *
	 * The method updates the snake's body to reflect its new position. If the snake is not set to grow,
	 * the last segment of its body is removed to maintain its current length. If the snake consumes an apple,
	 * it enters a state of growth, causing its length to increase in the next movement.
	 *
	 * @param newX the new x-coordinate of the snake's head position
	 */
	public void move(int newX, int newY, boolean ateApple) {
		body.addFirst(new int[]{newX, newY});
		if (!shouldGrow) {
			body.removeLast();
		} else {
			shouldGrow = false;
		}

		if (ateApple) {
			shouldGrow = true;
		}
	}

	/**
	 * Checks whether the given coordinates collide with any segment of the snake's body, excluding the head.
	 *
	 * This method iterates through the snake's body starting from the segment after the head,
	 * and compares the provided coordinates with each segment's position to determine if a collision occurs.
	 *
	 * @param x the x-coordinate to check for collision
	 * @param y the y-coordinate to check for collision
	 * @return true if the provided coordinates collide with any segment of the snake's body (excluding the head), false otherwise
	 */
	public boolean collidesWith(int x, int y) {
		for (int i = 1; i < body.size(); i++) {
			int[] segment = body.get(i);
			if (segment[0] == x && segment[1] == y) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Sets the snake to grow, causing it to increase in length in the next movement.
	 */
	public void grow() {
		shouldGrow = true;
	}
	/**
	 * Retrieves the current position of the snake's head.
	 *
	 * The head position is represented by an array of integers,
	 * where the first element represents the x-coordinate and the second element represents the y-coordinate.
	 *
	 * @return an array of integers representing the position of the snake's head
	 */
	@SuppressWarnings("unchecked")
	public int[] getHead() {
		return body.getFirst();
	}

	/**
	 * Retrieves the current body of the snake.
	 *
	 * The body is represented as a list of integer arrays, where
	 * each array consists of two integers indicating the x and y
	 * coordinates of a segment of the snake on the grid. The first
	 * element in the list represents the head of the snake.
	 *
	 * @return a LinkedList of integer arrays representing the coordinates of the snake's body
	 */
	public LinkedList<int[]> getBody() {
		return body;
	}
}