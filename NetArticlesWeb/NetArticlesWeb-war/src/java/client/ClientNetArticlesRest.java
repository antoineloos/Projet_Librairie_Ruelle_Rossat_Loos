/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dal.Achete;
import dal.Article;
import dal.Categorie;
import dal.Domaine;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import outils.Utilitaire;

/**
 * Jersey REST client generated for REST resource:WebServiceResource
 * [webService]<br>
 * USAGE:
 * <pre>
 *        ClientNetArticlesRest client = new ClientNetArticlesRest();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Epulapp
 */
public class ClientNetArticlesRest {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/NetArticlesRest/webresources";

    public ClientNetArticlesRest() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("webServices");
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8"));
    }

    public <T> T getUtilisateur(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUtilisateur/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get(responseType);
    }

    public <T> T getArticle(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getArticles/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get(responseType);
    }

    public <T> T getConnexion(Class<T> responseType, String login) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getConnexion/{0}", new Object[]{login}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get(responseType);
    }

    public <T> T getCategorie(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategorie/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get(responseType);
    }

    public List<Client> getUtilisateurs() throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path("getUtilisateurs");
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get();

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response.readEntity(new GenericType<List<Client>>() {
        });
    }

    public List<Article> getArticles() throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path("getArticles");
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response.readEntity(new GenericType<List<Article>>() {
        });
    }

    public List<Achete> getAchete(int id) throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAchetes/{0}", new Object[]{id}));
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response.readEntity(new GenericType<List<Achete>>() {
        });
    }

    public List<Article> getArticlesByDomaine(Object requestEntity) throws ClientErrorException, Exception {
        Response response = webTarget.path("getArticlesByDomaine").request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8"), Response.class);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response.readEntity(new GenericType<List<Article>>() {
        });
    }

    public <T> T getDomaine(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getDomaine/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get(responseType);
    }

    public List<Categorie> getCategories() throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path("getCategories");
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response.readEntity(new GenericType<List<Categorie>>() {
        });
    }

    public List<Domaine> getDomaines() throws ClientErrorException, Exception {
        WebTarget resource = webTarget;
        resource = resource.path("getDomaines");
        Response response = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get();
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response.readEntity(new GenericType<List<Domaine>>() {
        });
    }

    public Response ajouterUser(Object requestEntity) throws ClientErrorException, Exception {
        Response response = webTarget.path("ajouterClient").request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response;
    }

    public Response supprimerUser(Object requestEntity) throws ClientErrorException, Exception {
        Response response = webTarget.path("supprimerClient").request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response;
    }

    public String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8").get(String.class);
    }

    public Response modifierUser(Object requestEntity) throws ClientErrorException, Exception {
        Response response = webTarget.path("modifierClient").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response;
    }

    public void close() {
        client.close();
    }

    public Response ajouterAchat(Object requestEntity) throws Exception {
        Response response = webTarget.path("ajouterAchat").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response;
//        try {
//            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
//                JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
//                String message = jsonObject.getString("message");
//                throw new Exception(message);
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//        return response;
    }

    public Response ajouterAchete(Object requestEntity) throws ClientErrorException, Exception {
        Response response = webTarget.path("ajouterAchete").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            JsonObject jsonObject = Utilitaire.convertJson(response.readEntity(String.class));
            String message = jsonObject.getString("message");
            throw new Exception(message);
        }
        return response;
    }

}
