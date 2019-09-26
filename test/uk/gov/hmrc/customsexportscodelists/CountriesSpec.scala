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

package uk.gov.hmrc.customsexportscodelists

import org.scalatest.{MustMatchers, WordSpec}
import uk.gov.hmrc.customsexportscodelists.Countries.allCountries

class CountriesSpec extends WordSpec with MustMatchers {

  "Countries" should {

    "return all countries with codes in alphabetical order of country name" in {
      val sortedCountries = allCountries.sortBy(_.countryName)

      allCountries mustBe sortedCountries
    }

    "return the correct amount of countries" in {
      val expectedAmount = 245

      allCountries.length mustBe expectedAmount
    }

    "return list of countries with both country name and country code" in {

      val expectedList = allCountries.filter(c => c.countryName.isEmpty || c.countryCode.isEmpty)
      expectedList must be(empty)
    }
  }
}
