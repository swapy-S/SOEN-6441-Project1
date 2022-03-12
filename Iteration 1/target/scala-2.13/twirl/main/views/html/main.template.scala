
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html lang="en">
<head>
    <meta charset="utf-8">
    <title>"""),_display_(/*6.13*/title),format.raw/*6.18*/("""</title>
    <link rel="stylesheet" media="screen" href='"""),_display_(/*7.50*/routes/*7.56*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*7.106*/("""'>
</head>

<body>
<div class="containe3r-fluid">
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="/">
            <img src='"""),_display_(/*14.24*/routes/*14.30*/.Assets.versioned("images/logo.webp")),format.raw/*14.67*/("""'
                 width="200" height="200" class="d-inline-block align-top" alt="">
        </a>
    </nav>
    """),_display_(/*18.6*/content),format.raw/*18.13*/("""
"""),format.raw/*19.1*/("""</div>
</body>
</html>"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: f60881ee8182f846e6187c7314e78e7c841d6727
                  MATRIX: 911->1|1035->32|1062->33|1151->96|1176->101|1260->159|1274->165|1345->215|1534->377|1549->383|1607->420|1747->534|1775->541|1803->542
                  LINES: 27->1|32->2|33->3|36->6|36->6|37->7|37->7|37->7|44->14|44->14|44->14|48->18|48->18|49->19
                  -- GENERATED --
              */
          