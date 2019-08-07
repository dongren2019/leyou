package com.leyou.item.bo;

import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;
import lombok.Data;

import java.util.List;

/**
 * @author dongren
 * @create 2019-08-01 15:18
 */
@Data
public class SpuBo extends Spu {
    private String cname;// 商品分类名称
    private String bname;// 品牌名称
    private SpuDetail spuDetail;// 商品详情
    private List<Sku> skus;// sku列表




}
