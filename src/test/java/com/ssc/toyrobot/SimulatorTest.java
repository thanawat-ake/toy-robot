package com.ssc.toyrobot;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SimulatorTest {

    @Test
    public void exampleA() {
        var out = new ByteArrayOutputStream();
        var simulator = new Simulator(new Table(5,5), new PrintStream(out));
        simulator.execute(new Commands.Place(0, 0, Direction.NORTH));
        simulator.execute(new Commands.Move());
        simulator.execute(new Commands.Report());
        assertEquals("0,1,NORTH", out.toString().trim());
    }

    @Test
    public void exampleB() {
        var out = new ByteArrayOutputStream();
        var simulator = new Simulator(new Table(5,5), new PrintStream(out));
        simulator.execute(new Commands.Place(0, 0, Direction.NORTH));
        simulator.execute(new Commands.Left());
        simulator.execute(new Commands.Report());
        assertEquals("0,0,WEST", out.toString().trim());
    }

    @Test
    public void exampleC() {
        var out = new ByteArrayOutputStream();
        var simulator = new Simulator(new Table(5,5), new PrintStream(out));
        simulator.execute(new Commands.Place(1, 2, Direction.EAST));
        simulator.execute(new Commands.Move());
        simulator.execute(new Commands.Move());
        simulator.execute(new Commands.Left());
        simulator.execute(new Commands.Move());
        simulator.execute(new Commands.Report());
        assertEquals("3,3,NORTH", out.toString().trim());
    }

    @Test
    public void ignoreMovesThatFallOff() {
        var simulator = new Simulator(new Table(5,5), System.out);
        simulator.execute(new Commands.Place(0, 0, Direction.SOUTH));
        simulator.execute(new Commands.Move());
        assertEquals("0,0,SOUTH", simulator.reportStringOrNull());
    }

    @Test
    public void ignoreInvalidPlace() {
        var simulator = new Simulator(new Table(5,5), System.out);
        simulator.execute(new Commands.Place(9, 9, Direction.NORTH));
        assertFalse(simulator.isPlaced());
    }

}