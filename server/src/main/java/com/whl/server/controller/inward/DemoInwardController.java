package com.whl.server.controller.inward;

import com.whl.api.DemoAPI;
import com.whl.server.service.DemoService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 注释：
 *
 * @Author:whl
 * @Date:2019-06-12 12:07
 */
@RestController
public class DemoInwardController implements DemoAPI {

    @Resource
    DemoService demoService;

}
