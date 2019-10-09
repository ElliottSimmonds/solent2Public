package org.solent.com504.factoryandfacade.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.model.AnimalObjectFactory;
import org.solent.com504.factoryandfacade.model.FarmFacade;

/**
 *
 * @author cgallen
 */
public class FarmFacadeTest {
    
    FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();

    @Test
    public void FarmFacadeTest() {
        assertNotNull(farmFacade);
    }
    
    @Test
    public void addCat() {
        System.out.println("Adding cat to farm");
        farmFacade.addCat("Earnie");
        System.out.println("List Size: " + farmFacade.getAllAnimals().size());
        assertEquals(1,farmFacade.getAllAnimals().size());
    }

    @Test
    public void addCow() {
        System.out.println("Adding cow to farm");
        farmFacade.addCow("Frankie");
        System.out.println("List Size: " + farmFacade.getAllAnimals().size());
        assertEquals(2,farmFacade.getAllAnimals().size());
    }
    
    @Test
    public void addDog() {
        System.out.println("Adding dog to farm");
        farmFacade.addDog("Bert");
        System.out.println("List Size: " + farmFacade.getAllAnimals().size());
        assertEquals(3,farmFacade.getAllAnimals().size());
    }
    
    @Test
    public void addDuck() {
        System.out.println("Adding duck to farm");
        farmFacade.addDuck("Dookie");
        System.out.println("List Size: " + farmFacade.getAllAnimals().size());
        assertEquals(4,farmFacade.getAllAnimals().size());
    }
    
    @Test
    public void getMultipleAnimals() {
        System.out.println("Adding multiple animals to farm");
        farmFacade.addDog("Charles");
        farmFacade.addCat("Sally");
        farmFacade.addCow("McBeef");
        farmFacade.addDuck("Faegie");
        
        List<Animal> animalList = farmFacade.getAllAnimals();
        animalList.forEach(a -> System.out.println(a.getName() + " says " + a.getSound()));
        System.out.println("List Size: " + animalList.size());
        
        assertEquals(8,animalList.size());
    }
    
    
    
}
