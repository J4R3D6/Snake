package domain;

import java.util.LinkedList;

public class Snake {

	private LinkedList<int[]> body;

	public Snake(int x, int y, Board board) {
		this.body = new LinkedList<>();
		this.body.add(new int[]{x,y});
		board.updateSnake(x,y);
	}

	private boolean collisionApple(){return false;}

	public boolean collision(){return false;}

	public void growUp() {

	}

	public void move(Board board) {

	}

	public LinkedList<int[]> getBody() {
		return body;
	}
}
