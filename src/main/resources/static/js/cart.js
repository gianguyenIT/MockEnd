const $ = document.querySelector.bind(document)
const $$ = document.querySelectorAll.bind(document)

let flus = $$(".btn-plus")
let minus = $$(".btn-minus")
let btnRemove = $$(".btnRemove")
let trTags = $$("tr")

for (let i = 0; i < btnRemove.length; i++) {
    btnRemove[i].addEventListener("click", () => {
        trTags[i + 1].remove()
        setTimeout(SubToTal(), 500)
    })
}


for (let valueMinus of minus) {
    valueMinus.addEventListener("click", () => {
        setTimeout(SubToTal(), 500)
    })
}

for (let valuePlus of flus) {
    valuePlus.addEventListener("click", () => {
        setTimeout(SubToTal(), 500)
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
        arrPrices.push(parseInt(valuePrice.textContent.replace('$', '')))
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

function removeProduct() {

}