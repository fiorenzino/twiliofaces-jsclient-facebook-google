package org.twiliofaces.test.twiliojsclient.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.inject.configuration.TwilioCapabilityToken;
import org.twiliofaces.inject.configuration.TwilioNumber;

@SessionScoped
@Named
public class TwilioJsController implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Inject
   @TwilioCapabilityToken(client = "#{loginController.userRegistration.lastName}")
   String jsToken;

   @Inject
   @TwilioNumber
   String twilioNumber;

   public TwilioJsController()
   {
   }

   public String getJsToken()
   {
      return jsToken;
   }

   public String getTwilioNumber()
   {
      return twilioNumber;
   }

}