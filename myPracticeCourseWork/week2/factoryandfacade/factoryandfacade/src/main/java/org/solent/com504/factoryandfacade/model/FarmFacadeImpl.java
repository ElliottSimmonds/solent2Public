/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 4simme28
 */
public class FarmFacadeImpl implements FarmFacade {
    
    List<Animal> animals = new ArrayList<>();
    
    @Override
    public List<Animal> getAllAnimals() {
        return new ArrayList(animals);
    }

    @Override
    public void addDog(String name) {
        Animal newDog = AnimalObjectFactory.createDog();
        newDog.setName(name);
        animals.add(newDog);
    }

    @Override
    public void addCat(String name) {
        Animal newCat = AnimalObjectFactory.createCat();
        newCat.setName(name);
        animals.add(newCat);
    }

    @Override
    public void addCow(String name) {
        Animal newCow = AnimalObjectFactory.createCow();
        newCow.setName(name);
        animals.add(newCow);
    }

}
