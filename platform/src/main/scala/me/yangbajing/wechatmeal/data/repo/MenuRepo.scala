package me.yangbajing.wechatmeal.data.repo

import java.time.LocalDate
import javax.inject.{Inject, Singleton}

import me.yangbajing.wechatmeal.data.driver.MyDriver.api._
import me.yangbajing.wechatmeal.data.model.Menu

import scala.concurrent.{ExecutionContext, Future}

/**
 * 菜单
 * Created by Yang Jing (yangbajing@gmail.com) on 2015-08-19.
 */
@Singleton
class MenuRepo @Inject()(schemas: Schemas) {

  import schemas._

  def findCurrentMenu()(implicit ec: ExecutionContext): Future[Option[Menu]] = {
    db.run(tMenu.filter(_.date === LocalDate.now()).result).map(_.headOption)
  }
}