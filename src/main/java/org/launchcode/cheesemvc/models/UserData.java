package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

/**
 * Created by ryanneal on 12/5/17.
 */
public class UserData {
    static ArrayList<User> users = new ArrayList<>();

    //get all
    public static ArrayList<User> getAll() {
        return users;
    }

    // add
    public static void add(User newUser) {
        users.add(newUser);
    }

    // remove
    public static void remove(int id) {
        User userToRemove = getById(id);
        users.remove(userToRemove);
    }

    // getById
    public static User getById(int id) {
        User theUser = null;

        for (User userCandidate : users) {
            if (userCandidate.getUserId() == id){
                theUser = userCandidate;
            }
        }

        return theUser;

    }

}
