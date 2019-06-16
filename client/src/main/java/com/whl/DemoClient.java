package com.whl;

import com.whl.api.DemoAPI;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Description
 * User:whl
 * Date:2019-06-12 12:20
 */
@FeignClient(name = "demoServer")
public interface DemoClient extends DemoAPI {
}
