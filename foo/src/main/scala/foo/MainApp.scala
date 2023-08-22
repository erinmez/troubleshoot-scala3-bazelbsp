package foo

import zio.*
import zio.Console.*

object MainApp extends ZIOAppDefault:
  def run = myAppLogic
  val myAppLogic =
    for {
      _    <- printLine("Hello World")
    } yield ()