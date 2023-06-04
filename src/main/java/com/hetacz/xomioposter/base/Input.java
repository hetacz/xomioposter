package com.hetacz.xomioposter.base;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record Input(int reps, int minWait, int maxWait) {

    @Contract("_ -> new")
    public static @NotNull Input of(String @NotNull [] args) {
        return new Input(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }

    @Contract("_, _, _ -> new")
    public static @NotNull Input of(int reps, int minWait, int maxWait) {
        return new Input(reps, minWait, maxWait);
    }
}
