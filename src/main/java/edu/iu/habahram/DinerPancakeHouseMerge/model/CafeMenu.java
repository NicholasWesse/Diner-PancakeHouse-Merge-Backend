package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CafeMenu extends Menu{
    HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>();

    public CafeMenu(String name, String description) {
        super(name,description);
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99);
        addItem("Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false, 3.69);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29);
    }


    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(name, menuItem);
    }


    public MenuItem[] getMenuItems() {
        return menuItems.values().toArray(new MenuItem[0]);
    }

    @Override
    public MenuItem[] getItems() {
        Iterator<MenuItem> it = menuItems.values().iterator();
        MenuItem[] out = new MenuItem[menuItems.size()];
        int i=0;

        while(it.hasNext()){
            out[i] = it.next();
        }
        return out;
    }


    public Iterator<MenuComponent> createIterator() {
        if(iterator == null){
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }

}