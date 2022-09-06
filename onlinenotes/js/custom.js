$("document").ready(function() {


    $(".form").submit(function() {

        // =====================
        // Error of not written
        // ====================
        var name = $("#fname").val();

        var pass = $("#pass").val();
        var conpass = $("#confpass").val();
        var email = $("#email").val();
        if (!$("input[name='gender']:checked").val()) {
            gen = 0;
            $("#radio").next("p").show();

        } else {
            gen = 1;
            $("#radio").next("p").hide();

        }

        if (name == "") {
            nam = 0;
            $("#fname").next("p").show();
        } else {
            nam = 1;
            $("#fname").next("p").hide();

        }

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
            pas = 1;
            $("#pass").next("p").hide();

        }


        if (conpass == "") {
            p = 0;
            $("#confpass").next("p").show();
        } else if (pass != conpass) {
            p = 0;
            $("#confpass").next("p").hide();

            $("#confpass").next("p").next(".err").show();
        } else {
            p = 1;
        }

        if (nam == 1 && em == 1 && pas == 1 && gen == 1 && p == 1) {
            return true;

        } else {
            return false;

        }
    })
})