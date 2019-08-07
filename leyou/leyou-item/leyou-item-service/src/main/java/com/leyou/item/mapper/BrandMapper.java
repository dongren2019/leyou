package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-30 17:58
 */
public interface BrandMapper extends Mapper<Brand> {
    @Insert("insert into tb_category_brand values(#{cid},#{bid})")
    void insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    @Delete("delete from tb_category_brand where brand_id = #{bid}")
    void deleteCategoryAndBrand(Long bid);

    @Select("SELECT * FROM `tb_brand` a JOIN tb_category_brand b on a.id=b.brand_id where b.category_id= #{cid}")
    List<Brand> selectBrandsByCid(Long cid);
}
