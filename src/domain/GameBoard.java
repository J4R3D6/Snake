package domain;

public interface GameBoard {

	public abstract void growUp();

	public abstract void createApple();

	public abstract void createSnake();

	public abstract void move();

	public abstract void deleteApple();

	public abstract void updateApple(int x, int y);

	public abstract void updateSnake(int x, int y);

}
