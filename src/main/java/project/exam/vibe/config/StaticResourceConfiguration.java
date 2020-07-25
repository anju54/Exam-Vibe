package project.exam.vibe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/media/**")
        .addResourceLocations("file:media/")
        .setCachePeriod(0);
    }

}
