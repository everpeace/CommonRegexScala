package com.github.everpeace.commonregex

import org.scalatest.FunSpec

class CommonRegexSpec extends FunSpec {

  val text =
    """
      |John, please get that article
      |on www.linkedin.com or https://google.com or 192.67.23.222
      |to me by 5:00PM on Jan 9th 2012 or 4:00 am on 01/09/12
      |would be ideal, actually. If you have any questions,
      |you can reach my associate at
      |(012)-345-6789 or 1 230 241 2422 or associative@mail.com.
    """.stripMargin

  val ips = Seq("192.67.23.222")
  val phones = Seq("(012)-345-6789","1 230 241 2422")
  val times = Seq("5:00PM","4:00 am")
  val links = Seq("www.linkedin.com","https://google.com")
  val dates = Seq("Jan 9th 2012","01/09/12")
  val emails = Seq("associative@mail.com")

  describe("CommonRegex"){
    it("should provide ip regex."){
      assert(CommonRegex.ip.findAllIn(text).toSeq === ips)
    }

    it("should provide phone regex."){
      assert(CommonRegex.phone.findAllIn(text).toSeq === phones)
    }

    it("should provide time regex."){
      assert(CommonRegex.time.findAllIn(text).toSeq === times)
    }

    it("should provide link regex."){
      assert(CommonRegex.link.findAllIn(text).toSeq === links)
    }

    it("should provide date regex."){
      assert(CommonRegex.date.findAllIn(text).toSeq === dates)
    }

    it("should provide email regex."){
      assert(CommonRegex.email.findAllIn(text).toSeq === emails)
    }

    it("should be able to extract ips from given text.") {
      assert(CommonRegex(text).ips === ips)
    }

    it("should be able to extract phones from given text.") {
      assert(CommonRegex(text).phones === phones)
    }

    it("should be able to extract times from given text.") {
      assert(CommonRegex(text).times === times)
    }

    it("should be able to extract links from given text.") {
      assert(CommonRegex(text).links === links)
    }

    it("should be able to extract dates from given text.") {
      assert(CommonRegex(text).dates === dates)
    }

    it("should be able to extract emails from given text.") {
      assert(CommonRegex(text).emails === emails)
    }
  }
}

