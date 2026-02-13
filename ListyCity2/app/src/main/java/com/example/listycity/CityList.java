package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     *
     * @param city This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This deletes a city from the list
     * @param city This is a candidate city to remove
     */
    public void delete(City city){
        if (!cities.contains(city)){
            throw new IllegalArgumentException("City not found in the list");
        }
        cities.remove(city);
    }

    /**
     * This counts the number of cities in the list
     *
     * @return The total number of cities as an integer
     */
    public int countCities () {
        return cities.size();
    }

    /**
     * This checks whether the city belongs in the list
     *
     * @param city This is the candidate city to check for
     *
     * @return True or false on the basis of whether the city exists in the list
     */

    public boolean hasCity(City city){
        return cities.contains(city);
    }
}
