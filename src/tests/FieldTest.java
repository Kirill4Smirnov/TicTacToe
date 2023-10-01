package tests;

import model.Field;
import model.MoveOutcome;
import model.MoveReport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void makeMove8() {
        Field field = new Field(3);
        MoveReport report = field.makeMove(Field.Cell.PLAYER1, 8, 8);
        assertEquals(report.getOutcome(), MoveOutcome.WRONG_MOVE);
    }

    @Test
    void makeMovex() {
        Field field = new Field(3);
        MoveReport report = field.makeMove(Field.Cell.PLAYER1, 1, 8);
        assertEquals(report.getOutcome(), MoveOutcome.WRONG_MOVE);
    }

    @Test
    void makeMoveS() {
        Field field = new Field(3);
        MoveReport report = field.makeMove(Field.Cell.PLAYER1, 1, 1);
        assertEquals(report.getOutcome(), MoveOutcome.SUCCESS);
    }

    @Test
    void makeMoveSS() {
        Field field = new Field(3);
        field.makeMove(Field.Cell.PLAYER1, 1, 1);
        MoveReport report = field.makeMove(Field.Cell.PLAYER1, 1, 1);
        assertEquals(report.getOutcome(), MoveOutcome.WRONG_MOVE);
    }

    @Test
    void makeMoveSamePlayer() {
        Field field = new Field(3);
        field.makeMove(Field.Cell.PLAYER1, 1, 1);
        MoveReport report = field.makeMove(Field.Cell.PLAYER1, 0, 1);
        assertEquals(report.getOutcome(), MoveOutcome.WRONG_MOVE);
    }

}