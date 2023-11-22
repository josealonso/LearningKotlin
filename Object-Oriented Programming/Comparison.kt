// Add the function compareTo to the class MyDate to make it comparable. 
// After this, the code below date1 < date2 should start to compile.
// 
// Note that when you override a member in Kotlin, the override modifier is mandatory.


data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> other.dayOfMonth - dayOfMonth
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
