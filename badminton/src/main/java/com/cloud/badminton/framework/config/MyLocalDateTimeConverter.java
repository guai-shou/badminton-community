package com.cloud.badminton.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/6 22:01
 */
//@Configuration
public class MyLocalDateTimeConverter {


    /*String转LocalDateTime序列器*/
    //@Bean
    public StringToLocalDateTimeConverter localDateTimeConverter1() {
        return new StringToLocalDateTimeConverter() {
            @Override
            public LocalDateTime convert(String source) {
                return LocalDateTime.ofEpochSecond(Long.parseLong(source) / 1000, 0,  ZoneOffset.ofHours(8));
            }
        };
    }

    interface StringToLocalDateTimeConverter extends Converter<String, LocalDateTime> {

    }

}
