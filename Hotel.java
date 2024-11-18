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


        HashMap<Integer, String> reservations = new HashMap<>();


        HashSet<Integer> restrictedAges = new HashSet<>();
        for (int age = 1; age <= 20; age++) {
            restrictedAges.add(age);
        }
        

        System.out.println("Welcome to the Hotel Reservation System!");
        System.out.println("The available rooms and prices are listed below:");
        System.out.println();
        System.out.println("********************************************");
        System.out.println();

        
        for (Room room : rooms) {
            room.printInfo();
            System.out.println();
        }
        
        
        System.out.println("********************************************");
        System.out.println();

        boolean continueReservation = true;

        while (continueReservation) {
            
            System.out.print("Enter your name: ");
            String guestName = input.nextLine();

            System.out.print("Enter your age: ");
            int guestAge = input.nextInt();
            input.nextLine();

            
            if (restrictedAges.contains(guestAge)) {
                System.out.println("Sorry, you are unable to reserve a room because you are under 21.");
                continue;
            }

            
            System.out.print("Enter the room number to reserve: ");
            int roomNumber = input.nextInt();
            input.nextLine();

            Room selectedRoom = null;
            for (Room room : rooms) {
                if (room.getRoomNumber() == roomNumber) {
                    selectedRoom = room;
                    break;
                }
            }

            if (selectedRoom != null && !selectedRoom.isReserved()) {
                selectedRoom.reserve(guestName);
                reservations.put(roomNumber, guestName);
            } 
            else if (selectedRoom != null) {
                System.out.println("Room is already reserved.");
            } 
            else {
                System.out.println("Invalid room number.");
            }

            
            System.out.print("Would you like to check out another room? yes or no: ");
            String anotherRoom = input.nextLine();

            if (anotherRoom.equalsIgnoreCase("yes")) {
                continue;
            } 
            else {
                break;
            }
        }

        System.out.println();
        System.out.println("********************************************");
        System.out.println();
        System.out.println("Current Reservations: " + reservations);
        System.out.println();

        
        int totalCost = 0;
        for (Integer roomNumber : reservations.keySet()) {
            for (Room room : rooms) {
                if (room.getRoomNumber() == roomNumber) {
                    totalCost += room.getPrice();
                    break;
                }
            }
        }
       
        
        
        System.out.println("Total cost for reserved rooms: $" + totalCost);
        System.out.println();
        
        
        System.out.print("Do you have a promo code? yes or no: ");
        String yesPromoCode = input.nextLine();

        if (yesPromoCode.equalsIgnoreCase("yes")) {
            System.out.print("Enter the promo code: ");
            String promoCode = input.nextLine();

            
            if (promoCode.equals("HALFOFF")) {
                totalCost = (int) (totalCost * 0.5);
                System.out.println("********************************************");
                System.out.println();
                System.out.println("Promo code applied!");
                System.out.println();
                System.out.println();
                System.out.println("Current Reservations: " + reservations);
                System.out.println();
                System.out.println("Total cost for reserved rooms: $" + totalCost);
                System.out.println();
            } 
            else {
                System.out.println("********************************************");
                System.out.println();
                System.out.println("Invalid promo code. No discount applied.");
                System.out.println();
                System.out.println("Current Reservations: " + reservations);
                System.out.println();
                System.out.println("Total cost for reserved rooms: $" + totalCost);
                System.out.println();
            }
        }
        
        
        
        
        System.out.println("********************************************");
        System.out.println();
        System.out.println("Thank you for your reservation, see you soon!");
    }
}
