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

    public void setAlive(int x, int y){
        this.board[x][y] = 1;
    }

    public int countAliveNeighbours(int x, int y){
        int count = 0;

        count += this.board[x-1][y-1];
        count += this.board[x-1][y];
        count += this.board[x-1][y+1];

        count += this.board[x][y-1];
        count += this.board[x][y+1];

        count += this.board[x+1][y-1];
        count += this.board[x+1][y];
        count += this.board[x+1][y+1];

        return count;
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
        ConwayGameOfLife board = new ConwayGameOfLife(10,10);

        board.setAlive(1,1);
        board.setAlive(1,2);
        board.setAlive(5,2);

        System.out.println("-----\n");

        board.print();

        System.out.println("\n-----");

        System.out.println("Alive neighbours for [1][2]: " +
                board.countAliveNeighbours(1,2));
    }
}
