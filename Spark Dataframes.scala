import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.util


object s_baba {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("query").setMaster("local[2]").set("spark.executor.memory", "1g");
    val sc = new SparkContext("local[2]", "PbSpark")
    val sqlContext = new SQLContext(sc)
    val tweets = sqlContext.jsonFile("C:\\Users\\Sai\\Desktop\\tweetsphase2.json")
    tweets.registerTempTable("table2")
    val tempo = sqlContext.sql("select text,id from table2")
    tempo.show(false)
    tempo.save("dataframe1", "json")
    sc.stop()
  }
}
