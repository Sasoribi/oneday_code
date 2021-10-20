package io.sasoribi.algorithm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Spliterator;

class AlgorithmApplicationTests {

    @Test
    void test() {
        System.out.println("1;2".split(";").length);
        Spliterator<Object> spliterator = new ArrayList<>().spliterator();
        
    }

}
