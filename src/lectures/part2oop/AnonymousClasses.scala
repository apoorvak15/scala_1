package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal{
    def eat: Unit
  }

  //anonymous class:
  val funnyAnimal = new Animal {
    override def eat: Unit = println("HaHaHa")
  }

  /*
  this is same as defining:
  class someName extends Animal{
     override def eat: Unit = println("HaHaHa")
  }
  val funnyAnimal : Animal = new someClass
   */

  class PersonName(name: String){
    def sayHi : Unit = println(s"Hi, My name is $name")
  }
  val apoorva = new PersonName("apoorva"){
    override def sayHi: Unit = println("Hellloo I am Apoorva")
  }
  //Note : anonymous classes work for both Abstract class/traits and Non-Abstract classes
  // remember to pass arguments
  // and override all the fields/methods of abstract class/trait
}
