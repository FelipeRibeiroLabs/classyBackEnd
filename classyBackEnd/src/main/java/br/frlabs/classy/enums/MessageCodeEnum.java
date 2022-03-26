package br.frlabs.classy.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageCodeEnum {
    REQUIRED_FIEL("required.field"),
    NOT_ALLOWED("You are not from this crew");

    private final String code;
}
