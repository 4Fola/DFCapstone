package com.example.instagram_01;

import com.parse.ParseException;
import com.parse.ParseUser;

public interface ParseCallback2<T, T1> {
    /**
     * Override this function with the code you want to run after the save is complete.
     *
     * @param user The user that logged in, if the username and password is valid.
     * @param e    The exception raised by the login, or {@code null} if it succeeded.
     */
    void done(ParseUser user, ParseException e);
}
