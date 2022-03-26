package br.frlabs.classy.model;

import br.frlabs.classy.enums.MessageCodeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class ValidationError {
    private final MessageCodeEnum keyMessage;
    private final List<Object> params;
}
