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
@RequestMapping("/contact")
public class ContactKontroleris {

    @GetMapping
    public ModelAndView contactIndex(@RequestParam("id") Integer id) throws Exception {

        ModelAndView mav = new ModelAndView("contact");
        EntityManager em = EMF.getEntityManager();

        if (id != null) {
            Integer personId = em.find(Person.class, id).getId();

            Query q = em.createQuery("SELECT c FROM Contact c WHERE c.person.id = :personId");
            q.setParameter("personId", personId);
            try {
                EntityTransaction tx = EMF.getTransaction(em);

                List<Contact> cl = q.getResultList();

                if (cl == null) {
                    cl = new ArrayList<>();
                }
                mav.addObject("contact", cl);
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

    @GetMapping("deleteContact")
    public String deleteContact(@RequestParam("id") Integer id) throws Exception {
        EntityManager em = EMF.getEntityManager();
        Integer personId = null;
        try {
            EntityTransaction tx = EMF.getTransaction(em);
            Contact c = em.find(Contact.class, id);
            personId = c.getPerson().getId();
            em.remove(c);

            EMF.commitTransaction(tx);
        } catch (Exception ex) {
            throw ex;
        } finally {
            EMF.returnEntityManager(em);
        }
        if (personId != null) {
            return "redirect:/contact?id=" + personId;
        } else {
            return "redirect:/persons";
        }
    }

    @GetMapping("editContact")
    public ModelAndView editContact(@RequestParam(name = "id", required = false) Integer id,
                                    @RequestParam(name = "personId", required = false) Integer personId) throws Exception {

        ModelAndView mav = new ModelAndView("editContact");

        EntityManager em = EMF.getEntityManager();
        if (id != null) {
            Contact c = em.find(Contact.class, id);
            mav.addObject("contact", c);
            mav.addObject("persons", c.getPerson());
        } else{
            Person p = em.find(Person.class, personId);
            mav.addObject("persons", p);
        }

        EMF.returnEntityManager(em);
        return mav;

    }

    @PostMapping("editContact")
    public String saveContact(@RequestParam("id") Integer id,
            @RequestParam("personId") Integer personId,
            @RequestParam("type") String type,
            @RequestParam("contact") String contact) throws Exception {

        EntityManager em = EMF.getEntityManager();
        Person p = null;

        try {

            Contact c = null;

            try {
                c = em.find(Contact.class, id);
                personId = c.getPerson().getId();
            } catch (Exception ex) {
            }

            if (id != null) {
                
                EntityTransaction tx = EMF.getTransaction(em);
                c.setType(type);
                c.setContact(contact);
                
                EMF.commitTransaction(tx);

            } else {
                EntityTransaction tx = EMF.getTransaction(em);

                c = new Contact(type, contact);
                p = em.find(Person.class, personId);
                c.setPerson(p);
                em.persist(c);
                EMF.commitTransaction(tx);
            }

        } catch (Exception ex) {

        } finally {
            EMF.returnEntityManager(em);
        }
        if (personId != null) {
            return "redirect:/contact?id=" + personId;
        } else {
            return "redirect:/persons";
        }
    }
}
