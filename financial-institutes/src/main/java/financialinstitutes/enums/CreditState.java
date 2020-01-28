package financialinstitutes.enums;

public enum CreditState {
    ACTIVE("IN PROGRESS", true),
    BLOCKED("BLOCKED", false),
    FINISHED("FINISHED", false);

    private String state;
    private boolean isActive;

    private CreditState(String state, boolean isActive) {
        this.state = state;
        this.isActive = isActive;
    }

    public String getState() { return state; }

    public boolean isActive() { return isActive; }
}
