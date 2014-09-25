package com.example.conwaysgameoflife;

public class ConwayDemo {
    public static void main(String[] args) {
        int[][] sampleCoords = {{17,17},{17,18},{18,17},{18,18}};
        GameOfLife gameOfLife = new GameOfLife(sampleCoords);
        gameOfLife.play(10, 500);
//        gameOfLife.printGrid();
//        gameOfLife.iterate();
//        gameOfLife.printGrid();
//        for (int[] c: gameOfLife.findNextRoundLiveCoords()) {
//            System.out.println("" + c[0] + ", " + c[1]);
//        }
//        Grid grid = new Grid(sampleCoords);
//
//        System.out.println(grid.countLiveCells(grid.getNeighboringCoords(new int[]{1, 2})));

    }
}
