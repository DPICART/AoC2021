package main.java.fr.daart.ex03;

import main.java.fr.daart.AoC2021;

import java.util.List;

public class AoC03 extends AoC2021 {
    @Override
    public void run() {

        partOne();
        partTwo();
    }

    private void partOne() {

        var list = readInput("input.txt");
        String bitG = "";
        String bitE = "";
        var length = list.get(0).split("").length;
        for (int j = 0; j < length; j++) {
            var gammaBit = 0;
            var epsiBit = 0;
            for (int i = 0; i < list.size(); i++) {
                var listItem = list.get(i);
                var tab = listItem.split("");
                String item = tab[j];
                if (item.equals("0")) {
                    gammaBit -= 1;
                    epsiBit += 1;
                } else if (item.equals("1")) {
                    gammaBit += 1;
                    epsiBit -= 1;
                }
            }

            if (gammaBit > 0) {
                bitG += "1";
            } else {
                bitG += "0";
            }

            if (gammaBit < 0) {
                bitE += "1";
            } else {
                bitE += "0";
            }
        }

        var mult = Integer.parseInt(bitG, 2) * Integer.parseInt(bitE, 2);
        System.out.println(bitG + " " + Integer.parseInt(bitG, 2) + " | " + bitE + " " + Integer.parseInt(bitE, 2) + " => " + mult);
        // 001100100101 805 | 110011011010 3290 => 2648450
    }

    private void partTwo() {

        var list = readInput("input.txt");

        var length = list.get(0).split("").length;
        List oxyBits = readInput("input.txt");
        List co2Bits = readInput("input.txt");

        for (int x = 0; x < length; x++) {
            oxyBits = getOxyBits(oxyBits, x, "1");
        }

        for (int x = 0; x < length; x++) {
            co2Bits = getCo2Bits(co2Bits, x, "0");
        }

        Integer oxy = Integer.parseInt(oxyBits.get(0).toString(), 2);
        Integer co2 = Integer.parseInt(co2Bits.get(0).toString(), 2);
        System.out.println(oxy + "  " + co2 + " " + oxy * co2);
        // 841  3384 2845944
    }

    private List getCo2Bits(List<String> list, int currentIndex, String winner) {
        if (list.size() == 1) return list;
        var zero = 0;
        var one = 0;
        for (int i = 0; i < list.size(); i++) {
            var listItem = list.get(i);
            var tab = listItem.split("");
            String item = tab[currentIndex];
            if (item.equals("0")) {
                zero++;
            } else if (item.equals("1")) {
                one++;
            }
        }

        var filter = winner;
        if (zero < one) {
            filter = "0";
        } else if (zero > one) {
            filter = "1";
        }

        String finalFilter = filter;
        return list.stream().filter(v -> {
            var tab = v.split("");
            return tab[currentIndex].equals(finalFilter);
        }).toList();
    }

    private List<String> getOxyBits(List<String> list, int currentIndex, String winner) {
        var zero = 0;
        var one = 0;
        for (int i = 0; i < list.size(); i++) {
            var listItem = list.get(i);
            var tab = listItem.split("");
            String item = tab[currentIndex];
            if (item.equals("0")) {
                zero++;
            } else if (item.equals("1")) {
                one++;
            }
        }
        var filter = winner;
        if (zero > one) {
            filter = "0";
        } else if (one > zero) {
            filter = "1";
        }
        String finalFilter = filter;
        return list.stream().filter(v -> {
            var tab = v.split("");
            return tab[currentIndex].equals(finalFilter);
        }).toList();
    }


}
