/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import dal.Article;
import dal.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import outils.Utilitaire;
import session.ArticleFacade;
import session.CategorieFacade;
import session.ClientFacade;

/**
 *
 * @author Epulapp
 */
public class slCompte extends HttpServlet {

    @EJB
    private ClientFacade clientF;
    @EJB
    private CategorieFacade categorieF;
    private String erreur;
    @EJB
    private ArticleFacade articleF;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String demande;
        String vueReponse = "/index.jsp";
        erreur = "";
        try {
            demande = getDemande(request);
            if (demande.equalsIgnoreCase("login.cpt")) {
                vueReponse = login(request);
            } else if (demande.equalsIgnoreCase("connecter.cpt")) {
                vueReponse = connecter(request);
            } else if (demande.equalsIgnoreCase("deconnecter.cpt")) {
                vueReponse = deconnecter(request);
            } else if (demande.equalsIgnoreCase("voirCompte.cpt")) {
                vueReponse = voirCompte(request);
            } else if (demande.equalsIgnoreCase("validerCompte.cpt")) {
                vueReponse = validerCompte(request);
            } else if (demande.equalsIgnoreCase("creerCompte.cpt")) {
                vueReponse = creerCompte(request);
            }

        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            request.setAttribute("erreurR", erreur);
            request.setAttribute("pageR", vueReponse);
            RequestDispatcher dsp = request.getRequestDispatcher("/index.jsp");
            if (vueReponse.contains(".cpt")) {
                dsp = request.getRequestDispatcher(vueReponse);
            }
            dsp.forward(request, response);
        }
    }

    /**
     * Extrait le texte de la demande de l'URL
     *
     * @param request
     * @return String texte de la demande
     */
    private String getDemande(HttpServletRequest request) {
        String demande = "";
        demande = request.getRequestURI();
        demande = demande.substring(demande.lastIndexOf("/") + 1);
        return demande;
    }

    /**
     * Afficher la page de login
     *
     * @param request
     * @return
     * @throws Exception
     */
    private String login(HttpServletRequest request) throws Exception {
        try {
            return ("/login.jsp");
        } catch (Exception e) {
            throw e;
        }
    }

    private String deconnecter(HttpServletRequest request) throws Exception {
        try {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", null);

            Article art = articleF.lire(articleF.lister().size());
            request.setAttribute("articleR", art);

            return ("detailArticle.jsp");
        } catch (Exception e) {
            throw e;
        }
    }

    private String connecter(HttpServletRequest request) throws Exception {
        String login, pwd;
        String vueReponse = "/login.jsp";
        erreur = "";
        try {
            login = request.getParameter("txtLogin");
            pwd = request.getParameter("txtPwd");

            if (clientF.connecter(login, pwd)) {
                Client client = clientF.getClient();
                vueReponse = "/listeArticles.jsp";
                HttpSession session = request.getSession(true);
                ArrayList<Article> lstArticle = (ArrayList<Article>) articleF.lister();
                request.setAttribute("lArticlesR", lstArticle);
                session.setAttribute("userId", client.getIdClient());
                // session.setAttribute("panier", new ArrayList<Article>());
            } else {
                erreur = "Login ou mot de passe inconnus !";
            }
        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            return (vueReponse);
        }
    }

    private String voirCompte(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(true);
        int id = (int) session.getAttribute("userId");
        Client client = clientF.lire(id);
        request.setAttribute("clientR", client);
        request.setAttribute("listeCategoriesR", categorieF.lister());
        return "client.jsp";
    }

    private String validerCompte(HttpServletRequest request) throws Exception {
        String vueReponse;
        int id_client = 0;
        try {

            String id = request.getParameter("id_client");
            Client client = new Client();
            String titre = null;
            // Si on est en Modification ou Ajout            
            if (!id.equals("")) {
                id_client = Integer.parseInt(id);
                // Affecter l'Id de l'utilisateur à Modifier
                client.setIdClient(id_client);
                titre = "Modifier un profil";
            }
            // Peupler les propriétés de Utilisateur 

            client.setLoginClient(request.getParameter("txtLogin"));
            client.setPwdClient(request.getParameter("txtPwd"));
            client.setIdentiteClient(request.getParameter("txtIdentite"));
            client.setAdresseClient(request.getParameter("txtAdresse"));
            client.setCredits(Integer.parseInt(request.getParameter("txtCredits")));
            // Instancier l'objet Categorie de la classe Utilisateur
            client.setIdCategorie(categorieF.lire(Integer.parseInt(request.getParameter("cbCategories"))));

// Il faut conserver les valeurs pour pouvoir
            // les réafficher en cas d'erreur
            request.setAttribute("titre", titre);
            request.setAttribute("clientR", client);
            // Si on a un id c'est qu'il s'agit d'une modification
            if (id_client > 0) {
                clientF.modifier(client);
            } else {

                clientF.ajouter(client);
            }
            vueReponse = "/listeArticles.jsp";
            return (vueReponse);
        } catch (Exception e) {
            // On reste sur la même page qui est réaffichée
            request.setAttribute("listeCategoriesR", categorieF.lister());
            erreur = Utilitaire.getExceptionCause(e);
            return "/client.jsp";
        }
    }

    private String creerCompte(HttpServletRequest request) throws Exception {
        try {
            request.setAttribute("listeCategoriesR", categorieF.lister());
            return ("/client.jsp");
        } catch (Exception e) {
            throw e;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
