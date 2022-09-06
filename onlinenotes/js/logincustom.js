// =====================
// login page code start
// ====================

$(document).ready(function() {
    $(".form").submit(function() {
        var email = $("#email").val();
        var pass = $("#pass").val();
        if (email == "") {
            em = 0;
            $("#email").next("p").show();
        } else {
            em = 1;
            $("#email").next("p").hide();
        }
        if (pass == "") {
            pas = 0;
            $("#pass").next("p").show();

        } else {
            pass = 1;
            $("#pass").next("p").hide();

        }

        if (em == 1 && pas == 1) {
            return true;

        } else {
            return false;

        }



    })

})


// =====================
// login page code end
// ====================