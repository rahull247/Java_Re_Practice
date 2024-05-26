package com.batch.config;

import com.batch.model.User;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<User, User> {
    @Override
    public User process(User item) throws Exception {
        System.out.println("Transformation process");
        return item;
    }
}
