package view;

public interface UI {
    void greetUser();

    void readMove(int playerId);

    void subscribeForStepDoneEvent(StepDoneObserver observer);

    void printWrongMove(String message);

    void printVictory(int playerId);

    void printDraw();

    void printField(int[][] field);
}
