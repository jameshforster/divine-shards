package app

import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}

/**
  * Created by james-forster on 07/06/17.
  */
trait Proxy {
  def preInit(e: FMLPreInitializationEvent): Unit = {
    ModItems.init()
    ModRecipes.init()
  }
  def init(e: FMLInitializationEvent): Unit
  def postInit(e: FMLPostInitializationEvent): Unit
}
