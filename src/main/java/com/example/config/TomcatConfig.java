package com.example.config;

import org.apache.catalina.Context;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig implements EmbeddedServletContainerCustomizer{

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		
		TomcatEmbeddedServletContainerFactory tomcat=(TomcatEmbeddedServletContainerFactory)container;
		tomcat.addContextCustomizers(new TomcatContextCustomizer() {
			
			@Override
			public void customize(Context context) {
				
				context.addWelcomeFile("index.jsp");
			}
		});
	}
}
