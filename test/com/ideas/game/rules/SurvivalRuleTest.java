package com.ideas.game.rules;

import com.ideas.game.Life;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SurvivalRuleTest {

    private SurvivalRule survivalRule = new SurvivalRule();

    @Test
    public void test() {
        assertEquals(Life.DEAD, survivalRule.applyRule(Life.DEAD, 1));
        assertEquals(Life.DEAD, survivalRule.applyRule(Life.DEAD, 2));
        assertEquals(Life.DEAD, survivalRule.applyRule(Life.DEAD, 3));

        assertEquals(Life.DEAD, survivalRule.applyRule(Life.ALIVE, 1));
        assertEquals(Life.ALIVE, survivalRule.applyRule(Life.ALIVE, 2));
        assertEquals(Life.ALIVE, survivalRule.applyRule(Life.ALIVE, 3));
    }

}