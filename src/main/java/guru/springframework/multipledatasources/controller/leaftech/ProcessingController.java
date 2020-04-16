package guru.springframework.multipledatasources.controller.leaftech;


import guru.springframework.multipledatasources.dao.leaftech.ProcessingRepository;
import guru.springframework.multipledatasources.model.leaftech.Processing;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/processing")
@Controller
public class ProcessingController {
    @Autowired
    private ProcessingRepository processingRepository;

    @GetMapping
    public List<Processing> list(){
        return processingRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Processing get(@PathVariable String id){
        return processingRepository.getOne(id);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public Processing create(@RequestBody final Processing processing){
        return processingRepository.saveAndFlush(processing);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        processingRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Processing update(@PathVariable String id, @RequestBody Processing processing){
        Processing existingSeed = processingRepository.getOne(id);
        BeanUtils.copyProperties(processing, existingSeed, "productid");
        return processingRepository.saveAndFlush(existingSeed);
    }
}

