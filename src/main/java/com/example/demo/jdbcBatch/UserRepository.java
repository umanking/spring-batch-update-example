package com.example.demo.jdbcBatch;

import java.util.List;

/**
 * @author Geonguk Han
 * @since 2020-07-31
 */
public interface UserRepository {

    void saveAll(List<User> users);
}
