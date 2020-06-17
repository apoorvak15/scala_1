package lectures.part3FunctionalProgramming

import scala.util.Random

//Options are used to avoid NullPointerExceptions
//or to deal with unsafe APIs
object Options extends App {
  val myFirstOption : Option[Int] = Some(4)
  val noOption : Option[Int] = None

  println(myFirstOption)

  def unSafeMethod() : String = null
  println(Option(unSafeMethod()))

  //chained methods
   def backupMethod() : String = "A valid result"
  val chainedResult = Option(unSafeMethod()).orElse(Option(backupMethod()))

  //Design unsafe APIS
  def betterUnsafeMethod() : Option[String] = None
  def betterBackupMethod() : Option[String] = Some("A valid result")
  val betterChainResult = betterUnsafeMethod() orElse betterBackupMethod()

  //functions on Option
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) //Unsafe

  //map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10)) //this will give None, as 4 does not match the predicate
  println(myFirstOption.flatMap(x => Option(x * 10)))

  //exercise
  val config: Map[String, String] = Map (
    "host" -> "176.10.12.0",
    "port" -> "80"
  )
  class Connection {
    def connect = "Connected"
  }
  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host : String, port : String) : Option[Connection] =
      if (random.nextBoolean()) Some(new Connection())
      else None
  }

    //try to establish connection
  //apply might or might not connect because we're not sure of credentials
  //Not able to understand
  //Video 33

}
