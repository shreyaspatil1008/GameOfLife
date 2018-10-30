package com.ideas.game;

public enum Life {
    DEAD(0),
    ALIVE (1);

    private final int state;

    Life(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
