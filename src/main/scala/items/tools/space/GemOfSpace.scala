package items.tools.space

import app.ModItems
import effects.Space
import items.DivineShard
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.{ActionResult, EnumActionResult, EnumHand}
import net.minecraft.world.World

/**
  * Created by james-forster on 09/06/17.
  */
class GemOfSpace extends DivineShard {
  setUnlocalizedName("gem_of_space")
  setMaxDamage(1)

  override def onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult[ItemStack] = {
    val item = playerIn.getHeldItem(handIn)

    Space.spatialDisruption(playerIn, worldIn)
    inflictDamage(item, playerIn, Some(new ItemStack(ModItems.shardOfSpace)))

    new ActionResult[ItemStack](EnumActionResult.PASS, item)
  }
}
