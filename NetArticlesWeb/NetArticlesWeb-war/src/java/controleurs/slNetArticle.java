/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import dal.Article;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ArticleFacade;

/**
 *
 * @author Epulapp
 */
public class slNetArticle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String erreur;

    @EJB
    private ArticleFacade articleF;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String demande;
        String vueReponse = "/index.jsp";
        erreur = "";
        try {
            demande = getDemande(request);
            if (demande.equalsIgnoreCase("voirArticle.na")) {
                vueReponse = voirArticle(request);
            } else if (demande.equalsIgnoreCase("dernierArticle.na")) {
                vueReponse = dernierArticle(request);
            } else if (demande.equalsIgnoreCase("tousLesArticles.na")) {
                vueReponse = tousLesArticles(request);
            }

        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            request.setAttribute("erreurR", erreur);
            request.setAttribute("pageR", vueReponse);
            RequestDispatcher dsp = request.getRequestDispatcher("/index.jsp");
            if (vueReponse.contains(".na")) {
                dsp = request.getRequestDispatcher(vueReponse);
            }
            dsp.forward(request, response);
        }
    }

    private String voirArticle(HttpServletRequest request) throws Exception {
        try {

            String id = request.getParameter("id_article");
            Article art = articleF.lire(Integer.parseInt(id));
            request.setAttribute("articleR", art);
            request.setAttribute("id_domaineR", art.getIdDomaine());

            // return ("detailArticle.jsp");
            return ("voirArticle.jsp");
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

    private String dernierArticle(HttpServletRequest request) throws Exception {
        try {

            Article art = articleF.lire(articleF.lister().size());
            request.setAttribute("articleR", art);

            return ("detailArticle.jsp");
            //return ("voirArticle.jsp");
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

    private String tousLesArticles(HttpServletRequest request) throws Exception {
        try {
            ArrayList<Article> lstArticle = (ArrayList<Article>) articleF.lister();
            request.setAttribute("lArticlesR", lstArticle); //To change body of generated methods, choose Tools | Templates.
            return "/listeArticles.jsp";
        } catch (Exception ex) {
            throw ex;
        }
    }

}
