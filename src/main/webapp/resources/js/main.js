//$(document).ready(function() {
//    $("#DeleteButton").click(createUser)
//});

//$(document).on("Up","#forma", function(event) {
//    var $form = $(this);
//    $.post("/savefiles",
//        $form.serialize(),
//        function (data){
//            alert(data);
//        }
//    )
//    event.preventDefault();
//});
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

function writeImage(json) {
    // console.log(id)

    var t = JSON.parse(json);

    var id = t['id']
    var data = t['formats']
    var format = data[0]
    var byte = data [1]
    // var decodedString = Base64.decode(encodedString)
    for (var i in id) {


        document.getElementById(id[i]).src = "data:image/png;base64," + byte[id[i]];


    }


}


function DeleteGallery(id) {
    var token = $("#token").val();

    $.post("admin/DeleteGallery?_csrf=" + token, {
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
    while (s.length != 0) {

        idlist[i] = parseInt(s.substring(0, s.indexOf(',')))
        s = s.substring(s.indexOf(',') + 1)
        i++


    }
    console.log(s)
    var employees = {
        ids: []
    };
    employees.ids.push(idlist)
    console.dir(employees)
    $.post("adminDeletePhotos?_csrf=" + token, {
           idPhotos: JSON.stringify(employees)

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

function EditPost(id) {

    $.get("Update?id=" + id)
}
