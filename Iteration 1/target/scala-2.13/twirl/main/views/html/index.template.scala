
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main("Welcome to FreeLanceLot")/*2.33*/ {_display_(Seq[Any](format.raw/*2.35*/("""

        """),format.raw/*4.9*/("""<div class="input-group mb-3 mt-3">
            <input type="text" class="form-control" placeholder="Enter search terms" id="input" name="input">
            <div class="input-group-append">
                <button class="btn btn-primary" type="submit">Go!</button>
            </div>
        </div>
    """)))}),format.raw/*10.6*/("""

  
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 453134fe3435680e630d56ab5c2aed2d88608c8e
                  MATRIX: 989->2|1028->33|1067->35|1103->45|1438->350
                  LINES: 32->2|32->2|32->2|34->4|40->10
                  -- GENERATED --
              */
          