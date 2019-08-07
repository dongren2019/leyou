package com.leyou.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author dongren
 * @create 2019-08-03 23:52
 */
@FeignClient(value = "item-service")
public interface BrandClient extends BrandApi {
}
