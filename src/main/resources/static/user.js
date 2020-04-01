$(document).ready(function () {
    $.ajax({
        url:"http://localhost:8080/conference_mvc_war/user"
    }).then(function(data) {
        $('.firstname').append(data.firstname);
        $('.lastname').append(data.lastname);
        $('.age').append(data.age);
    });
})