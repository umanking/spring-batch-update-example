//package com.example.demo.jpa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Geonguk Han
// * @since 2020-07-31
// */
//@Component
//public class ItemRunner implements ApplicationRunner {
//
//    @Autowired
//    ItemService itemService;
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//
//    @Override
//    public void run(ApplicationArguments args) {
//
//        //10만건 3초
////        callJpaInsert();
//
//
////        callJdbcBatchUpdate();
//    }
//
//    private void callJpaInsert() {
//        List<Item> items = new ArrayList<>();
//        for (int i = 0; i < 100000; i++) {
//            final Item item = new Item();
//            item.setName("item " + i);
//            items.add(item);
//        }
//
//        itemService.saveAll(items);
//    }
//
//    private void callJdbcBatchUpdate() {
//        List<Item> items = new ArrayList<>();
//        for (int i = 0; i < 100000; i++) {
//            final Item item = new Item();
//            item.setId(Long.valueOf(i));
//            item.setName("item " + i);
//            items.add(item);
//        }
//
//
//        // jdbc batch update
//        jdbcTemplate.batchUpdate("insert into item (id, name) values(?,?)",
//                new BatchPreparedStatementSetter() {
//                    @Override
//                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                        preparedStatement.setLong(1, items.get(i).getId());
//                        preparedStatement.setString(2, items.get(i).getName());
//                    }
//
//                    @Override
//                    public int getBatchSize() {
//                        return items.size();
//                    }
//                }
//        );
//
//    }
//}
