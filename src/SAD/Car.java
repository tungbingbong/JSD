package SAD;

public class Car {
    int speed;
    double regularPrice;
    String color;
    String carName;

    public Car(int speed, double regularPrice, String color, String carName) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    public double getSalePrice() {
        if(color.equals("black")){
            return regularPrice * 1.5;
        } else {
            return regularPrice * 1.2;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", regularPrice=" + regularPrice +
                ", color='" + color + '\'' +
                ", carName='" + carName + '\'' +
                '}';
    }
}
