
    $(document).ready(function() {
    setInterval(getData, 3000);
});

    function getData() {
    $.ajax({
        url: "http://localhost:8080/showCategories",
        type: "GET",
        success: function(data) {
            // Update the page with the new data
            $("#data").text(data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("Error: " + textStatus);
        }
    });
}


    function setActive(element) {
    var activeClass = "active";
    if (element.classList.contains(activeClass)) {
    element.classList.remove(activeClass);
} else {
    element.classList.add(activeClass);
}
}
