package items

import app.Main
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.{Item, ItemStack}

/**
  * Created by james-forster on 07/06/17.
  */

trait ModItem extends Item {
  final val tab = new CreativeTabs("Divine Shards") {
    override def getTabIconItem: Item = Items.DIAMOND
  }
  setRegistryName(Main.MODID)
  setCreativeTab(tab)
}

trait DivineShard extends ModItem {

  def inflictDamage(item: ItemStack, player: EntityPlayer, remnants: Option[ItemStack] = None): Unit = {
    item.damageItem(1, player)
    if (item.getItemDamage >= item.getMaxDamage) {
      item.shrink(1)
      remnants.map {item => player.inventory.addItemStackToInventory(item)}
    }
  }

  maxStackSize = 1
}
