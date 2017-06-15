/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckconso;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Epulapp
 */
@MessageDriven(mappedName= "jms/Articles",activationConfig = {
    
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "MdbArticles"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "MdbArticles")
})
public class MdbArticles implements MessageListener {
    static final Logger logger = Logger.getLogger("Articles");

    @Resource
    private MessageDrivenContext mdc;
    
    public MdbArticles() {
        try {
            FileHandler fh = new FileHandler("Articles.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException | SecurityException ex) {
        }
    }
    
    @Override
    public void onMessage(Message message) {
        MapMessage mapMessage = null;
        String msg;
        try {
            if (message instanceof MapMessage) {
                mapMessage = (MapMessage) message;
                
                msg = "titre : "+mapMessage.getString("id") +"\n";
                msg += "id : "+mapMessage.getString("titre")+"\n";
                
                logger.log(Level.INFO, "{0}", msg);
                
            }
        } catch (Exception e) {
            mdc.setRollbackOnly();
            logger.log(Level.INFO, "Erreur sur réception message : {0}", e.getMessage());
        }
    }
    
}
