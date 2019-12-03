package TeamOneMiniProject;

public class Risks {
    private String description;
    private double impact;
    private double probability;

    public Risks(String description, double impact, double probability) {
        this.description = description;
        this.impact = impact;
        this.probability = probability;
    }
//    try to understand or remove it

    public Risks() {

    }

    public String getDescription() {
        return description;
    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    public double getImpact() {
        return impact;
    }
//
//    public void setImpact(double impact) {
//        this.impact = impact;
//    }

    public double getProbability() {
        return probability;
    }

//    public void setProbability(double probability) {
//        this.probability = probability;
//    }

    @Override
    public String toString() {
        return "Risks{" +
                "description='" + description + '\'' +
                ", impact=" + impact +
                ", probability=" + probability +
                '}';
    }
}
