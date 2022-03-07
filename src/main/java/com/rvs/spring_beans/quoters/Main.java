package com.rvs.spring_beans.quoters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new GenericApplicationContext();
        while (true) {
            Thread.sleep(100);
            Quoter tq = (TerminatorQuoter) context.getBean("tq");
            tq.sayQuote();
        }
    }
}
