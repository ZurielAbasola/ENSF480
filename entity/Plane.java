package entity;
import java.util.HashMap;
import java.util.Map;

public class Plane {
    private int id;
	private Map<String, Seat> seats;

    public Plane(int numRows, int seatsPerRow) {
        if(seatsPerRow > 7 || seatsPerRow < 1 || numRows < 1) {
            //throw new Exception("need 1 < numRows <= 7 && seatsPerRow > 1"); //should improve later
        }
        this.id = (int)Math.random() * 1000000;
        this.seats = new HashMap<>();
        String[] seatLetters = {"A", "B", "C", "D", "E", "F", "G"};
        // go through and initialize all seats
        for(int row = 0; row < numRows; row++) {
            if(row <= 2) {
                for(int i = 0; i < seatsPerRow; i++) {
                    String seatKey = Seat.getSeatKey(row, seatLetters[i]);
                    seats.put(seatKey, new BusinessClassSeat(seatKey));
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

    public Seat getSeat(String key) {
        //String seatKey = Seat.getSeatKey(row, letter);
        return seats.get(key);
    }

    public void setSeat(int row, String letter, Seat seat) {
        String seatKey = Seat.getSeatKey(row, letter);
        seats.put(seatKey, seat);
    }

    public void setSeatFromSql(String seatKey, float price){
        if(price == 1.35f){
            seats.put(seatKey, new ComfortSeat(seatKey));
        }else if(price == 2.1f){
            seats.put(seatKey, new BusinessClassSeat(seatKey));
        }else{
            seats.put(seatKey, new OrdinarySeat(seatKey));
        }
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }

    public void setID(int num){
        this.id=num;
    }

    public int getID(){
        return id;
    }
}