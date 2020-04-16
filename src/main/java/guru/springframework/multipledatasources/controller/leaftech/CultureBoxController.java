package guru.springframework.multipledatasources.controller.leaftech;


import guru.springframework.multipledatasources.dao.leaftech.CultureBoxRepository;
import guru.springframework.multipledatasources.model.leaftech.CultureBox;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/culturebox")
@Controller
public class CultureBoxController {
    @Autowired
    private CultureBoxRepository cultureBoxRepository;

    @GetMapping
    public List<CultureBox> list(){
        return cultureBoxRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public CultureBox get(@PathVariable String id){
        return cultureBoxRepository.getOne(id);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public CultureBox create(@RequestBody final CultureBox cultureBox){
        return cultureBoxRepository.saveAndFlush(cultureBox);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        cultureBoxRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public CultureBox update(@PathVariable String id, @RequestBody CultureBox cultureBox){
        CultureBox existingSeed = cultureBoxRepository.getOne(id);
        BeanUtils.copyProperties(cultureBox, existingSeed, "productid");
        return cultureBoxRepository.saveAndFlush(existingSeed);
    }
}
