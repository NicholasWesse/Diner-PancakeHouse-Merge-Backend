package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {

    DinerRepository dr = new DinerRepository();
    PancakeHouseRepository pr = new PancakeHouseRepository();

    @GetMapping()
    public List<MenuItem> getMenuItems(){
        List<MenuItem> output;
        output = pr.getTheMenu();
        output.addAll(Arrays.stream(dr.getTheMenu()).toList());
        System.out.println(output);
        return output;
    }
}
