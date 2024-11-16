import java.util.*;

public class Hotel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

      
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(101, 1));
        rooms.add(new Room(102, 1));
        rooms.add(new Room(201, 2));
        rooms.add(new Room(202, 2));
        rooms.add(new Room(301, 3));
        
        int[] hotelRating = new int[rooms.size()];

        
        HashSet<Integer> floors = new HashSet<>();
        for (Room room : rooms) {
            floors.add(room.getFloor());
        }

        
        HashMap<Integer, String> reservations = new HashMap<>();

        System.out.println("Welcome to the Hotel Reservation System!");
        System.out.println("Available Rooms and Prices:");
        for (Room room : rooms) {
            room.printInfo();
            System.out.println();
        }

        System.out.println("Available Floors: " + floors);
        System.out.print("Enter your name: ");
        String guestName = input.nextLine();

        System.out.print("Enter the room number to reserve: ");
        int roomNumber = input.nextInt();
        input.nextLine();
        
        
        // Reserve room
        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null && !selectedRoom.isReserved()) {
            selectedRoom.reserve(guestName, "12-01-2024");
            reservations.put(roomNumber, guestName);
            System.out.println("Price for your stay: $" + selectedRoom.getPrice());
        } else if (selectedRoom != null) {
            System.out.println("Room is already reserved.");
        } else {
            System.out.println("Invalid room number.");
        }

        System.out.print("Enter the room number to check out: ");
        roomNumber = input.nextInt();

        // Check out room
        selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null && selectedRoom.isReserved()) {
            selectedRoom.checkOut();
            reservations.remove(roomNumber);
            
            System.out.print("Please rate your stay (1 to 10): ");
            int rating = input.nextInt();
            
            if (rating >= 1 && rating <= 10) {
                int roomRating = rooms.indexOf(selectedRoom); //using IndexOf to locate room and get rating in the hotelRating array
                hotelRating[roomRating] = rating;
                System.out.println("Thank you for your feedback! You rated your experience: " + rating + "/10");
            } else {
                System.out.println("Invalid rating. Please rate between 1 and 10.");
            }
        } else if (selectedRoom != null) {
            System.out.println("Room is not reserved.");
        } else {
            System.out.println("Invalid room number.");
        }
    }
}
