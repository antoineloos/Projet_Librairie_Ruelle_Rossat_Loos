<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>
    Dernier(s) article(s) vendu(s)
</h1>
<table class="table table-bordered table-striped">
    <thead>
        <tr>
            <td>Id</td>
            <td>Titre</td>
            <td>Prix</td>    
                              
        </tr>
    </thead>
    <tbody>                            
        <c:forEach var="articleE" items="${lArticlesR}">
            <tr>
                <td>${articleE.idArticle}</td>
                <td>${articleE.titre}</td>
                <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${articleE.prix}"/></td>  
                                     
            </tr>
        </c:forEach>
    </tbody>
</table>           

