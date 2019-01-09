package com.yolo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/1/9
 * Time: 16:42
 */


@Configuration
@ConditionalOnWebApplication
@Order(0)
public class ServletConfig implements WebMvcConfigurer {
    public ServletConfig() {
    }


    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        Iterator iterator = converters.iterator();

        while (iterator.hasNext()) {
            HttpMessageConverter converter = (HttpMessageConverter) iterator.next();
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) converter).setDefaultCharset(Charset.forName("UTF-8"));
            }

            if (converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter json = (MappingJackson2HttpMessageConverter) converter;
                ObjectMapper mapper = json.getObjectMapper();
                mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                SimpleModule simpleModule = new SimpleModule();
                simpleModule.addSerializer(Long.class, new JsonSerializer<Long>() {
                    public void serialize(Long aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException{
                        jsonGenerator.writeString(String.valueOf(aLong));
                    }
                });
                mapper.registerModule(simpleModule);
                mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            }
        }

    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//    }


    @Bean
    public MultipartResolver standardMultipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setExtractValueFromSingleKeyModel(true);
        return jsonView;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setPreferFileSystemAccess(false);
        freeMarkerConfigurer.setTemplateLoaderPaths(new String[]{"classpath*:META-INF/resources", "classpath:templates"});
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");
        Map<String, Object> freemarkerVariables = new HashMap();
        freeMarkerConfigurer.setFreemarkerVariables(freemarkerVariables);
        Properties properties = new Properties();
        properties.put("tag_syntax", "auto_detect");
        properties.put("defaultEncoding", "UTF-8");
        properties.put("url_escaping_charset", "UTF-8");
        properties.put("locale", "zh_CN");
        properties.put("boolean_format", "true,false");
        properties.put("datetime_format", "yyyy-MM-dd HH:mm:ss");
        properties.put("date_format", "yyyy-MM-dd");
        properties.put("time_format", "HH:mm:ss");
        properties.put("number_format", "0.######");
        properties.put("whitespace_stripping", "true");
        freeMarkerConfigurer.setFreemarkerSettings(properties);
        return freeMarkerConfigurer;
    }

    @Bean
    public ViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".ftl");
        resolver.setOrder(0);
        resolver.setViewClass(FreeMarkerView.class);
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setCache(false);
        resolver.setExposeContextBeansAsAttributes(true);
        resolver.setExposePathVariables(true);
        resolver.setExposeRequestAttributes(true);
        resolver.setExposeSessionAttributes(true);
        resolver.setExposeSpringMacroHelpers(true);
        resolver.setRequestContextAttribute("base");
        return resolver;
    }

    public static Class init() {
        return ServletConfig.class;
    }
}
