package com.example.conwaygameoflife;

public class ConwayGameOfLife {

    int width;
    int height;
    int[][] board;

    public ConwayGameOfLife(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public void setAlive(int x, int y) {
        this.board[x][y] = 1;
    }

    public int countAliveNeighbours(int x, int y) {
        int count = 0;

        count += getState(x - 1, y - 1);
        count += getState(x - 1, y);
        count += getState(x - 1, y + 1);

        count += getState(x, y - 1);
        count += getState(x, y + 1);

        count += getState(x + 1, y - 1);
        count += getState(x + 1, y);
        count += getState(x + 1, y + 1);

        return count;
    }

    public int getState(int x, int y) {
        if (x < 0 || x >= width) {
            return 0;
        }

        if (y < 0 || y >= height) {
            return 0;
        }

        return this.board[x][y];
    }

    public void print() {
        System.out.println("-----\n");
        for (int x = 0; x < height; x++) {
            StringBuilder line = new StringBuilder("|");
            for (int y = 0; y < width; y++) {
                line.append(this.board[x][y] == 0 ? "-" : "X");
            }
            line.append("|");
            System.out.println(line);
        }
        System.out.println("\n-----");
    }

    public void nextRound() {
        int[][] newBoard = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int aliveNeighbours = countAliveNeighbours(x, y);

                if (getState(x, y) == 1) {
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        newBoard[x][y] = 0;
                    } else {
                        newBoard[x][y] = 1;
                    }
                }
                newBoard[x][y] = aliveNeighbours == 3 ? 1 : 0;
            }
        }
        this.board = newBoard;
    }

    public static void main(String[] args) {
        ConwayGameOfLife board = new ConwayGameOfLife(10, 10);

        board.setAlive(2, 2);
        board.setAlive(3, 2);
        board.setAlive(3, 4);

        board.print();
        board.nextRound();
        board.print();
        board.nextRound();
        board.print();
    }
}
