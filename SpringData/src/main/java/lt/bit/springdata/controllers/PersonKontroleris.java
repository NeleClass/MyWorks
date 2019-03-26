/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.springdata.controllers;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import lt.bit.springdata.dao.PersonDAO;
import lt.bit.springdata.db.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NeleN
 */
@Controller
@RequestMapping("/persons")
public class PersonKontroleris {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping
    public ModelAndView index() {

        ModelAndView mav = new ModelAndView("persons");

        mav.addObject("persons", personDAO.findAll());

        return mav;
    }

    @GetMapping("delete")
    @Transactional
    public String deletePerson(@RequestParam("id") Integer id) throws Exception {

        personDAO.deleteById(id);
        return "redirect:/persons";

    }

    @GetMapping("edit")
    public ModelAndView editPerson(@RequestParam(name = "id", required = false) Integer id) throws Exception {

        ModelAndView mav = new ModelAndView("edit");
        if (id != null) {
            mav.addObject("persons", personDAO.getOne(id));
        }
        return mav;

    }

    @PostMapping("edit")
    @Transactional
    public String savePerson(@RequestParam("id") Integer id,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("birthDate") String birthDateString,
            @RequestParam("salary") BigDecimal salary,
            @RequestParam("company") String company) throws Exception {

        Persons p = null;

        Date birthDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        birthDate = sdf.parse(birthDateString);

        if (id != null) {

            p = personDAO.getOne(id);

            p.setFirstName(firstName);
            p.setLastName(lastName);
            p.setBirthDate(birthDate);
            p.setSalary(salary);
            p.setCompany(company);

        } else {

            p = new Persons();

            p.setFirstName(firstName);
            p.setLastName(lastName);
            p.setBirthDate(birthDate);
            p.setSalary(salary);
            p.setCompany(company);

            personDAO.save(p);

        }

        return "redirect:/persons";
    }
}
