import domain.Direction;
import domain.Game;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    private static volatile Direction nextDirection = null;

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Snake Game ===");
        System.out.println("Controles:");
        System.out.println("W - Arriba");
        System.out.println("A - Izquierda");
        System.out.println("S - Abajo");
        System.out.println("D - Derecha");
        System.out.println("Q - Salir");
        System.out.println("=================");

        // Hilo para actualizar el juego (No sabia que se hacia con Hilos pero weno)
        Thread gameThread = new Thread(() -> {
            while (!game.isGameOver()) {
                long startTime = System.currentTimeMillis();

                game.update();
                printGameState(game);

                long processingTime = System.currentTimeMillis() - startTime;
                long sleepTime = 600 - processingTime; // 400ms por frame

                if (sleepTime > 0) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("¡Game Over! Puntuación final: " + game.getScore());
            System.exit(0);
        });
        gameThread.start();

        // Lectura de input
        while (!game.isGameOver()) {
            try {
                if (System.in.available() > 0) {
                    String input = scanner.nextLine().toLowerCase();

                    switch (input) {
                        case "w":
                            nextDirection = Direction.UP;
                            break;
                        case "a":
                            nextDirection = Direction.LEFT;
                            break;
                        case "s":
                            nextDirection = Direction.DOWN;
                            break;
                        case "d":
                            nextDirection = Direction.RIGHT;
                            break;
                        case "q":
                            System.exit(0);
                            break;
                    }
                }

                // Aplicar la dirección almacenada
                if (nextDirection != null) {
                    game.changeDirection(nextDirection);
                    nextDirection = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printGameState(Game game) {
        // Limpiar consola
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Puntuación: " + game.getScore());
        System.out.println();

        String[][] map = game.getGameBoard().getMap();
        for (int y = 0; y < map[0].length; y++) {
            for (int x = 0; x < map.length; x++) {
                if (map[x][y] == null) {
                    System.out.print("· ");
                } else if (map[x][y].equals("snake")) {
                    System.out.print("■ ");
                } else if (map[x][y].equals("apple")) {
                    System.out.print("○ ");
                }
            }
            System.out.println();
        }
    }
}