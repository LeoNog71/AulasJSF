package com.projeto.projetousuario.Web;

import Repository.UsuarioDAOHibernate;
import com.projeto.projetousuario.Model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	private String nome;
	private String email;
	private String senha;
	private String confirmaSenha;
        private Usuario usuario;
	
	public String novo() { //(_1_)
		return "usuario";
	}
	public String salvar() { //(_2_)
		FacesContext context = FacesContext.getCurrentInstance(); 
                
		if (!this.senha.equalsIgnoreCase(this.confirmaSenha)) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
				"Senha confirmada incorretamente",""));
			return "usuario"; //(_3_)
		}
		
                usuario = new Usuario();
                usuario.setNome(this.nome);
                usuario.setEmail(this.email);
                usuario.setSenha(this.senha);
                
                new UsuarioDAOHibernate().salvar(this.usuario);
                
		return "mostrausuario"; //(_4_)
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
}
