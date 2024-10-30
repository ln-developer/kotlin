package eShop

object Stock {
    const val tShirtCategory = "Футболка"
    const val jeansCategory = "Джинсы"
    const val coatCategory = "Пальто"

    private const val whiteColor = "Белый"
    private const val blackColor = "Черный"
    private const val brawnColor = "Коричневый"

    private const val cotton = "Хлопок"
    private const val polyester = "Полиэстер"
    private const val denim = "Деним"
    private const val wool = "Шерсть"

    private const val sizeXS = "XS"
    private const val sizeS = "S"
    private const val sizeM = "M"
    private const val sizeL = "L"

    val categoriesMap = mapOf(
        1 to tShirtCategory,
        2 to jeansCategory,
        3 to coatCategory,
        4 to "All",
    )

    val colorsMap = mapOf(
        1 to whiteColor,
        2 to blackColor,
        3 to brawnColor,
    )

    val sizesMap = mapOf(
        1 to sizeXS,
        2 to sizeS,
        3 to sizeM,
        4 to sizeL,
    )

    val materialsMap = mapOf(
        1 to cotton,
        2 to polyester,
        3 to denim,
        4 to wool,
    )

    val tShirtsList = setOf(
        Clothes(
            category = tShirtCategory,
            size = sizeXS,
            color = whiteColor,
            price = 999,
            quantity = 10,
            material = "100% $cotton",
            id = 1,
        ),
        Clothes(
            category = tShirtCategory,
            size = sizeS,
            color = whiteColor,
            price = 999,
            quantity = 5,
            material = "100% $cotton",
            id = 2,
        ),
        Clothes(
            category = tShirtCategory,
            size = sizeM,
            color = whiteColor,
            price = 999,
            quantity = 2,
            material = "100% $cotton",
            id = 3,
        ),
        Clothes(
            category = tShirtCategory,
            size = sizeL,
            color = whiteColor,
            price = 999,
            quantity = 1,
            material = "100% $cotton",
            id = 4,
        ),
        Clothes(
            category = tShirtCategory,
            size = sizeXS,
            color = blackColor,
            price = 1299,
            quantity = 15,
            material = "40% $cotton, 60% $polyester",
            id = 5,
        ),
        Clothes(
            category = tShirtCategory,
            size = sizeS,
            color = blackColor,
            price = 1299,
            quantity = 9,
            material = "40% $cotton, 60% $polyester",
            id = 6,
        ),
        Clothes(
            category = tShirtCategory,
            size = sizeM,
            color = blackColor,
            price = 1299,
            quantity = 6,
            material = "40% $cotton, 60% $polyester",
            id = 7,
        ),
        Clothes(
            category = tShirtCategory,
            size = sizeL,
            color = blackColor,
            price = 1299,
            quantity = 3,
            material = "40% $cotton, 60% $polyester",
            id = 8,
        )
    )

    val jeansList = setOf(
        Clothes(
            category = jeansCategory,
            size = sizeXS,
            color = blackColor,
            price = 2999,
            quantity = 5,
            material = "100% $denim",
            id = 9,
        ),
        Clothes(
            category = jeansCategory,
            size = sizeS,
            color = blackColor,
            price = 2999,
            quantity = 1,
            material = "100% $denim",
            id = 10,
        ),
        Clothes(
            category = jeansCategory,
            size = sizeM,
            color = blackColor,
            price = 2999,
            quantity = 2,
            material = "100% $denim",
            id = 11,
        ),
        Clothes(
            category = jeansCategory,
            size = sizeL,
            color = blackColor,
            price = 2999,
            quantity = 4,
            material = "100% $denim",
            id = 12,
        )
    )

    val coatList = setOf(
        Clothes(
            category = coatCategory,
            size = sizeXS,
            color = brawnColor,
            price = 12500,
            quantity = 10,
            material = "70% $wool, 30% $polyester",
            id = 13,
        ),
        Clothes(
            category = coatCategory,
            size = sizeS,
            color = brawnColor,
            price = 12500,
            quantity = 5,
            material = "70% $wool, 30% $polyester",
            id = 14,
        ),
        Clothes(
            category = coatCategory,
            size = sizeM,
            color = brawnColor,
            price = 12500,
            quantity = 0,
            material = "70% $wool, 30% $polyester",
            id = 15,
        ),
        Clothes(
            category = coatCategory,
            size = sizeL,
            color = brawnColor,
            price = 12500,
            quantity = 3,
            material = "70% $wool, 30% $polyester",
            id = 16,
        ),
        Clothes(
            category = coatCategory,
            size = sizeXS,
            color = blackColor,
            price = 15500,
            quantity = 12,
            material = "100% $wool",
            id = 17,
        ),
        Clothes(
            category = coatCategory,
            size = sizeS,
            color = blackColor,
            price = 15500,
            quantity = 9,
            material = "100% $wool",
            id = 18,
        ),
        Clothes(
            category = coatCategory,
            size = sizeM,
            color = blackColor,
            price = 15500,
            quantity = 1,
            material = "100% $wool",
            id = 19,
        ),
        Clothes(
            category = coatCategory,
            size = sizeL,
            color = blackColor,
            price = 15500,
            quantity = 8,
            material = "100% $wool",
            id = 20,
        )
    )

    val allClothes = tShirtsList union jeansList union coatList

    val categoriesListMap = mapOf(
        tShirtCategory to tShirtsList,
        jeansCategory to jeansList,
        coatCategory to coatList,
        "All" to allClothes,
    )

    fun removeClothes(clothes: Clothes) {
        val clothesIndex = allClothes.indexOf(clothes)
        allClothes.elementAt(clothesIndex).quantity -= 1
    }
}