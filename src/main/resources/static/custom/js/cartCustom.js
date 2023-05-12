const $ = document.querySelector.bind(document)
const $$ = document.querySelectorAll.bind(document)

setTimeout(() => {

    SubToTal()
    let plus = $$(".btn-plus")
    let minus = $$(".btn-minus")
    let btnRemove = $$(".btnRemove")
    let trTags = $$("tr")

    var inputElement = $$('.productCount')

    let getLocalStorage = JSON.parse(localStorage.getItem("cart"))

    for (let i = 0; i < btnRemove.length; i++) {
        btnRemove[i].addEventListener("click", () => {
            // getLocalStorage.splice(i, 1)
            trTags[i + 1].remove()
            // let test = getLocalStorage.splice(i, 1)
            // localStorage.deleteItem('cart', JSON.stringify(test))
            SubToTal()
        })

    }


    for (let i = 0; i < minus.length; i++) {
        minus[i].addEventListener("click", () => {
            var currentValue = parseInt(inputElement[i].value)

            // Giảm giá trị đi 1, nếu giá trị <= 1 thì giữ nguyên giá trị
            var newValue = currentValue > 1 ? currentValue - 1 : 1

            // Cập nhật giá trị mới vào thẻ input
            inputElement[i].value = newValue
            // console.log(minus[i])
            SubToTal()
        })
    }

    for (let i = 0; i < plus.length; i++) {
        plus[i].addEventListener("click", () => {
            var currentValue = parseInt(inputElement[i].value)

            // Tăng giá trị lên 1
            var newValue = currentValue + 1

            // Cập nhật giá trị mới vào thẻ input
            inputElement[i].value = newValue
            SubToTal()
        })
    }

    function SubToTal() {
        let productPrices = $$(".productPrice")
        let productCounts = $$(".productCount")
        let productTotals = $$(".productTotal")

        let arrPrices = new Array()
        let arrCounts = new Array()
        let arrTotal = new Array()

        for (let valuePrice of productPrices) {
            arrPrices.push(valuePrice.textContent.replace('$', ''))
        }

        for (let valueCount of productCounts) {
            arrCounts.push(parseInt(valueCount.value))
        }

        for (let i = 0; i < arrPrices.length; i++) {
            let total = arrPrices[i] * arrCounts[i]
            arrTotal.push(total)
        }

        for (let i = 0; i < arrTotal.length; i++) {
            productTotals[i].innerText = `$${arrTotal[i]}`
        }

        let subtotal = 0
        for (let i = 0; i < arrTotal.length; i++) {
            subtotal += arrTotal[i]
        }

        $("#summaryTotal").innerText = `$${subtotal}`

        if (subtotal == 0) {
            $("#shipping").innerText = `$0`
        } else {
            $("#shipping").innerText = `$10`
        }
        let totalAll = subtotal + parseInt($("#shipping").textContent.replace('$', ''))

        $("#totalAll").innerText = `$${totalAll}`
    }

}, 1000)
