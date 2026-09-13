package eg.tarek.pos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey val orderId: String,
    val timestamp: Long = System.currentTimeMillis(),
    val totalAmount: Double,
    val paymentMethod: String = "CASH", // CASH, CARD, WALLET
    val isSyncedWithCloud: Boolean = false
)
