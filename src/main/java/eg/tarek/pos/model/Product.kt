package eg.tarek.pos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey val id: String,
    val barcode: String,
    val name: String,
    val price: Double,
    val stockQuantity: Int,
    val taxRate: Double = 0.14
)
