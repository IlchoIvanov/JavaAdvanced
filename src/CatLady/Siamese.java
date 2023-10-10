package CatLady;

public class Siamese  extends  Cat{
    private double earSize;
    public Siamese(String name, double earSize) {
        this.name = name;
        this.earSize = earSize;
    }
    @Override
    public String toString() {
        return String.format("%s %s %.2f", "Siamese", this.getName(), this.earSize);
    }
}
