package com.ideas.game.rules;

import com.ideas.game.Life;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnderPopulationRuleTest {

    private UnderPopulationRule underPopulationRule = new UnderPopulationRule();

    @Test
    public void test() {
        assertEquals(Life.DEAD, underPopulationRule.applyRule(Life.DEAD, 1));
        assertEquals(Life.DEAD, underPopulationRule.applyRule(Life.DEAD, 3));
        assertEquals(Life.DEAD, underPopulationRule.applyRule(Life.ALIVE, 1));
        assertEquals(Life.ALIVE, underPopulationRule.applyRule(Life.ALIVE, 3));
    }

}