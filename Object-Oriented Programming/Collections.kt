// Kotlin can be easily mixed with Java code. Default collections in Kotlin are all Java collections under the hood. There are both read-only and mutable collections.
// The Kotlin standard library contains lots of extension functions that make working with collections more convenient. 
// For example, operations that transform a collection into another one, starting with 'to': toSet or toList.
// Implement the extension function Shop.getSetOfCustomers(). The class Shop and all related classes are given.

fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()

// Return a list of customers, sorted in the descending by number of orders they have made
fun Shop.getCustomersSortedByOrders(): List<Customer> = customers.sortedByDescending { it.orders.size }
        
//  ---------------------------------------------------------------------------------

data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>) {
    override fun toString() = "$name from ${city.name}"
}

data class Order(val product: List<Product>, val isDelivered: Boolean)

data class Product(val name: String, val price: Double) {
    override fun toString() = "$name for $price"
}

data class City(val name: String) {
    override fun toString() = name    
}
