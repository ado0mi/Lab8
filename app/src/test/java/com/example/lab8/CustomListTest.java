package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        list = MockCityList();
        City city = new City("Calgary", "Alberta");
        list.addCity(city);
        assertEquals(true, list.hasCity(city));
        assertFalse(list.hasCity(new City("Toronto", "Ontario")));
    }

    @Test
    public void testDelete() {
        list = MockCityList();
        City city = new City("Vancouver", "British Columbia");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.delete(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    public void testCountCities() {
        list = MockCityList();
        City city1 = new City("Winnipeg", "Manitoba");
        list.addCity(city1);
        Assert.assertEquals(1, list.countCities());
        list.addCity(new City("Regina", "Saskatchewan"));
        Assert.assertEquals(2, list.countCities());
        list.delete(city1);
        Assert.assertEquals(1, list.countCities());
    }


}
