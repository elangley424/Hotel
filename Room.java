public class Room extends Accommodation {
    private int floor;
    private int price;

    private int[] floorPrices = {200, 300, 400};

    public Room(int roomNumber, int floor) {
        super(roomNumber);
        this.floor = floor;

        
        if (floor >= 1 && floor <= floorPrices.length) {
            this.price = floorPrices[floor - 1];
        } 
        else {
            this.price = 0;
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
