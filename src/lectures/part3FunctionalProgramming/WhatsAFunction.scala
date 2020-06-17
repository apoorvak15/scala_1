package lectures.part3FunctionalProgramming

//objective is to be able to pass functions as parameters or return function as result
//we can do this with objects in Java
//hence we have turned ALL SCALA FUNCTIONS INTO OBJECTS
object WhatsAFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2)) // doubler which is an instance of function like class can be called like function


  //function types : Function1 ... Function22 = this will have 22 parameter and R (23rd)as result
  val StringToInt = new Function1 [String , Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(StringToInt("2") + 3)


  //using Function4
  val adder = new ((Int, Int, Int, Int) => Int) { // this definition is with syntactic sugar unlike definition of Function1 above
    override def apply(v1: Int, v2: Int, v3: Int, v4: Int): Int = v1 + v2 + v3 + v4
  }
  println(adder(1,2,3,4))
}

trait MyFunction[A, B] {
  def apply(element : A): B
}