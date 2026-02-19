package com.ssc.toyrobot;

public sealed interface Command permits Commands.Left, Commands.Move, Commands.Place, Commands.Report, Commands.Right {
    void apply(Simulator simulator);
}
