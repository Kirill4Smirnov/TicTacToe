package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UI {
    private List<StepDoneObserver> stepDoneObservers;
    private Scanner scanner;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        stepDoneObservers = new ArrayList<>();
    }

    public void subscribeForStepDoneEvent(StepDoneObserver observer) {
        stepDoneObservers.add(observer);
    }


    @Override
    public void greetUser() {
        System.out.println("Вечер в хату, уважаемый");;
    }

    public void readMove(int playerId) {
        System.out.println("Куда ходить, насяйника?");

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        notifyStepDoneObservers(x, y, playerId);
    }

    private void notifyStepDoneObservers(int x, int y, int playerId) {
        for (StepDoneObserver observer : stepDoneObservers) {
            observer.processStepDone(x, y, playerId);
        }
    }

    @Override
    public void printWrongMove(String message) {
        System.out.println("Wrong move: " + message);
    }

    @Override
    public void printVictory(int playerId) {
        if (playerId == 1){
            System.out.println("Player 1 won!");
        } else if (playerId == 2){
            System.out.println("Player 2 won!");
        }

    }

    @Override
    public void printDraw() {
        System.out.println("Draw!");
    }

    @Override
    public void printField(int[][] field) {
        for (int[] ints : field) {
            for (int anInt : ints) {
                System.out.printf("%d |", anInt);
            }
            System.out.println();
        }
    }
}
