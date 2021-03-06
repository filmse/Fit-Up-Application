package camt.FitUp.Project.config;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.*;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.MultipartConfigElement;
import java.util.Locale;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"camt.FitUp.Project"})
@EnableAspectJAutoProxy
@Import({PersistenceContext.class})
public class AppConfig extends WebMvcConfigurerAdapter {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowCredentials(false)
//                .allowedOrigins("*")
//                .allowedMethods("PUT", "POST", "GET", "OPTIONS", "DELETE")
//                .exposedHeaders("Authorization", "Content-Type");
//    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //     The localization here
    @Bean
    public LocaleResolver localeResolver() {
        final SessionLocaleResolver ret = new SessionLocaleResolver();
        ret.setDefaultLocale(new Locale("en"));
        return ret;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public HandlerInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localChangeInterceptor = new LocaleChangeInterceptor();
        localChangeInterceptor.setParamName("lang");
        return localChangeInterceptor;
    }

    @Bean
    public MultipartResolver filterMultipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(200000000);
        return multipartResolver;
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("50MB");
        factory.setMaxRequestSize("50MB");
        return factory.createMultipartConfig();
    }

//    private static BraintreeGateway gateway = new BraintreeGateway(
//            Environment.SANDBOX,
//            "your_merchant_id",
//            "your_public_key",
//            "your_private_key"
//    );

}
