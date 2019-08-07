package com.leyou.goods.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author dongren
 * @create 2019-08-03 23:51
 */
@FeignClient(value = "item-service")
public interface CategoryClient extends CategoryApi {
}
