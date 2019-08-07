package com.dongren.elasticsearch.test;

import com.dongren.pojo.Item;
import com.dongren.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author dongren
 * @create 2019-08-03 17:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTest {
    @Autowired
    private ElasticsearchTemplate template;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testIndex(){
        this.template.createIndex(Item.class);
        this.template.putMapping(Item.class);
    }

    @Test
    public void testCreate(){
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.leyou.com/13123.jpg");
        this.itemRepository.save(item);
    }

    @Test
    public void indexList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.leyou.com/123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.leyou.com/3.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    @Test
    public void testQuery(){
        Optional<Item> optional = this.itemRepository.findById(1l);
        System.out.println(optional.get());
    }

    @Test
    public void testFind(){
        // 查询全部，并按照价格降序排序
        Iterable<Item> items = this.itemRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
        items.forEach(item-> System.out.println(item));
    }

    @Test
    public void testFindByTitle(){
        List<Item> itemList = this.itemRepository.findByTitle("手机");
        itemList.forEach(System.out::println);
    }
}
