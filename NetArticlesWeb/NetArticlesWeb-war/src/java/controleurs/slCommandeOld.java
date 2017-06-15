/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import dal.Achete;
import dal.Article;
import dal.Client;
import dal.Domaine;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import static java.util.Arrays.stream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.AcheteFacade;
import session.ArticleFacade;
import session.ClientFacade;
import session.CompteFacade;
import session.DomaineFacade;
import utils.Transaction;

/**
 *
 * @author Epulapp
 */
public class slCommandeOld extends HttpServlet {

    @EJB
    private ArticleFacade articleF;
    @EJB
    private AcheteFacade acheteF;
    @EJB
    private DomaineFacade domaineF;
    @EJB
    private CompteFacade compteF;
    @EJB
    private ClientFacade clientF;

    private String erreur;
    private List<Article> lstArticleBySelectedDomaine;

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
            if (demande.equalsIgnoreCase("ajoutPanier.cde")) {
                vueReponse = ajouterPanier(request);
            } else if (demande.equalsIgnoreCase("supprimerPanier.cde")) {
                vueReponse = supprimerPanier(request);
            } else if (demande.equalsIgnoreCase("voirPanier.cde")) {
                vueReponse = voirPanier(request);
            } else if (demande.equalsIgnoreCase("listeAchats.cde")) {
                vueReponse = listeAchats(request);
            } else if (demande.equalsIgnoreCase("listeDomaines.cde")) {
                vueReponse = listeDomaines(request);
            } else if (demande.equalsIgnoreCase("validerPanier.cde")) {
                vueReponse = validerPanier(request);
            } else if (demande.equalsIgnoreCase("listeArticlesDomaine.cde")) {
                vueReponse = listeArticlesDomaine(request);
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

    private String getDemande(HttpServletRequest request) {
        String demande = "";
        demande = request.getRequestURI();
        demande = demande.substring(demande.lastIndexOf("/") + 1);
        return demande;
    }

    // A VOIR SI ON A LE DROIT 
    private String ajouterPanier(HttpServletRequest request) throws Exception {
        try {

            String id = request.getParameter("id_article");
            Article art = articleF.lire(Integer.parseInt(id));

            request.setAttribute("articleR", art);
            HttpSession session = request.getSession(true);

            if (session.getAttribute("panier") == null) {
                session.setAttribute("panier", new ArrayList<Article>());
            }

            ArrayList<Article> pan = ((ArrayList<Article>) session.getAttribute("panier"));

            pan.add(art);

            request.setAttribute("montantTotalR", ComputeTotal(pan));
            request.setAttribute("lArticlesPanierR", session.getAttribute("panier"));

            return ("panier.jsp");
        } catch (Exception e) {
            throw e;
        }
    }

    private double ComputeTotal(ArrayList<Article> lst) {
        double res = 0.0;

        for (Article a : lst) {
            res += a.getPrix().doubleValue();
        }

        return res;
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

    private String listeDomaines(HttpServletRequest request) throws Exception {

        request.setAttribute("lDomainesR", domaineF.lister());
        return "rechercher.jsp";
    }

    private String listeAchats(HttpServletRequest request) throws Exception {
        //lAchetesR
        HttpSession session = request.getSession(true);
        Integer idUser = (Integer) session.getAttribute("userId");
        request.setAttribute("lAchetesR", acheteF.getAcheteByCustomer(idUser));
        return "listeAchats.jsp";
    }

    private String voirPanier(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("userId") == null) {
            return ("/login.jsp");
        }
        ArrayList<Article> pan = ((ArrayList<Article>) session.getAttribute("panier"));
        request.setAttribute("montantTotalR", ComputeTotal(pan));
        request.setAttribute("lArticlesPanierR", session.getAttribute("panier"));

        return ("panier.jsp");
    }

    private String listeArticlesDomaine(HttpServletRequest request) {
        String vueReponse = "/listeArticles.jsp";
        erreur = "";
        try {
            String id_domaine = request.getParameter("cbDomaines");
            Domaine domaine = domaineF.lire(Integer.parseInt(id_domaine));
            ArrayList<Article> lstArticle = (ArrayList<Article>) articleF.listerByDomaine(domaine);
            request.setAttribute("lArticlesR", lstArticle);
            request.setAttribute("id_domaineR", id_domaine);

        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            return (vueReponse);
        }

    }

    private String supprimerPanier(HttpServletRequest request) throws Exception {
        try {

            String id = request.getParameter("id_article");
            Article art = articleF.lire(Integer.parseInt(id));
            HttpSession session = request.getSession(true);

            ArrayList<Article> pan = ((ArrayList<Article>) session.getAttribute("panier"));

            for (int i = 0; i < pan.size(); i++) {
                if (Objects.equals(pan.get(i).getIdArticle(), art.getIdArticle())) {
                    pan.remove(i);
                }
            }

                //session.setAttribute("panier", pan);
                request.setAttribute("montantTotalR", ComputeTotal(pan));
                request.setAttribute("lArticlesPanierR", pan);

                return ("panier.jsp");
            }catch (Exception e) {
            throw e;
        }
        }

    

    private String validerPanier(HttpServletRequest request) throws Exception {
        try {
            HttpSession session = request.getSession(true);
            Integer id = (Integer) session.getAttribute("userId");
            ArrayList<Article> pan = ((ArrayList<Article>) session.getAttribute("panier"));

            List<Achete> listeAchats = acheteF.getAcheteByCustomer(id);

            ArrayList<Article> tmp = (ArrayList<Article>) ((ArrayList<Article>) pan).clone();

            int i = 0;
            for (Article a : tmp) {
//                if (listeAchats.stream().anyMatch(art -> art.getArticle().getIdArticle() == a.getIdArticle())) {
//                    pan.remove(a);
//                }
                for (Achete achete : listeAchats) {
                    if (achete.getArticle().getIdArticle() == a.getIdArticle()) {
                        pan.remove(i);
                        break;
                    }
                }
                i++;
            }

            tmp = (ArrayList<Article>) ((ArrayList<Article>) pan).clone();

            Integer tot = (int) ComputeTotal(pan);
            Transaction transaction = new Transaction(id, tot);

            if (!pan.isEmpty()) {
                if (compteF.debiterCompte(transaction)) {
                    //Date today = Calendar.getInstance().getTime();
                    i = 0;
                    Client client = clientF.lire(id);
                    Date dateJour = new Date(System.currentTimeMillis());
                    for (Article a : tmp) {
                        Achete achat = new Achete(id, a.getIdArticle());
                        achat.setDateAchat(dateJour);
                        achat.setArticle(a);
                        achat.setClient(client);
                        acheteF.ajouter(achat);
                        pan.remove(i);
                        i++;
                    }
                }
            }

            Integer res = acheteF.getAcheteByCustomer(id).size();
            System.out.println(String.valueOf(res));
            request.setAttribute("lAchetesR", acheteF.getAcheteByCustomer(id));

            return ("listeAchats.jsp");

        } catch (Exception e) {
            throw e;
        }
    }

}
