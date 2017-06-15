/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import outils.Utilitaire;
import utils.Transaction;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        ClientBanqueRest client = new ClientBanqueRest();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Epulapp
 */
public class ClientBanqueRest {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/BanqueRest/webresources";

    public ClientBanqueRest() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public Response modifierCompte(Object requestEntity) throws ClientErrorException, Exception {
        Response response = webTarget.path("modifierCompte").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response;
    }

    public Boolean debiterCompte(Object transact) throws ClientErrorException, Exception {
        try {
            Response response = webTarget.path("debiterCompte").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(transact, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
                return jsonObject.getBoolean("isDebite");
                
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

   

    public  String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

   
    public void close() {
        client.close();
    }

    public <T> T getTest(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getTest");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        
    }
}
