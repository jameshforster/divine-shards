package events

import app.ModItems
import effects.Space
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

import collection.JavaConverters._

/**
  * Created by james-forster on 13/06/17.
  */
class OnAttackEventHandler {

  @SubscribeEvent
  def onLivingAttackEvent(e: LivingAttackEvent): Unit = {
    val victim = e.getEntityLiving
    val source = e.getSource.getEntity

    (victim, source) match {
      case (v: EntityPlayer, s: EntityLivingBase) if v.getArmorInventoryList.asScala.exists(_.getItem == ModItems.armourOfSpace) =>
        Space.defensiveWarp(v, s)
        v.getArmorInventoryList.asScala.find(_.getItem == ModItems.armourOfSpace).get.damageItem(25, v)
      case _ =>
    }
  }
}
