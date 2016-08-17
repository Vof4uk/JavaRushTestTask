package main.java.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.
        AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebAppInit
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        CharacterEncodingFilter encFilter = new CharacterEncodingFilter();

        encFilter.setEncoding("UTF-8");
        encFilter.setForceEncoding(true);

        javax.servlet.FilterRegistration.Dynamic filter1 = registerServletFilter(servletContext, encFilter);
        filter1.addMappingForUrlPatterns(null, false, "/*");
//        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();
//        javax.servlet.FilterRegistration.Dynamic filter2 = registerServletFilter(servletContext, httpMethodFilter);
//        filter2.addMappingForUrlPatterns(null, false, "/*");
    }
}