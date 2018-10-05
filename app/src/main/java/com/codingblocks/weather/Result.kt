package com.codingblocks.weather

import java.util.*

data class Result(
                  val list: ArrayList<Allvalue>? = null,
                  val city:cityvalue?=null)
data class Allvalue(
        val main:parameters?=null, val weather:ArrayList<cloud>?=null,
                   val wind :windvalue?=null,val dt_txt:String?=null)

data class parameters(val
    temp:Float,
    val temp_min:Float,
    val temp_max:Float,
    val pressure:Float,
    val sea_level:Float,
                      val grnd_level:Float,
                      val humidity:Int=0)
data class cloud(val main:String?=null,val description:String?=null,val icon:String?=null)
//data class cloudvalue(val all:Int=0)
data class windvalue(val speed:Float)
//data class sysvalue(val pod :String?=null)
data class cityvalue(val country:String?=null,val name:String)
