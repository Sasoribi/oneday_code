package io.sasoribi.algorithm;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AlgorithmApplication implements InitializingBean {
    @Autowired
    ApplicationContext context;
    @Autowired
    String str;
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(AlgorithmApplication.class);
    }
    
    
    String str() {
        return "String...";
    }
    
    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception
     *         in the event of misconfiguration (such as failure to set an
     *         essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(str.hashCode());
        System.out.println(context.getBean("str").hashCode());
    }
}
