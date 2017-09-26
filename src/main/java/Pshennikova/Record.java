package Pshennikova;


import java.util.*;

public abstract class Record {
    private static int counter = 0;
    private int id;

    public Record() {
        counter++;
        id = counter;
    }

    public int getId() {
        return id;
    }

public abstract boolean contains(String str);


}

