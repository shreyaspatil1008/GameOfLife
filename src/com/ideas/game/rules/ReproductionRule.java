package com.ideas.game.rules;

import com.ideas.game.Life;

public class ReproductionRule implements Rule {
    @Override
    public Life applyRule(Life state, int liveNeighbours) {
        Life value = Life.DEAD;
        if(state == Life.DEAD){
            if(liveNeighbours == 3) {
                value = Life.ALIVE;
            }
        }else{
            return state;
        }
        return value;
    }
}
