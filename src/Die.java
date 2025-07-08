import java.util.Random;

public class Die {
    private int faceValue;
    private final Random random;

    public Die() {
        this.random = new Random();
        this.faceValue = 1;
    }

    public void roll() {
        this.faceValue = random.nextInt(6) + 1;
    }

    public int getFaceValue() {
        return faceValue;
    }
}