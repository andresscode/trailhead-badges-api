package com.andrescode.trailheadbadgesapi.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "badges")
public class Badge {
    @Id private String id;
    private String type;
    private String name;
    private String href;
    private Object hours;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Object getHours() {
        return hours;
    }

    public void setHours(Object hours) {
        this.hours = hours;
    }
}
