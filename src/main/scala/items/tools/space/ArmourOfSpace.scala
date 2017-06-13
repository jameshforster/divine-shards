package items.tools.space

import items.{DivineShard, ModItem}
import materials.DivineMaterial
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemArmor

/**
  * Created by james-forster on 13/06/17.
  */
class ArmourOfSpace extends ItemArmor(DivineMaterial.spaceArmour, 3, EntityEquipmentSlot.CHEST) with DivineShard
