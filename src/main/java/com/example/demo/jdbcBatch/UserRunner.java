package com.example.demo.jdbcBatch;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Geonguk Han
 * @since 2020-07-31
 */
@Component
public class UserRunner implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            final User user = new User();
            user.setId(Long.valueOf(i));
            user.setName("name " + i);
            users.add(user);

        }
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        userRepository.saveAll(users);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(stopWatch.getTotalTimeSeconds());

    }
}
