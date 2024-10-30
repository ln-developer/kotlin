package eShop

fun main() {
    val eShop = EShop()

    do {
        println("========== МЕНЮ ==========")
        println("Показать всю коллекцию - 1")
        println("Отфильтровать коллекцию - 2")
        println("Показать примененные фильтры - 3")
        println("Сбросить фильтр - 4")
        println("Сбросить все фильтры - 5")
        println("Выбрать товар и добавить в корзину - 6")
        println("Удалить товар из корзины - 7")
        println("Перейти в корзину - 8")
        println("Завершить покупки - 0")
        println("==========================")
        val action = readlnOrNull()?.toIntOrNull()

        when (action) {
            0 -> return
            1 -> eShop.printStockList()
            2 -> eShop.chooseFilter()
            3 -> eShop.printSelectedFilters()
            4 -> eShop.resetFilter()
            5 -> eShop.resetAllFilters()
            6 -> chooseClothes(eShop)
            7 -> deleteClothesById(eShop)
            8 -> eShop.printShoppingCart()
        }
    } while (action != 0)
}

fun chooseClothes(eShop: EShop) {
    println("Введите артикул товара")
    when (val action = readlnOrNull()?.toIntOrNull()) {
        null -> return
        else -> eShop.addToShoppingCart(action)
    }
}

fun deleteClothesById(eShop: EShop) {
    println("Введите артикул товара")
    when (val action = readlnOrNull()?.toIntOrNull()) {
        null -> return
        else -> eShop.deleteFromShoppingCart(action)
    }
}

