import scala.io.StdIn.readInt
import scala.io.StdIn.readLine
import scala.collection.immutable.ListMap

object MyApp extends App {

  // *******************************************************************************************************************
  // Application Logic

  // Load predefined data from data.sc
  val f1Data: Map[Int, List[(String, Float, Int)]] = Map(
    2023 -> List(("Max Verstappen", 575.0f, 19), ("Sergio Perez", 285.0f, 2), ("Lewis Hamilton", 234.0f, 0), ("Fernando Alonso", 206.0f, 0), ("Charles Leclerc", 206.0f, 0), ("Lando Norris", 205.0f, 0), ("Carlos Sainz", 200.0f, 1), ("George Russell", 175.0f, 0), ("Oscar Piastri", 97.0f, 0), ("Lance Stroll", 74.0f, 0), ("Pierre Gasly", 62.0f, 0), ("Esteban Ocon", 58.0f, 0), ("Alexander Albon", 27.0f, 0), ("Yuki Tsunoda", 17.0f, 0), ("Valtteri Bottas", 10.0f, 0), ("Nico Hulkenberg", 9.0f, 0), ("Daniel Ricciardo", 6.0f, 0), ("Guanyu Zhou", 6.0f, 0), ("Kevin Magnussen", 3.0f, 0), ("Liam Lawson", 2.0f, 0), ("Logan Sargeant", 1.0f, 0), ("Nyck de Vries", 0.0f, 0)),
    2022 -> List(("Max Verstappen", 454.0f, 15), ("Charles Leclerc", 308.0f, 3), ("Sergio Perez", 305.0f, 2), ("George Russell", 275.0f, 1), ("Carlos Sainz", 246.0f, 1), ("Lewis Hamilton", 240.0f, 0), ("Lando Norris", 122.0f, 0), ("Esteban Ocon", 92.0f, 0), ("Fernando Alonso", 81.0f, 0), ("Valtteri Bottas", 49.0f, 0), ("Daniel Ricciardo", 37.0f, 0), ("Sebastian Vettel", 37.0f, 0), ("Kevin Magnussen", 25.0f, 0), ("Pierre Gasly", 23.0f, 0), ("Lance Stroll", 18.0f, 0), ("Mick Schumacher", 12.0f, 0), ("Yuki Tsunoda", 12.0f, 0), ("Guanyu Zhou", 6.0f, 0), ("Alexander Albon", 4.0f, 0), ("Nicholas Latifi", 2.0f, 0), ("Nyck de Vries", 2.0f, 0), ("Nico Hulkenberg", 0.0f, 0)),
    2021 -> List(("Max Verstappen", 395.5f, 10), ("Lewis Hamilton", 387.5f, 8), ("Valtteri Bottas", 226.0f, 1), ("Sergio Perez", 190.0f, 1), ("Carlos Sainz", 164.5f, 0), ("Lando Norris", 160.0f, 0), ("Charles Leclerc", 159.0f, 0), ("Daniel Ricciardo", 115.0f, 1), ("Pierre Gasly", 110.0f, 0), ("Fernando Alonso", 81.0f, 0), ("Esteban Ocon", 74.0f, 1), ("Sebastian Vettel", 43.0f, 0), ("Lance Stroll", 34.0f, 0), ("Yuki Tsunoda", 32.0f, 0), ("George Russell", 16.0f, 0), ("Kimi Raikkonen", 10.0f, 0), ("Nicholas Latifi", 7.0f, 0), ("Antonio Giovinazzi", 3.0f, 0), ("Mick Schumacher", 0.0f, 0), ("Robert Kubica", 0.0f, 0), ("Nikita Mazepin", 0.0f, 0)),
    2020 -> List(("Lewis Hamilton", 347.0f, 11), ("Valtteri Bottas", 223.0f, 2), ("Max Verstappen", 214.0f, 2), ("Sergio Perez", 125.0f, 1), ("Daniel Ricciardo", 119.0f, 0), ("Carlos Sainz", 105.0f, 0), ("Alexander Albon", 105.0f, 0), ("Charles Leclerc", 98.0f, 0), ("Lando Norris", 97.0f, 0), ("Pierre Gaslym", 75.0f, 1), ("Lance Stroll", 75.0f, 0), ("Esteban Ocon", 62.0f, 0), ("Sebastian Vettel", 33.0f, 0), ("Daniil Kvyat", 32.0f, 0), ("Nico Hulkenberg", 10.0f, 0), ("Kimi Raikkonen", 4.0f, 0), ("Antonio Giovinazzi", 4.0f, 0), ("George Russell", 3.0f, 0), ("Romain Grosjean", 2.0f, 0), ("Kevin Magnussen", 1.0f, 0), ("Nicholas Latifi", 0.0f, 0), ("Jack Aitken", 0.0f, 0), ("Pietro Fittipaldi", 0.0f, 0)),
    2019 -> List(("Lewis Hamilton", 413.0f, 11), ("Valtteri Bottas", 326.0f, 4), ("Max Verstappen", 278.0f, 3), ("Charles Leclerc", 264.0f, 2), ("Sebastian Vettel", 240.0f, 1), ("Carlos Sainz", 96.0f, 0), ("Pierre Gasly", 95.0f, 0), ("Alexander Albon", 92.0f, 0), ("Daniel Ricciardo", 54.0f, 0), ("Sergio Perez", 52.0f, 0), ("Lando Norris", 49.0f, 0), ("Kimi Raikkonen", 43.0f, 0), ("Daniil Kvyat", 37.0f, 0), ("Nico Hulkenberg", 37.0f, 0), ("Lance Stroll", 21.0f, 0), ("Kevin Magnussen", 20.0f, 0), ("Antonio Giovinazzi", 14.0f, 0), ("Romain Grosjean", 8.0f, 0), ("Robert Kubica", 1.0f, 0), ("George Russell", 0.0f, 0)),
    2018 -> List(("Lewis Hamilton", 408.0f, 11), ("Sebastian Vettel", 320.0f, 5), ("Kimi Raikkonen", 251.0f, 1), ("Max Verstappen", 249.0f, 2), ("Valtteri Bottas", 247.0f, 0), ("Daniel Ricciardo", 170.0f, 2), ("Nico Hulkenberg", 69.0f, 0), ("Sergio Perez", 62.0f, 0), ("Kevin Magnussen", 56.0f, 0), ("Carlos Sainz", 53.0f, 0), ("Fernando Alonso", 50.0f, 0), ("Esteban Ocon", 49.0f, 0), ("Charles Leclerc", 39.0f, 0), ("Romain Grosjean", 37.0f, 0), ("Pierre Gasly", 29.0f, 0), ("Stoffel Vandoorne", 12.0f, 0), ("Marcus Ericsson", 9.0f, 0), ("Lance Stroll", 6.0f, 0), ("Brendon Hartley", 4.0f, 0), ("Sergey Sirotkin", 1.0f, 0)),
    2017 -> List(("Lewis Hamilton", 363.0f, 9), ("Sebastian Vettel", 317.0f, 5), ("Valtteri Bottas", 305.0f, 3), ("Kimi Raikkonen", 205.0f, 0), ("Daniel Ricciardo", 200.0f, 1), ("Max Verstappen", 168.0f, 2), ("Sergio Perez", 100.0f, 0), ("Esteban Ocon", 87.0f, 0), ("Carlos Sainz", 54.0f, 0), ("Nico Hulkenberg", 43.0f, 0), ("Felipe Massa", 43.0f, 0), ("Lance Stroll", 40.0f, 0), ("Romain Grosjean", 28.0f, 0), ("Kevin Magnussen", 19.0f, 0), ("Fernando Alonso", 17.0f, 0), ("Stoffel Vandoorne", 13.0f, 0), ("Jolyon Palmer", 8.0f, 0), ("Pascal Wehrlein", 5.0f, 0), ("Daniil Kvyat", 5.0f, 0), ("Marcus Ericsson", 0.0f, 0), ("Pierre Gasly", 0.0f, 0), ("Antonio Giovinazzi", 0.0f, 0), ("Brendon Hartley", 0.0f, 0), ("Jenson Button", 0.0f, 0), ("Paul di Resta", 0.0f, 0))
  )


