package com.example;

import java.util.List;

public class Lion {

    private final Feline feline;
    private final boolean hasMane;

    public Lion(Feline feline, String sex) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("используйте доступные значения пола животных - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat();
    }
}