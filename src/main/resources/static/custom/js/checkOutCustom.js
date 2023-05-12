let getLocalStorage = localStorage.getItem("cart")
const products = JSON.parse(getLocalStorage)

let showOrderTotal = document.getElementsByClassName("showOrderTotal")

let arrSubtotal = new Array()

for (let i = 0; i < products.length; i++) {
    for (let j = 0; j < showOrderTotal.length; j++) {
        showOrderTotal[j].innerHTML += `
                                            <div class="d-flex justify-content-between">
                                                <p>${products[i].title}</p>
                                                <p>$${products[i].price}</p>
                                            </div>
                                        `
        arrSubtotal.push(products[i].price)
    }
}
let subtotal = 0
for (let i = 0; i < arrSubtotal.length; i++) {
    subtotal += arrSubtotal[i]
}

document.getElementById("subtotal").innerText = `$${subtotal}`

let shipping = document.getElementById("shipping")
if (subtotal == 0) {
    shipping.innerText = `$0`
} else {
    shipping.innerText = `$10`
}

let total = document.getElementById("total")
let operatorTotal = subtotal + parseInt(shipping.textContent.replace('$', ''))
total.innerText = `$${operatorTotal}`

document.getElementById("btnPlaceOrder").addEventListener("click", () => {
    exportJSON()
})

function exportJSON() {
    let listItems = new Array()
    let idOfCustomer = document.getElementById("idOfCustomer").value
    for (let i = 0; i < products.length; i++) {
        let objItemsOrder = new Object()
        objItemsOrder.product = Object.assign({}, { productName: products[i].title })
        objItemsOrder.quantity = 1
        listItems.push(objItemsOrder)
    }

    const jsonAPICheckOut = {
        orderCode: "B123",
        paymentMethod: "COD",
        deliveryDetailId: 1,
        orderStatusId: 1,
        customer: {
            id: idOfCustomer
        },
        totalPrice: operatorTotal,
        items: listItems
    }
    console.log(JSON.stringify(jsonAPICheckOut))

    // const customerIdFromMySQL = 2

    // fetch(`http://localhost:8080/api/v1/customer/${customerIdFromMySQL}`)
    //     .then(response => response.json())
    //     .then(data => {
    //         jsonAPICheckOut.customer.id = data.id
    //         console.log(JSON.stringify(jsonAPICheckOut))
    //     })
    //     .catch(error => {
    //         console.error('Error:', error)
    //     });


    // fetch('http://localhost:9090/api/v1/order/create', {
    //     method: 'POST',
    //     headers: {
    //         'Content-Type': 'application/json',
    //     },
    //     body: JSON.stringify(jsonAPICheckOut),
    // })
    //     .then(response => response.json())
    //     .then(data => {
    //         console.log('Success:', data);
    //     })
    //     .catch((error) => {
    //         console.error('Error:', error);
    //     });


}