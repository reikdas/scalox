import java.nio.file.{Files, Paths}
import java.nio.charset.Charset

class Lox {

    var hadError: Boolean = false

    def main(args: Array[String]) = {
        if (args.length > 1) {
            println("Usage: scalox [script]")
            System.exit(64)
        } else if (args.length == 1) {
            runFile(args(0))
        } else {
            runPrompt()
        }
    }

    private def runFile(path: String) = {
        val bytes = Files.readAllBytes(Paths.get(path))
        run(new String(bytes, Charset.defaultCharset()))
    }

    private def runPrompt() = {
         while (true) {
            print(" > ")
            run(scala.io.StdIn.readLine())
             hadError = false
        }
    }

    private def run(source: String) = {
        if (hadError) System.exit(65)

        val scanner: Scanner = new Scanner(source)
        val tokens = scanner.scanTokens()

        for (token <- tokens) {
            println(token)
        }
    }

    def error(line: Int, message: String) = {
        report(line, "", message)
    }

    private def report(line: Int, where: String, message: String) = {
        println("[line " + line + "] Error" + where + ": " + message)
        hadError = true
    }



}