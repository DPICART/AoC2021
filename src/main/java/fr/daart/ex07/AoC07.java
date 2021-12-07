package main.java.fr.daart.ex07;

import main.java.fr.daart.AoC2021;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AoC07 extends AoC2021 {
    @Override
    public void run() {
        partOne();
        partTwo();
    }

    private void partOne() {

        var input = Arrays.stream(readInputAsString("input.txt").split(",")).mapToInt(Integer::parseInt).toArray();
        int min = IntStream.of(input).min().orElseThrow();
        int max = IntStream.of(input).max().orElseThrow();

        var resp = IntStream
                .rangeClosed(min, max)
                .map(
                        target ->
                            IntStream
                                    .of(input)
                                    .map(i -> Math.abs(target - i))
                                    .sum()
                )
                .min()
                .orElseThrow();

        System.out.println(resp);

    }

    private void partTwo() {

        var input = Arrays.stream(readInputAsString("input.txt").split(",")).mapToInt(Integer::parseInt).toArray();
        int min = IntStream.of(input).min().orElseThrow();
        int max = IntStream.of(input).max().orElseThrow();

        var resp = IntStream
                .rangeClosed(min, max)
                .map(
                        target ->
                            IntStream
                                    .of(input)
                                    .map(i -> Math.abs(target - i))
                                    .map(i -> (i + 1) * i / 2)
                                    .sum()
                )
                .min()
                .orElseThrow();

        System.out.println(resp);

    }
}
