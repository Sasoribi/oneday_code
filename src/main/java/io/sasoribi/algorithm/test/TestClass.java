package io.sasoribi.algorithm.test;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestClass {
    @Bean
    String str() {
        return new String("TestClass");
    }
}
