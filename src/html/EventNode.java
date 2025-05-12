package html;

public class EventNode extends Html {
    private String event;

    public EventNode(String event) {
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
        return event ;
//        return "EventNode{" +
//                "event='" + event + '\'' +
//                '}';
    }
}