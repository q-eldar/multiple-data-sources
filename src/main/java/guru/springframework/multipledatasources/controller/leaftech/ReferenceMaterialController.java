package guru.springframework.multipledatasources.controller.leaftech;


import guru.springframework.multipledatasources.dao.leaftech.ReferenceMaterialRepository;
import guru.springframework.multipledatasources.model.leaftech.ReferenceMaterial;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/referencematerial")
@Controller
public class ReferenceMaterialController {
    @Autowired
    private ReferenceMaterialRepository referenceMaterialRepository;

    @GetMapping
    public List<ReferenceMaterial> list(){
        return referenceMaterialRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ReferenceMaterial get(@PathVariable String id){
        return referenceMaterialRepository.getOne(id);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ReferenceMaterial create(@RequestBody final ReferenceMaterial referenceMaterial){
        return referenceMaterialRepository.saveAndFlush(referenceMaterial);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        referenceMaterialRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ReferenceMaterial update(@PathVariable String id, @RequestBody ReferenceMaterial referenceMaterial){
        ReferenceMaterial existingSeed = referenceMaterialRepository.getOne(id);
        BeanUtils.copyProperties(referenceMaterial, existingSeed, "productid");
        return referenceMaterialRepository.saveAndFlush(existingSeed);
    }
}

