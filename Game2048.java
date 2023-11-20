import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game2048 extends JFrame {
    private static final int SIZE = 4;
    private int[][] board;

    public Game2048() {
        board = new int[SIZE][SIZE];
        initializeBoard();
        addRandomTile();
        addRandomTile();

        setLayout(new GridLayout(SIZE, SIZE));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    moveTiles(Direction.UP);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    moveTiles(Direction.DOWN);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    moveTiles(Direction.LEFT);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    moveTiles(Direction.RIGHT);
                }

                if (isGameOver()) {
                    int option = JOptionPane.showConfirmDialog(null, "Game Over! Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        resetGame();
                    } else {
                        System.exit(0);
                    }
                }

                repaint();
            }
        });

        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("2048 Game");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = 0;
            }
        }
    }

    private void addRandomTile() {
        int emptyCells = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    emptyCells++;
                }
            }
        }

        if (emptyCells == 0) {
            return;
        }

        int randomIndex = (int) (Math.random() * emptyCells) + 1;
        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    count++;

                    if (count == randomIndex) {
                        board[i][j] = (Math.random() < 0.9) ? 2 : 4;
                        return;
                    }
                }
            }
        }
    }

    private void moveTiles(Direction direction) {
        boolean moved = false;

        switch (direction) {
            case UP:
                moved = moveUp();
                break;
            case DOWN:
                moved = moveDown();
                break;
            case LEFT:
                moved = moveLeft();
                break;
            case RIGHT:
                moved = moveRight();
                break;
        }

        if (moved) {
            addRandomTile();
        } else {
          
            addRandomTile();
        }
    }

    private boolean moveUp() {
        boolean moved = false;

        for (int j = 0; j < SIZE; j++) {
            for (int i = 1; i < SIZE; i++) {
                if (board[i][j] != 0) {
                    int row = i;
                    while (row > 0 && board[row - 1][j] == 0) {
                        // Move tile up
                        board[row - 1][j] = board[row][j];
                        board[row][j] = 0;
                        row--;
                        moved = true;
                    }

                    if (row > 0 && board[row - 1][j] == board[row][j]) {
                        // Merge tiles
                        board[row - 1][j] *= 2;
                        board[row][j] = 0;
                        moved = true;
                    }
                }
            }
        }

        return moved;
    }

    private boolean moveDown() {
        boolean moved = false;

        for (int j = 0; j < SIZE; j++) {
            for (int i = SIZE - 2; i >= 0; i--) {
                if (board[i][j] != 0) {
                    int row = i;
                    while (row < SIZE - 1 && board[row + 1][j] == 0) {
                        // Move tile down
                        board[row + 1][j] = board[row][j];
                        board[row][j] = 0;
                        row++;
                        moved = true;
                    }

                    if (row < SIZE - 1 && board[row + 1][j] == board[row][j]) {
                        // Merge tiles
                        board[row + 1][j] *= 2;
                        board[row][j] = 0;
                        moved = true;
                    }
                }
            }
        }

        return moved;
    }

    private boolean moveLeft() {
        boolean moved = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                if (board[i][j] != 0) {
                    int col = j;
                    while (col > 0 && board[i][col - 1] == 0) {
                        // Move tile left
                        board[i][col - 1] = board[i][col];
                        board[i][col] = 0;
                        col--;
                        moved = true;
                    }

                    if (col > 0 && board[i][col - 1] == board[i][col]) {
                        // Merge tiles
                        board[i][col - 1] *= 2;
                        board[i][col] = 0;
                        moved = true;
                    }
                }
            }
        }

        return moved;
    }

    private boolean moveRight() {
        boolean moved = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = SIZE - 2; j >= 0; j--) {
                if (board[i][j] != 0) {
                    int col = j;
                    while (col < SIZE - 1 && board[i][col + 1] == 0) {
                        // Move tile right
                        board[i][col + 1] = board[i][col];
                        board[i][col] = 0;
                        col++;
                        moved = true;
                    }

                    if (col < SIZE - 1 && board[i][col + 1] == board[i][col]) {
                        // Merge tiles
                        board[i][col + 1] *= 2;
                        board[i][col] = 0;
                        moved = true;
                    }
                }
            }
        }

        return moved;
    }

    private boolean isGameOver() {
        // Check if the game is over (no more moves possible)
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0 ||
                    (i > 0 && board[i][j] == board[i - 1][j]) ||
                    (i < SIZE - 1 && board[i][j] == board[i + 1][j]) ||
                    (j > 0 && board[i][j] == board[i][j - 1]) ||
                    (j < SIZE - 1 && board[i][j] == board[i][j + 1])) {
                    return false; // There is a possible move
                }
            }
        }
        return true; // No more moves possible
    }

    private void resetGame() {
        initializeBoard();
        addRandomTile();
        addRandomTile();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int value = board[i][j];
                g.setColor(getTileColor(value));
                g.fillRect(j * 100, i * 100, 100, 100);
                g.setColor(Color.BLACK);
                g.drawRect(j * 100, i * 100, 100, 100);

                if (value != 0) {
                    g.setColor(Color.BLACK);
                    g.drawString(Integer.toString(value), j * 100 + 45, i * 100 + 55);
                }
            }
        }
    }

    private Color getTileColor(int value) {
        // Define colors based on tile values
        // You can customize this based on your preference
        switch (value) {
            case 2:
                return new Color(0xFFE4C4);
            case 4:
                return new Color(0xFFDAB9);
            case 8:
                return new Color(0xFFC0CB);
            // Add more cases for higher values
            default:
                return Color.WHITE;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game2048());
    }
}

enum Direction {
    UP, DOWN, LEFT, RIGHT
}
