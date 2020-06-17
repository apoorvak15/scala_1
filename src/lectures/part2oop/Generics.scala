package lectures.part2oop

object Generics extends App {
  //generic classes
  class MyList[A] { // A is data type
  }
  val listOfInt = new MyList[Int]
  val listOfString = new MyList[String]

  class MyMap [Key , Value]{
  }

  //generic methods
  //create companion object for MyList
  object MyList{
    def empty [A]: MyList[A] =  ???
  }
  val emptyListOfInt = MyList.empty[Int]

  //variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //If Cat extends Animal, does a list[Cat] extends list[Animal] ???
  //This question has 3 answers
  //1. Yes, this is called : Covariance
  class CovariantList[+A]
  val animal : Animal = new Cat
  val animalList : CovariantList[Animal] = new CovariantList[Cat]

  //2. No, they are 2 separate things, this is called : Invariant list
  class InvariantList[A]
  val invariantAnimalList : InvariantList[Animal] = new InvariantList[Animal]

  //3. Hell, no ! This relationship is called : Contravariance
  class Trainer [-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]


  //bounded types: allow you to use generics only for sub/super class of a certain type
  //upper bounded type
  class Cage [A <: Animal] (animal : A) //here A could be sub-types of Animal
  val cage = new Cage(new Dog)

}
