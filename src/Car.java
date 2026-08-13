public class Car extends Vehicle {
    // TODO 1: Add a field only cars have:
    private int numberOfDoors;

    // TODO 2: Create the constructor:
    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year);
        this.numberOfDoors = numberOfDoors;
    }

    // TODO 3: Override displayInfo() with @Override
    @Override
    public void displayInfo() {
        System.out.println("Car: " + brand + " (" + year + ") - "
                + numberOfDoors + " doors");
    }
}
