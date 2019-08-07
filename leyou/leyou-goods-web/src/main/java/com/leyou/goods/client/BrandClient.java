package com.leyou.goods.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author dongren
 * @create 2019-08-03 23:52
 */
@FeignClient("item-service")
public interface BrandClient extends BrandApi {
}
