package tableau;

public class Bouton {
    private final String label;
    private final String action;

    public Bouton(String label, String action) {
        this.label = label;
        this.action = action;
    }

    public String getLabel() {
        return label;
    }

    public String getAction() {
        return action;
    }
}
