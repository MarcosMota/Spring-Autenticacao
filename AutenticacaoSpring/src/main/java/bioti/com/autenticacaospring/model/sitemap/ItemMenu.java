/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioti.com.autenticacaospring.model.sitemap;

import java.util.List;

/**
 *
 * @author BioTI
 */
public class ItemMenu {

    private String texto;
    private String url;

    private List<String> perfils;

    public List<String> getPerfils() {
        return perfils;
    }

    public void setPerfils(List<String> perfils) {
        this.perfils = perfils;
    }
    
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
