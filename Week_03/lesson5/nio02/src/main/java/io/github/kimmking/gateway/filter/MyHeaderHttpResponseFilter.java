package io.github.kimmking.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class MyHeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {

        response.headers().set("myHeaderAfter", "这是我自定义的myHeaderBefore");
    }

}
