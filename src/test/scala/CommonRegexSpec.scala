package commonregex

import org.scalatest.FunSpec

class CommonRegexSpec extends FunSpec {

  val text =
    """
      |John, please get that article
      |on www.linkedin.com or https://google.com or 192.67.23.222
      |to me by 5:00PM on Jan 9th 2012 or 4:00 am on 01/09/12
      |would be ideal, actually. If you have any questions,
      |you can reach my associate at
      |(012)-345-6789 or (230) 241 2422 or associative@mail.com.
    """.stripMargin

  val ips = List("192.67.23.222")
  val phones = List("(012)-345-6789","(230) 241 2422")
  val times = List("5:00PM","4:00 am")
  val links = List("www.linkedin.com","https://google.com")
  val dates = List("Jan 9th 2012","01/09/12")
  val emails = List("associative@mail.com")

  describe("CommonRegex"){
    it("should provide ip regex."){
      assert(CommonRegex.ip.findAllIn(text).toList === ips)
    }

    it("should provide phone regex."){
      assert(CommonRegex.phone.findAllIn(text).toList === phones)
    }

    it("should provide time regex."){
      assert(CommonRegex.time.findAllIn(text).toList === times)
    }

    it("should provide link regex."){
      assert(CommonRegex.link.findAllIn(text).toList === links)
    }

    it("should provide date regex."){
      assert(CommonRegex.date.findAllIn(text).toList === dates)
    }

    it("should provide email regex."){
      assert(CommonRegex.email.findAllIn(text).toList === emails)
    }

    it("should be able to extract ips from given text.") {
      assert(CommonRegex(text).ips.toList === ips)
    }

    it("should be able to extract phones from given text.") {
      assert(CommonRegex(text).phones.toList === phones)
    }

    it("should be able to extract times from given text.") {
      assert(CommonRegex(text).times.toList === times)
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

