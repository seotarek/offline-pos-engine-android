package eg.tarek.pos.data

import androidx.room.*
import eg.tarek.pos.model.Product
import eg.tarek.pos.model.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface PosDao {
    @Query("SELECT * FROM products WHERE barcode = :barcode LIMIT 1")
    suspend fun getProductByBarcode(barcode: String): Product?

    @Query("SELECT * FROM products ORDER BY name ASC")
    fun getAllProducts(): Flow<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProduct(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: Order)

    @Query("SELECT * FROM orders WHERE isSyncedWithCloud = 0")
    suspend fun getUnsyncedOrders(): List<Order>

    @Query("UPDATE orders SET isSyncedWithCloud = 1 WHERE orderId = :orderId")
    suspend fun markOrderSynced(orderId: String)
}
