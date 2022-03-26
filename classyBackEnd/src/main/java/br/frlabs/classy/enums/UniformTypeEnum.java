package br.frlabs.classy.enums;

import java.util.Arrays;

public enum UniformTypeEnum {
    SPORT,
    HOODIE,
    TSHIRT;

    public static UniformTypeEnum getEnum(String name) {
        return Arrays.stream(values()).filter(
                        e -> e.name().equals(name))
                .findFirst().orElse(null);
    }
}
