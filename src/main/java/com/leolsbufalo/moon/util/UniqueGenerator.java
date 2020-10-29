package com.leolsbufalo.moon.util;


import com.fasterxml.uuid.Generators;

import java.security.SecureRandom;
import java.util.UUID;

public class UniqueGenerator {

    private final SecureRandom secureRandom = new SecureRandom();

    public String uniqueIdGenerator() {
        UUID uuid = Generators.randomBasedGenerator(secureRandom).generate();
        return uuid.toString().replaceAll("-", "").toUpperCase();
    }

}
