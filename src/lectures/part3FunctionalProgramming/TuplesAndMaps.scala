package lectures.part3FunctionalProgramming

object TuplesAndMaps extends App {
  //tuple : finite ordered lists
  val aTuple = Tuple2(2, "Hello, Scala")
  val anotherTuple = (2, 1.1, "Hi")
  println(aTuple._2)
  println(aTuple.copy(_2 = "Bye"))
  println(aTuple.swap)

  //maps : associate keys with values
  val aMap : Map[String,Int] = Map()
  val phonebook = Map(("Apoorva",111),("Abhi" -> 456),("ABHI" -> 123)).withDefaultValue(-1)
  //a -> b is syntactic sugar for (a,b)
  println(phonebook)
  //map ops
  println(phonebook.contains("Abhi"))
  println(phonebook("Apoorva"))
  println(phonebook("xxc"))

  //add a pairing
  val newPairing = "New" -> 444
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  //functions on map - map, flatMap, filter
  println("***" + phonebook.map(pair => pair._1.toLowerCase() -> pair._2))

  //filterKeys
  println(newPhonebook.filterKeys(x => x.startsWith("A")))

  //mapValues
  println(phonebook.mapValues(num => "020-" + num))

  //conversion to other collections
  println(phonebook.toList)
  println(List(("Dan",333)).toMap)

  val names = List("Asd","Awe","Vbb", "Bvf","Vsd")
  println(names.groupBy(name => name.charAt(0)))
}
