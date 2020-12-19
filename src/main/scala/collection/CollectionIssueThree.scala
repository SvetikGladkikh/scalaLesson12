package collection

/**
 * Считать из файла hdata_stock.csv данные в буфер
 * Преобразовать считанные данные в Tuple5
 * Вывести построчно в консоль считанные полученный результат
 */

object CollectionIssueThree {

  def main(args: Array[String]): Unit = {

    val bufferedSource = io.Source.fromFile("../hdata_stock.csv")

    val list_prices = ???

    list_prices.foreach(y => {
      println(y)
    })

    bufferedSource.close

  }
}
