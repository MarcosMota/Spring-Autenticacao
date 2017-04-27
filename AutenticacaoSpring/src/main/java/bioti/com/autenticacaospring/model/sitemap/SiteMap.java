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
public class SiteMap {
    private String icone;
    private String texto;
    private String url;    
    private List<ItemMenu> itens;
    private String perfils;

    public String getPerfils() {
        return perfils;
    }

    public void setPerfils(String perfils) {
        this.perfils = perfils;
    }

   
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<ItemMenu> getItens() {
        return itens;
    }

    public void setItens(List<ItemMenu> itens) {
        this.itens = itens;
    }
    
    
}
