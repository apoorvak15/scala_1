package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, favouriteMovie : String){
    def likes(movie : String) : Boolean = movie == favouriteMovie
    def hangoutWith(person: Person) = s"${this.name} hangouts with ${person.name}"
    def unary_! : String = s"$name, Hi" //prefix notations
    def isAlive : Boolean = true //postfix notation
    def apply() : String = s"Hi, my name is $name and I like $favouriteMovie"
  }

  val apoorva = new Person("Apoorva" , "XYZ")
  println(apoorva.likes("XYZ"))
  println(apoorva likes "XYZ") //both if these statements are same
  //this is called as infix notation = operator notation = syntactic sugar

  //"operators" in scala
  val abhiraj = new Person("Abhiraj", "ABC")
  println(apoorva hangoutWith abhiraj)
  //we can rename hangoutWith method with +, in scala + is not reserved for methods
  //hence following 2 statements are equivalent
  println(1 + 2)
  println(1.+(2))
  //ALL OPERATORS ARE METHODS


  //prefix notations - with unary operators - another example of syntactic sugar
  //following statements are equivalent
  val x = -1 //here - is unary operator
  val y = 1.unary_-
  //unary operators are methods with unary_*prefix* , works only with + - ~ !
  println(!apoorva) //check method defined in the class called : unary_!

  //postfix notation
  //function without parameter can be used a postfix notation
  println(apoorva.isAlive)
  println(apoorva isAlive)
  //both of the above statements are equivalent

  //apply : method
  println(apoorva.apply())
  println(apoorva())
  //both of the above statements are equivalent
}

