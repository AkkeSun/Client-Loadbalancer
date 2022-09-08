package com.example.clientloadbalancer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class LoadBalancerService {

    // 설정한 로드밸런서 이름을 baseUrl 로 등록
    private final String baseUrl = "http://myService";
    private final WebClient.Builder webClientBuilder;

    public String getData () {
        WebClient webClient = webClientBuilder.baseUrl(baseUrl).build();
        return webClient.get().uri("/test").retrieve().bodyToMono(String.class).block();
    }
}
