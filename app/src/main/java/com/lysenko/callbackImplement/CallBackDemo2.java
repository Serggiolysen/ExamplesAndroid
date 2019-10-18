package com.lysenko.callbackImplement;

interface Interface2 {
    void callPrivateMethod(String caller);
}

public class CallBackDemo2 {
    public static void main(String[] args) {
        PrivateFieldHolder pfh = new PrivateFieldHolder();
        OuterCaller oc = new OuterCaller();
        pfh.setOuterCaller(oc);
        pfh.publicMethod();
    }
}


class PrivateFieldHolder {
    private OuterCaller outerCaller;
    void setOuterCaller(OuterCaller outerCaller) {
        this.outerCaller = outerCaller;
    }
    void publicMethod() {
        System.out.println("Holder: public method call");
        // здесь хитрая штука: мы передаем в вызов метода
        // внешнего класса коллбэк, который
        // является анонимным классом внутри данного класса
        // т.к. этот анонимный класс видит private-метод, то мы
        // можем поместить внутрь callPrivateMethod вызов этого
        // private-метода. Таким образом при вызове
        // callPrivateMethod во внешнем классе позволит обратиться
        // к private-методу этого класса.
        outerCaller.callFromOutsidePrivateMethod(new Interface2() {

            public void callPrivateMethod(String caller) {
                privateMethod(caller);
            }
        });

    }

    private void privateMethod(String caller) {
        System.out.println(caller + ": private method call");
    }
}


class OuterCaller {
    void callFromOutsidePrivateMethod(Interface2 callback) {
        System.out.println("Outer method call");
        callback.callPrivateMethod("Outer caller");
    }
}



