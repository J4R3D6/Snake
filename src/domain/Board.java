package domain;
import java.util.Random;
import java.util.LinkedList;

public class Board implements GameBoard {

	private int longitudY;

	private int longitudX;

	private Snake snake;

	private Apple apple;

	private String[][] map;

	public Board(int x, int y) {
		this.longitudX = x;
		this.longitudY = y;
		this.map = new String[longitudX][longitudY];
		this.createSnake();
		this.createApple();
	}


	/**
	 * @see domain.GameBoard#growUp()
	 */
	public void growUp() {

	}


	/**
	 * @see domain.GameBoard#createApple()
	 */
	public void createApple() {
		int[] position = {new Random().nextInt(this.longitudX), new Random().nextInt(this.longitudY)};
		for(int[] coords :this.snake.getBody()){
			if (position[0] != coords[0] || position[1] != coords[1]){
				this.apple = new Apple(position[0] , position[1], this);
				return;
			}
		}
		this.createApple();
	}


	/**
	 * @see domain.GameBoard#createSnake()
	 */
	public void createSnake() {
		this.snake = new Snake((int) (this.longitudX/2) ,(int) (this.longitudY/2) , this);
	}


	/**
	 * @see domain.GameBoard#move()
	 */
	public void move() {

	}


	/**
	 * @see domain.GameBoard#deleteApple()
	 */
	public void deleteApple() {

	}


	/**
	 * @see domain.GameBoard#updateApple(int, int)
	 */
	public void updateApple(int x, int y) {
		this.map[x][y] = "apple";
	}


	/**
	 * @see domain.GameBoard#updateSnake(int, int)
	 */
	public void updateSnake(int x, int y) {
		this.map[x][y] = "snake";
	}

}
