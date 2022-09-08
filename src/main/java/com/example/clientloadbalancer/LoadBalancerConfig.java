package com.example.clientloadbalancer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

// Don't use @Configuration
// Ribbon 의 요소를 커스터마이징 하는 파일
public class LoadBalancerConfig {
    @Autowired
    IClientConfig ribbonClientConfig;

    // isSecure : https 유무
    // pingAppendString : ping을 체크하는 path
    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl(false, "/ping");
    }

    // 요청을 보낼 서버를 선택하는 논리를 수정할 수 있는 매소드
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}
