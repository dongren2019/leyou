package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dongren
 * @create 2019-07-30 15:02
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    public List<Category> queryCategoryiesByPid(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        return this.categoryMapper.select(record);
    }

    /**
     * 根据品牌id查询category列表
     * @param bid
     * @return
     */
    public List<Category> queryByBrandId(Long bid) {
        return this.categoryMapper.queryByBrandId(bid);
    }

    /**
     * 根据商品分类id，查询商品分类名称
     * @param ids
     * @return
     */
    public List<String> queryNamesByIds(List<Long> ids){
        //继承一个新的mapper接口实现多主键查询对象集合
        List<Category> categories = this.categoryMapper.selectByIdList(ids);
        return categories.stream().map(category -> category.getName()).collect(Collectors.toList());
    }

    /**
     * 根据3级分类id，查询1~3级的分类
     * @param id
     * @return
     */
    public List<Category> queryAllByCid3(Long id) {
        Category c3 = this.categoryMapper.selectByPrimaryKey(id);
        Category c2 = this.categoryMapper.selectByPrimaryKey(c3.getParentId());
        Category c1 = this.categoryMapper.selectByPrimaryKey(c2.getParentId());
        return Arrays.asList(c1,c2,c3);
    }
}
