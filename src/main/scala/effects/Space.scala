package effects

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.util.text.TextComponentString
import net.minecraft.world.World

import scala.collection.JavaConverters._
import scala.util.Random

/**
  * Created by james-forster on 08/06/17.
  */
object Space {

  def spatialDisruption(player: EntityPlayer, world: World): Unit = {
    val source = player.getPosition
    val victims = world.getLoadedEntityList.asScala.filter(_.getPosition.distanceSq(source) < 25)

    def filterLivingEntity(f: EntityLivingBase => Unit): Entity => Unit = {
      case _: EntityLivingBase => f
      case _ =>
    }

    def triggerSpatialChaos(): Unit = {
      val spatialChaos: EntityLivingBase => Unit = { victim =>
        //TODO add spatial chaos mechanics
        victim.sendMessage(new TextComponentString("The space around you has become heavily distorted!"))
      }

      player.sendMessage(new TextComponentString("Space in the region has become heavily distorted."))
      victims.foreach(filterLivingEntity(spatialChaos))
    }

    def triggerAscend(): Unit = {
      val ascend: EntityLivingBase => Unit = { victim =>
          victim.setPosition(victim.posX, victim.posY + 30, victim.posZ)
          victim.sendMessage(new TextComponentString("You have been warped into the sky!"))
      }

      player.sendMessage(new TextComponentString("All living beings have been warped into the sky."))
      victims.foreach(filterLivingEntity(ascend))
    }

    def triggerScatter(): Unit = {
      val scatter: EntityLivingBase => Unit = { victim =>
          victim.attemptTeleport(victim.posX + Random.nextInt(50), victim.posY, victim.posZ + Random.nextInt(50))
          victim.sendMessage(new TextComponentString("You are warped away!"))
      }

      player.sendMessage(new TextComponentString("Space warps and scatters all living beings away."))
      victims.foreach(filterLivingEntity(scatter))
    }

    def triggerWarp(): Unit = {
      val warp: EntityLivingBase => Unit = { victim =>
        //TODO add warp mechanics
        victim.sendMessage(new TextComponentString("Space around you warps dangerously."))
      }

      player.sendMessage(new TextComponentString("Space in the area begins to collapse in on itself."))
      victims.foreach(filterLivingEntity(warp))
    }

    Random.nextInt(100) match {
      case 99 => triggerWarp()
      case n if n > 89 => triggerAscend()
      case n if n > 44 => triggerScatter()
      case _ => triggerSpatialChaos()
    }
  }
}
