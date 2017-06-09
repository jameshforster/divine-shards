package app

import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}

/**
  * Created by james-forster on 07/06/17.
  */
class ServerProxy extends Proxy {
  override def preInit(e: FMLPreInitializationEvent): Unit = super.preInit(e)

  override def init(e: FMLInitializationEvent): Unit = super.init(e)

  override def postInit(e: FMLPostInitializationEvent): Unit = super.postInit(e)
}
