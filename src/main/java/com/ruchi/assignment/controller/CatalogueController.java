package com.ruchi.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ruchi.assignment.domain.Catalogue;
import com.ruchi.assignment.service.CatalogueService;


@Controller
public class CatalogueController {
	
	@Autowired
	private CatalogueService service;
	
	@GetMapping("/")
    public String viewHomePage(Model model) {
        List<Catalogue> listcatalogue = service.listAll();
        model.addAttribute("listcatalogue", listcatalogue);
        System.out.print("Get / "); 
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("catalogue", new Catalogue());
        return "new";
    }
    
    @GetMapping("/find")
    public String find(Model model) {
        model.addAttribute("catalogue", new Catalogue());
        return "find";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("catalogue") Catalogue std) {
        service.save(std);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCataloguePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Catalogue std = service.get(id);
        mav.addObject("catalogue", std);
        return mav;
        
    }
    
    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView findStu(@ModelAttribute("SKU_dis") String product) {
   	 ModelAndView mav = new ModelAndView("detail");
        List<Catalogue> listcatalogue = service.findByText(product);
        mav.addObject("listcatalogue", listcatalogue);
        return mav;
    }
    
    
    
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
	
}

