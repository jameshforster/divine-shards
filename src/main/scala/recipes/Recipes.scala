package recipes

import app.ModItems
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.registry.GameRegistry

/**
  * Created by james-forster on 07/06/17.
  */
object Recipes {

  def init(): Unit = {
    initTimeRecipes()
    initSpaceRecipes()
  }

  def initTimeRecipes(): Unit = {
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.scepterOfTime), Items.BLAZE_ROD, ModItems.shardOfTime)
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.wandOfTime), Items.STICK, ModItems.shardOfTime)
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gemOfTime), Items.EMERALD, ModItems.shardOfTime)
  }

  def initSpaceRecipes(): Unit = {
    GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gemOfSpace), Items.EMERALD, ModItems.shardOfSpace)
  }
}
