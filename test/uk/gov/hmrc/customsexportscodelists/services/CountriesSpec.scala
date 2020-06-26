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

import org.scalatest.{MustMatchers, WordSpec}

class CountriesSpec extends WordSpec with MustMatchers {

  val countries = new Countries()

  "Countries" should {

    "return all countries with codes in alphabetical order of country name" in {
      val sortedCountries = countries.allCountries.sortBy(_.countryName)

      countries.allCountries mustBe sortedCountries
    }

    "return the correct amount of countries" in {
      val expectedAmount = 245

      countries.allCountries.length mustBe expectedAmount
    }

    "return list of countries with both country name and country code" in {

      val listWithMissingValue = countries.allCountries.filter(c => c.countryName.isEmpty || c.countryCode.isEmpty)
      listWithMissingValue must be(empty)
    }
  }
}
