import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.util

object sb4 {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[2]", "PbSpark")
    val sqlContext = new SQLContext(sc)
    val tweets = sqlContext.jsonFile("C:\\Users\\Sai\\Desktop\\tweetsphase2.json")
    tweets.registerTempTable("table2")
    val tweets1 = sqlContext.jsonFile("C:\\Users\\Sai\\Desktop\\hip.json")
    tweets.registerTempTable("table3")
    val tempo = sqlContext.sql("SELECT table2.id, table3.text FROM table2 FULL OUTER JOIN table3 ON table2.id=table3.id ORDER BY table2.id")
    tempo.take(100).foreach(println)
    tempo.save("dataframe23", "json")
    sc.stop()
  }
}
