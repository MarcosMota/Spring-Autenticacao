/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioti.com.autenticacaospring.security;

/**
 *
 * @author BioTI
 */
public interface ContextSecurity {
    String getUserLogado();
    boolean isCurrentAuthenticationAnonymous();
}
