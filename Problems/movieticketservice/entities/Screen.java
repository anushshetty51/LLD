package Problems.movieticketservice.entities;

import java.util.List;

public class Screen {
    int id;
    List<Seat> seats;
    public Screen(int id, List<Seat> seats){
        this.id=id;
        this.seats=seats;
    }
    public int getId(){return id;}
    public List<Seat> getSeats(){return seats;}

}
