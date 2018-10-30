package com.ideas.game;

import com.ideas.game.rules.engine.RuleEngine;

public class GameOfLife {
    private final int rows;
    private final int cols;
    private final int[][] gameBoard;

    private final RuleEngine ruleEngine;

    public GameOfLife(int[][] gameBoard, RuleEngine ruleEngine) {
        this.gameBoard = gameBoard;
        this.rows = gameBoard.length;
        this.cols = gameBoard[0].length;
        this.ruleEngine = ruleEngine;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public int getLiveNeighbours(int row, int col) {
        int liveNeighBour = 0;
        for(int i=row-1; i<= row+1 ; i++) {
            for(int j=col-1; j <=col+1; j++ ) {
                if( i >= 0 && i < rows && j >= 0 && j < cols && !(i == row && j == col)) {
                    if(gameBoard[i][j] == 1) {
                        liveNeighBour++;
                    }
                }
            }
        }

        //System.out.printf("lives of [%d][%d] = %d%n", row, col,liveNeighBour);
        return liveNeighBour;
    }

    public GameOfLife applyRules(int iterationCount) {
        if(iterationCount <= 0) {
            return this;
        } else {
            GameOfLife newState = iterate();
            return newState.applyRules(iterationCount-1);
        }
    }

    private GameOfLife iterate() {
        int[][] newState = new int[rows][cols];
        for(int i=0; i < rows; i++) {
            for(int j=0; j < cols; j++) {
                int state = gameBoard[i][j];
                Life lifeState = state == 0 ? Life.DEAD : Life.ALIVE;
                Life  value = ruleEngine.applyRule(lifeState, getLiveNeighbours(i, j));
                newState[i][j] = value.getState();
                //System.out.printf("newStat[%d][%d] = %d%n:", i, j, newState[i][j]);
            }

        }
        return new GameOfLife(newState, ruleEngine);
    }


    public void display() {
        StringBuilder buffer = new StringBuilder();
        for(int i=0; i < rows; i++) {
            buffer.append("\n");
            for (int j = 0; j < cols; j++) {
                buffer.append(gameBoard[i][j] + "\t");
            }
        }

        System.out.println(buffer.toString());

    }

}

