package com.example.conwaysgameoflife;

public class ConwayDemo {
    public static void main(String[] args) {
        int[][] sampleCoords = {{1,2},{2,3}};
        GameOfLife gameOfLife = new GameOfLife(sampleCoords);
        gameOfLife.printGrid();
        Grid grid = new Grid(sampleCoords);

        System.out.println(grid.countLiveCells(grid.getNeighboringCoords(new int[]{19, 19})));

    }
}
