package com.example.conwaysgameoflife;

public class Cell {
    private boolean alive;

    public boolean isAlive() {
        return alive;
    }

    public void live() {
        alive = true;
    }

    public void kill() {
        alive = false;
    }

    public void spontaneouslyGenerate() {
        alive = true;
    }

    public String toString() {
        if (alive) {
            return "X";
        } else {
            return " ";
        }
    }
}
