package tableau;

public class Bouton {
    private String label;
    private String action;

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
