public class Accommodation {
    private int roomNumber;
    private boolean isReserved;
    private String reservedBy;

    public Accommodation(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isReserved = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve(String guestName) {
        if (!isReserved) {
            isReserved = true;
            reservedBy = guestName;
            System.out.println("Room " + roomNumber + " reserved by " + guestName);
        }
        else{
            System.out.println("Room " + roomNumber + " is already reserved by " + reservedBy );
        }
    }

    public void checkOut() {
        if (isReserved) {
            System.out.println("Room " + roomNumber + " checked out by " + reservedBy + ".");
            isReserved = false;
            reservedBy = null;
            
        }
        else {
            System.out.println("Room " + roomNumber + " is not reserved.");
        }
    }

    public void printInfo() {
        System.out.println("Room Number: " + roomNumber);
        if (isReserved) {
            System.out.println("Reserved by: " + reservedBy );
        } 
        else {
            System.out.println("Room is available.");
        }
    }
}
