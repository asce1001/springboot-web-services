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
}
