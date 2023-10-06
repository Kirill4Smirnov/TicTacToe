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
        MoveReport report = null;
        try {
            report = field.makeMove(1, 8, 8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(report.getOutcome(), MoveOutcome.WRONG_MOVE);
    }

    @Test
    void makeMovex() {
        Field field = new Field(3);
        MoveReport report = null;
        try {
            report = field.makeMove(1, 1, 8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(report.getOutcome(), MoveOutcome.WRONG_MOVE);
    }

    @Test
    void makeMoveS() {
        Field field = new Field(3);
        MoveReport report = null;
        try {
            report = field.makeMove(1, 1, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(report.getOutcome(), MoveOutcome.SUCCESS);
    }

    @Test
    void makeMoveSS() {
        Field field = new Field(3);
        try {
            field.makeMove(1, 1, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        MoveReport report = null;
        try {
            report = field.makeMove(1, 1, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(report.getOutcome(), MoveOutcome.WRONG_MOVE);
    }

    @Test
    void makeMoveSamePlayer() {
        Field field = new Field(3);
        try {
            field.makeMove(1, 1, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        MoveReport report = null;
        try {
            report = field.makeMove(1, 0, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(report.getOutcome(), MoveOutcome.WRONG_MOVE);
    }

}