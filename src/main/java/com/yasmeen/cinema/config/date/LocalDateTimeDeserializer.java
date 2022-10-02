package com.yasmeen.cinema.config.date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
    private static final DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public LocalDateTimeDeserializer() {
        this(null);
    }

    public LocalDateTimeDeserializer(Class t) {
        super(t);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String dateTime = jsonParser.getText();

        System.out.println("dateTime>>>>>>>>>>>>>>>>>>>" + dateTime);
       /* return LocalDateTime.parse(jsonParser.getText(),
         DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").withLocale(Locale.ENGLISH));*/
        return LocalDateTime.parse(dateTime, formatter.withLocale(Locale.ENGLISH));

    }

}


