package domain;

public class Apple {

	private int posX;

	private int posY;

	public Apple(int x, int y, Board game) {
		this.posX = x;
		this.posY = y;
		game.updateApple(posX, posY);
	}

	public void ate() {

	}

}
