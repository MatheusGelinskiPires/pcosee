package pcosee.config;

import java.util.concurrent.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.DispatcherServlet;

import pcosee.converter.DocumentoConverter;
import pcosee.converter.TelefoneConverter;
import pcosee.formatter.AdministracaoFormatter;
import pcosee.formatter.EscolaridadeFormatter;
import pcosee.formatter.PerfilFormatter;
import pcosee.formatter.PeriodoFormatter;

@Configuration
@EnableWebMvc
@EnableScheduling
@EnableAsync
@ComponentScan({"pcosee"})
@PropertySource({"classpath:application.properties"})
public class SpringConfig implements WebMvcConfigurer {

    @Autowired
    private PerfilFormatter perfilFormatter;
    @Autowired
    private AdministracaoFormatter administracaoFormatter;
    @Autowired
    private EscolaridadeFormatter escolaridadeFormatter;
    @Autowired
    private PeriodoFormatter periodoFormatter;
    @Autowired
    private TelefoneConverter telefoneConverter;
    @Autowired
    private DocumentoConverter documentoConverter;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/images/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/resources/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/resources/fonts/**").addResourceLocations("/resources/fonts/");
    }
    
    @Bean
    public DispatcherServlet dispatcherServlet() {
        DispatcherServlet ds = new DispatcherServlet();
        ds.setThrowExceptionIfNoHandlerFound(true);
        return ds;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/views/**/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }

    @Bean
    public Executor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        viewResolver.setContentType("text/html;charset=UTF-8");
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(this.perfilFormatter);
        registry.addFormatter(this.administracaoFormatter);
        registry.addFormatter(this.escolaridadeFormatter);
        registry.addFormatter(this.periodoFormatter);
        registry.addConverter(this.telefoneConverter);
        registry.addConverter(this.documentoConverter);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("/messages/message");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("utf-8");
        messageSource.setCacheSeconds(0);
        return messageSource;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipart = new CommonsMultipartResolver();
        return multipart;
    }

    @Bean
    @Order(0)
    public MultipartFilter multipartFilter() {
        MultipartFilter multipartFilter = new MultipartFilter();
        multipartFilter.setMultipartResolverBeanName("multipartResolver");
        return multipartFilter;
    }

}
