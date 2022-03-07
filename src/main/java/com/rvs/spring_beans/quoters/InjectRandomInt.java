package com.rvs.spring_beans.quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //по умолчанию CLASS
public @interface InjectRandomInt {
    int min();
    int max();
}
