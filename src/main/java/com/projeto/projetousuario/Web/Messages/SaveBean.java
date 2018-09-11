/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.projetousuario.Web.Messages;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.PrimeFaces;
 
@ManagedBean(name = "SaveBean")
public class SaveBean {
         
    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SALVO", "COM SUCESSO!");
         
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
}