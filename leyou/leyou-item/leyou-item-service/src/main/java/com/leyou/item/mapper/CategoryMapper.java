package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-30 14:59
 */
public interface CategoryMapper extends Mapper<Category>,SelectByIdListMapper<Category,Long>{

    @Select("select * from tb_category where id in (select category_id from tb_category_brand where brand_id = #{bid})")
    List<Category> queryByBrandId(Long bid);
}
