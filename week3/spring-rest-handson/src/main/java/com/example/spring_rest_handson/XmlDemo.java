package com.example.spring_rest_handson;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlDemo {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("beans.xml");
        Country c = (Country) context.getBean("country");
        System.out.println(c.getName() + " - " + c.getCode());
        context.close();
    }
}