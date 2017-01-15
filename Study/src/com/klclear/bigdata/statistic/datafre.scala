package com.klclear.bigdata.statistic

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import java.text.SimpleDateFormat
import java.util.Calendar

object datafre {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
    conf.setAppName("statistic device data frequence") //设置应用程序的名称，在程序运行的监控界面可以看到名称  
    conf.setMaster("local") //此时程序在本地运行，无需安装Spark的任何集群  

    // $example on:init_session$
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .master("local")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    runJdbcDatasetExample(spark)

  }

  private def getTomorrow(currentDate:String): String = {
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val cal: Calendar = Calendar.getInstance()
    cal.add(Calendar.DATE, +1)
    val tomorrow = dateFormat.format(cal.getTime())
    tomorrow
  }
  
   def getNowMonthStart():String={
    var period:String=""
    var cal:Calendar =Calendar.getInstance();
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    cal.set(Calendar.DATE, 1)
    period=df.format(cal.getTime())//本月第一天
    period
  }

  private def runJdbcDatasetExample(spark: SparkSession): Unit = {
    // $example on:jdbc_dataset$

    val jdbcDF = spark.read
      .format("jdbc")
      //.option("url", "jdbc:mysql://114.55.227.111:3306")
      //.option("driver", "com.mysql.jdbc.Driver")
      .option("url", "jdbc:mysql://112.124.50.252:3306")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "bms_p2.volt_info_t37")
      .option("user", "root")
      //.option("password", "P@ss4test")
      .option("password", "iso26262")
      .load()

    println(getTomorrow("2016-11-23 00:00:00"))

    jdbcDF.printSchema()

    jdbcDF.createOrReplaceTempView("volt_info_t37")

    import java.text.SimpleDateFormat
    val sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss")
    //val fromDate = sdf.parse("2016-11-15 7:23:33")

    /*    val dataFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val startDate = dataFormat.format("2016-11-15")*/
    var fromDate = "2016-11-25 00:00:00";
    var toDate = "2016-11-30 00:00:00";
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    var date_temp = format.format(format.parse("2014-12-21 00:19:58Z"))
    println(date_temp)

    val sqlDF = spark.sql("SELECT * FROM volt_info_t37 where time_in > '2016-12-25 23:00:00' limit 1")
    sqlDF.show()
    //println(jdbcDF.col("device_id").toString())

    //jdbcDF.show()

    /*    val jdbcDF = spark.read
      .format("jdbc")
      .option("url", "jdbc:postgresql:dbserver")
      .option("dbtable", "schema.tablename")
      .option("user", "username")
      .option("password", "password")
      .load()*/
    // $example off:jdbc_dataset$
  }

}