  // Define menu options as a Map of actions
  val actionMap = Map[Int, () => Boolean](
    1 -> handleWinners,
    2 -> handleSeasonResults,
    3 -> handleTotalRaces,
    4 -> handleAveragePoints,
    5 -> handleTotalPointsSorted,
    6 -> handleDriverPoints,
    7 -> handleQuit
  )

  // Loop to read input and invoke menu option
  var opt = readOption
  while (menu(opt)) {
    opt = readOption
  }


  // *******************************************************************************************************************
  // FUNCTIONS FOR MENU

  // Shows menu and reads input
  def readOption: Int = {
    println(
      """|Please select one of the following:
         |  1 - Get winners for all seasons
         |  2 - Get results for a specific season
         |  3 - Get total number of races per season
         |  4 - Get average points per season
         |  5 - Get total points per season (sorted)
         |  6 - Get total points for a driver
         |  7 - Quit""".stripMargin)
    readInt()
  }

  // Invokes selected menu option
  def menu(option: Int): Boolean = {
    actionMap.get(option) match {
      case Some(f) => f()
      case None =>
        println("Sorry, that command is not recognized.")
        true
    }
  }

  // handlers for menu options


  def handleWinners(): Boolean = {
    mnuShowWinners(getWinners)
    true
  }

  def handleSeasonResults(): Boolean = {
    mnuShowSeasonResults(getSeasonResults)
    true
  }

