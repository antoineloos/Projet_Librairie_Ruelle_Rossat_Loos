<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-target">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

<a  class="navbar-brand" href="#">ADMINISTRATION</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse-target">


             

                <ul class="nav navbar-nav navbar-right"> 
                    <c:if test="${sessionScope.userId != null}">
                        <li><a href="deconnecter.acq">Se déconnecter</a></li>
                        </c:if>  
                        <c:if test="${sessionScope.userId == null}">                   
                        <li><a href="login.acq">Se connecter</a></li>
                        </c:if>  
                </ul>
            </div>
        </div>
    </nav>
</div><!--/.container-fluid -->

