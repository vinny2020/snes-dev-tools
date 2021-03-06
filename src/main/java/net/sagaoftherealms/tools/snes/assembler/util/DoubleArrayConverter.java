package net.sagaoftherealms.tools.snes.assembler.util;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DoubleArrayConverter extends SimpleArgumentConverter {
org.junit.platform.commons.JUnitException ex;

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        String[] doublesAsString = source.toString().replace("[","").replace("]","").split(",");

        if (!List.class.isAssignableFrom(targetType)) {
            throw new ArgumentConversionException("Must convert to a double array");
        }

        return Arrays.stream(doublesAsString).map(Double::parseDouble).collect(Collectors.toList());

    }
}
