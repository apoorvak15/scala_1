package exercises

abstract class GenericMyList[+A] {
  def head : A
  def tail : GenericMyList[A]
  def isEmpty : Boolean
  def add[B >: A](element : B) : GenericMyList[B]
  def printElements : String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer : MyTransformer[A,B]) : GenericMyList[B] //for this method, we are using -A
  //def flatMap[B](transformer : MyTransformer[A,B]) : GenericMyList[B]
  def filter(predicate: MyPredicate[A]) : GenericMyList[A]
}
case object Empty1 extends GenericMyList[Nothing]{
  override def head: Nothing = throw new NoSuchElementException

  override def tail: GenericMyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element : B): GenericMyList[B] = new Cons1(element, Empty1)

  override def printElements: String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): GenericMyList[B] = Empty1

  //override def flatMap[B](trasnformer: MyTransformer[Nothing, B]): GenericMyList[B] = Empty1

  override def filter(predicate: MyPredicate[Nothing]): GenericMyList[Nothing] = Empty1
}

case class Cons1[+A](h : A, t: GenericMyList[A]) extends GenericMyList[A]{
  def head: A = h

  def tail: GenericMyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element : B): GenericMyList[B] = new Cons1(element, this)

  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  override def map[B](transformer: MyTransformer[A, B]): GenericMyList[B] = new Cons1(transformer.transform(h),t.map(transformer))

  //override def flatMap[B](trasnformer: MyTransformer[A, B]): GenericMyList[B] = ???

  override def filter(predicate: MyPredicate[A]): GenericMyList[A] = {
    if (predicate.test(h)) new Cons1[A](h, t.filter(predicate))
    else t.filter(predicate)
  }
}

trait MyPredicate[-T]{
  def test(element : T) : Boolean
}

trait MyTransformer [-A, B]{
  def transform(element : A ) : B
}


object ListTest1 extends App{
  /*val list : GenericMyList[String] = new Cons1("A1",new Cons1("A2",Empty1))
  println(list.tail.head)
  println(list.add("A4").head)
  println(list.toString)*/
  val listOfInt : GenericMyList[Int] = new Cons1[Int](1,new Cons1[Int](2,new Cons1[Int](3,Empty1)))
  println(listOfInt.toString)
  println(listOfInt.map(new MyTransformer[Int,Int] {
    override def transform(element: Int): Int = element * 2
  }))

  println(listOfInt.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = if (element % 2 == 0) true else false
  }))
}