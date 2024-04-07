package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;

public class NullIterator extends MenuComponent {

    public Object next(){
        return null;
    }

    public boolean hasNext(){
        return false;
    }


    public void remove(){
        throw new UnsupportedOperationException();
    }
}
