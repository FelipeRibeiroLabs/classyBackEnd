package br.frlabs.classy.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UniversityStatusEnum {
    ATLETICA,
    EMPRESA_JUNIOR,
    TURMA,
    DIRETORIO_ACADEMICO,
    CURSO,
    OUTRO;

    public static UniversityStatusEnum getEnum(String name) {
        return Arrays.stream(values()).filter(
                        e -> e.name().equals(name))
                .findFirst().orElse(null);
    }
}
