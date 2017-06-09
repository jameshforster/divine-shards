package app

import items.ModItem
import items.shards._
import items.tools.time.{GemOfTime, ScepterOfTime, WandOfTime}
import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.GameRegistry

/**
  * Created by james-forster on 07/06/17.
  */
object ModItems {

  //Shards
  val shardOfTime = new TimeShard
  val shardOfSpace = new SpaceShard
  val shardOfSpirit = new SpiritShard
  val shardOfPower = new PowerShard
  val shardOfKnowledge = new KnowledgeShard
  val shardOfVoid = new VoidShard

  val shards = Seq(shardOfTime, shardOfKnowledge, shardOfPower, shardOfSpace, shardOfSpirit, shardOfVoid)

  //Time Items
  val scepterOfTime = new ScepterOfTime
  val wandOfTime = new WandOfTime
  val gemOfTime = new GemOfTime

  val timeItems = Seq(scepterOfTime, wandOfTime, gemOfTime)

  val seq: Seq[ModItem] = shards ++ timeItems

  def init(): Unit = {
    seq.foreach(item => GameRegistry.register[Item](item))
  }
}
