package com.example.trashhack.functions

public fun removespaces(inp: String) : String {
    return inp.replace(" ", "")
}

public fun onlyprefixspace(inp: String) : String {
    return " ".plus(inp.replace(" ", ""))
}