package com.ssc.toyrobot;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        Table table = new Table(5, 5);
        Simulator simulator = new Simulator(table, System.out);
        CommandParser commandParser = new CommandParser();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = "";
            boolean hasValidPlace = false;

            while ((line = br.readLine()) != null) {
                var commandOpt = commandParser.parse(line);

                if (commandOpt.isEmpty()) {
                    continue;
                }
                Command command = commandOpt.get();

                // discard all commands until a valid PLACE command
                if (!hasValidPlace) {
                    if (command instanceof Commands.Place place) {
                        simulator.execute(command);
                        hasValidPlace = simulator.isPlaced(); // only true if PLACE valid on table
                    }
                    continue;
                }

                simulator.execute(command);
            }
        }
    }
}
