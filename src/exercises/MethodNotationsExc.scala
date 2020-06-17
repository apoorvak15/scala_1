package exercises

object MethodNotationsExc extends App {
  class Person(val name: String, favouriteMovie : String, val age : Int = 0) {
    def + (nickName : String) : Person = new Person(s"${name} ($nickName)",favouriteMovie)

    def unary_+ : Person = new Person(name, favouriteMovie,age + 1)

    def learns(skill : String ) = s"$name learns $skill"
    def learnsScala : String = this learns "scala"
    //or def learnsScala : String = learns("scala")

    def apply () = s"Hi, my name is $name. My fav. movie is $favouriteMovie."
    def apply(numOfTimeMovieWatched : Int) : String = s"$name watched $favouriteMovie $numOfTimeMovieWatched time."
  }

  val apoorvaPerson = new Person("Apoorva", "XYZ")
  //either
  val personWithNickName = apoorvaPerson + "rock star"
  println("Nick name: " + personWithNickName.name)
  //or
  println((apoorvaPerson + "rock star").apply())

  //either
  val incAgePerson : Person = +apoorvaPerson
  println("Incremented age : " + incAgePerson.age)
  //or
  println((+apoorvaPerson).age)

  println(apoorvaPerson learnsScala)

  println(apoorvaPerson(20))
}
