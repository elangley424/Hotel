public class Accommodation {
    private int roomNumber;
    private boolean isReserved;
    private String reservedBy;
    private String reservationEndDate;

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

    public void reserve(String guestName, String endDate) {
        if (!isReserved) {
            isReserved = true;
            reservedBy = guestName;
            reservationEndDate = endDate;
            System.out.println("Room " + roomNumber + " reserved by " + guestName + ". Reservation ends on " + endDate);
        } else {
            System.out.println("Room " + roomNumber + " is already reserved by " + reservedBy + ". Available after " + reservationEndDate);
        }
    }

    public void checkOut() {
        if (isReserved) {
            System.out.println("Room " + roomNumber + " checked out by " + reservedBy + ".");
            isReserved = false;
            reservedBy = null;
            reservationEndDate = null;
        } else {
            System.out.println("Room " + roomNumber + " is not reserved.");
        }
    }

    public void printInfo() {
        System.out.println("Room Number: " + roomNumber);
        if (isReserved) {
            System.out.println("Reserved by: " + reservedBy + ", Reservation ends on: " + reservationEndDate);
        } else {
            System.out.println("Room is available.");
        }
    }
}
