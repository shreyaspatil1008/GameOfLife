package com.ideas.game.rules;

import com.ideas.game.Life;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReproductionRuleTest {

    private ReproductionRule reproductionRule = new ReproductionRule();

    @Test
    public void test() {
        assertEquals(Life.DEAD, reproductionRule.applyRule(Life.DEAD, 1));
        assertEquals(Life.ALIVE, reproductionRule.applyRule(Life.DEAD, 3));
        assertEquals(Life.DEAD, reproductionRule.applyRule(Life.DEAD, 4));

        assertEquals(Life.ALIVE, reproductionRule.applyRule(Life.ALIVE, 1));
        assertEquals(Life.ALIVE, reproductionRule.applyRule(Life.ALIVE, 3));
    }

}