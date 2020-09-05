package com.zuul.example.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;


@Configuration
public class HystrixFallbackConfig {

	@Bean
	public FallbackProvider englishFallbackProvider() {
		
		return new FallbackProvider() {

			@Override
			public String getRoute() {
				// TODO Auto-generated method stub
				return "tpd-en";
			}

			@Override
			public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
				// TODO Auto-generated method stub
				return new ClientHttpResponse() {

					@Override
					public InputStream getBody() throws IOException {
                        return new ByteArrayInputStream("{\"factorA\":\"Sorry, Service is Down!\",\"factorB\":\"?\",\"id\":null}".getBytes());
					}

					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers  = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;
						}

					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.OK;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						return HttpStatus.OK.value();
					}

					@Override
					public String getStatusText() throws IOException {
						return HttpStatus.OK.toString();
					}

					@Override
					public void close() {
						// TODO Auto-generated method stub
						
					}
					
				};
			}
			
		};
	}
	
	@Bean
	public FallbackProvider spanishFallbackProvider() {
		
		return new FallbackProvider() {

			@Override
			public String getRoute() {
				// TODO Auto-generated method stub
				return "tpd-es";
			}

			@Override
			public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
				// TODO Auto-generated method stub
				return new ClientHttpResponse() {

					@Override
					public InputStream getBody() throws IOException {
                        return new ByteArrayInputStream("spanish service went down".getBytes());
					}

					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers  = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;
						}

					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.OK;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						return HttpStatus.OK.value();
					}

					@Override
					public String getStatusText() throws IOException {
						return HttpStatus.OK.toString();
					}

					@Override
					public void close() {
						// TODO Auto-generated method stub
						
					}
					
				};
			}
			
		};
	}
}
