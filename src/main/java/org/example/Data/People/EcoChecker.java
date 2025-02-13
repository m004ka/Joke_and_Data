package org.example.Data.People;

public class EcoChecker implements IEcoChecker {
    @Override
    public boolean isEco(People people, int maxCount) {
        return maxCount > people.getWater() && maxCount > people.getGasCount() && maxCount > people.getElectro();
    }
}