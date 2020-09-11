package com.example.hw10.model;

import java.util.Random;

// States for tasks
public enum State {
    Todo, Doing, Done;

    public static State getRandomState() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
