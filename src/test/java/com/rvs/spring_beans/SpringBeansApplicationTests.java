package com.rvs.spring_beans;

import com.rvs.spring_beans.quoters.Quoter;
import com.rvs.spring_beans.quoters.TerminatorQuoter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBeansApplicationTests {
    @Autowired
    Quoter quoter;

    private final String message = "I'll be back";

    @Test
    void testQuoter() {
        String result = quoter.sayQuote();
        Assertions.assertEquals(message, result);
    }

    @Test
    void testCycle() throws InterruptedException {
        while (true) {
            Thread.sleep(2000);
            quoter.sayQuote();
        }
    }
}
