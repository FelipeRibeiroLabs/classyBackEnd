package br.frlabs.classy.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PlataformEnum {

    MOBILE,
    PC,
    PLAYSTATION,
    XBOX;

    public static PlataformEnum getEnum(String name) {
        return Arrays.stream(values()).filter(
                        e -> e.name().equals(name))
                .findFirst().orElse(null);
    }
}
