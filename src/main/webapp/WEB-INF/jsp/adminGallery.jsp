<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
    <c:set var="ac" scope="session" value="${access}"/>

    <!-- Content -->
    <div id="content">
        <div class="inner">
            <%--<script language="javascript" type="text/javascript"--%>
                    <%--src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>--%>
            <script type="text/javascript">


                $(document).ready(function () {
                    setJson('${galleries}')
                    getGalleries(1)
                    getDeleteButtonsToGalleries(1)


                    $('#image_container img').click(function () {
                        //remove border on any images that might be selected
//                        $('#image_container img').removeClass("img_border")
                        $('#NEWimage_container img').removeClass("img_border")
                        if (this.classList.contains("img_border")) {
                            var s = $('#image_from_list').val();
                            var toRemove = event.target.id;
                            this.classList.remove("img_border");
//                            console.log(s);
//                           s= s.substring(s.indexOf(toRemove),s.indexOf(toRemove +toRemove.length) )
//                            console.log(s);
                            var to = s.indexOf(toRemove) + toRemove.length + 1;

//                            console.log(to);

//                            console.log(s.substring(0,s.indexOf(toRemove.toString()))+ s.substring(to))
                            s = s.substring(0, s.indexOf(toRemove.toString())) + s.substring(to)
                            $('#image_from_list').val(s)
//                            console.log(s.indexOf(toRemove.toString(), s.indexOf(toRemove.toString(to))));
//                            console.log(s.substring(s.indexOf(toRemove.toString(), s.indexOf(toRemove.toString(to)))));
                        } else {
                            // set the img-source as value of image_from_list
                            var s = $('#image_from_list').val();
                            $('#image_from_list').val($(this).attr("id") + "," + s);
                            $('#data_value').val($(this).attr("id"));
                            // $('#data_value').val( $(this).data("options").color );

                            //add border to a clicked image
                            $(this).addClass("img_border")
                        }

                    });


                })


            </script>

            <div id="div_gallery_context">

            </div>

            <input  id="token" type="hidden" name="${_csrf.parameterName}"
                    value="${_csrf.token}" />

            <a class="button green pull-right" id="showButton" onclick="nextGalleryPage(true)"><span>&#xf138;</span>Показати ще </a>

            <br>


        </div>
    </div>


    <!-- Sidebar -->
    <div id="sidebar">

        <!-- Logo -->

        <%--<h1 id="logo"><a href="#">Blog<c:if test="${ac == true}">${user.firstName }</c:if> </a></h1>--%>

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


<script src="../../resources/js/jquery.prettyPhoto.js"></script>
</body>

</html>