  def handleTotalRaces(): Boolean = {
    mnuShowRaces(getTotalRaces)
    true
  }

  def handleAveragePoints(): Boolean = {
    mnuShowAverages(getAveragePoints)
    true
  }

  def handleTotalPointsSorted(): Boolean = {
    mnuShowSortedPoints(getTotalPointsSorted)
    true
  }

  def handleDriverPoints(): Boolean = {
    mnuShowDriverPoints(getDriverPoints)
    true
  }

  def handleQuit(): Boolean = {
    println("Exiting application...")
    false
  }

  // menu interactions

  def mnuShowWinners(f: () => Map[Int, (String, Float, Int)]): Unit = {
    f() foreach { case (year, (name, points, wins)) =>
      println(s"$year: $name - $points points, $wins wins")
    }
  }

  def mnuShowSeasonResults(f: Int => Option[List[(String, Float, Int)]]): Unit = {
    print("Enter year: ")
    val year = readInt()
    f(year) match {
      case Some(results) =>
        results.foreach { case (name, points, wins) =>
          println(s"$name - $points points, $wins wins")
        }
      case None => println(s"No data for year $year")
    }
  }

  def mnuShowRaces(f: () => Map[Int, Int]): Unit = {
    f() foreach { case (year, races) =>
      println(s"$year: $races races")
    }
  }

  def mnuShowAverages(f: () => Map[Int, Float]): Unit = {
    f() foreach { case (year, avg) =>
      println(f"$year: $avg%.2f average points")
    }
  }

  def mnuShowSortedPoints(f: () => List[(Int, Float)]): Unit = {
    f() foreach { case (year, total) =>
      println(f"$year: $total%.2f total points")
    }
  }

  def mnuShowDriverPoints(f: String => Float): Unit = {
    print("Enter driver name: ")
    val name = readLine()
    println(s"Total points for $name: ${f(name)}")
  }


  // OPERATION FUNCTIONS

  def getWinners(): Map[Int, (String, Float, Int)] = {
    f1Data.map { case (year, drivers) => year -> drivers.head }
  }

  def getSeasonResults(year: Int): Option[List[(String, Float, Int)]] = {
    f1Data.get(year)
  }

  def getTotalRaces(): Map[Int, Int] = {
    f1Data.map { case (year, drivers) => year -> drivers.map(_._3).sum }
  }

  def getAveragePoints(): Map[Int, Float] = {
    f1Data.map { case (year, drivers) => year -> (drivers.map(_._2).sum / drivers.size) }
  }

  def getTotalPointsSorted(): List[(Int, Float)] = {
    f1Data.map { case (year, drivers) => year -> drivers.map(_._2).sum }.toList.sortBy(_._2)
  }

  def getDriverPoints(name: String): Float = {
    f1Data.values.flatten.filter(_._1.contains(name)).map(_._2).sum
  }
}
