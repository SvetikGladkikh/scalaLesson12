package collection

/**
 * Заполнить массив заданной длины произвольными положительными числами.
 * Провести анализ списка и найти все числа, которые делятся на два, делятся на три и делятся и на два, и на три.
 * При срабатывании условия выводить соответствующую запись в консоль.
 * Фильтрацию сделать двумя способами:
 * 1) паттерн-матчинг
 * 2) filter
 * */

object CollectionIssueOne{
  def main(args: Array[String]): Unit = {
    val count = 10 //Integer.parseInt(args(0))
    val r = scala.util.Random
    val nums = for (i <- 1 to count) yield r.nextInt(100)

    println(nums)

    println(nums.filter(x => x % 2 == 0 && x % 3 != 0))
    println(nums.filter(x => x % 3 == 0 && x % 2 != 0))
    println(nums.filter(x => x % 6 == 0))

    nums.collect( {
      case x if x % 6 == 0 => println(x + " % " + 3 + " && " + x + " % " + 2)
      case x if x % 2 == 0 => println(x + " % " + 2)
      case x if x % 3 == 0 => println(x + " % " + 3)
    })


  }
}
