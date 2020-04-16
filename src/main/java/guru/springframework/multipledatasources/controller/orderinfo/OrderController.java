package guru.springframework.multipledatasources.controller.orderinfo;

import guru.springframework.multipledatasources.dao.orderinfo.OrderRepository;
import guru.springframework.multipledatasources.model.orderinfo.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> list(){
        return orderRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Order get(@PathVariable Integer id){
        return orderRepository.getOne(id);
    }

    @PostMapping
    //    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody final Order order){
        return orderRepository.saveAndFlush(order);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        orderRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Order update(@PathVariable Integer id, @RequestBody Order order){
        Order existingSeed = orderRepository.getOne(id);
        BeanUtils.copyProperties(order, existingSeed, "product_code");
        return orderRepository.saveAndFlush(existingSeed);
    }
}
