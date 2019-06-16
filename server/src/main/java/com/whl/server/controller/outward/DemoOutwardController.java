package com.whl.server.controller.outward;

import com.whl.server.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 注释：
 *
 * @Author:whl
 * @Date:2019-06-12 12:07
 */
@RestController
@RequestMapping("/api/demo")
public class DemoOutwardController {

    @Resource
    DemoService demoService;

}
