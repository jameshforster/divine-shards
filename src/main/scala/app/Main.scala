package app

import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.{Mod, SidedProxy}

/**
  * Created by james-forster on 07/06/17.
  */

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
object Main {

  val MODID = "Divine_Shards"
  val MODNAME = "Divine Shards"
  val VERSION = "0.1.0"

  @EventHandler
  def init(event: FMLInitializationEvent): Unit = {

  }

  def preInit(e: FMLPreInitializationEvent): Unit = {
    proxy.preInit(e)
  }

  @SidedProxy(clientSide = "ClientProxy", serverSide = "ServerProxy")
  var proxy: Proxy = _
}
