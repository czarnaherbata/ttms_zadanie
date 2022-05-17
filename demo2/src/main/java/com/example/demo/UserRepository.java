package com.example.demo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class UserRepository {

    List<User> users;



    public UserRepository()
    {
        this.users=new ArrayList<>();
        this.users.add(new User("Zuzia", "Baginska"));
    }
    public User getUser(int id)
    {
        if(id>users.size()) return null;
        return users.get(id);
    }
    public void addUser(User user)
    {
        this.users.add(user);
    }
    public void removeUser(int id)
    {
        this.users.remove(id);
    }
}
