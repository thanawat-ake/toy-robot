package com.ssc.toyrobot;

import java.util.Optional;

public final class Robot {
    private Position position;
    private Direction direction;

    public boolean isPlaced() {
        return position != null && direction != null;
    }

    public Optional<String> report() {
        if (!isPlaced()) {
            return Optional.empty();
        }
        return Optional.of(position.x() + "," + position.y() + "," + direction);
    }

    public void place(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
