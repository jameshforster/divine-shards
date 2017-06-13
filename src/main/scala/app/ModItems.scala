package app

import items.ModItem
import items.shards._
import items.tools.space.{ArmourOfSpace, GemOfSpace}
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

  //Space Items
  val gemOfSpace = new GemOfSpace
  val armourOfSpace = new ArmourOfSpace

  val spaceItems = Seq(gemOfSpace, armourOfSpace)

  val seq: Seq[ModItem] = shards ++ timeItems ++ spaceItems

  def init(): Unit = {
    seq.foreach(item => GameRegistry.register[Item](item))
  }
}
