package com.ssc.toyrobot;

public final class Table {
    private final int width;
    private final int height;

    public Table(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw  new IllegalArgumentException("Invalid table size");
        }
        this.width = width;
        this.height = height;
    }

    public boolean isValid(Position p) {
        return p.x() >= 0 && p.y() >= 0 && p.x() < width && p.y() < height;
    }
}
