package org.example.Data.User;

import java.util.ArrayList;
import java.util.List;

public class UserFilterImpl implements UserFilter {

    public UserFilterImpl(int maxCount) {
        this.maxCount = maxCount;
    }

    int maxCount;

    @Override
    public List<User> filter(List<User> users) {
        List<User> ecoUsers = new ArrayList<>();
        for (User user : users) {
            if (user.isEco(user, maxCount)) {
                ecoUsers.add(user);
            }
        }
        return ecoUsers;
    }


}