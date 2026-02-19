package com.ssc.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    @Test
    public void parsePlaceWithSpacesCaseInsensitive() {
        var commandParser = new CommandParser();
        var cmd = commandParser.parse(" place 1 , 2 , east ").orElseThrow();
        assertTrue(cmd instanceof Commands.Place);
        var place = (Commands.Place) cmd;
        assertEquals(1, place.x());
        assertEquals(2, place.y());
        assertEquals(Direction.EAST, place.direction());
    }

    @Test
    public void unknownCommandReturnsEmpty() {
        var commandParser = new CommandParser();
        assertTrue(commandParser.parse("JUMP").isEmpty());
    }

}