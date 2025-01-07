package com.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping(path = "v1/person")
    public PersonV1 getFirstVersion(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "v2/person")
    public PersonV2 getSecondVersion(){
        return new PersonV2(new Name("Yatindra", "Mahadik"));
    }

    @GetMapping(path = "person", params = "version=1")
    public PersonV1 getFirstVersionParam(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "person", params = "version=2")
    public PersonV2 getSecondVersionParam(){
        return new PersonV2(new Name("Yatindra", "Mahadik"));
    }

    @GetMapping(path = "person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionHeader(){
        return new PersonV1("Yatindra Mahadik");
    }

    @GetMapping(path = "person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionHeader(){
        return new PersonV2(new Name("Yatindra", "Mahadik"));
    }

    @GetMapping(path = "person/accept", produces = "application/company-v1+json")
    public PersonV1 getFirstVersionAcceptHeader(){
        return new PersonV1("Yatindra Mahadik");
    }

    @GetMapping(path = "person/accept", produces = "application/company-v2+json")
    public PersonV2 getSecondVersionAcceptHeader(){
        return new PersonV2(new Name("Yatindra", "Mahadik"));
    }
}
