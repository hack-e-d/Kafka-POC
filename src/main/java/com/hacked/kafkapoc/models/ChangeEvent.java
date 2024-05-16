package com.hacked.kafkapoc.models;

public class ChangeEvent {

    private String eventDetails;

    private String eventType;

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "ChangeEvent{" +
                "eventDetails='" + eventDetails + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
