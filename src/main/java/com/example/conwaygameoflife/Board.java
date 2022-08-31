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
}
