package com.example.hw10;

import java.util.Random;

public class Task {
    private String mName;
    private State mState;

    private enum State {
        Todo, Doing, Done;

        public static State getRandomState() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public State getState() {
        return mState;
    }

    public void setState(State state) {
        mState = state;
    }
}
