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

    public int countLiveCells(ArrayList<int[]> coordPairs) {
        int aliveCount = 0;
        for (int[] coordPair: coordPairs) {
            System.out.println("" + coordPair[0] + coordPair[1]);
            if (getCell(coordPair).alive) {
                System.out.println("alive");
                aliveCount += 1;
            }
        }
        return aliveCount;
    }

    public ArrayList<int[]> getNeighboringCoords(int[] coordPair) {
        //will refactor.  Currently works, but row and col need to be swapped.
        ArrayList<int[]> neighborCoords = new ArrayList<int[]>();
        int lowRow = (coordPair[1] - 1) >= 0 ? (coordPair[1] - 1) : coordPair[1];
        int lowCol = (coordPair[0] - 1) >= 0 ? (coordPair[0] - 1) : coordPair[0];
        int highRow = (coordPair[1] + 1) < grid.length ? (coordPair[1] + 1) : coordPair[1];
        int highCol = (coordPair[0] + 1) < grid[0].length ? (coordPair[0] + 1) : coordPair[0];
        for (; lowRow <= highRow; lowRow++) {
            for (lowCol = (coordPair[0] - 1) >= 0 ? (coordPair[0] - 1) : coordPair[0]; lowCol <= highCol; lowCol++) {
                // need better fix for original coords showing up as a neighboring coord
                if (lowCol != coordPair[0] || lowRow != coordPair[1] ) {
                    neighborCoords.add(new int[]{lowCol, lowRow});
                }
            }
        }
        return neighborCoords;
    }

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
