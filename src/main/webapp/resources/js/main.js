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

function writeImage(json, galleryjson, page,pageMax) {


    if (page == null) {
        var t = JSON.parse(json);

        var id = t['id']
        var data = t['formats']
        var format = data[0]
        var byte = data [1]

        for (var i in id) {


            document.getElementById(id[i]).src = "data:image/" + format[[id[i]]] + ";base64," + byte[id[i]];


        }
    }
    else {
        console.log("dasdasdasdas")
        var divPageMax = Math.floor(pageMax / 4);
        var modPageMax = pageMax % 4
        if (modPageMax > 0)
            divPageMax++;
        if (page <= divPageMax) {

            page = page + 1;
        }
        var t = JSON.parse(json);

        var id = t['id']
        var data = t['formats']
        var format = data[0]
        var byte = data [1]
        for (var i = page * 4 in id) {

            document.getElementById(id[i]).src = "data:image/" + format[[id[i]]] + ";base64," + byte[id[i]];

            if (i + 4 >= page * 4)
                break

        }

    }
    if (galleryjson != null) {

        var t2 = JSON.parse(galleryjson);
        var idGallery = t2['idGalleries']


        var data2 = t2['Data']


        for (var i in idGallery) {

            for (var j in data2[idGallery[i]]) {
                var images = data2[idGallery[i]]
                var idImage = 'Gallery' + idGallery[i] + 'Image' + images[j]

                document.getElementById(idImage).src = "data:image/" + format[images[j]] + ";base64," + byte[images[j]];

            }

        }

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

function Unban(name, idi) {
    var token = $("#token").val();
    document.getElementById(idi).innerHTML = '<span style="color: forestgreen">Available</span>;';
    $.post("changeAccesss?_csrf=" + token, {
            username: name,
            status: true
        }
    )

}
function Upload() {
    //alert("vhod");
    var $form = $(this);
    var File1 = document.getElementById("File1");
    var tip = File1.value.toString();


    var tipstr1 = tip;
    var from1 = tipstr1.search('fakepath');
    var to1 = tipstr1.length;
    var tipstr2 = tipstr1.substring(from1, to1);


    var strstr1 = tipstr2;
    var from2 = 9;
    var to2 = strstr1.length;
    var strstr2 = strstr1.substring(from2, to2);
    var token = $("#token").val();//DO NOT OPEN!!!
    $.post("savefiles?_csrf=" + token,
        $form.serialize()
        ,
        function (data) {

            $("#NEWimage_container")

                .append('<img style="margin: 10px" width="100px" height="100px" src="\\resources\\images\\' + strstr2 + '"/>')
            SelectImg()
        }
    )
}


function preview(json, page) {

    if (page > 1) {
        page--;
        writeImage(json, null, page)
    }

}