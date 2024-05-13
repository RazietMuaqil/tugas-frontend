class Person {
    var name: String = ""
    var age: Int = 0
    constructor(name: String) {
        this.name = name
    }
    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}
constructor(age: Int) {
    this.age = age
}
fun main() {
    val person1 = Person("John")
    val person2 = Person("Jane", 30)
    val person3 = Person(25)
    println("Person 1: Name = ${person1.name}, Age = ${person1.age}")
    println("Person 2: Name = ${person2.name}, Age = ${person2.age}")
    println("Person 3: Name = ${person3.name}, Age = ${person3.age}")