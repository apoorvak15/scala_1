package lectures.part2oop

import jdk.nashorn.internal.scripts.JO

object Object extends App {
  //scala does not have class level functionality ("static")
  //scala object = singleton instance
  object Person { //type (Person) + Only instance
    //static / class level functionality
    //we often have factory methods in singleton objects
    val N_EYES = 2
    def canFly : Boolean = false

    //factory method
    //we define such methods as "apply"
    //hence calling this method would be little different, refer line with **
    def from(mother : Person, father : Person) : Person = new Person("Bobbie")

    def apply(mother :Person, father : Person): Person = new Person("Bobbie")
  }

  class Person(val name : String){
    //instance level functionality
  }
  //here object and class are called Companions
  //they reside in same scope and have same name
  //all the code that we write will be either in class (regular instance)
  // or in object (singleton instance)

  println(Person.N_EYES)
  println(Person.canFly)

  //scala object = singleton instance
  val mary = Person //instance of Person type object
  val john = Person //instance of Person type object
  //both point to same instance
  println(mary == john) //this returns True, hence Person is the only instance

  //scala class = not singleton / regular instance
  val mary1 = new Person("Mary") //instance of Person type class
  val john1 = new Person("John") //instance of Person type class
  //both does not point to same instance

  //factory method call
  val bobbie = Person(mary1,john1) //**


    //scala applications = scala object with
    //def main(args : Array[String]) : Unit
    //scala apps are turned into JVM apps whose entry pint has to be pub. stat. void main with args as parameter
    //hence entry point has to be main function
    //alternatively object can "extent App" which already has main method.

}
