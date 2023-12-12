for(x in 1 until 10 step 3) {
  println(x)
}     // 1, 4, 7

val names = listOf("Alice", "Anne")

for(name in names.withIndex()) {  
  println("$name")
}

// Destructuring to get the loop index
for((i, name) in names.withIndex()) {  
  println("$i --- $name")
}
