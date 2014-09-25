package com.example.conwaysgameoflife;

import java.util.ArrayList;

public class Grid {
    private Cell[][] grid = new Cell[20][20];


    Grid(int[][] coordinatesPairs) {
        initializeBlankGrid();
        seedLiveCells(coordinatesPairs);
    }

    public void printGrid() {
        for (Cell[] cellRow: grid) {
            for (Cell cell: cellRow) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public ArrayList<int[]> getNeighboringCoords(int[] coordPair) {
        ArrayList<int[]> neighborCoords = new ArrayList<int[]>();
        int lowRow = (coordPair[1] - 1) >= 0 ? (coordPair[1] - 1) : coordPair[1];
        int lowCol = (coordPair[0] - 1) >= 0 ? (coordPair[0] - 1) : coordPair[0];
        int highRow = (coordPair[1] + 1) <= grid.length ? (coordPair[1] + 1) : coordPair[1];
        int highCol = (coordPair[0] + 1) <= grid[0].length ? (coordPair[0] + 1) : coordPair[0];
        for (; lowRow <= highRow; lowRow++) {
            for (lowCol = (coordPair[0] - 1) >= 0 ? (coordPair[0] - 1) : coordPair[0]; lowCol <= highCol; lowCol++) {
                neighborCoords.add(new int[] {lowRow, lowCol});
            }
        }
        return neighborCoords;
    }

//    private ArrayList<Cell> getLiveCells() {
//        ArrayList<Cell> liveCells = new ArrayList<Cell>();
//        for (Cell[] cellRow: grid) {
//            for (Cell cell: cellRow) {
//                if (cell.alive) {
//                    liveCells.add(cell);
//                }
//            }
//        }
//        return liveCells;
//    }

    private Cell getCell(int[] coordPair) {
        return grid[coordPair[1]][coordPair[0]];
    }

    private void initializeBlankGrid() {
        for (int y=0; y < grid.length; y++) {
            for (int x=0; x < grid[0].length; x++) {
                grid[y][x] = new Cell();
            }
        }
    }

    private void seedLiveCells(int[][] coordinatesPairs) {
        for (int[] coordPair: coordinatesPairs) {
            grid[(coordPair[1])][coordPair[0]].spontaneouslyGenerate();
        }
    }
}
