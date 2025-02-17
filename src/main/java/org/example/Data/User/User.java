package org.example.Data.User;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.function.Function;

@Getter
public class User {
    public User(int id, String name, int waterDay, int waterNight, int gasCount, int electroDay, int electroNight) {
        this.id = id;
        this.name = name;
        this.waterCountDay = waterDay;
        this.waterCountNight = waterNight;
        this.gasCount = gasCount;
        this.electroCountDay = electroDay;
        this.electroCountNight = electroNight;
        this.water = waterDay + waterNight;
        this.electro = electroDay + electroNight;
    }

    int id;
    String name;

    int waterCountDay;
    int waterCountNight;

    int gasCount;

    int electroCountDay;
    int electroCountNight;

    int water;
    int electro;

    public <T> boolean isEco(User user, int maxCount, Function<User, T> resource) {
        BigDecimal maxValue = new BigDecimal(maxCount);
        BigDecimal value = new BigDecimal(resource.apply(user).toString());

        return maxValue.compareTo(value) >= 0;
    }

    @Override
    public String toString() {
        String sep = "|";
        return id + sep + name + sep + waterCountDay + sep + waterCountNight + sep + gasCount + sep + electroCountDay + sep + electroCountNight;
    }
}
