let testBtn = document.getElementsByClassName("addToCart")

setTimeout(() => {
    for (let i = 0; i < testBtn.length; i++) {
        testBtn[i].addEventListener("click", (e) => {
            let id = e.target.getAttribute("data-id")
            let image = e.target.getAttribute("data-image")
            let title = e.target.getAttribute("data-title")
            let price = e.target.getAttribute("data-price")

            let quantity = 1

            let productList = new Array()

            let product = {
                id: id,
                image: image,
                title: title,
                quantity: quantity,
                price: price * quantity
            }

            let getLocalStorage = localStorage.getItem("cart")

            if (getLocalStorage === null || getLocalStorage.length === undefined) {
                productList.push(JSON.stringify(product))
                localStorage.setItem("cart", `[` + productList + `]`)
                countProduct()
            } else {
                let isValueTitle = validateTitle(title)
                if (isValueTitle) {
                    alert("sản phẩm đã có trong giỏ hàng")
                } else {
                    let datas = JSON.parse(getLocalStorage);
                    for (let data of datas) {
                        productList.push(JSON.stringify(data));
                    }
                    productList.push(JSON.stringify(product))
                    localStorage.setItem("cart", `[` + productList + `]`)
                    countProduct()
                }
            }
        })
    }

    const validateTitle = (title) => {
        // get value of Local Storage
        let getLocalStorage = localStorage.getItem('cart')

        let products = JSON.parse(getLocalStorage)

        for (let data of products) {
            if (title === data.title) {
                return true
            }
        }
        return false
    }

    const countProduct = () => {
        let getLocalStorage = localStorage.getItem("cart")
        const products = JSON.parse(getLocalStorage)
        document.getElementById("countProductCart").innerText = products.length
    }
    countProduct()
}, 2000)