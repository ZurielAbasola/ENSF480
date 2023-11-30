package src.entity;
import java.util.ArrayList;

public class Crew {
    private int id;
	private Pilot pilot;
	private ArrayList<FlightAttendant> flightAttendants;

	public Crew(Pilot pilot, ArrayList<FlightAttendant> flightAttendants) {
		this.pilot = pilot;
		this.flightAttendants = new ArrayList<FlightAttendant>(flightAttendants);// might want to change this to be a copy
	}

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public ArrayList<FlightAttendant> getFlightAttendants() {
        return new ArrayList<>(flightAttendants);
    }

    public void setFlightAttendants(ArrayList<FlightAttendant> flightAttendants) {
        this.flightAttendants = new ArrayList<FlightAttendant>(flightAttendants);
    }

    public int getID(){
        return id;
    }
}