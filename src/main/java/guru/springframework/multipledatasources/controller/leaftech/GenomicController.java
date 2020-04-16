package guru.springframework.multipledatasources.controller.leaftech;



import guru.springframework.multipledatasources.dao.leaftech.GenomicRepository;
import guru.springframework.multipledatasources.model.leaftech.Genomic;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genomic")
@Controller
public class GenomicController {
    @Autowired
    private GenomicRepository genomicRepository;

    @GetMapping
    public List<Genomic> list(){
        return genomicRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Genomic get(@PathVariable String id){
        return genomicRepository.getOne(id);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public Genomic create(@RequestBody final Genomic genomic){
        return genomicRepository.saveAndFlush(genomic);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        genomicRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Genomic update(@PathVariable String id, @RequestBody Genomic genomic){
        Genomic existingSeed = genomicRepository.getOne(id);
        BeanUtils.copyProperties(genomic, existingSeed, "productid");
        return genomicRepository.saveAndFlush(existingSeed);
    }
}
