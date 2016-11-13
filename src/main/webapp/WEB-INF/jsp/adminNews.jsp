<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE HTML>
<!--
Striped by HTML5 UP
html5up.net | @n33co
Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
    <title>Blog</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <!--[if lte IE 8]>
    <script src="../../css/ie/html5shiv.js"></script><![endif]-->
    <script src="../../resources/js/jquery.min.js"></script>
    <script src="resources/js/skel.min.js"></script>
    <script src="resources/js/skel-layers.min.js"></script>
    <script src="resources/js/init.js"></script>
    <script src="../../resources/js/main.js"></script>

    <link rel="stylesheet" href="resources/css/skel.css"/>
    <link rel="stylesheet" href="resources/css/style1.css"/>
    <link rel="stylesheet" href="resources/css/style-desktop.css"/>
    <link rel="stylesheet" href="../../resources/css/style-wide.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="resources/css/ie/v8.css"/><![endif]-->
</head>
<!--
    Note: Set the body element's class to "left-sidebar" to position the sidebar on the left.
    Set it to "right-sidebar" to, you guessed it, position it on the right.
-->
<body class="left-sidebar">

<script language="javascript" type="text/javascript"
        src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript">


    $(document).ready(function () {

        writeImage('${images}')
            })
            </script>
<!-- Wrapper -->
<div id="wrapper">
    <c:set var="ac" scope="session" value="${access}"/>

    <!-- Content -->
    <div id="content">
        <div class="inner">
            <script language="javascript" type="text/javascript"
                    src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>


            <div id="NEWimage_container"></div>
            <%--<input type="hidden" id="token" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
            <%--<form action="upload" method="post" enctype="multipart/form-data">--%>
            <%--<input name="file" type="file" multiple="multiple">--%>
            <%--<input type="submit">--%>

            <%--</form>--%>

        </div>
        <div>
            Your Posts: You have  posts   ${fn:length(posts)}<br>
            <c:forEach items="${posts}" var="name"  varStatus="status">

                Post:${status.index+1}<br>
                ${name.title}<br>
                ${name.context}<br>

                <c:forEach var="img" items="${idImages}">
                    <c:if test="${img == name.idImage}">
                        <img style="margin: 10px" width="100px" height="100px" id="${img}" src=""/>

                    </c:if>

                </c:forEach>
                <%--<c:forEach items="${images}" var="img" varStatus="status">--%>
                    <%--<c:if test="${idImages[status.index] == name.idImage}">--%>
                    <%--<img style="margin: 10px" width="100px" height="100px"--%>
                         <%--src="<c:url value='${img}'/> "/><br>--%>

                <%--</c:if>--%>
                <%--</c:forEach>--%>

            <button class="button" onclick="DeletePost('${name.id}')">Delete</button>
            <br>
            </c:forEach>


        </div>
    </div>


    <!-- Sidebar -->
    <div id="sidebar">

        <!-- Logo -->

        <h1 id="logo"><a href="#">Blog<c:if test="${ac == true}">${user.firstName }</c:if> </a></h1>

        <!-- Nav -->
        <nav id="nav">
            <ul>
                <%--<li class="current"><a href="/">Post</a></li>--%>

                <sec:authorize access="hasRole('ROLE_ANONYMOUS')">


                </sec:authorize>
                <%--<li><a href="http://localhost:8080/gallery">Gallery</a></li>--%>


                <sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')">


                    <li><a href="adminGetPosts"> News</a></li>
                    <li><a href="adminAddPost"> Add Post</a></li>

                    <li><a href="adminPhoto"> Photos</a></li>
                    <li><a href="adminGallery"> Albums</a></li>
                    <li><a href="adminFeedBack"> FeedBacks</a></li>
                    <li><a href="http://localhost:8080/user/Update?id=0"> Main changes</a></li>
                    <li><a href="http://localhost:8080/logout">Log Out</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <%--<li><a href="http://localhost:8080/admin/userList">Ban List</a></li>--%>
                    <%--<li><a href="http://localhost:8080/admin/stat">Stats</a></li>--%>
                    <%--<li><a href="http://localhost:8080/admin/actions">Actions</a></li>--%>


                </sec:authorize>

            </ul>
        </nav>

        <!-- Search -->
        <section class="box search">
            <form method="post" action="#">
                <input type="text" class="text" name="search" placeholder="Search"/>
            </form>
        </section>

        <!-- Text -->
        <section class="box text-style1">
            <div class="inner">
                <p>
                    <strong>Striped:</strong> A free and fully responsive HTML5 site
                    template designed by <a href="http://n33.co/">AJ</a> for <a href="http://html5up.net/">HTML5 UP</a>
                </p>
            </div>
        </section>


    </div>

</div>

</body>
</html>