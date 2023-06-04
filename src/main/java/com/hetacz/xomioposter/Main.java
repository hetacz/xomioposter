package com.hetacz.xomioposter;

import com.hetacz.xomioposter.base.Input;
import com.hetacz.xomioposter.base.Loop;
import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String @NotNull [] args) throws InterruptedException {
        Input input = args.length == 3
                ? Input.of(args)
                : Input.of(10, 1000, 2000);
        new Loop(input).run();
    }
}
