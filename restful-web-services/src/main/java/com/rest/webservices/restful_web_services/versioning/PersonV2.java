package com.rest.webservices.restful_web_services.versioning;

public class PersonV2 {

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }
}
