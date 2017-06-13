package materials

import net.minecraft.init.SoundEvents
import net.minecraft.item.ItemArmor
import net.minecraftforge.common.util.EnumHelper

/**
  * Created by james-forster on 13/06/17.
  */
object DivineMaterial {

  val spaceArmour: ItemArmor.ArmorMaterial =
    EnumHelper.addArmorMaterial("SPACE_ARMOUR", "space_armour", 16, Array(3, 8, 6, 3), 0,SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F)
}
