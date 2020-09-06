package com.zuul.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class RibbonConfig {

	@Autowired
	public IClientConfig config;

	/**
	 * 
	 * @param config
	 * @return check status machanism
	 */
	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}

	/**
	 * 
	 * @param config
	 * @return change default load balancer(round robin) to this new load balancer.
	 *         AvailabilityFilteringRule:
	 *         will use Ribbon’s built-in circuit breaker functionality to filter
	 *         out any servers in an “open-circuit” state: if a ping fails to
	 *         connect to a given server, or if it gets a read failure for the
	 *         server, Ribbon will consider that server “dead” until it begins to
	 *         respond normally.
	 */
	@Bean
	public IRule ribbonRule(IClientConfig config) {
		AvailabilityFilteringRule rule = new AvailabilityFilteringRule();
		rule.initWithNiwsConfig(config);
		return rule;
	}

}
