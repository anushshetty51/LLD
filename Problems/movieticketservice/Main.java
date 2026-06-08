package Problems.movieticketservice;

import java.time.LocalDateTime;
import java.util.List;

import Problems.movieticketservice.entities.Cinema;
import Problems.movieticketservice.entities.City;
import Problems.movieticketservice.entities.Movie;
import Problems.movieticketservice.entities.Payment;
import Problems.movieticketservice.entities.Screen;
import Problems.movieticketservice.entities.Seat;
import Problems.movieticketservice.entities.Show;
import Problems.movieticketservice.enums.PaymentStatus;
import Problems.movieticketservice.enums.SeatType;

public class Main {
    public static void main(String[] args) {
        City city = new City("city-1", "Bengaluru");
        Movie movie = new Movie("movie-1", "Inception", 148);
        Seat seat = new Seat("A1", 1, 1, SeatType.PREMIUM);
        Screen screen = new Screen(1, List.of(seat));
        Cinema cinema = new Cinema("cinema-1", "PVR Orion", city, List.of(screen));
        Show show = new Show("show-1", movie, screen, LocalDateTime.now(), seatType -> 250.0);
        Payment payment = new Payment(250.0, PaymentStatus.COMPLETED, "txn-1");

        System.out.println("Movie: " + show.getMovie().getTitle());
        System.out.println("Cinema: " + cinema.getName());
        System.out.println("Payment: " + payment.getStatus());
    }
}
