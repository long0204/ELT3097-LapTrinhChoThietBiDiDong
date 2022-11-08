package com.example.platformcodenames;

import java.util.ArrayList;
import java.util.Arrays;

public class Version {
    private final String name;
    private final double number;

    public static ArrayList<Version> versionList = new ArrayList<>(
            Arrays.asList(
                    new Version("Cupcake", 1.5),
                    new Version("Donut", 1.6),
                    new Version("Eclair", 2.0),
                    new Version("Froyo", 2.2),
                    new Version("Gingerbread", 2.3),
                    new Version("Honeycomb", 3.0),
                    new Version("Ice Cream Sandwich", 4.0),
                    new Version("Jelly Bean", 4.1),
                    new Version("KitKat", 4.4),
                    new Version("Lollipop", 5.0),
                    new Version("Marshmallow", 6.0),
                    new Version("Nougat", 7.0),
                    new Version("Oreo", 8.0),
                    new Version("Pie", 9.0)
            )
    );

    public Version(String name, double number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public double getNumber() {
        return number;
    }
}
