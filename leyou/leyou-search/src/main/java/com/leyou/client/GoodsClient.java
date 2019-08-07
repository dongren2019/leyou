package com.leyou.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author dongren
 * @create 2019-08-03 23:39
 */
@FeignClient(value = "item-service")
public interface GoodsClient extends GoodsApi {
}
