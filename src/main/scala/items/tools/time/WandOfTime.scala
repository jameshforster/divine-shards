package items.tools.time

import app.ModItems
import effects.Time
import items.DivineShard
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.item.ItemStack
import net.minecraft.util.text.TextComponentString
import net.minecraft.util.{ActionResult, EnumActionResult, EnumHand}
import net.minecraft.world.World

/**
  * Created by james-forster on 08/06/17.
  */
class WandOfTime extends DivineShard {
  bFull3D = true
  setUnlocalizedName("wand_of_time")
  setMaxDamage(10)

  override def onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult[ItemStack] = {
    val item = playerIn.getHeldItem(handIn)

    Time.restoreState(playerIn)
    inflictDamage(item, playerIn, Some(new ItemStack(ModItems.shardOfTime)))

    new ActionResult[ItemStack](EnumActionResult.PASS, item)
  }

  override def onLeftClickEntity(stack: ItemStack, player: EntityPlayer, entity: Entity): Boolean = {
    entity match {
      case e: EntityLivingBase =>
        Time.restoreState(e)
        inflictDamage(player.getHeldItem(EnumHand.MAIN_HAND), player, Some(new ItemStack(ModItems.shardOfTime)))
        player.sendMessage(new TextComponentString(s"Restored ${entity.getName} to original state."))
      case _ =>
        player.sendMessage(new TextComponentString("The entity cannot be restored."))
    }

    true
  }
}
