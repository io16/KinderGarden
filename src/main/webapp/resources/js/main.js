function Redirect() {
    window.location.href = "http://localhost:8080/404";
}
function DeleteFeedBack(id) {
    var token = $("#token").val();

    $.post("admin/DeleteFeedBack?_csrf=" + token, {
            idFeedBack: id

        }, function () {

            window.location.reload();

        }
    )

}
function getDeleteButtonsToPosts(page) {
    var t = JSON.parse(globalJson)
    var posts = t['posts']
    var postData = posts['postData']
    var idPosts = posts['idPosts']
    var i = (page * 4) - 4
    var counter = 0

    for (i; i < idPosts.length && counter <= 3; i++, counter++) {

        var tempPostData = idPosts[i]

        var idDiv = '#buttonsPost' + tempPostData

        $(idDiv).append('<button type="button" class="btn btn-danger" onclick="DeletePost(' + tempPostData + ')">Удалить</button> <br> ');
    }
}
function getDeleteButtonsToGalleries(page) {
    var t = JSON.parse(globalJson)

    var galleries = t['galleries']
    var idGalleries = galleries['idGalleries']

    var i = (page * 4) - 4
    var counter = 0

    for (i; i < idGalleries.length && counter <= 3; i++, counter++) {

        var tempGalleryData = idGalleries[i]

        var idDiv = '#idGalleryButton' + tempGalleryData

        $(idDiv).append('<button type="button" class="btn btn-danger" onclick="DeleteGallery(' + tempGalleryData + ')">Удалить</button> <br> ');
    }
}

function getPosts(page, idPost) {


    var t = JSON.parse(globalJson)
    var posts = t['posts']
    var postData = posts['postData']
    var idPosts = posts['idPosts']

    var images = t['images']
    var data = images['images']
    var imagesDate = data[0]
    var imagesSRC = data [1]

    if (page >= getMaxPageToPost()) {
        document.getElementById('showButton').style.display = 'none';

    }

    var i = (page * 4) - 4
    var counter = 0


    var countPost = 3

    if (idPost != null) {

        countPost = idPosts.indexOf(parseInt(idPost))
        console.log(countPost)
        if (countPost < 3) {
            countPost = 3
        }
    }


    for (i; i < idPosts.length && counter <= countPost; i++, counter++) {


        var tempPostData = idPosts[i]
        var tempPostDataId = postData[tempPostData];
        var context = tempPostDataId[1]
        if (context.length > 150) {
            context = context.substring(0, 150)
            context = context.substring(0, context.lastIndexOf(" ")) + "..."
        }
        var title = tempPostDataId[0]
        if (title.length > 30) {
            title = tempPostDataId[0].substring(0, 30)
            title = title.substring(0, context.lastIndexOf(" ")) + "..."
        }


        $('#div_post_context').append('  <div style="max-width: 90%; margin: auto; "> <h2 class="entry-title post-title" ><a style="text-decoration: none;" name="' + tempPostData + '">' + title + '</a></h2> <div class="post-meta mg-b10"> <span class="timestamp updated">' + tempPostDataId[2] + '</span></div>     <img   class="img-thumbnail" src="' + imagesSRC[tempPostDataId[3]] + '"/> <p style="color: #3e3e3e; font-size: 16px; ">' + context + '</p>  <div id="buttonsPost'+ tempPostData+'"><a type="button" class="btn btn-success"   href="blog-post' + tempPostData + '">Показать</a> </div><div class="separator"></div> </div> ');

        if (i%2==1)

        $('#div_post_context').append('<div class="clearfix"></div>')


    }


}
function scrollTo(hash) {
    location.hash = "#" + hash;
}
function getPost() {


    var t = JSON.parse(globalJson)
    var posts = t['posts']
    var postData = posts['postData']
    var idPosts = posts['idPosts']

    var images = t['images']
    var data = images['images']
    var imagesDate = data[0]
    var imagesSRC = data [1]


    document.getElementById('showButton').style.display = 'none';

    var tempPostData = idPosts[0]
    var tempData = postData[tempPostData];


    $('#div_post_context').append('   <div id="idPost' + tempPostData + '" class="content-bg"> <div class="col-lg-6 col-sm-12"> <h2 class="entry-title post-title"></h2> <div class="post-meta mg-b10"> <span class="timestamp updated">' + tempData[2] + '</span> </div>   ' + tempData[1] + ' <a href="' + imagesSRC[tempData[3]] + '" rel="prettyphoto[post' + tempPostData + ']"> <img   class="img-border"  src="' + imagesSRC[tempData[3]] + '"/> </a><p>' + tempData[0] + '</p> <a type="button" class="btn btn-success"  href="blog.html?idPost=' + tempPostData + '" >Повернутись</a> ');


}

