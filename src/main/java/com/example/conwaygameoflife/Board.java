package com.example.conwaygameoflife;

public class Board {

    int width;
    int height;
    int[][] board;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public void print() {
        for (int x = 0; x < height; x++) {
            StringBuilder line = new StringBuilder("|");
            for (int y = 0; y < width; y++) {
                line.append(this.board[x][y] == 0 ? "-" : "X");
            }
            line.append("|");
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        Board board = new Board(10,10);

        System.out.println("-----\n");

        board.print();

        System.out.println("\n-----");
    }
}
