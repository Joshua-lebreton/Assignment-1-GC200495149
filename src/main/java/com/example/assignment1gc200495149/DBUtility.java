package com.example.assignment1gc200495149;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DBUtility {
    private static String user = "Josh200495149"; //MySQL server username
    private static String pw = "UrSwAXxnHK";
    private static String connectUrl = "jdbc:mysql://172.31.22.43:3306/Josh200495149";




    public static ArrayList<Workout> getWorkoutDataFromDB()
    {
        //the pizzaID will be the key, the pizza will be the value
        ArrayList<Workout> workouts = new ArrayList<>();

        //create the sql string we want to run on the database
        String sql = "SELECT pizzas.pizzaID, size, dough, crustStyle,sauce,delivery,price,toppings.toppingID,toppingName " +
                "FROM pizzas INNER JOIN toppingsonpizza " +
                "INNER JOIN toppings " +
                "WHERE toppings.toppingID = toppingsonpizza.toppingID AND pizzas.pizzaID = toppingsonpizza.pizzaID " +
                "ORDER BY pizzas.pizzaID,toppingsonpizza.toppingonpizzaID;";

        //the try () is called "try with resources".  Anything opened in the () will
        //automatically close when the try block is done.
        try(
                //1.  connect to the database
                Connection conn = DriverManager.getConnection(connectUrl,user,pw);

                //2.  create a statement object
                Statement statement = conn.createStatement();

                //3.  use the statement object to run the sql and return a ResultSet object
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            //4.  loop over the resultSet and create Topping objects
            while (resultSet.next())
            {
                int pizzaID = resultSet.getInt("pizzaID");
                String size = resultSet.getString("size");
                String dough = resultSet.getString("dough");
                String crust = resultSet.getString("crustStyle");
                String sauce = resultSet.getString("sauce");
                Boolean delivery = resultSet.getBoolean("delivery");
                Double price = resultSet.getDouble("price");
                int toppingID = resultSet.getInt("toppingID");


                //the pizza does not exist, create it and add it to the TreeMap
                ArrayList<Topping> toppings = new ArrayList<>();
                toppings.add(allToppings.get(toppingID-1));  //The toppingID in the database
                //starts at 1.  In the arraylist
                //it starts at 0.
                Pizza newPizza = new Pizza(pizzaID,size,toppings,dough,crust,sauce,delivery);
                pizzas.put(pizzaID,newPizza);

            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return pizzas.values();
    }
}
