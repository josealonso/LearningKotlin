// Kotlin can be easily mixed with Java code. Default collections in Kotlin are all Java collections under the hood. There are both read-only and mutable collections.
// The Kotlin standard library contains lots of extension functions that make working with collections more convenient. 
// For example, operations that transform a collection into another one, starting with 'to': toSet or toList.
// Implement the extension function Shop.getSetOfCustomers(). The class Shop and all related classes are given.

fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()

// Return a list of customers, sorted in the descending by number of orders they have made
fun Shop.getCustomersSortedByOrders(): List<Customer> = customers.sortedByDescending { it.orders.size }

//  Implement the following extension functions using the map and filter functions:

// Find all the different cities the customers are from
fun Shop.getCustomerCities(): Set<City> =
        customers.map { it.city }.toSet() 

// Find the customers living in a given city
fun Shop.getCustomersFrom(city: City): List<Customer> =
        customers.filter { it.city == city }

// Implement the following functions using all, any, count, find

// Return true if all customers are from a given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean =
    customers.all { it.city == city }

// Return true if there is at least one customer from a given city
fun Shop.hasCustomerFrom(city: City): Boolean =
    customers.any { it.city == city }

// Return the number of customers from a given city
fun Shop.countCustomersFrom(city: City): Int =
    customers.count { it.city == city }

// Return a customer who lives in a given city, or null if there is none
fun Shop.findCustomerFrom(city: City): Customer? =
    customers.find { it.city == city }

// Implement the following functions using associateBy, associateWith, and associate:

// Build a map from the customer name to the customer
fun Shop.nameToCustomerMap(): Map<String, Customer> =
        customers.associateBy(Customer::name)

// Build a map from the customer to their city
fun Shop.customerToCityMap(): Map<Customer, City> =
        customers.associateWith { it.city }   // customers.associateBy(Customer::city)

// Build a map from the customer name to their city
fun Shop.customerNameToCityMap(): Map<String, City> =
        customers.associate { it.name to it.city }    

// Use "groupBy" to build a map that stores the customers living in a given city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> =
        customers.groupBy { it.city }
        
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
