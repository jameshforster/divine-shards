package entities

import effects.Time
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.projectile.EntitySmallFireball
import net.minecraft.util.math.RayTraceResult
import net.minecraft.util.text.TextComponentString
import net.minecraft.world.World

/**
  * Created by james-forster on 07/06/17.
  */
case class EntityTime(worldIn: World, shooter: EntityLivingBase, accelX: Double, accelY: Double, accelZ: Double)
  extends EntitySmallFireball(worldIn, shooter, accelX, accelY, accelZ) {

  override def onImpact(result: RayTraceResult): Unit = {
    Option {
      result.entityHit
    } match {
      case Some(entity: EntityLivingBase) =>
        Time.stopTime(entity, 30)
        shooter.sendMessage(new TextComponentString(s"You have frozen ${entity.getName} in time for 30 seconds."))
      case _ =>
        shooter.sendMessage(new TextComponentString("The target is unaffected by the freezing of time."))
    }
  }
}
