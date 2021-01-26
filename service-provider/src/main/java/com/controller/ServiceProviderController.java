package com.controller;

import com.model.Order;
import com.repository.OrderRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
@RequestMapping("/provider")
public class ServiceProviderController {

    private static final Log log = LogFactory.getLog(ServiceProviderController.class);

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private OrderRepository orderRepository;

    @ApiOperation(value = "获取order数据")
    @GetMapping("/order/get")
    public List<Order> message(){
        log.info("接收到请求");

        return orderRepository.findAll();
    }

    @ApiOperation(value = "获取注册中心数据")
    @GetMapping("/register/get")
    public void getRegister(){
        List<String> services = discoveryClient.getServices();
        log.info("所有的服务-----------" + services.toString());
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("host: " + instance.getHost() + " instanceId:" + instance.getMetadata() + " serviceId:" + instance.getServiceId());
            }
        }
    }

}
