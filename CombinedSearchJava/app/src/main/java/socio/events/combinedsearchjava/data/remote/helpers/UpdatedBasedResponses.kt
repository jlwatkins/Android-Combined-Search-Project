package socio.events.combinedsearchjava.data.remote.helpers


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class UpdateBasedList<T : Any> (
        @Expose @SerializedName("data") val items : List<T> = emptyList(),
        @Expose @SerializedName("last_updated") var lastUpdated : Long = 0,
        @Expose @SerializedName("count") var count : Long = 0
) : Serializable {
    override fun equals(other: Any?): Boolean = if (other is UpdateBasedList<*>) other.lastUpdated == lastUpdated else false
    override fun hashCode(): Int = lastUpdated.hashCode()
}

open class UpdateBasedItem<T : Any> (
        @Expose @SerializedName("data") val item: T? = null,
        @Expose @SerializedName("last_updated") var lastUpdated : Long = 0,
        @Expose @SerializedName("count") var count : Long = 0
) : Serializable {
    override fun equals(other: Any?): Boolean = if (other is UpdateBasedList<*>) other.lastUpdated == lastUpdated else false
    override fun hashCode(): Int = lastUpdated.hashCode()
}
