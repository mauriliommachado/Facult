/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.control;

import br.com.forwardit.dao.GradeDAO;
import br.com.forwardit.model.Grade;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author mauri
 */
@Controller
@Transactional
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeDAO gradeDAO;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@Validated Grade grade, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return form(grade);
        }
        gradeDAO.save(grade);
        redirectAttributes.addFlashAttribute("sucesso",
                "Nota cadastrada com sucesso");
        return new ModelAndView("redirect:grades");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{gradeId}")
    public ModelAndView remove(@PathVariable("gradeId") Integer gradeId) {
        gradeDAO.remove(gradeId);
        return new ModelAndView("redirect:grades");
    }

    @RequestMapping("/form")
    public ModelAndView form(Grade grade) {
        ModelAndView modelAndView = new ModelAndView("grades/form");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("grades/list");
        modelAndView.addObject("grades", gradeDAO.list());
        return modelAndView;
    }
}
