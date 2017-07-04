$(document).ready(function(){
    $("#siemka").click(function(){
        $.getJSON('http://localhost:8080/champion/1', { get_param: 'value' }, function(data) {
                console.log(data);
                $("#someID").html(data.toString())
            });
    });
});