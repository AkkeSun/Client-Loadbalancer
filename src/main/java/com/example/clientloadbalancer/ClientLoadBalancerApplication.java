package com.example.clientloadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
// 로드밸런싱 이름과 커스텀 config 파일을 등록
@RibbonClient(name = "myService", configuration = LoadBalancerConfig.class)
public class ClientLoadBalancerApplication {

	@Bean
	@LoadBalanced // webClient 로 로드밸런싱을 처리하겠다는 선언
	public WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientLoadBalancerApplication.class, args);
	}

}
