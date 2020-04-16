package guru.springframework.multipledatasources.controller.inventory;

import guru.springframework.multipledatasources.dao.inventory.ShurbRepository;
import guru.springframework.multipledatasources.model.inventory.Shrub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shrubs")
@Controller
public class ShrubController {
    @Autowired
    private ShurbRepository shrubsRepository;

    @GetMapping
    public List<Shrub> list(){
        return shrubsRepository.findAll();
    }

//    @GetMapping
//    @RequestMapping("{id}")
//    public Shrub get(@PathVariable String id){
//        return shrubsRepository.getOne(id);
//    }
//
//    @PostMapping
//    public Shrub create(@RequestBody final Shrub shrub){
//        return shrubsRepository.saveAndFlush(shrub);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable String id){
//        shrubsRepository.deleteById(id);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//    public Shrub update(@PathVariable String id, @RequestBody Shrub shrub){
//        Shrub existingShrub = shrubsRepository.getOne(id);
//        BeanUtils.copyProperties(shrub, existingShrub, "product_code");
//        return shrubsRepository.saveAndFlush(existingShrub);
//    }
}

