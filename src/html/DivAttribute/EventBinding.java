package html.DivAttribute;

public class EventBinding extends DivAttribute{

    public String event;
    public EventBinding(String event) {
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
        return event + '\'' ;
    }
}
