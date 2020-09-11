package com.example.hw10;

import java.util.Random;
import java.util.UUID;

enum State {
    Todo, Doing, Done;

    public static State getRandomState() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

public class Task {
    private UUID mId;
    private String mName;
    private State mState;


    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
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
