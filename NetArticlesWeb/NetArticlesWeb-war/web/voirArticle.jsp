<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="detailArticle.jsp"/>
<div class="well col-md-6 col-lg-offset-3 " >
    
        
    
    <a  class="btn btn-primary pull-left" href="ajoutPanier.cde?id_article=${articleR.idArticle}"><span class="glyphicon glyphicon-log-in"></span> Acquérir cet article</a>
    &nbsp;
    <c:if test="${id_domaineR != null}">
        
        <a class="btn btn-primary pull-right" href="listeArticlesDomaine.cde?cbDomaines=${articleR.idDomaine.getIdDomaine()}"><span class="glyphicon glyphicon-list"></span> Retour liste</a>
    </c:if>

    
    
</div>  





