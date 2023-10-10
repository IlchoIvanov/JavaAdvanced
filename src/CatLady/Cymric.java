package CatLady;

public class Cymric extends Cat{
    private double furLenght;

    @Override
    public String toString() {
        return String.format("%s %s %.2f", "Cymric", this.getName(), this.furLenght);
    }

    public Cymric(String name, double furLength) {
        this.name = name;
        this.furLenght = furLength;
    }
}
