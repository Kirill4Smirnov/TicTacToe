package controller;


import model.Field;
import view.ConsoleUI;
import view.UI;

public class Controller {
    private UI ui;
    private Field field;

    public Controller() {
        ui = new ConsoleUI();
    }

    public void playGame() {
        ui.greetUser();
        field = new Field(3);


    }
}
