public class Room extends Accommodation {
    private int floor;
    private int price;

    public Room(int roomNumber, int floor) {
        super(roomNumber);
        this.floor = floor;

        // Set price based on floor
        if (floor == 1) {
            this.price = 200;
        } else if (floor == 2) {
            this.price = 300;
        } else if (floor == 3) {
            this.price = 400;
        }
    }

    public int getFloor() {
        return floor;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void printInfo() {
        System.out.println("Floor: " + floor);
        System.out.println("Price per night: $" + price);
        super.printInfo();
    }
}
