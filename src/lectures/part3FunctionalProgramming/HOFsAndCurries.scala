package lectures.part3FunctionalProgramming

object HOFsAndCurries extends App {
  // a function that take another function as parameter or returns another function as result is called as higher order function
  //eg: map, flatMap from whatsAFunctionExc

  //function that applies function n times over x

  def nTimes(f: Int => Int, n: Int, x: Int) : Int =
    if (n <= 0) x
    else nTimes(f , n-1 , f(x))

  val plusOne  = (x: Int) => x + 1

  println(nTimes(plusOne, 3 ,1))

  //nTimesBetter : not understood lecture 26

  //curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  //function with multiple parameter list
  def curriedFormatter(c: String)(x: Double) : String = c.format(x)
  val standardFormat : (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat : (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  //exercises 2 & 3 video 27

  def toCurry (f : (Int, Int) => Int) : (Int => Int => Int) =
    x => y => f (x , y)

  def fromCurry (f : (Int => Int => Int)) : (Int, Int) => Int =
    (x, y) => f(x)(y)

//  def compose (f : (Int) => Int, g : Int => Int) : Int => Int =
//    x => f(g(x))
//
//  def andThen(f : (Int) => Int, g : Int => Int) : Int => Int =
//    x => g(f(x))

  def compose [A,B,T] (f : A => B , g : T => A) : T => B =
    x => f(g(x))

  def andThen [A,B,C] (f : A => B , g: B=> C) : A => C =
    x => g(f(x))

  def superAdder2  : (Int => Int => Int) = toCurry(_ + _)
  def add4 = superAdder2(4)
  println(add4(17))

  def simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4,17))

  val add2 = (x: Int) => x + 2
  val times3 = (x : Int) => x* 3

  val composed  = compose(add2,times3)
  val ordered = andThen(add2,times3)

  println(composed(4))
  println(ordered(4))
}

