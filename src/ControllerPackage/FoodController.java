package ControllerPackage;

import DatabaseConnection.DbFoodQueries;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuItemsController extends Control {
    DbFoodQueries dbFoodQueries=new DbFoodQueries();
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    public void APaddToCartBtn(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("American Pizza");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("American Pizza",90,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void VPaddToCartBtn(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Veg Pizza");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Veg Pizza",99,Quantity);
            AlertBox("Successfully Added");

        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void CPaddToCartBtn(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Chicken Pizza");
        if(available>=Quantity){

            dbFoodQueries.insertValuesIntoMealsTable("Chicken Pizza",150,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void PPaddToCartBtn(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Pepperroni Pizza");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Pepperroni Pizza",110,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void VBaddToCartBtn(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Veg Burger");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Veg Burger",109,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void CBaddToCartBtn(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Chicken Burger");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Chicken Burger",69,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

}

    public void PBaddToCartBtn(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Power Burger");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Power Burger",110,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void SBaddToCartBtn(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Sandwich Burger");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Sandwich Burger",89,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void CZDrinkAddToCart(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Cola Zero");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Cola Zero",10,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void FDrinkAddToCart(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Fanta");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Fanta",9,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void CLDrinkAddToCart(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Crush Lime");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Crush Lime",7,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void PDrinkAddToCart(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Pepsi");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Pepsi",10,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void SupDrinkAddToCart(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("7up");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("7up",7,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void SpriteDrinkAddToCart(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Sprite");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Sprite",9,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void cokeDrinkAddToCart(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Coke");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Coke",10,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

    public void lokaDrinkAddToCart(ActionEvent event) {
        int Quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int available=dbFoodQueries.availableStock("Loka");
        if(available>=Quantity){
            dbFoodQueries.insertValuesIntoMealsTable("Loka",7,Quantity);
            AlertBox("Successfully Added");
        }else {
            AlertBox("Not Enough Stock\nAvailable Stock : "+available);
        }

    }

}










