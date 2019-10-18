package com.lysenko.callbackImplement;

import java.util.Arrays;
import java.util.List;

interface Interface3 {
    String evaluate(String s);
}

public class CallBackDemo3 {
    public static void main(String[] args) {
        List<String> data = Arrays.asList("first line", "SEcOnD LiNe");

        Template template = new Template(new CustomOperation());
        template.processData(data);

        template.setCallback(new CustomOperation_2());
        template.processData(data);
    }
}


class Template {
    private Interface3 callback;
    Template(Interface3 callback) {
        this.callback = callback;
    }
    void setCallback(Interface3 callback) {
        this.callback = callback;
    }
    void processData(List<String> lines) {
        for (String line : lines) {
            System.out.println("Input: " + line);
            line = "[" + line + "]";
            System.out.println("Standart operation a1 result : " + line);

            line = line.replaceAll(" ", "_");
            System.out.println("Standart operation a2 result : " + line);

            line = callback.evaluate(line); // здесь мы будем передавать контроль над обработкой пользователю
            System.out.println("Custom operation result     : " + line);

            line = line.toLowerCase();
            System.out.println("Standart operation a3 result : " + line);
        }
    }
}


class CustomOperation implements Interface3 {
    public String evaluate(String s) {
        return "CUSTOM: " + s;
    }
}


class CustomOperation_2 implements Interface3 {
    public String evaluate(String s) {
        return "CUSTOM_2: " + s;
    }
}





