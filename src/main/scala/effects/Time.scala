package effects

import net.minecraft.entity.EntityLivingBase
import net.minecraft.potion.{Potion, PotionEffect}
import net.minecraft.util.text.TextComponentString

/**
  * Created by james-forster on 08/06/17.
  */
object Time {

  def stopTime(entity: EntityLivingBase, duration: Int): Unit = {
    entity.addPotionEffect(new PotionEffect(Potion.getPotionById(15), duration))
    entity.addPotionEffect(new PotionEffect(Potion.getPotionById(2), duration, 127))
    entity.addPotionEffect(new PotionEffect(Potion.getPotionById(8), duration, -1))
    entity.addPotionEffect(new PotionEffect(Potion.getPotionById(11), duration, 5))
    entity.sendMessage(new TextComponentString(s"You have been frozen in time for $duration seconds!"))
  }

  def restoreState(entity: EntityLivingBase): Unit = {
    entity.heal(250)
    entity.clearActivePotions()
    entity.sendMessage(new TextComponentString("You have been restored to a previous state."))
  }
}
