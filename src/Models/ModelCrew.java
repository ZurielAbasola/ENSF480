package Models;

import com.raven.table.model.TableRowData;

public class ModelCrew extends TableRowData {    
    private final String flight;
    private final String origin;
    private final String destination;
    private final String departure;
    private final String arrival;
    private final int crew;
    
    public ModelCrew (String flight, String origin, String destination, String departure, String arrival, int crew) {
        this.flight = flight;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.crew = crew;
    }
    
    @Override
    public Object[] toTableRow() {
        return new Object[]{flight, origin, destination, departure, arrival, crew};
    }
}
