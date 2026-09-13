package eg.tarek.pos.printer

import java.io.OutputStream

class EscPosPrinterService(private val outputStream: OutputStream) {

    // ESC/POS Commands
    private val ESC: Byte = 0x1B
    private val GS: Byte = 0x1D
    private val LF: Byte = 0x0A

    fun initPrinter() {
        outputStream.write(byteArrayOf(ESC, '@'.code.toByte()))
    }

    fun printText(text: String, bold: Boolean = false, alignCenter: Boolean = false) {
        if (alignCenter) {
            outputStream.write(byteArrayOf(ESC, 'a'.code.toByte(), 1)) // Center align
        } else {
            outputStream.write(byteArrayOf(ESC, 'a'.code.toByte(), 0)) // Left align
        }

        if (bold) {
            outputStream.write(byteArrayOf(ESC, 'E'.code.toByte(), 1))
        }

        outputStream.write(text.toByteArray(Charsets.UTF_8))
        outputStream.write(byteArrayOf(LF))

        if (bold) {
            outputStream.write(byteArrayOf(ESC, 'E'.code.toByte(), 0))
        }
    }

    fun cutPaper() {
        outputStream.write(byteArrayOf(GS, 'V'.code.toByte(), 66, 0))
    }
}
