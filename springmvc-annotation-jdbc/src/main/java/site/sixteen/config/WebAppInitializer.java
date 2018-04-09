package site.sixteen.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

@Slf4j
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public static final String CHARACTER_ENCODING = "UTF-8";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter =new CharacterEncodingFilter();
        encodingFilter.setEncoding(CHARACTER_ENCODING);
        encodingFilter.setForceEncoding(true);
        return new Filter[]{encodingFilter};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //选择数据源：开发环境
        servletContext.setInitParameter("spring.profiles.default","dev");
        super.onStartup(servletContext);
    }
}
