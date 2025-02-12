package com.franc.domain.account.domain.code;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status status) {
        return (status != null) ? status.getCode() : null;
    }

    @Override
    public Status convertToEntityAttribute(Integer dbData) {
        return (dbData != null) ? Status.fromCode(dbData) : Status.ACTIVE;
    }
}
