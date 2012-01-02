/**
 * 
 */
package com.jsfbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.render.ResponseStateManager;

/**
 * @author beheraab
 *
 */
@ManagedBean( name = "userController" )
@RequestScoped
public class UserController {
	private String username;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	public UserController() {
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	@PostConstruct
	public void init (){
		System.out.println("UserController.init()");
		this.setUsername("abani");
	}
	
	public boolean isPostBack(){
		ResponseStateManager rsm = FacesContext.getCurrentInstance().getRenderKit().getResponseStateManager();
		return rsm.isPostback(FacesContext.getCurrentInstance()); 
	}
	
	public String nextPage(){
		System.out.println("UserController.nextPage() " + isPostBack() );
		return "second";
	}
}
