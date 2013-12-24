CommonRegexScala
=============

[CommonRegex](https://github.com/madisonmay/CommonRegex/ "CommonRegex") port for Scala

Find all `times`, `dates`, `links`, `phones`, and `emails` in a string. 

Pull requests welcome!

Please note that this is currently English/US specific.

Examples and Usage
========
    scala> import com.github.everpeace.commonregex._
    import com.github.everpeace.commonregex._
    scala> val text = """
      |John, please get that article
      |on www.linkedin.com or https://google.com or 192.67.23.222
      |to me by 5:00PM on Jan 9th 2012 or 4:00 am on 01/09/12
      |would be ideal, actually. If you have any questions,
      |you can reach my associate at
      |(012)-345-6789 or 1 230 241 2422 or associative@mail.com.
    """.stripMargin
    
    scala> val commonRegex = CommonRegex(text)
    commonRegex: com.github.everpeace.commonregex.CommonRegex = com.github.everpeace.commonregex.CommonRegex@4ad7f3e3

    scala> commonRegex.phones
    res0: Seq[String] = Stream((012)-345-6789, 230 241 2422)
    
    scala> commonRegex.phones.toList
    res1: List[String] = List((012)-345-6789, 230 241 2422)
    
    scala> commonRegex.times
    res2: Seq[String] = Stream(5:00PM, ?)
    
    scala> commonRegex.times.toList
    res3: List[String] = List(5:00PM, 4:00)
    
    scala> commonRegex.links
    res4: Seq[String] = Stream(www.linkedin.com, ?)
    
    scala> commonRegex.links.toList
    res5: List[String] = List(www.linkedin.com, https://google.com)
    
    scala> commonRegex.dates
    res6: Seq[String] = Stream(Jan 9th 2012, ?)
    
    scala> commonRegex.dates.toList
    res7: List[String] = List(Jan 9th 2012, 01/09/12)
    
    scala> commonRegex.emails
    res8: Seq[String] = Stream(associative@mail.com, ?)
    
    scala> commonRegex.emails.toList
    res9: List[String] = List(associative@mail.com)