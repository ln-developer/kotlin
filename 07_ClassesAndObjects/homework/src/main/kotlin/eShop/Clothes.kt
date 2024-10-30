package eShop

class Clothes(
    private val category: String,
    val size: String,
    val color: String,
    var quantity: Int,
    val price: Int,
    val material: String,
    val id: Int,
) {
    fun printClothInfo() {
        println("Артикул товара: $id")
        println("Категория одежды: $category")
        println("Размер: $size")
        println("Цвет: $color")
        println("Цена: $price руб.")
        println("Состав: $material")
        println("Количество: $quantity")
        println('\n')
    }
}