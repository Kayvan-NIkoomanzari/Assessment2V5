This is an Android application developed for Assignment 2 NIT3213 and makes an API call to get a random subject in my case invesment.
 my APP shows financial entities such as stocks, bonds, ETFs, cryptocurrencies, real estate, commodities, and mutual funds.
 The app integrates with a RESTful API to fetch and display data.
## Features
 User authentication through a login screen.
- A dashboard that displays various financial entities.
- Navigation to a details screen to view descriptions and additional information about each entity.
- Unit tests for dashboard ViewModel

## Technologies Used
**Programming Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **Libraries**:
  - Android Jetpack (ViewModel, LiveData, Navigation)
  - Retrofit for network calls
  - MockK for unit testing
  - Hilt for dependency injection
  - Coroutine for asynchronous programming.
## Architecture
The app follows the MVVM architecture pattern, where:
- **Model**: Represents the data layer, including API data and database interactions.
- **ViewModel**: Manages UI-related data in a lifecycle-conscious way and communicates with the model.
- **View**: Represents the UI components, including activities and fragments.

git clone https://github.com/Kayvan-NIkoomanzari/Assessment2V5.git
User Name: Kayvan
Password: s4674575
