package lectures.part2oop

object AbstractDataTypes extends App {
  // unimplemented fields or methods or classes are called as abstract
  //abstract class : cannot be instantiated
  //they are supposed to be inherited only
  //can contain abstract or non-abstract methods
  //abstract class can contain constructor

  abstract class Animal{
    val creatureType: String
    def eat : Unit
  }

  class Dog extends Animal{
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
    //it is okay even if we do not use override keyword
  }

  //traits
  //a class can inherit one class + one or more trait
  //so traits are abstract classes
  //abstract classes can have abstract or non-abstract types
  //DIFFERENCE::
  //so can traits
  //1. traits do not have constructor parameters
  //2. we can extend only one abstract class but multiple traits
  //3. traits are behavior and abstract class is "thing"
  trait Carnivore{
    def eat(animal : Animal) : Unit
  }

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    override def eat: Unit = println("monmon")
    override def eat(animal: Animal): Unit = println(s"I am a Croc and I eat ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat
  croc.eat(dog)
}

/*
Multiple inheritance NOT supported by classes.
But it is supported by Traits.
Reason it is not supported by classes:
  Reason is diamond problem.
  A = grandparent class = has method Foo
  B & C = Inherits A = B and C both have overridden method Foo
  D = Inherits B & C => Multiple inheritance
  Object of D is created and Foo() is called, then which function will be implemented?
  This is diamond problem.

  This problem is solved in scala using Traits.

  Main difference between Trait and abstract class is : abstract class can have constructor parameters and Traits cannot!
  Constructors have several limitations that regular methods don't have -
  they can only be called once per object,
  they have to be called for each new object,
   a child class' constructor must call it's parent's constructor as it's first instruction

   both B and C's constructors call A's constructor,
   then D's constructor will call A's constructor twice.
   Defining which implementations to choose like Scala did with methods won't work here because,
   both B's and C's constructors must be called.
  Traits avoid this problem since they don't have constructors.


 */