/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioti.com.autenticacaospring.security;

import bioti.com.autenticacaospring.dao.AbstractDao;
import bioti.com.autenticacaospring.dao.UserProfileDao;
import bioti.com.autenticacaospring.model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BioTI
 */
@Service("userContext")
@Transactional

public class UserContext implements ContextSecurity {

//    @Autowired
//    AuthenticationTrustResolver authenticationTrustResolver;

    @Override
    public String getUserLogado() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @Override
    public boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //return authenticationTrustResolver.isAnonymous(authentication);
        return true;
    }

}
