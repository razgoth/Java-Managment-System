package TeamOneMiniProject;

public class Risk {
    private String description;
    private double impact;
    private double probability;

    public Risk() {
    }

    public Risk(String description, double impact, double probability) {
        this.description = description;
        this.impact = impact;
        this.probability = probability;
    }

    public String getDescription() {
        return description;
    }

    public double getImpact() {
        return impact;
    }

    public double getProbability() {
        return probability;
    }

    public double getRisk() {
        return impact * probability;
    }
}
