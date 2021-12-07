package main.java.fr.daart;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public abstract class AoC2021 {

    public abstract void run();

    protected void println(Object o) {
        System.out.println(o);
    }

    protected List<String> readInput(String filename) {
        try {
            return Files.readAllLines(Paths.get(this.getClass().getResource(filename).toURI()), Charset.defaultCharset());
        } catch (IOException | URISyntaxException e) {
            System.err.println(e);
        }
        return null;
    }

    protected String readInputAsString(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(this.getClass().getResource(filename).toURI())));
        } catch (IOException | URISyntaxException e) {
            System.err.println(e);
        }
        return null;
    }

    protected Stream<String> streamInput(String filename) {
        try {
            return Files.lines(Paths.get(this.getClass().getResource(filename).toURI()));
        } catch (IOException | URISyntaxException e) {
            System.err.println(e);
        }
        return null;
    }
}
