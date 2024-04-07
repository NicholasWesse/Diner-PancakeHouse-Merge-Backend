

package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.util.CompositeIterator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        return mergerRepository.getTheMenuItems();
    }

    @GetMapping("/vegetarian")
    public List<Object> getVegetarian(){
        MenuItem[] items = mergerRepository.getItems();
        List<Object> output = new ArrayList<>();
        Iterator<MenuItem> ite = Arrays.stream(items).iterator();
        edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator it = new edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator(ite);

        while(it.hasNext()){
            Object x = it.next();

            if(x instanceof DinerMenu || x instanceof PancakeHouseMenu || x instanceof CafeMenu){
                for(MenuItem er : ((Menu) x).getItems()) {
                    if (er.isVegetarian()) {
                        output.add(new MenuItemRecord(er.getName(), er.getDescription(), er.isVegetarian(), er.getPrice()));
                    }
                }
            }
        }
        return output;
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfast(){
        MenuItem[] items = mergerRepository.getItems();
        List<MenuItemRecord> output = new ArrayList<>();
        Iterator<MenuItem> ite = Arrays.stream(items).iterator();
        edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator it = new edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator(ite);

        while(it.hasNext()){
            Object x = it.next();
            if(x instanceof PancakeHouseMenu) {
                for (MenuItem er : ((PancakeHouseMenu) x).getMenuItems()) {
                    output.add(new MenuItemRecord(er.getName(),er.getDescription(),er.isVegetarian(),er.getPrice()));
                }
            }
        }
        return output;
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunch(){
        MenuItem[] items = mergerRepository.getItems();
        List<MenuItemRecord> output = new ArrayList<>();
        Iterator<MenuItem> ite = Arrays.stream(items).iterator();
        edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator it = new edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator(ite);

        while(it.hasNext()){
            Object x = it.next();
            if(x instanceof DinerMenu) {
                for (MenuItem er : ((DinerMenu) x).getMenuItems()) {
                    output.add(new MenuItemRecord(er.getName(),er.getDescription(),er.isVegetarian(),er.getPrice()));
                }
            }
        }
        return output;
    }

    @GetMapping("/dinner")
    public List<MenuItemRecord> getSupper(){
        MenuItem[] items = mergerRepository.getItems();
        List<MenuItemRecord> output = new ArrayList<>();
        Iterator<MenuItem> ite = Arrays.stream(items).iterator();
        edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator it = new edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator(ite);

        while(it.hasNext()){
            Object x = it.next();
            if(x instanceof CafeMenu) {
                for (MenuItem er : ((CafeMenu) x).getMenuItems()) {
                    output.add(new MenuItemRecord(er.getName(),er.getDescription(),er.isVegetarian(),er.getPrice()));
                }
            }
        }
        return output;
    }


}
