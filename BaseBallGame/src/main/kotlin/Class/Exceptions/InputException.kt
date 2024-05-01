package org.example.Class.Exception

open class InputException(message: String): Exception(message)

class NumberException:InputException("!!!올바르지 않은 값입니다.\n")
class LengthException:InputException("!!!올바르지 않은 길이입니다.\n")
class ZeroException:InputException("!!!가장 앞에 0이 있습니다.\n")
class EqualException:InputException("!!!같은 숫자는 생성되지 않습니다.\n")
