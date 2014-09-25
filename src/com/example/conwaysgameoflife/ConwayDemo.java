package com.example.conwaysgameoflife;

public class ConwayDemo {
    public static void main(String[] args) {
//        int[][] sampleCoords = {{9,8},{9,9},{9,10},{8,9}};
//        int[][] sampleCoords = {{9,9},{8,10},{9,10},{10,10},{8,11},{10,11},{8,12},{9,12},{10,12},{9,13}};
        int[][] sampleCoords = {{1,3},{2,3},{3,3},{3,2},{2,1}};
        GameOfLife gameOfLife = new GameOfLife(sampleCoords);
        gameOfLife.play(70, 500);
    }
}
