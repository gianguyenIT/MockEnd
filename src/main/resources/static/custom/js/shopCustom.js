let useAPI = document.getElementsByClassName("useAPI")

init()

// hàm khởi tạo, setup cho trang web
function init() {
    getProducts()
}

// hàm lấy dữ liệu giả từ trang web
async function getProducts() {
    await fetch("https://java-mock-project-2023.s3.ap-southeast-1.amazonaws.com/1683721833993_showProduct.json")
    // await fetch("http://localhost:9090/api/v1/products")
        .then(res => res.json())
        .then((data) => {
            for (i = 0; i < data.length; i++) {
                for (j = 0; j < useAPI.length; j++) {
                    useAPI[j].innerHTML += htmlProduct(data[i].id, data[i].image, data[i].title, data[i].price)
                }
            }
        })
}


function searchProduct() {
    let searchInput = document.getElementById("searchInput").value
    fetch("https://java-mock-project-2023.s3.ap-southeast-1.amazonaws.com/1683721833993_showProduct.json")
        .then(res => res.json())
        .then((data) => {
            for (i = 0; i < data.length; i++) {
                for (j = 0; j < useAPI.length; j++) {
                    let titleProduct = data[i].title.toLowerCase()
                    if (titleProduct.includes(searchInput.toLowerCase())) {
                        useAPI[j].innerHTML = ""
                        useAPI[j].innerHTML += htmlProduct(data[i].id, data[i].image, data[i].title, data[i].price)
                    }
                }
            }

        })
}

// code html để fetch ra khung mẫu
function htmlProduct(id, image, title, price) {
    return (
        `
            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
                <div class="card product-item border-0 mb-4">
                    <div
                        class="d-flex justify-content-center card-header product-img position-relative overflow-hidden bg-transparent border p-0" style = "height: 20rem;">
                        <img class="img-fluid w-50 align-self-center" src="${image}" alt="">
                    </div>
                    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                        <h6 class="text-truncate mb-3">${title}</h6>
                        <div class="d-flex justify-content-center">
                            <h6>$${price}</h6>
                            
                        </div>
                    </div>
                    <div class="card-footer d-flex justify-content-between bg-light border">
                        <a href="" class="btn btn-sm text-dark p-0"><i
                                class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                        <a href="javascript:void(0)" class="btn btn-sm text-dark p-0 addToCart" data-id="${id}" data-image="${image}" data-title="${title}" data-price="${price}"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                    </div>
                </div>
            </div>
        `
    )
}
