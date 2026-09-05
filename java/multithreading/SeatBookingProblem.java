package multithreading;

import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.sleep;

public class SeatBookingProblem {
    static void main() {
        SeatBooking seatBooking = new SeatBooking();
        Thread r1 = new Thread(() -> {
            boolean isBooked = seatBooking.bookSeat("Aditya");
            if(isBooked) System.out.println("Seat has been booked by 1 "+ Thread.currentThread().getName());
        });
        Thread r2 = new Thread(() -> {
            boolean isBooked = seatBooking.bookSeat("Rohit");
            if(isBooked) System.out.println("Seat has been booked by 2 "+ Thread.currentThread().getName());
        });
        r1.start();
        r2.start();

        try {
            sleep(1000);
        } catch (InterruptedException _) {}

        System.out.println(seatBooking.seat.get());

    }
}

class SeatBooking {
    AtomicReference<String> seat = new AtomicReference<>("EMPTY");

    boolean bookSeat(String name){
        String currentValue = seat.get();
        if(!currentValue.equals("EMPTY")){
            return false;
        }
        return seat.compareAndSet("EMPTY", name); //CAS - atomic operation
    }
}
