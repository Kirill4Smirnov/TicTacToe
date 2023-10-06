package controller;


import model.Field;
import model.MoveOutcome;
import model.MoveReport;
import view.ConsoleUI;
import view.StepDoneObserver;
import view.UI;

public class Controller implements StepDoneObserver {
    private final UI ui;
    private Field field;
    private int currentId;


    public Controller() {
        ui = new ConsoleUI();
        ui.subscribeForStepDoneEvent(this);
    }

    public void playGame() {
        ui.greetUser();
        field = new Field(3);
        ui.readMove(1);

    }

    @Override
    public void processStepDone(int x, int y, int playerId) {
        System.err.println("Move attempt in " + x + " " + y);
        MoveReport report;
        try {
            report = field.makeMove(playerId, x, y);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        switch (report.getOutcome()) {
            case WRONG_MOVE -> {

                ui.printWrongMove(report.getMessage());
                System.err.println("Wrong move");
                ui.printField(field.getFieldCells());
                ui.readMove(playerId);
            }
            case VICTORY -> {
                ui.printVictory(playerId);
                System.err.println("Victory of player " + playerId);
                return;
            }
            case DRAW -> {
                ui.printDraw();
                System.err.println("Draw");
                return;
            }
            default -> {
                ui.printField(field.getFieldCells());

                if (playerId == 1) {
                    ui.readMove(2);
                } else {
                    ui.readMove(1);
                }

            }
        }

    }
}
