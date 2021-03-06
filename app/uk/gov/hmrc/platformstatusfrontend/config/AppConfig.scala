/*
 * Copyright 2019 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.platformstatusfrontend.config

import javax.inject.{Inject, Singleton}
import play.api.Configuration
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig

@Singleton
class AppConfig @Inject()(config: Configuration, servicesConfig: ServicesConfig) {

  private val assetsUrl         = config.get[String]("assets.url")

  val assetsPrefix: String   = assetsUrl + config.get[String]("assets.version")
  val analyticsToken: String = config.get[String](s"google-analytics.token")
  val analyticsHost: String  = config.get[String](s"google-analytics.host")

  lazy val dbUrl = servicesConfig.getString("mongodb.uri")

  lazy val proxyProtocol: String = servicesConfig.getString("proxy.protocol")
  lazy val proxyHost: String = servicesConfig.getString("proxy.host")
  lazy val proxyPort: Integer = servicesConfig.getInt("proxy.port")
  lazy val proxyUsername: String = servicesConfig.getString("proxy.username")
  lazy val proxyPassword: String = servicesConfig.getString("proxy.password")
  lazy val proxyRequired: Boolean = servicesConfig.getBoolean("proxy.required")
}
