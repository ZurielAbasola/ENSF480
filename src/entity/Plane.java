import java.util.HashMap;
import java.util.Map;

public class Plane {
    private int id;
	private Map<String, Seat> seats;

    public Plane(int numRows, int seatsPerRow) {
        if(seatsPerRow > 7 || seatsPerRow < 1 || numRows < 1) {
            throw new Exception("need 1 < numRows <= 7 && seatsPerRow > 1");//should improve later
        }
        this.id = Math.random() * 1000000;
        this.seats = new HashMap<>();
        String[] seatLetters = {"A", "B", "C", "D", "E", "F", "G"};
        // go through and initialize all seats
        for(int row = 0; row < numRows; row++) {
            if(row <= 2) {
                for(int i = 0; i < seatsPerRow; i++) {
                    String seatKey = Seat.getSeatKey(row, seatLetters[i]);
                    seats.put(seatKey, new Businesspublic classSeat(seatKey));
                }
            } else if(row <= 5) {
                for(int i = 0; i < seatsPerRow; i++) {
                    String seatKey = Seat.getSeatKey(row, seatLetters[i]);
                    seats.put(seatKey, new ComfortSeat(seatKey));
                }
            } else {
                for(int i = 0; i < seatsPerRow; i++) {
                    String seatKey = Seat.getSeatKey(row, seatLetters[i]);
                    seats.put(seatKey, new OrdinarySeat(seatKey));
                }
            }
        }
    }

    public Plane(int numRows) {
        this(numRows, 4);
    }

    public Plane() {
        this(10);
    }

    public Seat getSeat(int row, String letter) {
        String seatKey = Seat.getSeatKey(row, letter);
        return seats.get(seatKey);
    }

    public void setSeat(int row, String letter, Seat seat) {
        String seatKey = Seat.getSeatKey(row, letter);
        seats.put(seatKey, seat);
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }
}