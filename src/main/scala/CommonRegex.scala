package com.github.everpeace.commonregex

object CommonRegex {
  def apply() = new CommonRegex(None)
  def apply(text:String) = new CommonRegex(Option(text))

  val time = caseIgnore("""(0?[0-9]|1[0-2]):[0-5][0-9](am|pm)|([01]?[0-9]|2[0-3]):[0-5][0-9]""").r
  val ip = """((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)""".r
  val phone = """\d?[^\s\w]*(?:\(?\d{3}\)?\W*)?\d{3}\W*\d{4}""".r
  val link = """((?:https?:\/\/|www\d{0,3}[.]|[a-z0-9.\-]+[.][a-z]{2,4}\/)(?:[^\s()<>]+|\((?:[^\s()<>]+|(?:\([^\s()<>]+\)))*\))+(?:\((?:[^\s()<>]+|(?:\([^\s()<>]+\)))*\)|[^\s`!()\[\]{};:\'".,<>?\xab\xbb\u201c\u201d\u2018\u2019]))""".r
  val date = (group(any(List(_day+"""\s+(?:of\s+)?"""+_month, _month+"""\s+"""+_day))) + """(?:\,)?\s*""" + opt(_year) + """|[0-3]?\d[-/][0-3]?\d[-/]\d{2,4}""").r
  val email = """[a-z0-9!#$%&'*+/=?^_`{|}~-]+@([a-z0-9]+\.)+([a-z0-9]+)""".r

  private lazy val _month = caseIgnore("""(?:jan\.?|january|feb\.?|february|mar\.?|march|apr\.?|april|may|jun\.?|june|jul\.?|july|aug\.?|august|sep\.?|september|oct\.?|october|nov\.?|november|dec\.?|december)""")
  private lazy val _day = caseIgnore("""[0-3]?\d(?:st|nd|rd|th)?""")
  private lazy val _year = """\d{4}"""
  def caseIgnore(regex:String) = """(?i)(""" + regex + """)"""
  def opt(regex:String) = """(?:""" + regex + """)?"""
  def group(regex:String) = """(?:""" + regex + """)"""
  def any(regexs:Seq[String]) = regexs.mkString("|")
}


class CommonRegex(val text:Option[String]){
  import CommonRegex._

  //  ∘ == map
  lazy val _dates  = text map (date.findAllIn(_).toSeq)
  lazy val _times  = text map (time.findAllIn(_).toSeq)
  lazy val _phones = text map (phone.findAllIn(_).toSeq)
  lazy val _links  = text map (link.findAllIn(_).toSeq)
  lazy val _emails = text map (email.findAllIn(_).toSeq)
  lazy val _ips    = text map (ip.findAllIn(_).toSeq)


  def dates  = _dates  getOrElse Seq.empty
  def times  = _times  getOrElse Seq.empty
  def phones = _phones getOrElse Seq.empty
  def links  = _links  getOrElse Seq.empty
  def emails = _emails getOrElse Seq.empty
  def ips    = _ips    getOrElse Seq.empty

}

