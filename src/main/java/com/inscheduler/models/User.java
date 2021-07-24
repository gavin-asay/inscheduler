package com.inscheduler.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String email;
    private String password;
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

    public User() {
    }

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(Guest guestData, String password) {
        this.email = guestData.getEmail();
        this.password = password;
        this.firstName = guestData.getFirstName();
        this.lastName = guestData.getLastName();
        this.emailUuid = guestData.getEmailUuid();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        User user = (User) o;
        return sessionActive == user.sessionActive && Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(emailUuid, user.emailUuid) && Objects.equals(events, user.events) && Objects.equals(signups, user.signups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, lastName, emailUuid, events, signups, sessionActive);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailUuid=" + emailUuid +
                ", events=" + events +
                ", signups=" + signups +
                ", sessionActive=" + sessionActive +
                '}';
    }
}
