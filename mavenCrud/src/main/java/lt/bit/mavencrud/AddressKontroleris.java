/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.mavencrud;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author macbookair
 */
@Controller
@RequestMapping("/address")
public class AddressKontroleris {

    @GetMapping
    public ModelAndView addressIndex(@RequestParam("id") Integer id) throws Exception {

        ModelAndView mav = new ModelAndView("address");
        EntityManager em = EMF.getEntityManager();

        if (id != null) {
            Integer personId = em.find(Person.class, id).getId();

            Query q = em.createQuery("SELECT a FROM Address a WHERE a.person.id = :personId");
            q.setParameter("personId", personId);
            try {
                EntityTransaction tx = EMF.getTransaction(em);

                List<Address> al = q.getResultList();

                if (al == null) {
                    al = new ArrayList<>();
                }
                mav.addObject("address", al);
                mav.addObject("persons", em.find(Person.class, id));
                EMF.commitTransaction(tx);
            } catch (Exception ex) {
                throw ex;
            } finally {
                EMF.returnEntityManager(em);
            }
        }
        return mav;
    }

    @GetMapping("deleteAddress")
    public String deleteAddress(@RequestParam("id") Integer id) throws Exception {
        EntityManager em = EMF.getEntityManager();
        Integer personId = null;
        try {
            EntityTransaction tx = EMF.getTransaction(em);
            Address a = em.find(Address.class, id);
            personId = a.getPerson().getId();
            em.remove(a);

            EMF.commitTransaction(tx);
        } catch (Exception ex) {
            throw ex;
        } finally {
            EMF.returnEntityManager(em);
        }
        if (personId != null) {
            return "redirect:/address?id=" + personId;
        } else {
            return "redirect:/persons";
        }
    }

    @GetMapping("editAddress")
    public ModelAndView editAddress(@RequestParam(name = "id", required = false) Integer id,
                                    @RequestParam(name = "personId", required = false) Integer personId) throws Exception {

        ModelAndView mav = new ModelAndView("editAddress");

        EntityManager em = EMF.getEntityManager();
        if (id != null) {
            Address a = em.find(Address.class, id);
            mav.addObject("address", a);
            mav.addObject("persons", a.getPerson());
        } else {
            Person p = em.find(Person.class, personId);
            mav.addObject("persons", p);
        }

        EMF.returnEntityManager(em);
        return mav;

    }

    @PostMapping("editAddress")
    public String saveAddress(@RequestParam("id") Integer id,
            @RequestParam("personId") Integer personId,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("postalCode") String postalCode) throws Exception {

        EntityManager em = EMF.getEntityManager();
        Person p = null;

        try {

            Address a = null;

            try {
                a = em.find(Address.class, id);
                personId = a.getPerson().getId();

            } catch (Exception ex) {
            }

            if (id != null) {

                EntityTransaction tx = EMF.getTransaction(em);
                a.setAddress(address);
                a.setCity(city);
                a.setPostalCode(postalCode);

                EMF.commitTransaction(tx);

            } else {
                EntityTransaction tx = EMF.getTransaction(em);

                a = new Address(address, city, postalCode);
                p = em.find(Person.class, personId);
                a.setPerson(p);
                em.persist(a);
                EMF.commitTransaction(tx);
            }

        } catch (Exception ex) {

        } finally {
            EMF.returnEntityManager(em);
        }
        if (personId != null) {
            return "redirect:/address?id=" + personId;
        } else {
            return "redirect:/persons";
        }
    }
}
