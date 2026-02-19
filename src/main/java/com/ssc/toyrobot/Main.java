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
                var cmdOpt = commandParser.parse(line);

                if (cmdOpt.isEmpty()) {
                    continue;
                }
                Command command = cmdOpt.get();

                // discard everything until a valid PLACE is executed
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
