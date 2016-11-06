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
