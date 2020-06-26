/*
 * Copyright 2020 HM Revenue & Customs
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

package uk.gov.hmrc.customsexportscodelists.models

import play.api.Logger
import play.api.libs.json.Json

case class AuthorisationCode(value: String)

object AuthorisationCode {
  private val logger = Logger(this.getClass)

  def apply(data: List[String]): AuthorisationCode = data match {
    case code :: Nil => AuthorisationCode(code)
    case error =>
      logger.warn("Incorrect data: " + error)
      throw new IllegalArgumentException("Authorisation codes file has incorrect structure")
  }

  implicit val format = Json.format[AuthorisationCode]
}
