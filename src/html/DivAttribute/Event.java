package html.DivAttribute;

public class Event extends DivAttribute{

    public String event;
    public Event(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event='" + event + '\'' +
                '}';
    }
}
