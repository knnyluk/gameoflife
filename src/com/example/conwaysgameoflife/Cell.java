package com.example.conwaysgameoflife;

public class Cell {
    public boolean alive;

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
