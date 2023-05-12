package fa.training.controller;

import fa.training.dto.CustomerDTO;
import fa.training.entity.Customer;
import fa.training.repository.CustomerRepository;
import fa.training.service.CategoryService;
import fa.training.service.CustomerService;
import fa.training.service.OrderService;
import fa.training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class ViewController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    private CustomerRepository repository;

    @GetMapping(value = {"/home", "/"})
    public String homePage(Model model) {
        model.addAttribute("home", Boolean.TRUE); // Active Home Nav Bar
        model.addAttribute("shop", Boolean.FALSE);
        model.addAttribute("product", Boolean.FALSE);
        model.addAttribute("contact", Boolean.FALSE);
        model.addAttribute("pageTitle", "Home");
        model.addAttribute("direction", "container/home");
        return "index";
    }

    @GetMapping(value ="/shop")
    public String shop(Model model) {
        model.addAttribute("home", Boolean.FALSE);
        model.addAttribute("shop", Boolean.TRUE); // Active Shop Nav Bar
        model.addAttribute("product", Boolean.FALSE);
        model.addAttribute("contact", Boolean.FALSE);
        model.addAttribute("pageTitle", "Shop");
        model.addAttribute("direction", "container/shop");
        return "index";
    }

    @GetMapping("/productDetail/{id}")
    public String productDetail (Model model, @PathVariable("id") Long productId){
        model.addAttribute("ProductById", productService.getProductById(productId));
        model.addAttribute("pageTitle", "Product Detail");
        model.addAttribute("direction", "container/productDetail");
        return "index";
    }

    @GetMapping(value = "/cart")
    public String cart(Model model) {
        model.addAttribute("pageTitle", "Cart");
        model.addAttribute("direction", "container/cart");
        return "index";
    }

    @GetMapping(value ="/checkout")
    public String checkOut(Model model) {
        model.addAttribute("pageTitle", "Check Out");
        model.addAttribute("direction", "container/checkout");
        return "index";
    }

    @GetMapping(value ="/contact")
    public String contact(Model model) {
        model.addAttribute("home", Boolean.FALSE);
        model.addAttribute("shop", Boolean.FALSE);
        model.addAttribute("product", Boolean.FALSE);
        model.addAttribute("contact", Boolean.TRUE); // Active Contact Nav Bar
        model.addAttribute("pageTitle", "Contact");
        model.addAttribute("direction", "container/contact");
        return "index";
    }

    @GetMapping(value = "/profile")
    public String profile(Model model, Principal principal) {
        String email = principal.getName();
        Customer customer = repository.findByEmail(email);
        model.addAttribute("customer", customer);
        model.addAttribute("pageTitle", "Profile");
        model.addAttribute("direction", "container/profile");
        return "index";
    }

    @GetMapping(value = "/purchase")
    public String purchase(Model model, HttpSession session) {
        session.setAttribute("order", orderService.findAll()) ;
        model.addAttribute("pageTitle", "Purchase");
        model.addAttribute("direction", "container/purchase");
        model.addAttribute("state", "To Receive");
        return "index";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "container/register";
    }

    @GetMapping(value = "/signing")
    public String login() {
        return "container/login";
    }

    @PostMapping(value = "create/cus")
    public String createCustomer(@ModelAttribute CustomerDTO newCustomer, Model model, HttpSession session) {

        boolean check = customerService.checkEmail(newCustomer.getEmail());

        if (check) {
            session.setAttribute("msg", "Email already exists");
        } else {
        CustomerDTO customerDTO = customerService.save(newCustomer);
        if (customerDTO != null) {
            session.setAttribute("msg", "Register successfully");
        } else {
            session.setAttribute("msg", "Something wrong on server");
        }
        }

        return "redirect:/register";

    }


    @PostMapping(value = "/customer-update/{id}")
    public String updateCus(@PathVariable Long id, @ModelAttribute("customer") CustomerDTO customer, Model model) {
        CustomerDTO customerDTO = customerService.findById(id);
        customerDTO.setId(id);
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setAddressId(customer.getAddressId());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());

        customerService.update(customerDTO);
//        service.update(customer);
        return "redirect:/profile";
    }

    @GetMapping("/showCategories")
    public String showAllCategories(Model model, HttpSession session) {
        session.setAttribute("category", categoryService.findAll()) ;
        model.addAttribute("pageTitle", "Home");
        model.addAttribute("direction", "container/home");
        return "index";
    }

    @GetMapping("/find-by-category/{id}")
    public String getProductByCate(Model model, @PathVariable("id") Long categoryId) {
        model.addAttribute("listProduct", productService.getProductByCategory(categoryId));
        System.out.println( productService.getProductByCategory(categoryId));
        model.addAttribute("pageTitle", "Category");
        model.addAttribute("direction", "container/productCategories");
        return "index";
    }


}
