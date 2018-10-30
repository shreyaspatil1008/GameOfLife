package com.ideas.game.rules;

import com.ideas.game.Life;

public interface Rule {
    Life applyRule(Life state, int liveNeighbours);
}
