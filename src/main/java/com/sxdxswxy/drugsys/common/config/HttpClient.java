package com.sxdxswxy.drugsys.common.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 连接池配置
 *
 * @author Justdwiwt
 */
@Configuration
public class HttpClient {

    @Value("${http.maxTotal:1}")
    private Integer maxTotal;

    @Value("${http.defaultMaxPerRoute:1}")
    private Integer defaultMaxPerRoute;

    @Value("${http.connectTimeout:1}")
    private Integer connectTimeout;

    @Value("${http.connectionRequestTimeout:1}")
    private Integer connectionRequestTimeout;

    @Value("${http.socketTimeout:1}")
    private Integer socketTimeout;

    @Value("${http.staleConnectionCheckEnabled:true}")
    private boolean staleConnectionCheckEnabled;

    /**
     * 实例化连接池管理器
     * <p>设置最大连接数、并发连接数</p>
     *
     * @return 连接池管理器对象
     */
    @Bean(name = "httpClientConnectionManager")
    public PoolingHttpClientConnectionManager getHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();
        // 最大连接数
        httpClientConnectionManager.setMaxTotal(maxTotal);
        // 并发数
        httpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        return httpClientConnectionManager;
    }

    /**
     * 实例化连接池
     * <p>设置连接池管理器</p>
     * <p>需要以参数形式注入实例化的连接池管理器</p>
     *
     * @param httpClientConnectionManager 连接池管理器对象
     * @return 实例化的连接池
     * @see #getHttpClientBuilder(PoolingHttpClientConnectionManager)
     */
    @Bean(name = "httpClientBuilder")
    public HttpClientBuilder getHttpClientBuilder(@Qualifier("httpClientConnectionManager")
                                                          PoolingHttpClientConnectionManager httpClientConnectionManager) {
        // 构造方法被protected修饰，不能直接使用new来实例化一个HttpClientBuilder
        // 可以使用HttpClientBuilder提供的静态方法create()来获取HttpClientBuilder对象
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(httpClientConnectionManager);
        return httpClientBuilder;
    }

    /**
     * 注入连接池
     * <p>获取httpClient</p>
     *
     * @param httpClientBuilder 连接池
     * @return httpClient
     * @see #getHttpClientBuilder(PoolingHttpClientConnectionManager)
     */
    @Bean
    public CloseableHttpClient getCloseableHttpClient(@Qualifier("httpClientBuilder")
                                                              HttpClientBuilder httpClientBuilder) {
        return httpClientBuilder.build();
    }

    /**
     * Builder是RequestConfig的一个内部类
     * <p>通过RequestConfig的custom方法来获取到一个Builder对象</p>
     * <p>设置builder的连接信息</p>
     * <p>还可以设置proxy，cookieSpec等属性</p>
     *
     * @return builder对象
     */
    @Bean(name = "builder")
    public RequestConfig.Builder getBuilder() {
        RequestConfig.Builder builder = RequestConfig.custom();
        return builder.setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout)
                .setStaleConnectionCheckEnabled(staleConnectionCheckEnabled);
    }

    /**
     * 构建RequestConfig对象
     *
     * @param builder builder对象
     * @return RequestConfig对象
     */
    @Bean
    public RequestConfig getRequestConfig(@Qualifier("builder") RequestConfig.Builder builder) {
        return builder.build();
    }

}
