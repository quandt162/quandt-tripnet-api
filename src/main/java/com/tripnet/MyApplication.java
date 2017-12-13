package com.tripnet;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@EntityScan(basePackages = { "com.tripnet.enties" })
public class MyApplication extends SpringBootServletInitializer {

	// @Resource
	// StorageService storageService;

	// @Override
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder
	// application) {
	// return application.sources(MyApplication.class);
	// }

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {

		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

		tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
			if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
				// -1 means unlimited
				((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
			}
		});

		return tomcat;

	}

	// @Override
	// public void run(String... args) throws Exception {
	// // storageService.deleteAll();
	// storageService.init();
	// }
}