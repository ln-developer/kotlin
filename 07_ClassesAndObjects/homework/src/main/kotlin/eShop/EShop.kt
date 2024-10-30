package eShop

class EShop {
    private var shoppingCart = mutableListOf<Clothes>()
    private var selectedFiltersList = mutableMapOf<String, Int>()
    private var currentClothesList = Stock.allClothes

    fun addToShoppingCart(id: Int) {
        val clothes = findClothesById(id)

        if (clothes != null) {
            if (clothes.quantity > 0) {
                shoppingCart.add(clothes)
            } else println("Ошибка: К сожалению, данный товар закончился")
        } else println("Ошибка: Товара с таким артикулом не существует")
    }

    fun deleteFromShoppingCart(id: Int) {
        val clothes = shoppingCart.find { it.id == id }

        if (clothes != null) {
            shoppingCart = shoppingCart.filter { it.id != id }.toMutableList()
        } else println("Ошибка: Товара с таким артикулом нет в корзине")
    }

    fun printShoppingCart() {
        shoppingCart.forEach { it.printClothInfo() }
        println("Итого: ${shoppingCart.sumOf { it.price }} руб.")
        println("Перейти к оформлению - 1")
        println("Вернуться в меню - 0")
        when (readlnOrNull()?.toIntOrNull()) {
            1 -> buy()
            else -> return
        }
    }

    fun printStockList() {
        Stock.allClothes.forEach { it.printClothInfo() }
    }

    private fun buy() {
        shoppingCart.forEach { Stock.removeClothes(it) }
        println("Покупка успешно завершена!")
    }

    private fun printClothesList(category: String?) {
        when (category) {
            Stock.tShirtCategory -> Stock.tShirtsList.forEach { it.printClothInfo() }
            Stock.jeansCategory -> Stock.jeansList.forEach { it.printClothInfo() }
            Stock.coatCategory -> Stock.coatList.forEach { it.printClothInfo() }
            "All" -> printStockList()
            else -> println("Ошибка: Такой категории товаров не существует")
        }
    }

    private fun findClothesById(id: Int): Clothes? {
        return currentClothesList.find { it.id == id }
    }

    private fun chooseCategory() {
        println("Выберите категорию")
        printCategories()

        when (val action = readlnOrNull()?.toIntOrNull()) {
            null -> {
                println("Ошибка: Неверный ввод")
                return
            }

            in 1..Stock.categoriesMap.size -> {
                selectedFiltersList["Категория"] = action
                filterByCategory(action)
            }

            else -> println("Ошибка: Неверный ввод")
        }
    }

    private fun filterByCategory(categoryKey: Int) {
        currentClothesList = Stock.categoriesListMap[Stock.categoriesMap[categoryKey]]!!
        printClothesList(Stock.categoriesMap[categoryKey])
    }

    private fun chooseColor() {
        println("Выберите цвет")
        printColors()

        when (val action = readlnOrNull()?.toIntOrNull()) {
            null -> {
                println("Ошибка: Неверный ввод")
                return
            }

            in 1..Stock.colorsMap.size -> {
                selectedFiltersList["Цвет"] = action
                filterByColor(action)
            }

            else -> println("Ошибка: Неверный ввод")
        }
    }

    private fun filterByColor(colorKey: Int) {
        currentClothesList = currentClothesList.filter {
            it.color == Stock.colorsMap[colorKey]
        }.toSet()
        currentClothesList.forEach { it.printClothInfo() }
    }

    private fun chooseSize() {
        println("Выберите размер")
        printSizes()

        when (val action = readlnOrNull()?.toIntOrNull()) {
            null -> {
                println("Ошибка: Неверный ввод")
                return
            }

            in 1..Stock.sizesMap.size -> {
                selectedFiltersList["Размер"] = action
                filterBySize(action)
            }

            else -> println("Ошибка: Неверный ввод")
        }
    }

    private fun filterBySize(sizeKey: Int) {
        currentClothesList = currentClothesList.filter {
            it.size == Stock.sizesMap[sizeKey]
        }.toSet()
        currentClothesList.forEach { it.printClothInfo() }
    }

    private fun chooseMaterial() {
        println("Выберите материал")
        printMaterials()

        when (val action = readlnOrNull()?.toIntOrNull()) {
            null -> {
                println("Ошибка: Неверный ввод")
                return
            }

            in 1..Stock.materialsMap.size -> {
                selectedFiltersList["Материал"] = action
                filterByMaterial(action)
            }

            else -> println("Ошибка: Неверный ввод")
        }
    }

    private fun filterByMaterial(materialKey: Int) {
        currentClothesList = currentClothesList.filter {
            Stock.materialsMap[materialKey].toString() in it.material
        }.toSet()
        currentClothesList.forEach { it.printClothInfo() }
    }

    private fun filterByQuantity() {
        selectedFiltersList["В наличии"] = 1
        currentClothesList = currentClothesList.filter { it.quantity > 0 }.toSet()
        currentClothesList.forEach { it.printClothInfo() }
    }

    fun resetFilter() {
        println("Выберите фильтр, который хотите сбросить")
        printFilters()

        when (val action = readlnOrNull()?.toIntOrNull()) {
            null -> return
            in 1..filtersMap.size -> {
                currentClothesList = Stock.allClothes
                selectedFiltersList = selectedFiltersList.filter {
                    it.key != filtersMap[action]
                }.toMutableMap()
                selectedFiltersList.forEach { (key, value) ->
                    when (key) {
                        "Категория" -> filterByCategory(value)
                        "Цвет" -> filterByColor(value)
                        "Размер" -> filterBySize(value)
                        "Материал" -> filterByMaterial(value)
                        "В наличии" -> filterByQuantity()
                    }
                }
            }
        }
    }

    fun resetAllFilters() {
        selectedFiltersList = mutableMapOf()
        currentClothesList = Stock.allClothes
    }

    fun printSelectedFilters() {
        println("Примененные фильтры")
        selectedFiltersList.forEach { (key, value) -> println("$key - $value") }
        println('\n')
    }

    fun chooseFilter() {
        println("Выберите фильтр")
        printFilters()

        when (readlnOrNull()?.toIntOrNull()) {
            0, null -> return
            1 -> chooseCategory()
            2 -> chooseColor()
            3 -> chooseSize()
            4 -> chooseMaterial()
            5 -> filterByQuantity()
            else -> println("Ошибка: Неверный ввод")
        }
    }

    companion object {
        private val filtersMap = mapOf(
            1 to "Категория",
            2 to "Цвет",
            3 to "Размер",
            4 to "Материал",
            5 to "В наличии"
        )

        private fun printMenuActions(actions: Map<Int, String>) {
            actions.forEach { (key, value) -> println("\t$value - $key") }
            println("Вернуться в меню - 0")
        }

        fun printFilters() {
            printMenuActions(filtersMap)
        }

        fun printCategories() {
            printMenuActions(Stock.categoriesMap)
        }

        fun printColors() {
            printMenuActions(Stock.colorsMap)
        }

        fun printSizes() {
            printMenuActions(Stock.sizesMap)
        }

        fun printMaterials() {
            printMenuActions(Stock.materialsMap)
        }
    }
}