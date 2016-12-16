/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.control;

import br.com.forwardit.dao.PersonDAO;
import br.com.forwardit.model.Person;
import br.com.forwardit.model.PersonType;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author mauri
 */
@Controller
@Transactional
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    private PersonDAO personDao;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@Validated Person person, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return form(person);
        }
        personDao.save(person);
        redirectAttributes.addFlashAttribute("sucesso",
                "Pessoa cadastrada com sucesso");
        return new ModelAndView("redirect:persons");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{personId}")
    public ModelAndView remove(@PathVariable("personId") Integer personId) {
        personDao.remove(personId);
        return list();
    }

    @RequestMapping("/form")
    public ModelAndView form(Person person) {
        ModelAndView modelAndView = new ModelAndView("persons/form");
        modelAndView.addObject("person", person);
        return modelAndView;
    }
    
    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam("id") Integer personId) {
        return form(personDao.find(personId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("persons/list");
        modelAndView.addObject("persons", personDao.list());
        modelAndView.addObject("types",PersonType.values());
        return modelAndView;
    }
}
