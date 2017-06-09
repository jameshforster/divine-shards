package items.tools.time

import app.ModItems
import effects.Time
import items.DivineShard
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.text.TextComponentString
import net.minecraft.util.{ActionResult, EnumActionResult, EnumHand}
import net.minecraft.world.World

import collection.JavaConverters._

/**
  * Created by james-forster on 08/06/17.
  */
class GemOfTime extends DivineShard {
  setUnlocalizedName("gem_of_time")
  setMaxDamage(1)

  override def onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult[ItemStack] = {
    val item = playerIn.getHeldItem(handIn)

    worldIn.loadedEntityList.asScala.foreach {
      case e: EntityLivingBase if e.getName != playerIn.getName => Time.stopTime(e, 60)
      case _ =>
    }
    playerIn.sendMessage(new TextComponentString("Time has been frozen for 60 seconds."))
    inflictDamage(item, playerIn, Some(new ItemStack(ModItems.shardOfTime)))

    new ActionResult[ItemStack](EnumActionResult.PASS, item)
  }
}
