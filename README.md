# Behavioral Profile App Using Compose Multiplatform

In my MBA, I was having a class about Leadership skills and the teacher asked us to do this test where you have to select
a word from a selection of four words, each word has letter A, B, C and D, you select the word by selecting the letter, you have seven seconds to write the letter.<br>
The test shows 25 groups of four words and in the end, you count how many of each letter you selected. Each letter represent an animal: Dolphin, Shark, Eagle and Wolf.  

I've found this test very interesting and because I wanted to learn more about Compose Multiplatform(CMP), that's I decided to write this project. 

To better understand CMP, I've first wrote the App using Compose for Android, that's the code in the main branch and then I created a branch called cmp, where I've changed the code to also work for iOS. The idea with this is to understand how many things I would have to change if I had another project using Compose for Android and wanted to change to use CMP.

## Platforms

Currenlty, just Android and iOS, but I plan in the future to add Desktop and Web.


## Tech Stack & Libraries

### Dependency Injection
- **Koin**
  - `io.insert-koin:koin-core`
  - `io.insert-koin:koin-android`

### Date & Time
- **kotlinx-datetime**
- **kotlinx-serialization-json**

### Local Storage
- **Room**
  - `androidx.room:room-compiler`
  - `androidx.room:room-runtime`

- **SQLite**
  - `androidx.sqlite:sqlite-bundled`

### Coroutines & Flow
- **kotlinx-coroutines-core**

### Architecture
- **MVVM** pattern
- **Kotlinx Serialization** for JSON parsing
- **Kotlinx DateTime** for date handling

## Demo

Android and iOS are using the Dark and Light Mode.

|<image width="322" alt="" src="https://github.com/user-attachments/assets/238c06bb-bb97-4b1f-8147-cf2037328cb4">|
|<image width="322" alt="" src="https://github.com/user-attachments/assets/c719fc69-3eae-4c8d-8813-5435dd45104d">|
|<image width="322" alt="" src="https://github.com/user-attachments/assets/d6ce1549-980e-4aa9-819d-1cba6beac128">|
|<image width="322" alt="" src="https://github.com/user-attachments/assets/822fe889-f2d8-486c-9508-a2631d38ce14">|

|<video width="322" alt="Android" src="https://github.com/user-attachments/assets/7317f1f6-27e3-4643-bca2-171d2ac53ea0">|

