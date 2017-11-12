package socio.events.combinedsearchjava.data.remote.helpers

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class LongDateDeserializer : JsonDeserializer<Long> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Long {
        try {
            return json?.let { json ->
                json.asString.toLongOrNull()?.let { it } ?: run {
                    return SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.getDefault()).parse(json.asString).time / 1000
                }
            } ?: 0L
        } catch (pe : ParseException) {
            Log.e(this.javaClass.simpleName, "Problem parsing Long: ${pe.message}")
            return 0L
        }
    }
}