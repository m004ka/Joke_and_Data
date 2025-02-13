package org.example.Data.People;

import java.util.ArrayList;
import java.util.List;

public class EcoUsersFilter {
    private final EcoChecker ecoChecker;

    public EcoUsersFilter(EcoChecker ecoChecker) {
        this.ecoChecker = ecoChecker;
    }

    public List<People> getEcoUsers(List<People> users, int maxCount) {
        List<People> ecoPeople = new ArrayList<>();
        for (People people : users) {
            if (ecoChecker.isEco(people, maxCount)) {
                ecoPeople.add(people);
            }
        }
        return ecoPeople;
    }
}