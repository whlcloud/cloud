package com.whl.server.service.impl;

import com.whl.server.dao.whl.StudentDAO;
import com.whl.server.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 注释：
 *
 * @Author:whl
 * @Date:2019-06-12 12:12
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    StudentDAO studentDAO;

}
