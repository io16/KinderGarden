<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 05.11.16
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE HTML>

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
    <script src="../../resources/js/jquery.min.js"></script>
    <link href="resources/css/bootstrap.min.css" type="text/css" rel="stylesheet" media="screen">
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

<!-- Wrapper -->
<div id="wrapper">


    <!-- Content -->
    <div id="content">
        <div class="container">

            <%--<script language="javascript" type="text/javascript"--%>
                    <%--src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>--%>

            <h1>FeedBacks:</h1>
            You have ${fn:length(feedBacks)} feedBacks

            <c:if test="${fn:length(feedBacks) !=0}">

                <button class="button" onclick="DeleteAllFeedBacks()">Delete ALL</button>
            <table class="table">
            </c:if>
            <c:forEach items="${feedBacks}" var="fb">
                <thead>
                    <tr>
                        <th><b>Name:</b></th>
                        <th><b>Text:</b></th>
                        <th><b>Email:</b></th>
                        <th><b>Date:</b></th>
                        <th><b>Delete</b></th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td> ${fb.name}</td>
                        <td> ${fb.text}</td>
                        <td> ${fb.email}</td>
                        <td> ${fb.date}</td>
                        <td><button class="button" onclick="DeleteFeedBack('${fb.id}')">Delete</button></td>
                    </tr>
                </tbody>
            </c:forEach>

            <input  id="token" type="hidden" name="${_csrf.parameterName}"
                    value="${_csrf.token}" />
            </table>
        </div>

    </div>


    <!-- Sidebar -->
    <div id="sidebar">

        <!-- Logo -->

        <%--<h1 id="logo"><a href="#">Admin </a></h1>--%>

        <!-- Nav -->
        <nav id="nav">
            <ul>
                <%--<li class="current"><a href="/">Post</a></li>--%>


                <%--<li><a href="http://localhost:8080/gallery">Gallery</a></li>--%>


                <sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')">



                    <li><a href="adminGetPosts"> News</a></li>
                    <li><a href="adminAddPost"> Add Post</a></li>

                    <li><a href="adminPhoto"> Photos</a></li>
                    <li><a href="adminGallery"> Albums</a></li>
                    <li><a href="adminAddGallery"> Add Albums</a></li>
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

    </div>

</div>

</body>
</html>