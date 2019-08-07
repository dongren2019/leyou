package com.dongren.repository;


import com.dongren.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author dongren
 * @create 2019-08-03 17:10
 */
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
    List<Item> findByTitle(String title);
}
