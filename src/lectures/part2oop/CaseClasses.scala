package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age:Int)

  //1. class parameters are field. No need to use "val" keyword for parameters
  val jim = new Person("Jim",28)
  println(jim.name)

  //2. sensible toString
  println(jim)

  //3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim",28)
  println(jim == jim2)

  //4. handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  //5. case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary",23) //this is apply method,
  //we do not use new while initiating case class

  //6. serializable : useful while dealing with Akka. this is useful when dealing with distributed systems
  // we can send instances of case classes thr n/w and in-between JVMs

  //6. extractor patters : used in Pattern matching

  //7. there is such a this as case object, they have same props as case classes ,
  // except they do not have companion object, because they are their companion object

}

