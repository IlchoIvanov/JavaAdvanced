package CatLady;

public class StreetExtraordinaire extends Cat{
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        this.name = name;
        this.decibelsOfMeows = decibelsOfMeows;
    }
    @Override
    public String toString() {
        return String.format("%s %s %.2f", "StreetExtraordinarie", this.getName(), this.decibelsOfMeows);
    }
}
