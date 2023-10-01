package model;

import utilities.Utilities;

import java.util.Arrays;

public class Field {
    private final Cell[][] field;
    private final int sideSize;
    private int filledCellsNum;

    private Cell previousPlayer;

    public Field(int sideSize) {
        filledCellsNum = 0;
        this.sideSize = sideSize;
        field = new Cell[sideSize][sideSize];
        for (Cell[] cells : field) {
            Arrays.fill(cells, Cell.EMPTY);
        }
    }


    public MoveReport makeMove(Cell playerNumber, int x, int y) {
        if (playerNumber == previousPlayer){
            return new MoveReport(MoveOutcome.WRONG_MOVE, "Now is the other's player move");
        }
        previousPlayer = playerNumber;

        String message = getErrorMessage(x, y);
        if (message != null) {
            return new MoveReport(MoveOutcome.WRONG_MOVE, message);
        } else {
            return new MoveReport(checkMoveOutcomeAndMove(playerNumber, x, y), "");
        }
    }

    //returns null if no error
    @org.jetbrains.annotations.Nullable
    private String getErrorMessage(int x, int y) {
        if (!Utilities.inRange(0, sideSize, x)) {
            return "At least X out of the field!";
        }
        if (!Utilities.inRange(0, sideSize, y)) {
            return "Y out of the field!";
        }
        if (field[x][y] != Cell.EMPTY) {
            return "This cell is already filled";
        } else {
            return null; //вообще, так делать плохо, но тут это - самое простое решение
        }
    }

    private MoveOutcome checkMoveOutcomeAndMove(Cell playerID, int x, int y) {
        if (checkVertVictory(playerID, x, y)){
            return MoveOutcome.VICTORY;
        }
        if (checkHorVictory(playerID, x, y)){
            return MoveOutcome.VICTORY;
        }
        if (checkDiagVictory(playerID, x, y)){
            return MoveOutcome.VICTORY;
        }

        if (filledCellsNum == sideSize*sideSize - 1){
            return MoveOutcome.DRAW;
        }

        filledCellsNum++;
        field[x][y] = playerID;
        return MoveOutcome.SUCCESS;
    }

    private boolean checkHorVictory(Cell playerID, int x, int y) {
        int vertFilledCellsNum = 0;
        for (Cell cell : field[x]) {
            if (cell == playerID) {
                vertFilledCellsNum++;
            }
        }
        if (vertFilledCellsNum == sideSize - 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkVertVictory(Cell playerID, int x, int y) {
        int horFilledCellsNum = 0;
        for (Cell[] cells : field) {
            if (cells[y] == playerID) {
                horFilledCellsNum++;
            }
        }
        if (horFilledCellsNum == sideSize - 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkDiagVictory(Cell playerID, int x, int y) {
        if (x == y || x + y == sideSize) {
            //first big diagonal
            int diagFilledCellsNum = 0;
            for (int i = 0; i < sideSize; i++) {
                if (field[i][i] == playerID) {
                    diagFilledCellsNum++;
                }
            }
            if (diagFilledCellsNum == sideSize - 1) {
                return true;
            } else {
                //second big diagonal
                diagFilledCellsNum = 0;
                for (int i = 0; i < sideSize; i++) {
                    if (field[sideSize - i - 1][i] == playerID) {
                        diagFilledCellsNum++;
                    }

                }
                if (diagFilledCellsNum == sideSize - 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } else{
            return false;
        }

    }

    private int countNonEmptyCells(){
        int count = 0;
        for (int i = 0; i < sideSize; i++) {
            for (int j = 0; j < sideSize; j++) {
                if (field[i][j] != Cell.EMPTY){
                    count++;
                }
            }
        }
        return count;
    }

    public enum Cell {
        PLAYER1,
        PLAYER2,
        EMPTY
    }

}
