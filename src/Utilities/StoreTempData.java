package Utilities;

import Drink.SoftDrinks;
import Food.*;
import Table.Order;
import Users.Person;
import Users.User;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.ArrayList;

public class StoreTempData {

    private static StoreTempData ourInstance = new StoreTempData();

    private ArrayList<User> userData;

    private ArrayList<Pizza> pizzasData;

    private ArrayList<Burger> burgersData;


    private String showThisMenu;
    private Person.Role role = Person.Role.guest;

    private SimpleListProperty<Order> shoppingCartData = new SimpleListProperty<>(FXCollections.observableArrayList());

    private ArrayList<SoftDrinks> softDrinksData;
    private ArrayList<Pizza> foodsData ;


    private double totalPrice;

    private StoreTempData() {

    }
    public static StoreTempData getInstance() {
        return ourInstance;
    }
    public ArrayList<User> getUserData() {
        return userData;
    }
    public ArrayList<Pizza> getPizzasData() {
        return pizzasData;
    }
    public void setPizzasData(ArrayList<Pizza> pizzasData) {
        this.pizzasData = pizzasData;
    }

    public void setUserData(ArrayList<User> userData) {
        this.userData = userData;
    }

    public ArrayList<Burger> getBurgersData() {
        return burgersData;
    }
    public void setBurgersData(ArrayList<Burger> burgersData) {
        this.burgersData = burgersData;
    }
    public void setSoftDrinksData(ArrayList<SoftDrinks> softDrinksData) {
        this.softDrinksData = softDrinksData;
    }
    public String getShowThisMenu() {
        return showThisMenu;
    }
    public void setShowThisMenu(String showThisMenu) {
        this.showThisMenu = showThisMenu;
    }
    public SimpleListProperty<Order> getShoppingCartData() {
        return shoppingCartData;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public ArrayList<Pizza> getFoodsData() {
        return foodsData;
    }
    public void setFoodsData(ArrayList<Pizza> foodsData) {
        this.foodsData = foodsData;
    }

    public Person.Role getRole() {
        return role;
    }

    public void setRole(Person.Role role) {
        this.role = role;
    }
    public ArrayList<SoftDrinks> getSoftDrinksData() {
        return softDrinksData;
    }

}
