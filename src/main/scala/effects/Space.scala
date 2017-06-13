package effects

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.potion.{Potion, PotionEffect}
import net.minecraft.util.math.RayTraceResult
import net.minecraft.util.text.TextComponentString
import net.minecraft.world.World

import scala.collection.JavaConverters._
import scala.util.Random

/**
  * Created by james-forster on 08/06/17.
  */
object Space {

  class SpatialChaos extends Potion(true, 1) {
    override def isInstant: Boolean = false

    override def performEffect(entityLivingBaseIn: EntityLivingBase, p_76394_2_ : Int): Unit = {
      if (Random.nextInt(20) == 0) entityLivingBaseIn.attemptTeleport(entityLivingBaseIn.posX + Random.nextInt(25),
        entityLivingBaseIn.posY, entityLivingBaseIn.posZ + Random.nextInt(25))
    }
  }

  def spatialDisruption(player: EntityPlayer, world: World): Unit = {
    val source = player.getPosition
    val victims = world.getLoadedEntityList.asScala.filter(_.getPosition.distanceSq(source) < 25)

    def filterLivingEntity(f: EntityLivingBase => Unit): Entity => Unit = {
      case entity: EntityLivingBase if player.getName != entity.getName => f
      case _ =>
    }

    def triggerSpatialChaos(): Unit = {
      val spatialChaos: EntityLivingBase => Unit = { victim =>
        victim.addPotionEffect(new PotionEffect(new SpatialChaos, 30))
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

  def teleport(player: EntityPlayer, world: World): Unit = {
    val ray = world.rayTraceBlocks(player.getPositionVector, player.getLookVec)

    ray.typeOfHit match {
      case RayTraceResult.Type.ENTITY =>
        val entity = ray.entityHit
        player.attemptTeleport(entity.posX, entity.posY, entity.posZ)
      case RayTraceResult.Type.BLOCK =>
        val block = ray.getBlockPos
        player.attemptTeleport(block.getX, block.getY, block.getZ)
      case _ => player.sendMessage(new TextComponentString("Could not reach target."))
    }
  }

  def defensiveWarp(player: EntityPlayer, attacker: EntityLivingBase): Unit = {
    attacker.attemptTeleport(player.posX + Random.nextInt(50), player.posY, player.posZ + Random.nextInt(50))
    attacker.sendMessage(new TextComponentString("You are warped away!"))
  }
}
