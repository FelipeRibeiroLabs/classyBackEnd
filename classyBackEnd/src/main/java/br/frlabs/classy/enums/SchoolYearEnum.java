package br.frlabs.classy.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SchoolYearEnum {

    ANO_6_ENSINO_FUND,
    ANO_7_ENSINO_FUND,
    ANO_8_ENSINO_FUND,
    ANO_9_ENSINO_FUND,
    ANO_1_ENSINO_MEDIO,
    ANO_2_ENSINO_MEDIO,
    ANO_3_ENSINO_MEDIO;

    public static SchoolYearEnum getEnum(String name) {
        return Arrays.stream(values()).filter(
                e -> e.name().equals(name))
                .findFirst().orElse(null);
    }
}
