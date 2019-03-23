class Token(typeOf: TokenType, lexeme: String, literal: AnyRef, line: Int) {

    override def toString: String = {
        typeOf + " " + lexeme + " " + literal
    }
}
