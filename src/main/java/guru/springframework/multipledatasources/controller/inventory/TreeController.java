package guru.springframework.multipledatasources.controller.inventory;

import guru.springframework.multipledatasources.dao.inventory.TreeRepository;
import guru.springframework.multipledatasources.model.inventory.Tree;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/trees")
@Controller
public class TreeController {
    @Autowired
    private TreeRepository treesRepository;

    @GetMapping
    public List<Tree> list(){
        return treesRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Tree get(@PathVariable String id){
        System.out.println(id);
        return treesRepository.getOne(id);
    }

    @PostMapping
    public Tree create(@RequestBody final Tree tree){
        System.out.println(tree.getProduct_code());
        return treesRepository.saveAndFlush(tree);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        treesRepository.deleteById(id);
    }

    @PutMapping
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Tree update(@PathVariable String id, @RequestBody Tree tree){
        System.out.println(id);

        Tree existingTree = treesRepository.getOne(id);
        BeanUtils.copyProperties(tree, existingTree, "product_code");
        return treesRepository.saveAndFlush(existingTree);
    }
}
