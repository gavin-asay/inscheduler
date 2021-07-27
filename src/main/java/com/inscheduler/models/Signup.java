package com.inscheduler.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Signup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Integer eventId;
    Integer clientId;
    boolean isClientGuest;
    Integer slot;

    public Signup() {}

    public Signup(int eventId, int clientId, boolean isClientGuest, int slot) {
        this.eventId = eventId;
        this.clientId = clientId;
        this.isClientGuest = isClientGuest;
        this.slot = slot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public boolean isClientGuest() {
        return isClientGuest;
    }

    public void setClientGuest(boolean clientGuest) {
        isClientGuest = clientGuest;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signup signup = (Signup) o;
        return isClientGuest == signup.isClientGuest && Objects.equals(id, signup.id) && Objects.equals(eventId, signup.eventId) && Objects.equals(clientId, signup.clientId) && Objects.equals(slot, signup.slot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventId, clientId, isClientGuest, slot);
    }

    @Override
    public String toString() {
        return "Signup{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", clientId=" + clientId +
                ", isClientGuest=" + isClientGuest +
                ", slot=" + slot +
                '}';
    }
}
