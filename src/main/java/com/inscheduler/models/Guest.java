package com.inscheduler.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "guest")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Guest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private UUID emailUuid;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Event> events;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Signup> signups;

    @Transient
    private boolean sessionActive;

    public Guest() {
        this.emailUuid = UUID.randomUUID();
    }

    public Guest(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getEmailUuid() {
        return emailUuid;
    }

    public void setEmailUuid(UUID emailUuid) {
        this.emailUuid = emailUuid;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Signup> getSignups() {
        return signups;
    }

    public void setSignups(List<Signup> signups) {
        this.signups = signups;
    }

    public boolean isSessionActive() {
        return sessionActive;
    }

    public void setSessionActive(boolean sessionActive) {
        this.sessionActive = sessionActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return sessionActive == guest.sessionActive && Objects.equals(id, guest.id) && Objects.equals(email, guest.email) && Objects.equals(firstName, guest.firstName) && Objects.equals(lastName, guest.lastName) && Objects.equals(emailUuid, guest.emailUuid) && Objects.equals(events, guest.events) && Objects.equals(signups, guest.signups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, emailUuid, events, signups, sessionActive);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailUuid=" + emailUuid +
                ", events=" + events +
                ", signups=" + signups +
                ", sessionActive=" + sessionActive +
                '}';
    }
}
