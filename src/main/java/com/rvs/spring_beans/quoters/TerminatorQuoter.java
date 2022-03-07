package com.rvs.spring_beans.quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("tq")
@Profiling
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminatorQuoter() { //Оригинальный java-конструктор
        System.out.println("Phase 1");
        System.out.println(repeat);
    }

    @PostConstruct //Всегда работает на оригинальные методы, пока прокси еще не накрутились
    public void init() {
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    @Value("${msg}")
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy // Метод вызовется после создания всех прокси
    public String sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
        return message;
    }
}