function getGalleries(page) {
    var t = JSON.parse(globalJson)

    var images = t['images']


    var data = images['images']
    var imagesDate = data[0]
    var imagesSRC = data [1]

    var galleries = t['galleries']
    var galleryData = galleries['galleryData']
    var idGalleries = galleries['idGalleries']

    var galleryAndImageIds = t['galleryAndImageIds']
    var idData = galleryAndImageIds['data']

    if (page >= getMaxPageToGallery()) {
        document.getElementById('showButton').style.display = 'none';

    }
    var i = (page * 4) - 4
    var counter = 0

    $('#div_gallery_context').append(' <div class="content-bg"> ')
    for (i; i < idGalleries.length && counter <= 3; i++, counter++) {
        var tempIdImage = idData[idGalleries[i]];
        var tempGalleryData = galleryData[idGalleries[i]]

        $('#div_gallery_context').append('<div id="idGallery' + idGalleries[i] + '"></div>	<h2 class="green-title"><span class="fa"></span>' + tempGalleryData[2] + '   ' + tempGalleryData[0] + '</h2> <p>' + tempGalleryData[1] + '</p><div class="img-border" ')
        for (var j in tempIdImage) {


            $('#div_gallery_context').append('<a href="' + imagesSRC[tempIdImage[j]] + '" rel="prettyphoto[gallery' + idGalleries[i] + ']"><img  style="margin: 10px" width="100px" height="100px"  src="' + imagesSRC[tempIdImage[j]] + '" alt="" /></a></div>');
        }
        $('#div_gallery_context').append(' <div class="clearfix"></div> </div><div id="idGalleryButton' + idGalleries[i] + '"</div>   <div class="separator"></div>')
        if (i % 2 == 1) {

            $('#div_gallery_context').append('<div class="clearfix"></div>')

        }


    }
    $('#div_gallery_context').append('</div>')
}


function writeImage() {

    var t = JSON.parse(globalJson);
    var images = t['images']
    var id = images['id']
    var data = images['images']
    var imageDate = data[0]
    var imagesSRC = data[1]

    for (var i in id) {

        $('#image_container').append('<img  id="' + id[i] + '" style="margin: 10px" width="100px" height="100px"  src="' + imagesSRC[id[i]] + '"/>')

    }

}
function writeImageToGalleries(idGallery, json) {
    var idDiv = '#Gallery_' + idGallery
    var t = JSON.parse(json);
    var id = t['idGalleries']


    var data = t['Data']


    for (var i in id) {

        for (var j in data[id[i]]) {
            var images = data[id[i]]
            if (idGallery == id[i])
                $(idDiv).append(' <img style="margin: 10px" width="100px" height="100px" id="Gallery' + idGallery + 'Image' + images[j] + '" src=""/>');

        }

    }


}


function DeleteGallery(id) {
    var token = $("#token").val();

    $.post("adminDeleteGallery?_csrf=" + token, {
            idGallery: id

        }, function () {


            window.location.reload();

        }
    )

}
function DeletePost(id) {
    var token = $("#token").val();

    $.post("adminDeletePost?_csrf=" + token, {
            idPost: id

        }, function () {


            window.location.reload();

        }
    )

}

function DeletePhoto(id) {
    var token = $("#token").val();

    $.post("adminDeletePhoto?_csrf=" + token, {
            idPhoto: id

        }, function () {


            window.location.reload();

        }
    )

}
function DeleteSelectedPhotos() {
    var token = $("#token").val();
    var s = $('#image_from_list').val();
    var idlist = [];
    var i = 0;
    var employees = [];
    while (s.length != 0) {

        idlist[i] = parseInt(s.substring(0, s.indexOf(',')))
        employees.push(parseInt(s.substring(0, s.indexOf(','))))
        s = s.substring(s.indexOf(',') + 1)
        i++


    }

    console.dir(employees)
    $.post("adminDeletePhotos?_csrf=" + token, {
            idPhotos: JSON.stringify(employees)

        }, function () {


            window.location.reload();

        }
    )

}
function AddImagesToGallery() {
    var token = $("#token").val();
    var s = $('#image_from_list').val();
    var title = $('#titleGallery').val();
    var context = $('#contextGallery').val();
    var idlist = [];
    var i = 0;
    var employees = [];
    while (s.length != 0) {

        idlist[i] = parseInt(s.substring(0, s.indexOf(',')))
        employees.push(parseInt(s.substring(0, s.indexOf(','))))
        s = s.substring(s.indexOf(',') + 1)
        i++


    }

    $.post("adminCreateGallery?_csrf=" + token, {
            idPhotos: JSON.stringify(employees),
            title: title,
            context: context

        }, function () {


            window.location.reload();

        }
    )

}

function DeleteAllFeedBacks() {
    var token = $("#token").val();

    $.post("admin/DeleteAllFeedBacks?_csrf=" + token, function () {

            window.location.reload();

        }
    )
}

var globalPage = 1;


var globalJson
function setJson(json) {
    globalJson = json

}
function getMaxPageToPost() {
    var t = JSON.parse(globalJson)
    var post = t['posts']
    var idposts = post['idPosts']
    var maxPage = Math.floor(idposts.length / 4)

    if ((idposts.length / 4) != maxPage) {
        maxPage++;

    }
    return maxPage


}
function getMaxPageToGallery() {
    var t = JSON.parse(globalJson)

    var galleries = t['galleries']
    var galleryData = galleries['galleryData']
    var idGalleries = galleries['idGalleries']
    var maxPage = Math.floor(idGalleries.length / 4)

    if ((idGalleries.length / 4) != maxPage) {
        maxPage++;

    }
    return maxPage


}
function nextPostPage(adm) {

    if (globalPage <= getMaxPageToPost()) {
        globalPage++;
        getPosts(globalPage)
        if (adm == true)
            getDeleteButtonsToPosts(globalPage)
    }
}
function nextGalleryPage(adm) {

    if (globalPage <= getMaxPageToGallery()) {
        globalPage++;
        getGalleries(globalPage)
        if (adm == true)
            getDeleteButtonsToGalleries(globalPage)
    }
}