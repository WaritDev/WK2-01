public class Square {
    private final String name;
    private final int location;

    public Square(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return name;
    }
}