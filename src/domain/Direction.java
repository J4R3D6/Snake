package domain;

/**
 * Represents cardinal directions with corresponding movement vectors (x, y).
 * Each direction is defined with a unique pair of x and y components
 * that indicate the direction of movement on a Cartesian plane.
 *
 * Example directions:
 * - UP: Moves along the negative y-axis.
 * - RIGHT: Moves along the positive x-axis.
 * - DOWN: Moves along the positive y-axis.
 * - LEFT: Moves along the negative x-axis.
 */
public enum Direction {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    private final int x;
    private final int y;

    /**
     * Initializes a Direction instance with specified x and y values representing a direction vector.
     *
     * @param x the x-component of the direction
     * @param y the y-component of the direction
     */
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieves the x-component of the direction vector.
     *
     * @return the x-component of the direction
     */
    public int getX() {
        return x;
    }

    /**
     * Retrieves the y-component of the direction vector.
     *
     * @return the y-component of the direction
     */
    public int getY() {
        return y;
    }

    /**
     * Determines if this direction is opposite to the specified direction.
     *
     * @param other the direction to compare with
     * @return true if this direction is opposite to the specified direction, false otherwise
     */
    public boolean isOpposite(Direction other) {
        return this.x == -other.x && this.y == -other.y;
    }
}
