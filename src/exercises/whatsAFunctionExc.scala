package exercises

//whatsAFunction + HOF / curried functions
abstract class MyListFunc [+A] {
  def headFunc : A
  def tailFunc : MyListFunc[A]
  def isEmptyFunc : Boolean
  def addFunc[B >: A](element : B) : MyListFunc[B]
  def printElementsFunc : String
  override def toString: String = "[" + printElementsFunc + "]"

  //higher order functions
  def mapFunc[B] (transformer: A => B) : MyListFunc[B]
  def flatMapFunc[B] (transformer: A => MyListFunc[B] ) : MyListFunc[B]
  def filterFunc(predicate: A => Boolean) : MyListFunc[A]
  def ++ [B >: A] (list : MyListFunc[B]) : MyListFunc[B]

  //hof video27
  def foreach(f: A => Unit) : Unit
  def sort(f : (A,A) => Int) : MyListFunc[A]
  def zipWith[B,C](list: MyListFunc[B], zip : (A,B) => C) : MyListFunc[C]
  def fold[B](start : B)(operator : (B, A) => B) : B
}

case object EmptyFunc extends MyListFunc[Nothing]{
  override def headFunc: Nothing = throw new NoSuchElementException

  override def tailFunc: MyListFunc[Nothing] = throw new NoSuchElementException

  override def isEmptyFunc: Boolean = true

  override def addFunc[B >: Nothing](element: B): MyListFunc[B] = ConsFunc(element,EmptyFunc)

  override def printElementsFunc: String = ""

  override def mapFunc[B](transformer: Nothing => B): MyListFunc[B] = EmptyFunc

  override def flatMapFunc[B](transformer: Nothing => MyListFunc[B]): MyListFunc[B] = EmptyFunc

  override def filterFunc(predicate: Nothing => Boolean): MyListFunc[Nothing] = EmptyFunc

  override def ++[B >: Nothing](list: MyListFunc[B]): MyListFunc[B] = list

  override def foreach(f: Nothing => Unit): Unit = EmptyFunc

  override def sort(f: (Nothing, Nothing) => Int): MyListFunc[Nothing] = EmptyFunc

  override def zipWith[B, C](list: MyListFunc[B], zip: (Nothing, B) => C): MyListFunc[C] =
    if (! list.isEmptyFunc) throw new RuntimeException("Lists do not have the same lengths")
    else EmptyFunc

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class ConsFunc[+A] (h: A, t:MyListFunc[A]) extends MyListFunc[A] {
  override def headFunc: A = h

  override def tailFunc: MyListFunc[A] = t

  override def isEmptyFunc: Boolean = false

  override def addFunc[B >: A](element: B): MyListFunc[B] = new ConsFunc(element,this)

  override def printElementsFunc: String =  {
    if (t.isEmptyFunc) "" + h
    else h + " " + t.printElementsFunc
  }

  override def mapFunc[B](transformer: A => B): MyListFunc[B] = new ConsFunc[B](transformer(h), t.mapFunc(transformer))

  def ++ [B >: A] (list : MyListFunc[B]) : MyListFunc[B] = new ConsFunc[B](h , t ++ list)

  override def flatMapFunc[B](transformer: A => MyListFunc[B]): MyListFunc[B] = transformer(h) ++ t.flatMapFunc(transformer)

  override def filterFunc(predicate: A => Boolean): MyListFunc[A] = {
    if (predicate(h)) new ConsFunc(h, t.filterFunc(predicate))
    else t.filterFunc(predicate)
  }

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(f: (A, A) => Int): MyListFunc[A] = {

    def insert(x: A, sortedList: MyListFunc[A]) : MyListFunc[A] ={
      if (sortedList.isEmptyFunc) new ConsFunc(x,EmptyFunc)
      else if (f(x,sortedList.headFunc) <= 0) new ConsFunc(x, sortedList)
      else new ConsFunc(sortedList.headFunc, insert(x,sortedList.tailFunc))
    }
    val sortedTail = t.sort(f)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyListFunc[B], zip: (A, B) => C): MyListFunc[C] =
    if (list.isEmptyFunc) throw new RuntimeException("Lists do not have the same lengths.")
    else new ConsFunc[C](zip(h,list.headFunc), t.zipWith(list.tailFunc,zip))

  override def fold[B](start: B)(operator: (B, A) => B): B =
  //val newStart = operator(start,h)
    t.fold(operator(start, h)) (operator)

}


object whatsAFunctionExc extends App {

  val concat = new ((String,String) => String){
    override def apply(v1: String, v2: String): String = v1 + " " + v2
  }

  println(concat("Hello", "World"))

  //list testing

  val listOfIntegers : MyListFunc[Int] = new ConsFunc[Int](3, new ConsFunc[Int](2, new ConsFunc[Int](1, EmptyFunc)))
  val listOfAnotherIntegers : MyListFunc[Int] = new ConsFunc[Int](4, new ConsFunc[Int](5, EmptyFunc))
  val listOfStrings : MyListFunc[String] = new ConsFunc[String]("Hello" , new ConsFunc[String]("World", new ConsFunc[String]("!", EmptyFunc)))

  println(listOfIntegers.toString)
  println(listOfIntegers.mapFunc(new ((Int) => Int) {
    override def apply(v1: Int): Int = v1 * 2
  }).toString)

  //map function equivalent : anonymous or lambda function
   println(listOfIntegers.mapFunc(elem => elem * 2).toString)
  println(listOfIntegers.mapFunc(_ * 2).toString)

  println((listOfIntegers ++ listOfAnotherIntegers).toString)

  println(listOfIntegers.flatMapFunc(new ((Int) => MyListFunc[Int]) {
    override def apply(v1: Int): MyListFunc[Int] = new ConsFunc[Int](v1 , new ConsFunc[Int](v1 + 1, EmptyFunc))
  }).toString)
  //flatMapFunc equivalent
  println(listOfIntegers.flatMapFunc(elem => new ConsFunc(elem + 1, EmptyFunc)).toString)

  println(listOfIntegers.filterFunc(new ((Int) => Boolean) {
    override def apply(v1: Int): Boolean = {
      v1 % 2 == 0
    }
  }).toString)
//filterFunc : lambda equivalent
  println(listOfIntegers.filterFunc(_ % 2 == 0))

  //3rd exercise
  val superAdder = new Function[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function[Int,Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) //curried function

  //superAdder with lambda

  val superAdderLambda = (x: Int) => (y : Int) => x + y
  println(superAdderLambda(3)(4))


  //hofs
  println("hofs")
  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x,y) => x - y))
  println(listOfIntegers.zipWith[String,String](listOfStrings, _ + "-" + _))

  println(listOfIntegers.fold(0)(_ + _))
}
