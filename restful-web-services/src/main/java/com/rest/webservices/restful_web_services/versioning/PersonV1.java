package com.rest.webservices.restful_web_services.versioning;

public class PersonV1 {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public PersonV1(String name) {
        this.name = name;
    }
}
