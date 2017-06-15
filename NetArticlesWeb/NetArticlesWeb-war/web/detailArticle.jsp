<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="well">
    <div class="row">
        <div class="col-md-3 col-md-offset-1" >
            <figure class='book' >

                <!-- Front -->

                <ul class='hardcover_front'>
                    <li>
                        <div class="coverDesign yellow">
                            <span class="ribbon">NEW</span>
                            <h1>${articleR.idDomaine.libdomaine}</h1>
                            <p>${articleR.titre}</p>
                        </div>
                    </li>
                    <li></li>
                </ul>

                <!-- Pages -->

                <ul class='page'>
                    <li></li>
                    <li>
                        <a class="btn" href="ajoutPanier.cde?id_article=${articleR.idArticle}">Acheter</a>
                    </li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>

                <!-- Back -->

                <ul class='hardcover_back'>
                    <li></li>
                    <li></li>
                </ul>
                <ul class='book_spine'>
                    <li></li>
                    <li></li>
                </ul>
                
            </figure> 
        </div>
        <div class="col-md-7">
            <div class="row">
                <label class="col-md-2 text-right">N° Article : </label>
                <div class="col-md-6">${articleR.idArticle}</div>
            </div>
            <div class="row">
                <label class="col-md-2 text-right">Titre :</label>
                <div class="col-md-9">${articleR.titre}</div>
            </div>
            <div class="row">
                <label class="col-md-2 text-right">Résumé : </label>
                <div class="col-md-9">${articleR.resume}</div>
            </div>            
            <div class="row">
                <label class="col-md-2 text-right">Prix : </label>
                <div class="col-md-6"><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${articleR.prix}"/></div>
            </div>  
            <div class="row">
                <label class="col-md-2 text-right">Date publication : </label>
                <div class="col-md-6"><fmt:formatDate pattern="dd/MM/yyyy" value="${articleR.dateArticle}"/></div>
            </div>  
            <div class="row">
                <label class="col-md-2 text-right">Domaine : </label>
                <div class="col-md-6">${articleR.idDomaine.libdomaine}</div>
            </div> 
        </div>
    </div>
</div>