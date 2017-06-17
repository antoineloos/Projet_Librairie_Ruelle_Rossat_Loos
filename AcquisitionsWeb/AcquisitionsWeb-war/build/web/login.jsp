<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="well">
        <form class="form-signin form-horizontal" role="form" action="connecter.acq" method="post">  
            <h1 align='center'>Authentification</h1>
            <br/>
            <br/>
            <div class="form-group ">
                <label class="col-md-3 control-label col-md-offset-2">Login : </label>
                <div class="col-md-3">
                    <input type="text" name="txtLogin" class="form-control" placeholder="Saisir votre identifiant" required autofocus>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label col-md-offset-2">Mot de passe : </label>
                <div class="col-md-3">
                    <input type="password" name="txtPwd"  class="form-control" placeholder="Saisir votre mot de passe" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-5 col-md-offset-5 ">
                    <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-log-in"></span> Valider</button>
                    
                    
                </div>
            </div> 
        </form>
    </div>


