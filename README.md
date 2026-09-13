# Offline POS Engine for Android 🛒📱

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.0-purple.svg?logo=kotlin)](https://kotlinlang.org)
[![Android](https://img.shields.io/badge/Android-SDK%2024+-green.svg?logo=android)](https://developer.android.com)

**An offline-first Android architecture engine for Point-of-Sale (POS) and retail billing applications. Features local Room DB persistence, barcode indexing, offline order syncing, and ESC/POS thermal printer driver integration.**

Developed by **Tarek Mohamed** ([@seotarek](https://github.com/seotarek))

---

## 📌 Features

- 📶 **100% Offline-First:** Fast local barcode lookup and invoice generation without network dependencies.
- 📦 **Room DB Persistence:** Structured Product and Order entities with reactive Kotlin Flow support.
- 🖨️ **ESC/POS Thermal Printing:** Hardware-level ESC/POS byte command serializer for Bluetooth and USB 58mm/80mm receipt printers.
- 🔄 **Cloud Sync Queue:** Track unsynced transactions and push them automatically when connectivity resumes.

---

## 🚀 Quick Usage

### 1. Barcode Lookup:
```kotlin
val product = posDao.getProductByBarcode("6221234567890")
if (product != null) {
    cart.addItem(product)
}
```

### 2. Print Thermal Receipt:
```kotlin
val printer = EscPosPrinterService(bluetoothSocket.outputStream)
printer.initPrinter()
printer.printText("Store Receipt", bold = true, alignCenter = true)
printer.printText("Item A: 120.00 EGP")
printer.printText("Total: 120.00 EGP", bold = true)
printer.cutPaper()
```

---

## 📜 License
Licensed under the [MIT License](LICENSE).
