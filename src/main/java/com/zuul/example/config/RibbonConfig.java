package com.zuul.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ServerListSubsetFilter;
import com.zuul.example.ZuulGatewayApplication;


public class RibbonConfig {

	@Autowired
	public IClientConfig config;
	/**
	 * 
	 * @param config
	 * @return check status machanism
	 */
	@Bean
	public IPing ribbonPing() {
		return new PingUrl(false, "/health");
	}
	
	/**
	 * 
	 * @param config
	 * @return change default load balancer(round robin) to this new load balancer
	 */
	@Bean
	public IRule ribbonRule() {
		return new AvailabilityFilteringRule();
	}
	
//	@Bean
//	public ServerList<Server> ribbonServerList(IClientConfig config) {
//		return new ZuulGatewayApplication.BazServiceList(config);
//	}
//
//	@Bean
//	public ServerListSubsetFilter serverListFilter() {
//		ServerListSubsetFilter filter = new ServerListSubsetFilter();
//		return filter;
//	}
}
