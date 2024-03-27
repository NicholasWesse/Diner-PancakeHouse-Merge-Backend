package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;
    CafeRepository cafeRepository;
    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository, DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository, CafeRepository cafeRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
        this.cafeRepository = cafeRepository;
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> output = new ArrayList<>();
        ArrayList<Menu> holder = mergerRepository.getTheMenus();
        Iterator<Menu> h = holder.iterator();


        while(h.hasNext()) {
            Iterator<MenuItem> it = h.next().createIterator();
            while (it.hasNext()) {
                output.add(it.next());
            }
        }
        return output;
    }
}
