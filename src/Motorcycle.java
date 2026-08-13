public class Motorcycle extends Vehicle {
    // TODO 4: Add a field only motorcycles have:
    private boolean hasSidecar;

    // TODO 5: Create the constructor:
    public Motorcycle(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }

    // TODO 6: Override displayInfo() with @Override.
    @Override
    public void displayInfo() {
        if (hasSidecar) {
            System.out.println("Motorcycle: " + brand + " (" + year + ") - with sidecar");
        } else {
            System.out.println("Motorcycle: " + brand + " (" + year + ") - no sidecar");
        }
    }
}