package com.example.search.service;

import com.example.search.exception.MaximumTryException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final ExecutorService pool;
    private final RestTemplate ribbonRestTemplate;

    @Autowired
    public EmployeeServiceImpl (ExecutorService pool, RestTemplate ribbonRestTemplate) {
        this.pool = pool;
        this.ribbonRestTemplate = ribbonRestTemplate;
    }
    @HystrixCommand(fallbackMethod = "FallBack")
    @Override
    public Map<Integer, Map> fetchEmployeeByAges(List<Integer> ages) {
        int count = 0;
        List<CompletableFuture> completableFutureList = new ArrayList<>();
        while(count<4) {
            try {
                for (int age : ages) {
                    completableFutureList.add(
                            CompletableFuture.supplyAsync(
                                    () -> ribbonRestTemplate.getForObject("http://employee-service/employees?age=" + age, HashMap.class)
                                    , pool
                            )
                    );
                }
                return CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]))
                        .thenApply(VOID -> {
                            Map<Integer, Map> res = new HashMap<>();
                            for (int i = 0; i < completableFutureList.size(); i++) {
                                res.put(ages.get(i), (Map) completableFutureList.get(i).join());
                            }
                            return res;
                        }).join();
            } catch (HttpClientErrorException.TooManyRequests e) {
                count++;
                System.out.println("retrying...");
                }

        }
        throw new MaximumTryException("Too many retry failed.");
    }

    public Map<Integer, Map> FallBack(List<Integer> ages) {
        Map<Integer, Map> map = new HashMap<>(1);
        map.put(-11,null);
        return map;
    }
}
