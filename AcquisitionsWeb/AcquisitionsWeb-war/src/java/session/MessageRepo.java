/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Epulapp
 */
@Singleton
public class MessageRepo implements MessageRepoLocal {

    public ArrayList<Integer> lstMsg = new ArrayList<>();
    
    public ArrayList<Integer> getLstMessage()
    {
        return (ArrayList<Integer>) lstMsg.clone();
                
            
    }
}
