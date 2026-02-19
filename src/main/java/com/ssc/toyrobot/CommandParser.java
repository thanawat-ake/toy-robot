package com.ssc.toyrobot;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CommandParser {
    private static final Pattern PLACE = Pattern.compile("^PLACE\\s+(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*([A-Z]+)\\s*$", Pattern.CASE_INSENSITIVE);

    public Optional<Command> parse(String line) {
        if (line == null) {
            return Optional.empty();
        }
        String s = line.trim();
        if (s.isEmpty()) {
            return Optional.empty();
        }

        if (s.equalsIgnoreCase("MOVE")) {
            return Optional.of(new Commands.Move());
        }
        if (s.equalsIgnoreCase("LEFT")) {
            return Optional.of(new Commands.Left());
        }
        if (s.equalsIgnoreCase("RIGHT")) {
            return Optional.of(new Commands.Right());
        }
        if (s.equalsIgnoreCase("REPORT")) {
            return Optional.of(new Commands.Report());
        }

        Matcher matcher = PLACE.matcher(s);
        if (matcher.matches()) {
            try {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                Direction direction = Direction.parse(matcher.group(3));
                return Optional.of(new Commands.Place(x, y, direction));
            } catch (Exception e) {
                return Optional.empty();
            }
        }
        return Optional.empty(); // unknown command
    }
}
