package org.example.Data.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UserFilterImpl implements UserFilter {

    public UserFilterImpl(int maxCount, Function<User, ? extends Number> resource) {
        this.maxCount = maxCount;
        this.resource = resource;
    }

    int maxCount;
    private final Function<User, ? extends Number> resource;

    @Override
    public List<User> filter(List<User> users) {
        List<User> ecoUsers = new ArrayList<>();
        for (User user : users) {
            if (user.isEco(user, maxCount, resource)) {
                ecoUsers.add(user);
            }
        }
        return ecoUsers;
    }
}