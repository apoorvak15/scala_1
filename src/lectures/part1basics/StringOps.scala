package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala!"
  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ","-"))
  println(str.toUpperCase())
  println(str.length)

  //scala own utilities
  val aNumStr = "2"
  val iNum = aNumStr.toInt
  println('a' +: aNumStr :+ 'z') //prepending and appending operators
  println(str.reverse)
  println(str.take(2))

  //scala specific interpolator
  //S - Interpolator
  val name = "Apoorva"
  val age = 12
  val greeting = s"Hello, my name is $name and I am ${age + 1} years old."
  println(greeting)

  //F - Interpolator : can check type correctness
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute."
  println(myth)

  //raw - interpolator
  println(raw"This is a \n new line") //new line not added, as string is raw
  val escaped = "This is a \n new line"
  println(raw"$escaped") //new line is added, as string is in the form of variable : escaped
}
