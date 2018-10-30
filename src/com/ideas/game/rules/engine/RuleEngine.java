package com.ideas.game.rules.engine;

import com.ideas.game.Life;
import com.ideas.game.rules.Rule;

import java.util.List;

public class RuleEngine implements Rule {

    private final List<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = rules;
    }


    public List<Rule> rules() {
        return rules;
    }

    @Override
    public Life applyRule(Life state, int liveNeighbours) {
        return rules.stream()
                .map(rule -> rule.applyRule(state, liveNeighbours))
                .filter(life -> life == Life.DEAD)
                .findFirst()
                .orElse(Life.ALIVE);
    }
}