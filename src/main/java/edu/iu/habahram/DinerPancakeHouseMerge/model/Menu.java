package edu.iu.habahram.DinerPancakeHouseMerge.model;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    Iterator<MenuComponent> iterator = null;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }
    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }
    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
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
    public MenuItem[] getItems() {
        ArrayList<MenuItem> me = new ArrayList<>();
        MenuItem[] output = new MenuItem[menuComponents.size()];
        int i=0;
        for(MenuComponent m : menuComponents){
               Iterator<MenuItem> it = m.createIterator();
               if(it.hasNext()){
                   MenuItem hol = it.next();
                   output[i] = hol;
                   ++i;
               }
        }

        return output;
    }
    @Override
    public Iterator<MenuComponent> createIterator(){
        if(iterator == null){
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }
}