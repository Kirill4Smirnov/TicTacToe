package model;


public class MoveReport {
    private final MoveOutcome outcome;
    private final String message;

    public MoveReport(MoveOutcome outcome, String message) {
        this.outcome = outcome;
        this.message = message;
    }

    public MoveOutcome getOutcome() {
        return outcome;
    }

    public String getMessage() {
        return message;
    }
}

