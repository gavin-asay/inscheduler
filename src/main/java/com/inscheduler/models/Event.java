package com.inscheduler.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "event")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer userId;
    private String title;
    private String description;
    private String organization;
    private long startDateTime;
    private long endDateTime;
    private Integer signupIncrement;

    @Transient
    private Integer totalSignupSlots;

    @OneToMany(mappedBy = "eventId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Signup> signups;

    public Event() {}

    public Event(int userId, String title, String description, String organization, long startDateTime, long endDateTime, int signupIncrement) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.organization = organization;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.signupIncrement = signupIncrement;
        this.totalSignupSlots = Math.toIntExact((endDateTime - startDateTime) / (signupIncrement * 60 * 1000));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public long getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(long startDateTime) {
        this.startDateTime = startDateTime;
    }

    public long getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(long endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getSignupIncrement() {
        return signupIncrement;
    }

    public void setSignupIncrement(Integer signupIncrement) {
        this.signupIncrement = signupIncrement;
    }

    public Integer getTotalSignupSlots() {
        return totalSignupSlots;
    }

    public void setTotalSignupSlots(Integer totalSignupSlots) {
        this.totalSignupSlots = totalSignupSlots;
    }

    public List<Signup> getSignups() {
        return signups;
    }

    public void setSignups(List<Signup> signups) {
        this.signups = signups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return startDateTime == event.startDateTime && endDateTime == event.endDateTime && Objects.equals(id, event.id) && Objects.equals(userId, event.userId) && Objects.equals(title, event.title) && Objects.equals(description, event.description) && Objects.equals(organization, event.organization) && Objects.equals(signupIncrement, event.signupIncrement) && Objects.equals(totalSignupSlots, event.totalSignupSlots) && Objects.equals(signups, event.signups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, description, organization, startDateTime, endDateTime, signupIncrement, totalSignupSlots, signups);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", organization='" + organization + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", signupIncrement=" + signupIncrement +
                ", totalSignupSlots=" + totalSignupSlots +
                ", signups=" + signups +
                '}';
    }
}
