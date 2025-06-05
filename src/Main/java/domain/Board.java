package domain;

import java.util.Random;

/**
 * The Board class represents a game board for a Snake game.
 * It manages the game elements, such as the snake, the apple, and their positions
 * on*/
public class Board implements GameBoard {
	private final int width;
	private final int height;
	private Snake snake;
	private Apple apple;
	private String[][] map;

	/**
	 * Constructs a new Board instance with the specified width and height.
	 * Initializes the game board, creates a snake, and places an apple.
	 *
	 * @param width  the width of the*/
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.map = new String[width][height];
		this.createSnake();
		this.createApple();
	}

	/**
	 * Creates a new apple at a random position on the game board.
	 * The position is randomly generated within the board's dimensions
	 * and ensures that it does not collide with the snake's current body segments.
	 * Once the position is determined, the apple is placed, and its location is updated
	 * on the game board map.
	 */
	@Override
	public void createApple() {
		Random random = new Random();
		int x, y;

		do {
			x = random.nextInt(width);
			y = random.nextInt(height);
		} while (isPositionOccupied(x, y));

		this.apple = new Apple(x, y);
		updateApple(x, y);
	}

	/**
	 * Determines if a given position on the board is currently occupied by the snake.
	 *
	 * @param x the x-coordinate of the position to check
	 * @param y the y-coordinate of the position to check
	 * @return true if the position is occupied by any segment of the snake, false otherwise
	 */
	private boolean isPositionOccupied(int x, int y) {
		for (int[] segment : snake.getBody()) {
			if (segment[0] == x && segment[1] == y) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Initializes the snake at its starting position and updates the game board to reflect the snake's presence.
	 *
	 * The snake is created at the center of the board using calculated coordinates based on the board's width and height.
	 * These starting coordinates are passed to the Snake constructor, and the resulting snake object is stored.
	 * The `updateSnake` method is then invoked to place the snake's initial position on the board's map.
	 */
	@Override
	public void createSnake() {
		int startX = width / 2;
		int startY = height / 2;
		this.snake = new Snake(startX, startY);
		updateSnake(startX, startY);
	}

	/**
	 * Moves the snake in the specified direction on the game board.
	 * Checks for collisions with the game board boundaries, the snake's own body, and the apple.
	 * Updates the snake's position and modifies the game state accordingly.
	 *
	 * @param direction the direction in which the snake should move
	 * @return true if the move results in the game ending (e.g., collision), false otherwise
	 */
	public boolean move(Direction direction) {
		int[] head = snake.getHead();
		int newX = head[0] + direction.getX();
		int newY = head[1] + direction.getY();

		if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
			return true;
		}

		if (snake.collidesWith(newX, newY)) {
			return true;
		}

		snake.move(newX, newY, apple.getX() == newX && apple.getY() == newY);

		clearMap();
		updateSnakePositions();
		updateApple(apple.getX(), apple.getY());

		return false;
	}

	/**
	 * Clears the game board's map by setting all cells to null.
	 *
	 * This method iterates through the entire map grid,*/
	private void clearMap() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				map[i][j] = null;
			}
		}
	}

	/**
	 * Updates the positions of all segments of the snake on the game board.
	 *
	 * This method iterates through the snake's body segments and calls the
	 * `updateSnake` method for each segment. Each segment's position is
	 */
	private void updateSnakePositions() {
		for (int[] segment : snake.getBody()) {
			updateSnake(segment[0], segment[1]);
		}
	}

	/**
	 * Updates the game board to place an apple at the specified position.
	 * This method modifies the internal map to mark the cell at the given
	 * coordinates as occupied by an apple.
	 *
	 **/
	@Override
	public void updateApple(int x, int y) {
		map[x][y] = "apple";
	}

	/**
	 * Updates the game board to mark the specified position as occupied by the snake.
	 *
	 **/
	@Override
	public void updateSnake(int x, int y) {
		map[x][y] = "snake";
	}

	/**
	 * Determines if the snake's head is located at the same position as the apple.
	 *
	 * The method compares the coordinates of the snake's head with the coordinates
	 * of the apple to check if the snake has eaten the apple.
	 *
	 * @return true if the snake's head is at the same position as the apple, false otherwise
	 */
	public boolean snakeAteApple() {
		int[] head = snake.getHead();
		return head[0] == apple.getX() && head[1] == apple.getY();
	}

	/**
	 * Instructs the*/
	@Override
	public void growSnake() {
		this.snake.grow();
	}

	/**
	 * Retrieves the current state of the game board as a 2D array of strings.
	 * Each cell in the array represents a specific position on the game board,
	 * with values indicating the contents of the cell (e.g., null, snake segment, apple).
	 *
	 * @return a 2D string array representing the game board, where each element corresponds
	 *         to a cell on the board and indicates its current state.
	 */
	@Override
	public String[][] getMap() {
		return map;
	}
}