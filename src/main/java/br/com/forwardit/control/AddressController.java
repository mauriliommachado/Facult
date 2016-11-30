/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.control;

import br.com.forwardit.dao.AddressDAO;
import br.com.forwardit.model.Address;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author mauri
 */
@Controller
@Transactional
@RequestMapping("/persons")
public class AddressController {
    @Autowired
    private AddressDAO addressDAO;
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("summary") MultipartFile summary, 
            @Validated Address address, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return form(address);
        }
        addressDAO.save(address);
        redirectAttributes.addFlashAttribute("sucesso",
                "Endereço cadastrado com sucesso");
        return new ModelAndView("redirect:persons");
    }
    
    @RequestMapping("/form")
    public ModelAndView form(Address address) {
        ModelAndView modelAndView = new ModelAndView("persons/form");
        return modelAndView;
    }
}
