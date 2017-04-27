/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioti.com.autenticacaospring.controller;

import bioti.com.autenticacaospring.model.seguranca.Perfil;
import bioti.com.autenticacaospring.model.sitemap.SiteMap;
import bioti.com.autenticacaospring.security.ContextSecurity;
import bioti.com.autenticacaospring.service.UserProfileService;
import bioti.com.autenticacaospring.service.UserService;
import bioti.com.autenticacaospring.templates.Layout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BioTI
 */
@Controller
public class DashboardController {

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    ContextSecurity userContext;
  
    
    @RequestMapping(value = {"/admin", "admin/dashboard"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/teste.html");
        return model;
    }
   
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView index2() {
        ModelAndView model = new ModelAndView("/teste.html");
        
        return model;
    }
    
    
}
