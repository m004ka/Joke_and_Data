package org.example.Data.User;

import lombok.Getter;

import java.util.function.Function;

@Getter
public enum Resource {
    WATER("вода", User::getWater),
    GAS("газ", User::getGasCount),
    ELECTRO("электричество", User::getElectro);

    public final String name;
    public final Function<User, ? extends Number> resource;


    Resource(String name, Function<User, ? extends Number> resource) {
        this.name = name;
        this.resource = resource;
    }
}

