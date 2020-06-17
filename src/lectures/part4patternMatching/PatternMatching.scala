package lectures.part4patternMatching

import scala.util.Random

object PatternMatching extends App{
  //switch on steroids

  val random = new Random
  val x = random.nextInt(10)
  val description = x match {
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case _ => "something else" //_ is default, called as wildcard
  }
  println(x)
  println(description)

  // 1. decompose values
  case class PersonPM (name : String, age: Int)
  val bob = PersonPM("Bob", 20)
  val greeting = bob match  {
    case PersonPM(a,b) if b < 21 => s"Hi, My name is $a and I am $b years old, I can't drink!"
    case PersonPM(a,b) => s"Hi, My name is $a and I am $b years old."
    case _ => "I don't know who I am!"
  }
  println(greeting)
  /*
  1. if we do not write case _,and if matching case is not found, we get MatchError exception
  2. if is called a guard
  3. cases are matched in order
  4. if all cases return string, return type of description in example 1 would be string
      otherwise return type will be "any"
      5. PM works weill with case classes, as they come with extractor pattern
   */

  //Pattern matching on sealed hierarchies
  //unable to understand
  sealed class Animal
  case class Dog (breed : String) extends Animal
  case class Parrot(greeting : String) extends Animal

  val animal : Animal = Dog("XYZ")

  animal match {
    case Dog(someBreed) => println(s"Matched a dog of breed $someBreed")
  }

  //match everything

}
