import java.util.Scanner;
 
class Reservation {
    protected String reservationID;
    protected String customerName;
    protected String reservationDate;
 
    public Reservation(String reservationID, String customerName, String reservationDate) {
        this.reservationID = reservationID;
        this.customerName = customerName;
        this.reservationDate = reservationDate;
    }
 
    public void checkReservationStatus() {
        System.out.println("Reservation ID: " + reservationID);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Reservation Date: " + reservationDate);
        System.out.println("Status: Confirmed");
    }
 
    public void modifyReservation(String customerName, String reservationDate) {
        this.customerName = customerName;
        this.reservationDate = reservationDate;
        System.out.println("Reservation details updated successfully.");
    }
}
 
class ResortReservation extends Reservation {
    private int roomNumber;
 
    public ResortReservation(String reservationID, String customerName, String reservationDate, int roomNumber) {
        super(reservationID, customerName, reservationDate);
        this.roomNumber = roomNumber;
    }

    @Override
    public void checkReservationStatus() {
        super.checkReservationStatus();
        System.out.println("Room Number: " + roomNumber);
    }
 
    public void modifyReservation(int roomNumber) {
        this.roomNumber = roomNumber;
        System.out.println("Room number updated to: " + roomNumber);
    }
}
 
class RailwayReservation extends Reservation {
    private int seatNumber;
 
    public RailwayReservation(String reservationID, String customerName, String reservationDate, int seatNumber) {
        super(reservationID, customerName, reservationDate);
        this.seatNumber = seatNumber;
    }
 
    @Override
    public void checkReservationStatus() {
        super.checkReservationStatus();
        System.out.println("Seat Number: " + seatNumber);
    }
 
    public void modifyReservation(int seatNumber) {
        this.seatNumber = seatNumber;
        System.out.println("Seat number updated to: " + seatNumber);
    }
}
 
public class ReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Creating a Resort Reservation...");
        System.out.print("Enter Reservation ID: ");
        String resortReservationID = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String resortCustomerName = scanner.nextLine();
        System.out.print("Enter Reservation Date (YYYY-MM-DD): ");
        String resortReservationDate = scanner.nextLine();
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
 
        ResortReservation resortReservation = new ResortReservation(resortReservationID, resortCustomerName, resortReservationDate, roomNumber);
        resortReservation.checkReservationStatus();

        System.out.println("\nModifying Resort Reservation...");
        System.out.print("Enter new Customer Name: ");
        String newResortCustomerName = scanner.nextLine();
        System.out.print("Enter new Reservation Date (YYYY-MM-DD): ");
        String newResortDate = scanner.nextLine();
        System.out.print("Enter new Room Number: ");
        int newRoomNumber = scanner.nextInt();
        scanner.nextLine();
 
        resortReservation.modifyReservation(newResortCustomerName, newResortDate);
        resortReservation.modifyReservation(newRoomNumber);
        resortReservation.checkReservationStatus();
 
        System.out.println("\nCreating a Railway Reservation...");
        System.out.print("Enter Reservation ID: ");
        String railwayReservationID = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String railwayCustomerName = scanner.nextLine();
        System.out.print("Enter Reservation Date (YYYY-MM-DD): ");
        String railwayReservationDate = scanner.nextLine();
        System.out.print("Enter Seat Number: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine();
 
        RailwayReservation railwayReservation = new RailwayReservation(railwayReservationID, railwayCustomerName, railwayReservationDate, seatNumber);
        railwayReservation.checkReservationStatus();

        System.out.println("\nModifying Railway Reservation...");
        System.out.print("Enter new Customer Name: ");
        String newRailwayCustomerName = scanner.nextLine();
        System.out.print("Enter new Reservation Date (YYYY-MM-DD): ");
        String newRailwayDate = scanner.nextLine();
        System.out.print("Enter new Seat Number: ");
        int newSeatNumber = scanner.nextInt();
 
        railwayReservation.modifyReservation(newRailwayCustomerName, newRailwayDate);
        railwayReservation.modifyReservation(newSeatNumber);
        railwayReservation.checkReservationStatus();
 
        scanner.close();
    }
}
