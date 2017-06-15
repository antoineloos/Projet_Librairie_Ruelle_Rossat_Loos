<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="lib/css/default2.css" />
        <link rel="stylesheet" type="text/css" href="lib/css/component2.css" />
        <link rel="stylesheet" type="text/css" href="lib/css/book.css" />
        <link href="lib/css/appStyles.css" rel="stylesheet" type="text/css"/>
        <link href="lib/bootstrap/css/united.css" rel="stylesheet" type="text/css"/>     
        <script src="lib/jquery/jquery-2.1.3.min.js" type="text/javascript"></script>        
        <script src="lib/bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="net_articles.js" type="text/javascript"></script>
        

        <title>Net Articles</title>
    </head>
    <body class="body" >       
        <div class="container">
            <c:import url="/menu.jsp"/>
            <div>
                <c:if test="${pageR != null}">
                    <c:import url="${pageR}"/>
                </c:if>
                <c:if test="${erreurR != null}">
                    <c:import url="/erreur.jsp"/>
                </c:if>   
            </div>
        </div>

    </body>
    <script src="lib/js/classie.js"></script>
    <script src="lib/js/modalEffects.js"></script>
    <script>
        // this is important for IEs
        var polyfilter_scriptpath = 'lib/js/';
    </script>
    <script src="lib/js/cssParser.js"></script>
    <script src="lib/js/css-filters-polyfill.js"></script>
    <script src="lib/js/modernizr.custom.js"></script>
</html>
