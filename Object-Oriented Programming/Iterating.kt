// A Kotlin for loop can iterate through any object if the corresponding iterator member or extension function is available.
// 
// Make the class DateRange implement Iterable<MyDate>, so that it can be iterated over. Use the function MyDate.followingDate(), 
// so you don't have to implement the logic for finding the following date on your own.
// Use an object expression which plays the same role in Kotlin as an anonymous class in Java.


class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current = start
            
            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val result = current
                current = current.followingDate()
                return result
            }
        
            override fun hasNext(): Boolean = current <= end
        }
    }
}


fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}

// ----------------------------------------------------------------------------------------
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> other.dayOfMonth - dayOfMonth
    }
}

import java.util.Calendar

fun MyDate.followingDate(): MyDate {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    val millisecondsInAday = 24 * 60 * 60 * 1000L
    val timeInMillis = c.timeInMillis + millisecondsInAday
    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis
    return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
}





