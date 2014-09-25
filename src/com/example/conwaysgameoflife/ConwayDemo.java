package com.example.conwaysgameoflife;

public class ConwayDemo {
    public static void main(String[] args) {
        int[][] sampleCoords = {{1,2},{1,3},{1,4}};
        GameOfLife gameOfLife = new GameOfLife(sampleCoords);
        gameOfLife.printGrid();
        Grid grid = new Grid(sampleCoords);

        System.out.println(grid.countLiveCells(grid.getNeighboringCoords(new int[]{1, 2})));

    }
}
