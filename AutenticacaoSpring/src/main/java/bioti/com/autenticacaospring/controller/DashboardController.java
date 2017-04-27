/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioti.com.autenticacaospring.controller;

import bioti.com.autenticacaospring.model.Perfil;
import bioti.com.autenticacaospring.security.ContextSecurity;
import bioti.com.autenticacaospring.service.UserProfileService;
import bioti.com.autenticacaospring.service.UserService;
import bioti.com.autenticacaospring.templates.Layout;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BioTI
 */
@Controller
 //@Layout(value = "/layout/admin_layout.html")
public class DashboardController {

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    ContextSecurity userContext;
   
    
    @RequestMapping(value = {"/", "/dashboard"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        if (userContext != null) {
            model.addAttribute("user_logado", userContext.getUserLogado());
        }

        return "dashboard";
    }
   
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView index2() {
        ModelAndView model = new ModelAndView("/teste.html");
        
        return model;
    }
    @ModelAttribute("roles")
    public List<Perfil> initializeProfiles() {
        return userProfileService.findAll();
    }
}
