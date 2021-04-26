public class Wolf {
    private boolean isMale;
    private String name;
    private double weight;
    private byte age;
    private String color;

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void walk() {
        System.out.println("I'm walking.");
    }

    public void sit() {
        System.out.println("I'm sitting.");
    }

    public void run() {
        System.out.println("I'm running.");
    }

    public void howl() {
        System.out.println("I'm howling.");
    }

    public void hunt() {
        System.out.println("I'm hunting.");
    }
}