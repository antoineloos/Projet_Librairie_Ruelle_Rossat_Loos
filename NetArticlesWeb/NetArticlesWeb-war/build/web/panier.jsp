<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="well col-md-9 col-md-offset-2">
    <h1 align='center'>Panier<c:out value="${titre}"/></h1>
    <c:if test="${sessionScope.panier != null}">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Titre</td>
                    <td>Prix</td>                  
                    <td>Supprimer</td>                     
                </tr>
            </thead>
            <tbody>                
                <c:forEach var="articleE" items="${lArticlesPanierR}">
                    <tr>
                        <td>${articleE.idArticle}</td>
                        <td>${articleE.titre}</td>
                        <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${articleE.prix}"/></td>   
                        <td><a href="supprimerPanier.cde?id_article=${articleE.idArticle}">Supprimer</a></td>                         
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="2" style="text-align: right">Montant total</td>                    
                    <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${montantTotalR}"/></td>                       
                </tr> 

            </tbody>
        </table>
        <div>
            <%--<c:if test="${sessionScope.userId != null}"><a class="btn btn-primary" href="validerPanier.cde"><span class="glyphicon glyphicon-log-in"></span> Valider panier</a></c:if>--%>    
        </div>      
        <c:if test="${sessionScope.userId != null && !empty lArticlesPanierR}"><a href="verifierPanier.cde" style="text-decoration: none; color:white"><button>Valider Panier</button></a></c:if> 
        <c:if test="${showPopup != null}">
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Validation du panier</h4>
                        </div>
                        <div class="modal-body">
                            <c:if test="${cptArticlesEnleves != '0'}">
                                <p>${cptArticlesEnleves} article(s) enlevé(s) de votre commande, car déjà présent(s) sur votre compte. Voici votre nouveau panier :</p>
                            </c:if>
                                <p>Voulez-vous valider ce panier ? Votre compte sera débité si vos fonds sont suffisants.</p>
                            <table class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <td>Id</td>
                                        <td>Titre</td>
                                        <td>Prix</td>                  
                                    </tr>
                                </thead>
                                <tbody>                
                                    <c:forEach var="articleE" items="${lArticlesPanierR}">
                                        <tr>
                                            <td>${articleE.idArticle}</td>
                                            <td>${articleE.titre}</td>
                                            <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${articleE.prix}"/></td>   
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td colspan="2" style="text-align: right">Montant total</td>                    
                                        <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${montantTotalR}"/></td>                       
                                    </tr> 

                                </tbody>
                            </table>
                            <a href="validerPanier.cde" style="text-decoration: none"><button class="md-content" >Valider le panier</button></a>
                            <button type="button" class="btnFermerModal" id="btnFermerModal">Fermer</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <script>
            $(document).ready(function () {
                // Show the Modal on load
                $("#myModal").modal("show");

                // Hide the Modal
                $("#btnFermerModal").click(function () {
                    $("#myModal").modal("hide");
                });
            });
        </script>
    </c:if>
</c:if>
</div>

