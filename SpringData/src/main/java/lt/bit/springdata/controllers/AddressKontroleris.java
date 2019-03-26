/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.springdata.controllers;

import lt.bit.springdata.dao.AddressDAO;
import lt.bit.springdata.dao.PersonDAO;
import lt.bit.springdata.db.Addresses;
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
@RequestMapping("/address")
public class AddressKontroleris {

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private AddressDAO addressDAO;

    @GetMapping
    public ModelAndView addressIndex(@RequestParam("id") Integer id) throws Exception {

        ModelAndView mav = new ModelAndView("address");
        Persons p = personDAO.getOne(id);

        mav.addObject("address", p.getAddressesList());

        return mav;
    }

    @GetMapping("deleteAddress")
    @Transactional
    public String deleteAddress(@RequestParam("id") Integer id) throws Exception {

        Integer personId = null;

        Addresses a = addressDAO.getOne(id);
        personId = a.getPersonId().getId();
        addressDAO.delete(a);

        if (personId != null) {
            return "redirect:/address?id=" + personId;
        } else {
            return "redirect:/persons";
        }
    }

    @GetMapping("editAddress")
    public ModelAndView editAddress(@RequestParam(name = "id", required = false) Integer id) throws Exception {

        ModelAndView mav = new ModelAndView("editAddress");

        if (id != null) {
            mav.addObject("address", addressDAO.getOne(id));
        }

        return mav;

    }

    @PostMapping("editAddress")
    @Transactional
    public String saveAddress(@RequestParam("id") Integer id,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            //@RequestParam("personId") Integer personId,
            @RequestParam("postalCode") String postalCode) throws Exception {

        Persons p = null;

        Integer personId = null;

        Addresses a = null;

        try {
            a = addressDAO.getOne(id);
            personId = a.getPersonId().getId();
        } catch (Exception ex) {
        }

        if (a == null) {
            a = new Addresses();
        }
        if (p == null) {
            p = a.getPersonId();
        }
        a.setAddresses(address);
        a.setCity(city);
        a.setPostalCode(postalCode);
        if (id == null) {

            a.setPersonId(p);
            addressDAO.save(a);
        }

        if (personId != null) {
            return "redirect:/address?id=" + personId;
        } else {
            return "redirect:/persons";
        }
    }
}
