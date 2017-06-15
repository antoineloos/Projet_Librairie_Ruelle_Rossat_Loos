/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import session.*;
import dal.*;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import outils.Utilitaire;

/**
 * REST Web Service
 *
 * @author Epulapp
 */
@Path("webServices")
public class WebServicesResource {

    @Context
    private UriInfo context;

    @EJB
    AcheteFacade acheteF;
    @EJB
    ArticleFacade articleF;
    @EJB
    AuteurFacade auteurf;
    @EJB
    CategorieFacade categorieF;
    @EJB
    ClesFacade clesF;
    @EJB
    ClientFacade clientF;
    @EJB
    DomaineFacade domaineF;
    @EJB
    DroitsFacade droitsF;
    @EJB
    RedigeFacade redigeF;

    /**
     * Creates a new instance of WebServiceResource
     */
    public WebServicesResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.WebServiceResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of WebServiceResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public void putJson(String content) {
    }

    @GET
    @Path("getConnexion/{login}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getConnexion(@PathParam("login") String login) throws Exception {
        Response response = null;
        try {
            Client user = clientF.lireLogin(login);
            response = Response.status(Response.Status.OK).entity(user).build();
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @GET
    @Path("getConnexionAuteur/{login}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getConnexionAuteur(@PathParam("login") String login) throws Exception {
        Response response = null;
        try {
            Auteur user = auteurf.lireLogin(login);
            response = Response.status(Response.Status.OK).entity(user).build();
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @GET
    @Path("getUtilisateurs")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getUtilisateurs() throws Exception {
        Response response = null;
        try {
            List<Client> lstClient = clientF.findAll();
            GenericEntity<List<Client>> lClient = new GenericEntity<List<Client>>(lstClient) {
            };
            response = Response.status(Response.Status.OK).entity(lClient).build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @GET
    @Path("getAuteurs")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getAuteurs() throws Exception {
        Response response = null;
        try {
            List<Auteur> lstClient = auteurf.findAll();
            GenericEntity<List<Auteur>> lClient = new GenericEntity<List<Auteur>>(lstClient) {
            };
            response = Response.status(Response.Status.OK).entity(lClient).build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }
    
    @GET
    @Path("getArticles")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getArticles() throws Exception {
        Response response = null;
        try {
            List<Article> lstArticles = articleF.findAll();
            GenericEntity<List<Article>> lArticles = new GenericEntity<List<Article>>(lstArticles) {
            };
            response = Response.status(Response.Status.OK).entity(lArticles).build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @GET
    @Path("getCategories")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getCategories() throws Exception {
        Response response = null;
        try {
            List<Categorie> lCategories = categorieF.findAll();
            GenericEntity<List<Categorie>> lCategorie = new GenericEntity<List<Categorie>>(lCategories) {
            };
            response = Response.status(Response.Status.OK).entity(lCategorie).build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @GET
    @Path("getDomaines")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getDomaines() throws Exception {
        Response response = null;
        try {
            List<Domaine> lDomaines = domaineF.findAll();
            GenericEntity<List<Domaine>> lDomaine = new GenericEntity<List<Domaine>>(lDomaines) {
            };
            response = Response.status(Response.Status.OK).entity(lDomaine).build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @GET
    @Path("getAchetes/{idCustomer}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getAchetes(@PathParam("idCustomer") Integer id) throws Exception {
        Response response = null;
        try {
            List<Achete> lstAchetes = acheteF.getAcheteByCustomer(id);
            GenericEntity<List<Achete>> lAchetes = new GenericEntity<List<Achete>>(lstAchetes) {
            };
            response = Response.status(Response.Status.OK).entity(lAchetes).build();
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", msg).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @GET
    @Path("getDomaine/{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Domaine getDomaine(@PathParam("id") Integer id) throws Exception {
        return domaineF.find(id);
    }

    @POST
    @Path("getArticlesByDomaine")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getArticlesByDomaine(Domaine domaine) throws Exception {
        Response response = null;
        try {
            if (domaine != null) {

                List<Article> lstArticles = articleF.listeByDomaine(domaine);
                GenericEntity<List<Article>> lArticles = new GenericEntity<List<Article>>(lstArticles) {
                };
                response = Response.status(Response.Status.OK).entity(lArticles).build();
            }
        } catch (Exception ex) {
            String msg = Utilitaire.getExceptionCause(ex);
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @GET
    @Path("getArticles/{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Article getArticles(@PathParam("id") Integer id) throws Exception {
        return articleF.find(id);
    }

    @GET
    @Path("getUtilisateur/{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Client getUtilisateur(@PathParam("id") Integer id) throws Exception {
        return clientF.lire(id);
    }

    @GET
    @Path("getAuteur/{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Auteur getAuteur(@PathParam("id") Integer id) throws Exception {
        return auteurf.lire(id);
    }
    
    @GET
    @Path("getCategorie/{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Categorie getCategorie(@PathParam("id") Integer id) throws Exception {
        return categorieF.find(id);

    }

    @POST
    @Path("modifierArticle")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response modifierArticle(Article article) throws Exception {
        Response response = null;
        try {
            if (article != null) {

                articleF.edit(article);
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @POST
    @Path("modifierClient")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response modifierClient(Client client) throws Exception {
        Response response = null;
        try {
            if (client != null) {

                clientF.edit(client);
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }
    
    @POST
    @Path("modifierAuteur")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response modifierClient(Auteur auteur) throws Exception {
        Response response = null;
        try {
            if (auteur != null) {

                auteurf.edit(auteur);
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @POST
    @Path("modifierCategorie")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response modifierClient(Categorie categorie) throws Exception {
        Response response = null;
        try {
            if (categorie != null) {

                categorieF.edit(categorie);
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @POST
    @Path("ajouterClient")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response ajouterClient(Client client) throws Exception {
        Response response = null;
        try {
            if (client != null) {

                clientF.create(client);
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }
    
    @POST
    @Path("ajouterAuteur")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response ajouterAuteur(Auteur auteur) throws Exception {
        Response response = null;
        try {
            if (auteur != null) {

                auteurf.create(auteur);
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @POST
    @Path("ajouterArticles")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response ajouterArticles(Article article) throws Exception {
        Response response = null;
        try {
            if (article != null) {

                articleF.create(article);
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @POST
    @Path("ajouterCategorie")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response ajouterCategorie(Categorie categorie) throws Exception {
        Response response = null;
        try {
            if (categorie != null) {

                categorieF.create(categorie);
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @POST
    @Path("ajouterAchat")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ajouterAchat(Achete achete) throws Exception {
        Response response = null;
        try {
            if (achete != null) {
                acheteF.create(achete);
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

    @POST
    @Path("ajouterAchete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ajouterAchete(Achete achete) throws Exception {
        Response response = null;
        try {
            if (achete != null) {
                acheteF.ajouterAchat(achete);
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            JsonObject retour = Json.createObjectBuilder().add("message", Utilitaire.getExceptionCause(ex)).build();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(retour).build();
        }
        return response;
    }

}
