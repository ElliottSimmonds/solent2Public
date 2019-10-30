package org.solent.com504.factoryandfacade.impl.service;

import java.util.ArrayList;
import java.util.List;
import org.solent.com504.factoryandfacade.model.dao.AnimalDao;
import org.solent.com504.factoryandfacade.model.dao.AnimalTypeDao;
import org.solent.com504.factoryandfacade.model.dto.Animal;
import org.solent.com504.factoryandfacade.model.dto.AnimalType;
import org.solent.com504.factoryandfacade.model.service.FarmFacade;

public class FarmFacadeImpl implements FarmFacade {

    private AnimalDao animalDao = null;
    
    private AnimalTypeDao animalTypeDao = null;

   // setters for DAOs
    public void setAnimalDao(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    public void setAnimalTypeDao(AnimalTypeDao animalTypeDao) {
        this.animalTypeDao = animalTypeDao;
    }
    
    // Farm facade methods
    @Override
    public List<Animal> getAllAnimals() {
        return animalDao.retrieveAll();
    }

    @Override
    public Animal addAnimal(String animalTypeStr, String name) {
        AnimalType animalType = animalTypeDao.getAnimalType(animalTypeStr);
        Animal animal = animalDao.create(animalType);
        animal.setName(name);
        return animal;
    }

    @Override
    public List<Animal> getAnimalsOfType(String animalTypeStr) {
        AnimalType animalType = animalTypeDao.getAnimalType(animalTypeStr);
        Animal templateAnimal = animalDao.create(animalType);
        List<Animal> typeList = animalDao.retrieve(templateAnimal);
        return typeList;
    }

    @Override
    public Animal getAnimal(String name) {
        Animal animalTemplate = new Animal();
        animalTemplate.setName(name);
        List<Animal> animals = animalDao.retrieve(animalTemplate);
        return animals.get(0);
    }

    @Override
    public boolean removeAnimal(String name) {
        Animal animal = getAnimal(name);
        Long id = animal.getId();
        return animalDao.delete(id);
    }

    @Override
    public List<String> getSupportedAnimalTypes() {
        List<String> stringTypeList = new ArrayList<>();
        List<AnimalType> typeList = animalTypeDao.getSupportedAnimalTypes();
        //iterate through typelist, get type as string and append to stringtypelist
        return stringTypeList;
    }
}
