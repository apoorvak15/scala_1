package lectures.part2oop

object Inheritance extends App {
  //single class inheritance

  class Animal{
    val creatureType = "Animal"
    def eat() = println("Animal eat") //public method, can be accessed in file | can be overridden
    protected def legs() = println("Animal legs") //protected method can be accessed only in subclass
    // | can be overridden by sub class
    private def privateToAnimalClass = println("Animal private method") //private method cannot be accessed in sub class
    //cannot be overridden
    final def notToBeOverridden() = println("Do not override")
    //this method with "final" keyword cannot be overridden by sub class
  }

  class Cat extends Animal{
    override val creatureType: String = "Wild cat"
    def catLegs: Unit ={
      legs
      println("Cat legs : 4")
    }
    override def eat(): Unit = println("cat eat")
    println(creatureType)
 }

  class Dog(override val creatureType: String) extends Animal{
    override def eat(): Unit = {
      super.eat()
      println("Dog eat")
    }
    println(creatureType)
  }
  //val cat = new Cat
  //cat.eat
  //cat.catLegs

  val dog = new Dog("Domestic")
  dog.eat
  println(dog.creatureType)

  //constructors
  class Person (name: String , age : Int){
    def this(name: String) = this(name, 0)//auxiliary constructor
  }

  class Mary(name : String, age: Int, idCard: String) extends Person(name, age)
  class John(name: String) extends Person(name)

  //super : used when we want to reference method/field from parent class
  //preventing override:
  // 1 - Use final keyword on member -  method/field  or on class
  //2 - Seal the class : class can be extended in this file only , not in other files
}

