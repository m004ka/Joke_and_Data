package org.example.Data.User;

import java.util.List;

public interface UserFilter {
    List<User> filter(List<User> users);
}
