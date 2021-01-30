package io.github.kimmking.gateway.router;

import io.github.kimmking.gateway.util.RandomCollection;

import java.util.List;
import java.util.Random;

public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        // 按照权重获取url
        RandomCollection<Object> rc = new RandomCollection<>().add(Double.valueOf("90.0"), 0).add(Double.valueOf("10.0"), 1);
        return urls.get(Integer.valueOf(rc.next().toString()));
    }
}
