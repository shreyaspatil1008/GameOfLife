package com.ideas.game.rules;

import com.ideas.game.Life;

public class UnderPopulationRule implements Rule {
    @Override
    public Life applyRule(Life state, int liveNeighbours) {
        Life value = Life.DEAD;
        if(state == Life.ALIVE){
            if(!(liveNeighbours < 2)) {
                value = Life.ALIVE;
            }
        }
        return value;
    }
}
