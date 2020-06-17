package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)
  //vals are immutable, you cannot do:: x=30

  val y = 40
  println(y)
  //compiler can infer data types.

  //semicolns are not necessary.

  //other data types:
  //boolean, char, int, short, long, float, double


  //variables : mutable
  var aVar : Int = 4
  aVar = 5 //side effect . Avoid using vars
}
