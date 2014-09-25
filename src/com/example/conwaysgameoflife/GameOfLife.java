package com.example.conwaysgameoflife;

public class GameOfLife {
    private Grid gameGrid;

    GameOfLife(int[][] seedCoordPairs) {
        gameGrid = new Grid(seedCoordPairs);
    }

    public void printGrid() {
        gameGrid.printGrid();
    }
}
