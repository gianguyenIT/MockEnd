package fa.training.controller;

import fa.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/showOrder")
    public String showAllOrder(Model model, HttpSession session) {
        session.setAttribute("order", orderService.findAll()) ;
        model.addAttribute("pageTitle", "Purchase");
        model.addAttribute("direction", "container/purchase");
        return "index";
    }
}
