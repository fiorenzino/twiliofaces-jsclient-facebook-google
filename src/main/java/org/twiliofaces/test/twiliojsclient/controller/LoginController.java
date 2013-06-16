package org.twiliofaces.test.twiliojsclient.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.picketlink.social.reg.UserRegistration;

@Named
@SessionScoped
public class LoginController implements Serializable
{

   private static final long serialVersionUID = 1L;

   private UserRegistration userRegistration;

   public LoginController()
   {
      System.out.println(System.currentTimeMillis());
   }

   public String logout()
   {
      ExternalContext extCtx = FacesContext.getCurrentInstance()
               .getExternalContext();
      try
      {
         extCtx.redirect(extCtx.encodeActionURL("/logout.jsp"));
      }
      catch (Exception e)
      {

      }
      return null;
   }

   public UserRegistration getUserRegistration()
   {
      if (userRegistration == null)
      {
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
         this.userRegistration = (UserRegistration) session.getAttribute("user");
         System.out.println("WHO AM I? " + userRegistration.getFirstName() + " " + userRegistration.getLastName());
         if (this.userRegistration.getFullName() == null || this.userRegistration.getFullName().isEmpty())
         {
            System.out.println("init full name!!");
            this.userRegistration.setFullName(this.userRegistration.getFirstName() + " "
                     + userRegistration.getLastName());
         }
      }
      return userRegistration;
   }

   public void setUserRegistration(UserRegistration userRegistration)
   {
      this.userRegistration = userRegistration;
   }

}
