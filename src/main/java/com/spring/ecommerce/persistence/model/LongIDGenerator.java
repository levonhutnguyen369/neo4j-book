package com.spring.ecommerce.persistence.model;

import org.springframework.data.neo4j.core.schema.IdGenerator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;


@Component
public class LongIDGenerator implements IdGenerator<Long> {

    private final AtomicLong counter = new AtomicLong(1);


    @Override
    public Long generateId(String primaryLabel, Object entity) {

        return counter.getAndIncrement();
    }
}
