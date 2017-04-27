/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioti.com.autenticacaospring.controller;

import bioti.com.autenticacaospring.security.ContextSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author BioTI
 */
@Controller

public class ConfiguracaoController {

    @Autowired
    ContextSecurity userContext;

    @RequestMapping(value = {"/configuracao"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        if (userContext != null) {
            model.addAttribute("user_logado", userContext.getUserLogado());
        }
        return "configuracao";
    }
}
