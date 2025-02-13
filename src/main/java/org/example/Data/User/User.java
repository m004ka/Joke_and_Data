package org.example.Data.User;

import lombok.Getter;

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

    public boolean isEco(User user, int maxCount) {
        return maxCount > user.getWater() && maxCount > user.getGasCount() && maxCount > user.getElectro();
    }

    @Override
    public String toString() {
        String sep = "|";
        return id + sep + name + sep + waterCountDay + sep + waterCountNight + sep + gasCount + sep + electroCountDay + sep + electroCountNight;
    }
}
