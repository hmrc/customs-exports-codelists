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

package uk.gov.hmrc.customsexportscodelists.services

import com.github.tototoshi.csv.CSVReader
import uk.gov.hmrc.customsexportscodelists.models.AuthorisationCode

import scala.io.Source

class AuthorisationCodes {

  val allAuthorisationCodes: List[AuthorisationCode] = {
    val reader =
      CSVReader.open(Source.fromURL(getClass.getClassLoader.getResource("code-lists/holder-of-authorisation-codes.csv"), "UTF-8"))

    val errors: List[List[String]] = reader.all()

    errors.map(AuthorisationCode.apply)
  }
}
