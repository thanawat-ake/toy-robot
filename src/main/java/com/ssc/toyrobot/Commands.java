package com.ssc.toyrobot;

public final class Commands {
    private Commands() {}

    public record Place(int x, int y, Direction direction) implements Command {
        @Override
        public void apply(Simulator simulator) {
            simulator.place(x, y, direction);
        }
    }

    public record Move() implements Command {
        @Override
        public void apply(Simulator simulator) {
            simulator.move();
        }
    }

    public record Left() implements Command {
        @Override
        public void apply(Simulator simulator) {
            simulator.left();
        }
    }

    public record Right() implements Command {
        @Override
        public void apply(Simulator simulator) {
            simulator.right();
        }
    }

    public record Report() implements Command {
        @Override
        public void apply(Simulator simulator) {
            simulator.report();
        }
    }
}
