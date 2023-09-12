package controller;


import view.ConsoleUI;
import view.UI;

public class Controller {
    private UI ui;

    public Controller() {
        ui = new ConsoleUI();
    }

    public void playGame() {
        ui.greetUser();
    }
}
