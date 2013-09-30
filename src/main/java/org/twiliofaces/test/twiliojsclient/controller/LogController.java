package org.twiliofaces.test.twiliojsclient.controller;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.cdi.event.TwimlEvent;
import org.twiliofaces.cdi.producer.util.TwilioRequestMap;
import org.twiliofaces.inject.notification.TwilioRequestParams;

@Named
@RequestScoped
public class LogController
{

   @Inject
   @TwilioRequestParams
   TwilioRequestMap twilioRequestMap;

   public void creditPayment(@Observes TwimlEvent event)
   {
      System.out.println(event.getTwimlFormatted());

   }

   public void log()
   {
      System.out.println(twilioRequestMap.toString());
   }
}
