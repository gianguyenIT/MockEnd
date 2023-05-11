function setActive(element) {
    // Loại bỏ class "active" khỏi các thẻ HTML khác
    var activeElements = document.getElementsByClassName('active');
    for (var i = 0; i < activeElements.length; i++) {
        activeElements[i].classList.remove('active');
    }
    // Thêm class "active" vào thẻ HTML mới
    element.classList.add('active');
}
