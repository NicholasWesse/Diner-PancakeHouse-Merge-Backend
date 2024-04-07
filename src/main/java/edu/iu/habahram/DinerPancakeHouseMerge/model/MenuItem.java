package edu.iu.habahram.DinerPancakeHouseMerge.model;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;

import java.util.Iterator;

public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price)
    {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }
    @Override
    public String toString() {
        return (name + ", $" + price + "\n   " + description);
    }
    @Override
    public MenuItem[] getItems() {
        MenuItem[] items = new MenuItem[1];
        items[0] = this;
        return items;
    }
    @Override
    public Iterator<MenuComponent> createIterator(){
        return null;
    }
}