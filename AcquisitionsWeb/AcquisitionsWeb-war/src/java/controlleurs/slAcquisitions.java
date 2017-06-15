/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleurs;

import dal.Article;
import dal.Auteur;
import dal.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Utilitaire;
import session.ArticleFacade;
import session.AuteurFacade;

/**
 *
 * @author Epulapp
 */
public class slAcquisitions extends HttpServlet {

    
    private AuteurFacade auteurF = new AuteurFacade();
    
    private ArticleFacade articleF = new ArticleFacade();

    private String erreur;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
    }

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

            return ("index.jsp");
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
            Boolean res = auteurF.connecter(login, pwd);
            if (res) {
                Auteur auteur = auteurF.getAuteur();
                vueReponse = "/listeArticles.jsp";
                HttpSession session = request.getSession(true);
                ArrayList<Article> lstArticle = (ArrayList<Article>) articleF.lister();
                request.setAttribute("lArticlesR", lstArticle);
                session.setAttribute("userId", auteur.getIdAuteur());
                
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
        Auteur auteur = auteurF.lire(id);
        request.setAttribute("clientR", auteur);

        return "client.jsp";
    }

    private String validerCompte(HttpServletRequest request) throws Exception {
        String vueReponse;
        int id_client = 0;
        try {

            String id = request.getParameter("id_client");
            Auteur auteur = new Auteur();
            String titre = null;
            // Si on est en Modification ou Ajout            
            if (!id.equals("")) {
                id_client = Integer.parseInt(id);
                // Affecter l'Id de l'utilisateur à Modifier
                auteur.setIdAuteur(id_client);
                titre = "Modifier un profil";
            }
            // Peupler les propriétés de Utilisateur 

            auteur.setLoginAuteur(request.getParameter("txtLogin"));
            auteur.setPwdAuteur(request.getParameter("txtPwd"));
            auteur.setIdentiteAuteur(request.getParameter("txtIdentite"));
            auteur.setAdresseAuteur(request.getParameter("txtAdresse"));

// Il faut conserver les valeurs pour pouvoir
            // les réafficher en cas d'erreur
            request.setAttribute("titre", titre);
            request.setAttribute("clientR", auteur);
            // Si on a un id c'est qu'il s'agit d'une modification
            if (id_client > 0) {
                auteurF.modifier(auteur);
            } else {

                auteurF.ajouter(auteur);
            }
            vueReponse = "/listeArticles.jsp";
            return (vueReponse);
        } catch (Exception e) {
            // On reste sur la même page qui est réaffichée

            erreur = Utilitaire.getExceptionCause(e);
            return "/client.jsp";
        }
    }

    private String creerCompte(HttpServletRequest request) throws Exception {
        try {

            return ("/client.jsp");
        } catch (Exception e) {
            throw e;
        }
    }

    private String getDemande(HttpServletRequest request) {
        String demande = "";
        demande = request.getRequestURI();
        demande = demande.substring(demande.lastIndexOf("/") + 1);
        return demande;
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
