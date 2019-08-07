package com.leyou.repository;

import com.leyou.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author dongren
 * @create 2019-08-04 12:36
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long>{
}
