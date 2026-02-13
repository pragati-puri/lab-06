package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCityTrue(){
        CityList cityList = mockCityList();
        City city = mockCity();
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testHasCityFalse(){
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testHasCityDifferentProvince() {
        CityList cityList = new CityList();
        City city1 = new City("Ottawa", "Ontario");
        cityList.add(city1);
        City city2 = new City("Ottawa", "British Columbia");
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    void testDelete(){
        CityList cityList = mockCityList();
        City city = mockCity();
        assertEquals(1,cityList.countCities());
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException(){
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testDeleteMultipleCities(){
        CityList cityList = mockCityList();
        City city2 = new City("Calgary", "Alberta");
        City city3 = new City("Vancouver", "British Columbia");
        cityList.add(city2);
        cityList.add(city3);
        assertEquals(3, cityList.countCities());
        cityList.delete(city2);

        assertEquals(2, cityList.countCities());
        assertFalse(cityList.hasCity(city2));
        assertTrue(cityList.hasCity(mockCity()));
        assertTrue(cityList.hasCity(city3));
    }

    @Test
    void testCountCitiesEmpty(){
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testCountCitiesOne(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
    }

    @Test
    void testCountCitiesMultiple(){
        CityList cityList = mockCityList();
        cityList.add(new City("Calgary", "Alberta"));
        cityList.add(new City("Vancouver", "British Columbia"));
        cityList.add(new City("Toronto", "Ontario"));
        assertEquals(4, cityList.countCities());
    }

    @Test
    void testCountCitiesAfterAdd(){
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        cityList.add(new City("Montreal", "Quebec"));
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Ottawa", "Ontario"));
        assertEquals(2, cityList.countCities());
    }

    @Test
    void testCountCitiesAfterDelete(){
        CityList cityList = mockCityList();
        City city2 = new City("Winnipeg", "Manitoba");
        cityList.add(city2);
        assertEquals(2, cityList.countCities());
        cityList.delete(city2);
        assertEquals(1, cityList.countCities());
        cityList.delete(mockCity());
        assertEquals(0, cityList.countCities());
    }

}

