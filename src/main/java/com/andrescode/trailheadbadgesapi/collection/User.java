package com.andrescode.trailheadbadgesapi.collection;

import com.andrescode.trailheadbadgesapi.model.UserBadge;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User {
    @Id private String id;
    private String trailheadId;
    private String firstName;
    private String lastName;
    private String company;
    private List<UserBadge> badges;

    public String getTrailheadId() {
        return trailheadId;
    }

    public void setTrailheadId(String trailheadId) {
        this.trailheadId = trailheadId;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<UserBadge> getBadges() {
        return badges;
    }

    public void setBadges(List<UserBadge> badges) {
        this.badges = badges;
    }
}
