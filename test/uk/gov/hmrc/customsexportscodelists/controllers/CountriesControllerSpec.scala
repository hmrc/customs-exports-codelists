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

package uk.gov.hmrc.customsexportscodelists.controllers

import play.api.libs.json.Json
import play.api.test.Helpers._
import uk.gov.hmrc.customsexportscodelists.base.ControllerSpec
import uk.gov.hmrc.customsexportscodelists.services.Countries

class CountriesControllerSpec extends ControllerSpec {

  private val countries = new Countries()
  private val controller = new CountriesController(countries, stubControllerComponents())

  "Authorisation Codes Controller" should {

    "return list of authorisation Codes" in {

      val result = controller.countryList()(getRequest())

      status(result) mustBe OK
      contentAsJson(result) mustBe Json.toJson(countries.allCountries)
    }
  }
}