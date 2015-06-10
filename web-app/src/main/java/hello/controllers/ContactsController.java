package hello.controllers;

import hello.models.ResponseDataModel;
import hello.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by silvian on 21/12/14.
 */

@Controller
public class ContactsController {

    @Autowired
    EmailService emailService;


    @RequestMapping(value = "contacts")
    public String displayContacts(ModelMap modelMap) {

        return "contacts";
    }

    @RequestMapping(value = "contacts-form-submit",
                    method = RequestMethod.GET)
    public ModelAndView processContactsForm(@RequestParam(value="contacts-name") String name,
                                      @RequestParam(value="contacts-email") String email,
                                      @RequestParam(value="contacts-subject") String subject,
                                      @RequestParam(value="contacts-message") String message,
                                      ModelMap modelMap) {


        ResponseDataModel responseDataModel;
        responseDataModel = emailService.sendEmail(name, email, subject, message);
        modelMap.addAttribute("isSuccessful", responseDataModel.isSuccessful());
        modelMap.addAttribute("response", responseDataModel.getResponseMessage());

        return new ModelAndView("contacts", modelMap);
    }




}
