package org.solent.com504.factoryandfacade.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalObjectFactory {
    
    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static Animal createCat() {
        Cat cat = (Cat) CONTEXT.getBean("cat");
        return cat;
    }

    public static Animal createDog() {
        Dog dog = (Dog) CONTEXT.getBean("dog");
        return dog;
    }

    public static Animal createCow() {
        Cow cow = (Cow) CONTEXT.getBean("cow");
        return cow;
    }
    
    public static Animal createDuck() {
        Duck duck = (Duck) CONTEXT.getBean("duck");
        return duck;
    }

    public static FarmFacade createFarmFacade() {
        FarmFacade farmFacade = (FarmFacadeImpl) CONTEXT.getBean("farmFacade");
        return farmFacade;
    }
}
