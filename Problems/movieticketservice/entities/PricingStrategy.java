package Problems.movieticketservice.entities;

import Problems.movieticketservice.enums.SeatType;

public interface PricingStrategy {
    double calculatePrice(SeatType seatType);
}
