package com.ideas.game.rules;

import com.ideas.game.Life;

public class OverPopulationRule implements Rule {
    @Override
    public Life applyRule(Life state, int liveNeighbours) {
        Life value = Life.DEAD;
        if(state == Life.ALIVE){
            if(liveNeighbours > 3) {
                value = Life.DEAD;
            }else{
                value = state;
            }
        }
        return value;
    }
}
