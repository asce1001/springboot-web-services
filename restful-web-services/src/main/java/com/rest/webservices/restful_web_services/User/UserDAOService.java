package com.rest.webservices.restful_web_services.User;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();

    private static int userCounts = 3;

    static {
        users.add(new User( 1, "Yatin",  new Date()));
        users.add(new User(2, "Pradnya",  new Date()));
        users.add(new User( 3, "Akshay",  new Date()));

    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCounts);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user: users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }


}
