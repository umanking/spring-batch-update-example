package com.example.demo.jdbcBatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Geonguk Han
 * @since 2020-07-31
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void saveAll(List<User> users) {
        // jdbc batch update
        jdbcTemplate.batchUpdate("INSERT INTO user( id, name ) VALUES (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        preparedStatement.setLong(1, users.get(i).getId());
                        preparedStatement.setString(2, users.get(i).getName());
                    }

                    @Override
                    public int getBatchSize() {
                        return users.size();
                    }
                }
        );
    }
}
