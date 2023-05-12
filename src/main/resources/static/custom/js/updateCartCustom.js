let showProductCart = document.getElementsByClassName("showProductCart")

let getLocalStorage = localStorage.getItem("cart")
const products = JSON.parse(getLocalStorage)

for (let i = 0; i < products.length; i++) {
    for (let j = 0; j < showProductCart.length; j++) {
        showProductCart[j].innerHTML += `
            <tr>
                <td class="align-middle productTitle"><img src="${products[i].image}" alt="" style="width: 50px;"> ${products[i].title.substring(0, 10)}...</td>
                <td class="align-middle productPrice">$${products[i].price}</td>
                <td class="align-middle">
                    <div class="input-group quantity mx-auto" style="width: 100px;">
                        <div class="input-group-btn">
                            <button title="minus count" class="btn btn-sm btn-primary btn-minus" >
                                <i class="fa fa-minus"></i>
                            </button>
                        </div>
                        <input title = "count products" type="text" class="form-control form-control-sm bg-secondary text-center productCount" value="1">
                        <div class="input-group-btn">
                            <button title="plus count" class="btn btn-sm btn-primary btn-plus">
                                <i class="fa fa-plus"></i>
                            </button>
                        </div>
                    </div>
                </td>
                <td class="align-middle productTotal">$${products[i].price}</td>
                <td class="align-middle"><button title="remove" class="btn btn-sm btn-primary btnRemove"><i class="fa fa-times"></i></button></td>
            </tr>
        `
    }
}
