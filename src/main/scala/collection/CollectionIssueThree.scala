package collection

/**
 * Считать из файла hdata_stock.csv данные в буфер
 * Преобразовать считанные данные в Tuple5
 * Вывести построчно в консоль считанные полученный результат
 */

object CollectionIssueThree {

  def toDouble(s: String): Option[Double] = {
    try{
      Some(s.toDouble)
    } catch {
      case e: NumberFormatException => None
    }
  }

  def main(args: Array[String]): Unit = {

    val bufferedSource = io.Source.fromFile("E:/Web/gs-rest-service-master/scala-example-for-school-one/hdata_stock.csv")

    val list_prices = bufferedSource.getLines().map(_.split(";").map(_.trim)).collect( _ match {
      case Array(a, b, c, d, e) => (a, b, c, d, e)
    })

    var result: (Double, Double, Double, Double) = (0.0, 0.0, 0.0, 0.0)
    var count  = 0
    var names: (String, String, String, String) = ("", "", "", "")

    list_prices.foreach(y => {
      if (count == 0)
        names = (y._2.split(":").last, y._3.split(":").last, y._4.split(":").last, y._5.split(":").last);
      else
        result = (result._1 + toDouble(y._2).getOrElse(0.0), result._2 + toDouble(y._3).getOrElse(0.0), result._3 + toDouble(y._4).getOrElse(0.0), result._4 + toDouble(y._5).getOrElse(0.0))

      count += 1
    })

    count -= 1
    result = if (count > 0) (result._1/count, result._2/count, result._3/count, result._4/count) else (0.0,0.0,0.0,0.0)

    println(s"${names._1}: ${result._1};\n${names._2}: ${result._2};\n${names._3}: ${result._3};\n${names._4}: ${result._4}.")
  }
}
