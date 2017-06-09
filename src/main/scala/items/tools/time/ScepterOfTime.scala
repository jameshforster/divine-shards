package items.tools.time

import app.ModItems
import entities.EntityTime
import items.DivineShard
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.util.{ActionResult, EnumActionResult, EnumHand}
import net.minecraft.world.World

/**
  * Created by james-forster on 07/06/17.
  */
class ScepterOfTime extends DivineShard {
  bFull3D = true
  setUnlocalizedName("scepter_of_time")
  setMaxDamage(25)

  override def onItemRightClick(worldIn: World, playerIn: EntityPlayer, handIn: EnumHand): ActionResult[ItemStack] = {
    val direction = playerIn.getLookVec
    val shot = EntityTime(worldIn, playerIn, 1, 1, 1)
    val item = playerIn.getHeldItem(handIn)

    shot.setPosition(direction.xCoord, direction.yCoord, direction.zCoord)
    worldIn.spawnEntity(shot)
    inflictDamage(item, playerIn, Some(new ItemStack(ModItems.shardOfTime)))

    new ActionResult[ItemStack](EnumActionResult.PASS, item)
  }
}
