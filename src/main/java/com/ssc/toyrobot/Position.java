package com.ssc.toyrobot;

public record Position(int x, int y) {
    public Position move(Direction d) {
        return new Position(x + d.getDx(), y + d.getDy());
    }
}
