class Scanner(source: String) {

    var tokens: List[Token]
    private var start: Int = 0
    private var current: Int = 0
    private var line: Int = 1

    def scanTokens(): List[Token] = {
        while(!isAtEnd()) {
            start = current
            scanToken()
        }

        tokens :+ new Token(EOF, "", null, line)
        tokens
    }

    private def isAtEnd(): Boolean = {
        current >= source.length
    }

}
