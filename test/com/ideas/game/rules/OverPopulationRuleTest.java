package com.ideas.game.rules;

import com.ideas.game.Life;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OverPopulationRuleTest {

    private OverPopulationRule overPopulationRule = new OverPopulationRule();

    @Test
    public void test() {
        assertEquals(Life.DEAD, overPopulationRule.applyRule(Life.DEAD, 1));
        assertEquals(Life.DEAD, overPopulationRule.applyRule(Life.DEAD, 2));
        assertEquals(Life.DEAD, overPopulationRule.applyRule(Life.DEAD, 3));
        assertEquals(Life.DEAD, overPopulationRule.applyRule(Life.DEAD, 4));

        assertEquals(Life.ALIVE, overPopulationRule.applyRule(Life.ALIVE, 1));
        assertEquals(Life.ALIVE, overPopulationRule.applyRule(Life.ALIVE, 2));
        assertEquals(Life.ALIVE, overPopulationRule.applyRule(Life.ALIVE, 3));
        assertEquals(Life.DEAD, overPopulationRule.applyRule(Life.ALIVE, 4));
    }

}