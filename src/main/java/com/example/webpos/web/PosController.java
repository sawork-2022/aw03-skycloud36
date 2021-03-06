package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/")
    public String pos(Model model) {
//        posService.add("PD1",2);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        return "index";
    }

    @GetMapping("/ss")
    public String posss(Model model) {
        posService.add("PD1",2);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        return "index";
    }

    @GetMapping("/addItem")
    public String addItem(@RequestParam("productId") String productId,
                       @RequestParam("amount") int amount,
                       Model model) {
        posService.add(productId, amount);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        return "redirect:/";
    }

    @GetMapping("/deleteItem")
    public String deleteItem(@RequestParam("productId") String productId,
                       Model model) {
        posService.delete(productId);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        return "redirect:/";
    }

    @GetMapping("/modifyItem")
    public String modifyItem(@RequestParam("productId") String productId,
                             @RequestParam("amount") int amount,
                             Model model) {
        posService.modify(productId,amount);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        return "redirect:/";
    }

    @GetMapping("/emptyCart")
    public String emptyCart(Model model) {
        posService.empty();
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        return "redirect:/";
    }

    @GetMapping("/pay")
    public String pay(Model model) {
        posService.empty();
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        return "redirect:/";
    }
}
