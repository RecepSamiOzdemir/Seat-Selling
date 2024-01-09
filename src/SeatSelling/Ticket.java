package SeatSelling;
import java.util.Scanner;

public class Ticket {
    Boolean[] seats = {false, false, false, false, false, false, false, false, false, false};
  //Boolean[] seats = {true, true, true, true, true, false, false, false, false, false};
  //Boolean[] seats = {false, false, false, false, false, true, true, true, true, true}; //testing arrays
  //Boolean[] seats = {true, true, true, true, true,true, true, true, true, false};

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Scanner scn = new Scanner(System.in);
        boolean run = true;
        
        while (run) {
        	if(ticket.allFull()) {
                System.out.println("\nAll seats are taken\n");
                System.out.println("\nNext flight leaves in 3 hours.\n");
                scn.close();
                System.exit(1);
        	}
            System.out.println("\nPlease type 1 for Buying First Class Ticket\nPlease type 2 for Buying Economy Class Ticket\nPlease type 3 for Ticket Validation\nPlease type 0 for Exiting program\n");
            int operation = scn.nextInt();

            switch (operation) {
                case 0:
                    run = false;
                    System.out.println("\nExiting the program...\n");
                    scn.close();
                    System.exit(1);
                    break;
                case 1:
                    if (ticket.firstClassFull()) {
                        System.out.println("\nAll First Class seats are full\nWould you like to take Economy Class?\n(1 for Yes, 2 for No)\n");
                        int continueTo = scn.nextInt();
                        if (continueTo == 1) {
                            ticket.reserveEconomyClassSeat();
                        }else{
                            System.out.println("\nNext flight leaves in 3 hours.\n");
                            scn.close();
                            System.exit(1);
                        }
                    } else {
                        ticket.reserveFirstClassSeat();
                    }
                    break;
                case 2:                   
                    if (ticket.economyClassFull()) {
                        System.out.println("\nAll Economy Class seats are full\nWould you like to take First Class?\n(1 for Yes, 2 for No)");
                        int continueTo = scn.nextInt();
                        if (continueTo == 1) {
                            ticket.reserveFirstClassSeat();
                        }else{
                            System.out.println("\nNext flight leaves in 3 hours.\n");
                            scn.close();
                            System.exit(1);
                        }
                    } else {
                        ticket.reserveEconomyClassSeat();
                    }
                    break;
                case 3:
                    ticket.ticketValidation();
                    break;
                default:
                    System.out.println("\nPlease enter a listed number...\n");
            }
        }
    }

    public boolean allFull() {// checks all seats are taken or not
        for (Boolean seat : seats) {
            if (!seat) {
                return false;
            }
        }
        return true;
        
    }

    public boolean firstClassFull() {// checks First Class seats are taken or not
        for (int i = 0; i < 5; i++) {
            if (!seats[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean economyClassFull() {// checks Economy Class seats are taken or not
        for (int i = 5; i < 10; i++) {
            if (!seats[i]) {
                return false;
            }
        }
        return true;
    }

    public void reserveFirstClassSeat() {// receiving First Class seat
        System.out.println("\nEmpty seats in First Class are:\n ");
        for (int i = 0; i < 5; i++) {
            if (!seats[i]) {
                System.out.println("Seat " + (i + 1) + " is empty.");
            }else {
            	System.out.println("Seat "+ (i + 1) + "is received");
            }
        }

        Scanner scn = new Scanner(System.in);
        System.out.println("\nPlease enter the seat number of the First Class seat you would like to reserve:\n");
        int seatID = scn.nextInt();
        if (seatID >= 1 && seatID <= 5) {
            int i = seatID - 1;
            if (!seats[i]) {
                seats[i] = true;
                System.out.println("\nSeat " + seatID + " in First Class reserved successfully\n.");
            } else {
                System.out.println("\nSeat " + seatID + " is already taken.\n");
            }
        } else {
            System.out.println("\nInvalid seat number. Please enter a valid seat number.\n");
        }
    }

    public void reserveEconomyClassSeat() {// receiving Economy Class seat
        System.out.println("\nEmpty seats in Economy Class are: \n");
        for (int i = 5; i < 10; i++) {
            if (!seats[i]) {
                System.out.println("Seat " + (i + 1) + " is empty.");
            } else {
                System.out.println("Seat " + (i + 1) + " is received.");
            }
        }

        Scanner scn = new Scanner(System.in);
        System.out.println("\nPlease enter the seat number of the Economy Class seat you would like to reserve:\n");
        int seatID = scn.nextInt();
        if (seatID >= 6 && seatID <= 10) {
            int i = seatID - 1;
            if (!seats[i]) {
                seats[i] = true;
                System.out.println("\nSeat " + seatID + " in Economy Class reserved successfully.\n");
            } else {
                System.out.println("\nSeat " + seatID + " is already taken.\n");
            }
        } else {
            System.out.println("\nInvalid seat number. Please enter a valid seat number.\n");
        }
    }

    public void ticketValidation(){ // validating all seats
        Scanner scn = new Scanner(System.in);
        System.out.println("\nPlease enter the seat number which you want to check validation:\n");
        int seatID = scn.nextInt();

        if (seatID >= 1 && seatID <= 10) {
            int i = seatID - 1;
            if (seats[i]){
                System.out.println("\nNumber " + seatID + " seat is reserved\n");
            }else{
                System.out.println("\nNumber " + seatID + " seat is not reserved\n");
            }
        } else {
            System.out.println("\nInvalid seat number. Please enter a valid seat number.\n");
        }
    }
}