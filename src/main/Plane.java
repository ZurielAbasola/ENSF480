class Plane {
	private Map<String, Seat> seats;

	String getSeatKey(int row, String letter) {
		return row + letter;
	}

    public Plane() {
        this.seats = new HashMap<>();
        String[] seatLetters = {"A", "B", "C", "D"};
        // go through and initialize all seats
        for(int row = 0; row < 10; row++) {
        	if(row <= 2) {
        		for(String letter : seatLetters) {
        			String seatKey = getSeatKey(row, letter);
        			// I'm sure constructor will change
        			seats.put(seatKey, new BusinessSeat(seatKey));
        		}
        	} else if(row <= 5) {
        		// comfort
        	} else {
        		// regular
        	}
        }
    }

    public Seat getSeat(int row, String letter) {
        String seatKey = getSeatKey(row, letter);
        return seats.get(seatKey);
    }

    public void setSeat(int row, String letter, Seat seat) {
        String seatKey = getSeatKey(row, letter);
        seats.put(seatKey, seat);
    }

    public Map<String, Ticket> makeTickets() {
        Map<String, Ticket> ticketMap = new HashMap<>();
        for (Map.Entry<String, Seat> entry : seats.entrySet()) {
            ticketMap.put(entry.getKey(), null);
        }
        return ticketMap;
    }
}