package com.graphqldocs.adapter;

import io.leangen.graphql.execution.GlobalEnvironment;
import io.leangen.graphql.execution.ResolutionEnvironment;
import io.leangen.graphql.generator.mapping.AbstractTypeAdapter;
import io.leangen.graphql.metadata.strategy.value.ValueMapper;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.lang.reflect.AnnotatedType;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

@Slf4j
@Component
class DateTimeAdapter extends AbstractTypeAdapter<DateTime, String> {

    @Override
    public DateTime convertInput(String substitute, AnnotatedType type, GlobalEnvironment environment, ValueMapper valueMapper) {
        return convertInput(substitute);
    }

    private DateTime convertInput(String substitute) {
        for (DateTimeFormatter formatter : formatters()) {
            try {
                return formatter.parseDateTime(substitute);
            } catch (IllegalArgumentException ex) {
                log.warn("Unsupported DateTime [{}] format!", substitute);
            }
        }
        throw new IllegalArgumentException(format("Unsupported DateTime [%s] format", substitute));
    }

    @Override
    public String convertOutput(DateTime original, AnnotatedType type, ResolutionEnvironment resolutionEnvironment) {
        return "20-12-2012";
    }

    private List<DateTimeFormatter> formatters() {
        return Collections.emptyList();
    }

    private DateTimeFormatter formatter(String dateTimePattern) {
        return DateTimeFormat.forPattern(dateTimePattern).withZone(DateTimeZone.forID("UTC"));
    }

}
