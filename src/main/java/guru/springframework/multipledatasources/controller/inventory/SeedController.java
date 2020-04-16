package guru.springframework.multipledatasources.controller.inventory;


import guru.springframework.multipledatasources.dao.inventory.SeedRepository;
import guru.springframework.multipledatasources.model.inventory.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seeds")
@Controller
public class SeedController {
    @Autowired
    private SeedRepository seedsRepository;

    @GetMapping
    public List<Seed> list(){
        return seedsRepository.findAll();
    }
//
//    @GetMapping
//    @RequestMapping("{id}")
//    public Seed get(@PathVariable String id){
//        return seedsRepository.getOne(id);
//    }
//
//    @PostMapping
////    @ResponseStatus(HttpStatus.CREATED)
//    public Seed create(@RequestBody final Seed seed){
//        return seedsRepository.saveAndFlush(seed);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable String id){
//        seedsRepository.deleteById(id);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//    public Seed update(@PathVariable String id, @RequestBody Seed seed){
//        Seed existingSeed = seedsRepository.getOne(id);
//        BeanUtils.copyProperties(seed, existingSeed, "product_code");
//        return seedsRepository.saveAndFlush(existingSeed);
//    }
}
