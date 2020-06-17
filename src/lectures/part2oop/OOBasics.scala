package lectures.part2oop

object OOBasics extends App {
  val basicPerson = new basicPerson
  val person = new person("Apoorva", 28)
  println(person.age) //we cannot print person.name, because it is not declared as val

  //method call
  person.greeting("Abhiraj",29)
  person.greeting()
}

class basicPerson
//constructor
class person(name : String, val age: Int){
  //method
  def greeting(name : String, age: Int) = {
    println(s"Hello ${this.name}, my name is $name.")
  }

  //overloading
  def greeting() = println(s"My name is $name")
  //cannot define a function that has same name and signature but different return type
  //def greeting() : Int = 12
  //def greeting (name : String, age: Int) : Int = {..some code..}

  //multiple constructors
  //these are similar to using default argument
  def this(name: String) = this(name,0) //RHS is call to primary constructor, RHS has to be call to primary constructor,
  // hence similar to using default argument
  def this() = this("Apoorva Kulkarni")
}
