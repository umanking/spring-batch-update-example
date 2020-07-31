//package com.example.demo.jpa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StopWatch;
//
//import java.util.List;
//
///**
// * @author Geonguk Han
// * @since 2020-07-31
// */
//@Service
//public class ItemService {
//
//    @Autowired
//    ItemRepository itemRepository;
//
//    public void saveAll(List<Item> items) {
//        final StopWatch stopWatch = new StopWatch();
//        stopWatch.start("call saveAll iterator");
//
//        itemRepository.saveAll(items);
//
//        stopWatch.stop();
//        System.out.println(stopWatch.prettyPrint());
//        System.out.println(stopWatch.getTotalTimeSeconds());
//    }
//}
