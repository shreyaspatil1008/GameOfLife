import com.ideas.game.GameOfLife;
import com.ideas.game.rules.OverPopulationRule;
import com.ideas.game.rules.ReproductionRule;
import com.ideas.game.rules.SurvivalRule;
import com.ideas.game.rules.UnderPopulationRule;
import com.ideas.game.rules.engine.RuleEngine;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    private int[][] expectedGameBoard;
    private GameOfLife gameOfLife;
    private RuleEngine ruleEngine;

    @Before
    public void setup() {
        int cols = 5;
        int rows = 5;
        expectedGameBoard = new int[rows][cols];
        expectedGameBoard[0][0] = 1;
        expectedGameBoard[1][2] = 1;
        expectedGameBoard[2][2] = 1;
        ruleEngine = new RuleEngine(
                Arrays.asList(
                        new UnderPopulationRule(),
                        new SurvivalRule(),
                        new OverPopulationRule(),
                        new ReproductionRule()
                )
        );
        gameOfLife = new GameOfLife(expectedGameBoard, ruleEngine);
    }

    @Test
    public void weShouldBeAbleToValidateMatrixWithDefauleStateOfLife() {

        int[][] gameBoard = gameOfLife.getGameBoard();
        assertEquals(expectedGameBoard,gameBoard);
    }

    @Test
    public void weShouldBeAbleToGetLiveNeighbours() {

        int liveNeighbours = gameOfLife.getLiveNeighbours(1, 1);
        assertEquals(3, liveNeighbours);
    }

    @Test
    public void checkIfUnderPopulationAppliesForLiveCells() {
        GameOfLife newInstance = gameOfLife.applyRules(1);
        int[][] gameBoard = newInstance.getGameBoard();
        int[][] expectedState = new int[5][5];
        assertEquals(expectedState, gameBoard);

    }


    @Test
    public void shouldApplyRulesIteratively() {
        GameOfLife newState = this.gameOfLife.applyRules(2);
        newState.display();
    }


}

