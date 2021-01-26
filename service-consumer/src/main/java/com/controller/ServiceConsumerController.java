package com.controller;

import com.feign.ServiceProviderFeign;
import com.model.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/1/26.
 */
@Api("接口")
@RestController
@RequestMapping("/consumer")
public class ServiceConsumerController {

    private static final Log log = LogFactory.getLog(ServiceConsumerController.class);

    @Resource
    private ServiceProviderFeign serviceProviderFeign;

    @ApiOperation(value = "获取order数据")
    @GetMapping("/order/get")
    public List<Order> message(){
        return serviceProviderFeign.getOrderList();
    }
}
