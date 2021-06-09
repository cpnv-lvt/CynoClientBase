package ch.leytto.cynoclient.db

import java.util.*
import androidx.room.TypeConverter
import java.text.SimpleDateFormat

class TypeConverter {
    val format: SimpleDateFormat = SimpleDateFormat("YYYY-MM-DD")

    @TypeConverter
    fun fromString(value: String?): Date? {
        return format.parse(value)
    }

    @TypeConverter
    fun dateToString(date: Date?): String? {
        return format.format(date)
    }

    @TypeConverter
    fun fromInteger(value: Int?): Boolean? {
        return value == 1;
    }

    @TypeConverter
    fun booleanToInteger(boolean: Boolean?): Int? {
        return if(boolean == true) 1 else 0
    } // */
}