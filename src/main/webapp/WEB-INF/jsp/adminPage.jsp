<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



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

<!-- Wrapper -->
<div id="wrapper">
    <c:set var="ac" scope="session" value="${access}"/>

    <!-- Content -->
    <div id="content">
        <div class="inner">
            <script language="javascript" type="text/javascript"
                    src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
            <script type="text/javascript">

                $(document).ready(function () {
                    writeImage('${images}')
                    $('#image_container img').click(function () {
                        //remove border on any images that might be selected
                        $('#image_container img').removeClass("img_border")
                        $('#NEWimage_container img').removeClass("img_border")
                        // set the img-source as value of image_from_list
                        $('#image_from_list').val($(this).attr("src"));
                        $('#data_value').val($(this).attr("id"));
                        // $('#data_value').val( $(this).data("options").color );

                        //add border to a clicked image
                        $(this).addClass("img_border")
                    });

                })
                function  SelectImg() {
                    $('#NEWimage_container img').click(function () {

                        //remove border on any images that might be selected
                        $('#NEWimage_container img').removeClass("img_border")
                        $('#image_container img').removeClass("img_border")
                        // set the img-source as value of image_from_list
                        $('#image_from_list').val($(this).attr("src"));
                        $('#data_value').val($(this).attr("id"));
                        // $('#data_value').val( $(this).data("options").color );

                        //add border to a clicked image
                        $(this).addClass("img_border")
                });

                }
            </script>
            <style>
                .img_border {
                    border: 4px solid blue;
                }
            </style>

            <form action="updatePost?${_csrf.parameterName}=${_csrf.token}" method="post">
                <input type="text" name="title" placeholder="Title" required value="${post.title}"><br/>
                <%--<input type="text" name="context" required>--%>
                <textarea class="text-style1" rows="10" cols="70"
                          STYLE="max-height: 300px; max-width: 100%; height: 60%" placeholder="Context" name="context"
                          required>${post.context}</textarea>
                <input id="image_from_list" name="image" type="hidden" value=""/><br/>
                <input id="ID" name="ID" type="hidden" value="${post.id+0}"/><br/>
                <%--<input type="hidden" th:th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>--%>
                <input type="submit" name="add" value="Update" align="right">

                <input  id="token" type="hidden" name="${_csrf.parameterName}"
                        value="${_csrf.token}" />
            </form>

            <div id="image_container">

                <c:forEach var="img" items="${idImages}">

                    <img style="margin: 10px" width="100px" height="100px" id="${img}" src=""/>

                </c:forEach>
                <%--<c:forEach items="${idImages}" var="name">--%>
                    <%--${name}<br>--%>
                <%--</c:forEach>--%>

            </div>

            <div id="NEWimage_container"></div>
            <input type="hidden" id="token" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <form:form id="forma"  modelAttribute="uploadForm" target="frame_ajax" action="http://localhost:8080/user//savefiles?${_csrf.parameterName}=${_csrf.token}"
                       enctype="multipart/form-data">

                <p>Select files to upload. .</p>


                <input id="File1" name="files[0]" type="file"/>
                <br/>
                <%--<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>--%>

                <%--<input type="submit" name="Up" value="Upload">--%>

                <%--<input type="hidden" name="${_csrf.parameterName}"--%>
                       <%--value="${_csrf.token}" />--%>
                <button class="button" name="Up" value="Upload" onclick="Upload()"></button>
            </form:form>
            <iframe name="frame_ajax" src="http://localhost:8080/user/savefiles?${_csrf.parameterName}=${_csrf.token}" width="0" height="0" style="display:none">
                            </iframe>
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

                <sec:authorize access="hasRole('ROLE_ANONYMOUS')" >



                </sec:authorize>
                <%--<li><a href="http://localhost:8080/gallery">Gallery</a></li>--%>


                <sec:authorize access="hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')" >


                    <li><a href="adminGetPosts"> News</a></li>

                    <li><a href="adminAddPost"> Add Post</a></li>
                    <li><a href="adminPhoto"> Photos</a></li>
                    <li><a href="adminGallery"> Albums</a></li>
                    <li><a href="adminFeedBack"> FeedBacks</a></li>
                    <li><a href="http://localhost:8080/user/Update?id=0"> Main changes</a></li>
                    <li><a href="http://localhost:8080/logout">Log Out</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')" >
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

        <!-- Recent Posts -->
        <section class="box recent-posts">
            <header>
                <h2>Recent Posts</h2>
            </header>
            <ul>
                <li><a href="#">Lorem ipsum dolor</a></li>
                <li><a href="#">Feugiat nisl aliquam</a></li>
                <li><a href="#">Sed dolore magna</a></li>
                <li><a href="#">Malesuada commodo</a></li>
                <li><a href="#">Ipsum metus nullam</a></li>
            </ul>
        </section>

        <!-- Recent Comments -->
        <section class="box recent-comments">
            <header>
                <h2>Recent Comments</h2>
            </header>
            <ul>
                <li>case on <a href="#">Lorem ipsum dolor</a></li>
                <li>molly on <a href="#">Sed dolore magna</a></li>
                <li>case on <a href="#">Sed dolore magna</a></li>
            </ul>
        </section>

        <!-- Calendar -->
        <section class="box calendar">
            <div class="inner">
                <table>
                    <caption>July 2014</caption>
                    <thead>
                    <tr>
                        <th scope="col" title="Monday">M</th>
                        <th scope="col" title="Tuesday">T</th>
                        <th scope="col" title="Wednesday">W</th>
                        <th scope="col" title="Thursday">T</th>
                        <th scope="col" title="Friday">F</th>
                        <th scope="col" title="Saturday">S</th>
                        <th scope="col" title="Sunday">S</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td colspan="4" class="pad"><span>&nbsp;</span></td>
                        <td><span>1</span></td>
                        <td><span>2</span></td>
                        <td><span>3</span></td>
                    </tr>
                    <tr>
                        <td><span>4</span></td>
                        <td><span>5</span></td>
                        <td><a href="#">6</a></td>
                        <td><span>7</span></td>
                        <td><span>8</span></td>
                        <td><span>9</span></td>
                        <td><a href="#">10</a></td>
                    </tr>
                    <tr>
                        <td><span>11</span></td>
                        <td><span>12</span></td>
                        <td><span>13</span></td>
                        <td class="today"><a href="#">14</a></td>
                        <td><span>15</span></td>
                        <td><span>16</span></td>
                        <td><span>17</span></td>
                    </tr>
                    <tr>
                        <td><span>18</span></td>
                        <td><span>19</span></td>
                        <td><span>20</span></td>
                        <td><span>21</span></td>
                        <td><span>22</span></td>
                        <td><a href="#">23</a></td>
                        <td><span>24</span></td>
                    </tr>
                    <tr>

                        <td><a href="#">25</a></td>
                        <td><span>26</span></td>
                        <td><span>27</span></td>
                        <td><span>28</span></td>
                        <td class="pad" colspan="3"><span>&nbsp;</span></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </section>

        <!-- Copyright -->
        <ul id="copyright">
            <li>&copy; Untitled.</li>
            <li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
        </ul>

    </div>

</div>

</body>
</html>