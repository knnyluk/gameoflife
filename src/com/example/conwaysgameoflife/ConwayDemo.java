package com.example.conwaysgameoflife;

public class ConwayDemo {
    public static void main(String[] args) {
        int[][] sampleCoords = {{1,2},{2,3}};
        GameOfLife gameOfLife = new GameOfLife(sampleCoords);
        gameOfLife.printGrid();
        Grid grid = new Grid(sampleCoords);
        for (int[] cp: grid.getNeighboringCoords(new int[]{1, 1})) {
            System.out.println("" + cp[0] + ", " + cp[1]);
        }
    }
}
