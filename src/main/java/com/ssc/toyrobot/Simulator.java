package com.ssc.toyrobot;

import java.io.PrintStream;

public final class Simulator {
    private final Table table;
    private final Robot robot = new Robot();
    private final PrintStream out;

    public Simulator(Table table, PrintStream out) {
        this.table = table;
        this.out = out;
    }

    public void execute(Command command) {
        if (command == null) {
            return;
        }
        command.apply(this);
    }

    public void place(int x, int y, Direction direction) {
        Position position = new Position(x, y);
        if (!table.isValid(position)) {
            return;
        }
        robot.place(position, direction);
    }

    public void move() {
        if (!robot.isPlaced()) {
            return;
        }
        Position next = robot.getPosition().move(robot.getDirection());
        if (table.isValid(next)) {
            robot.setPosition(next);
        }
    }

    public void left() {
        if (!robot.isPlaced()) {
            return;
        }
        robot.setDirection(robot.getDirection().left());
    }

    public void right() {
        if (!robot.isPlaced()) {
            return;
        }
        robot.setDirection(robot.getDirection().right());
    }

    public void report() {
        robot.report().ifPresent(s -> out.println(s));
    }

    public String reportStringOrNull() {
        return robot.report().orElse(null);
    }

    public boolean isPlaced() {
        return robot.isPlaced();
    }
}
