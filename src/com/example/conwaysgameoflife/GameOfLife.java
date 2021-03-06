package com.example.conwaysgameoflife;

import java.util.ArrayList;

public class GameOfLife {
    private Grid gameGrid;

    GameOfLife(int[][] seedCoordPairs) {
        gameGrid = new Grid(seedCoordPairs);
    }

    public void play(int roundsToBePlayed, int gameSpeed) {
        while (roundsToBePlayed > 0) {
            printGrid();
            sleep(gameSpeed);
            iterate();
            roundsToBePlayed -= 1;
        }
    }

    public void iterate() {
        ArrayList<int[]> nextLiveCoords = findNextRoundLiveCoords();
        wipeBoard();
        placeLiveCells(nextLiveCoords);
    }

    public void printGrid() {
        gameGrid.printGrid();
    }

    public ArrayList<int[]> findNextRoundLiveCoords() {
        ArrayList<int[]> result = new ArrayList<int[]>();
        int[] currentCoords;
        Cell currentCell;
        int liveNeighborCount;
        boolean cellsFate;
        for (int row=0; row < gameGrid.getRowCount(); row++) {
            for (int col=0; col < gameGrid.getColCount(); col++) {
                currentCoords = new int[] {row, col};
                currentCell = gameGrid.getCell(currentCoords);
                liveNeighborCount = gameGrid.liveNeighborCount(currentCoords);
                if (divineFate(liveNeighborCount, currentCell.isAlive())) result.add(currentCoords);
            }
        }
        return result;
    }

    private boolean divineFate(int neighborCount, boolean isCellAlive) {
        if (neighborCount < 2) {
            return false;
        } else if (neighborCount > 3) {
            return false;
        } else if (neighborCount == 2) {
            if (isCellAlive) return true;
            else return false;
        } else if (neighborCount == 3) {
            return true;
        } else return false; //don't really need this, but Java wants it.
    }

    private void wipeBoard() {
        for (Cell[] cellRow: gameGrid.getGrid()) {
            for (Cell cell: cellRow) {
                cell.kill();
            }
        }
    }

    private void placeLiveCells(ArrayList<int[]> liveCoordPairs) {
        for (int[] liveCoordPair: liveCoordPairs) {
            gameGrid.getCell(liveCoordPair).spontaneouslyGenerate();
        }
    }

    private void sleep(int timeInMS) {
        try {
            Thread.sleep(timeInMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
