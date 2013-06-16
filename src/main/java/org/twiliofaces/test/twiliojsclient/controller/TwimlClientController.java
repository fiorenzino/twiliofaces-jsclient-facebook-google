package org.twiliofaces.test.twiliojsclient.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.annotations.configuration.TwilioNumber;
import org.twiliofaces.annotations.notification.PhoneNumber;

@Named
@RequestScoped
public class TwimlClientController
{

   @Inject
   @TwilioNumber
   String twilioNumber;

   @Inject
   @PhoneNumber
   String phoneNumber;

   public String getTwilioNumber()
   {
      return twilioNumber;
   }

   public boolean isClient()
   {
      return isNumeric(phoneNumber);
   }

   public static boolean isNumeric(String str)
   {
      return str.matches("[+-]?\\d*(\\.\\d+)?");
   }

}
