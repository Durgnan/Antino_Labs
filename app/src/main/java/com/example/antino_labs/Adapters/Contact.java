package com.example.antino_labs.Adapters;

public class Contact {
    String url,name,age,location,bodyType,userDesire,details[];

    public Contact(String url, String name, String age, String location, String bodyType, String userDesire, String[] details) {
        this.url = url;
        this.name = name;
        this.age = age;
        this.location = location;
        this.bodyType = bodyType;
        this.userDesire = userDesire;
        this.details = details;
    }
    public Contact(String url, String name, String age, String location, String bodyType, String userDesire) {
        this.url = url;
        this.name = name;
        this.age = age;
        this.location = location;
        this.bodyType = bodyType;
        this.userDesire = userDesire;
        this.details = null;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getUserDesire() {
        return userDesire;
    }
}
