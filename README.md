# UserListApplication

UserListApplication is a simple Android application that fetches and displays a list of users from a remote API. The app uses Retrofit for networking, ViewModel for managing UI-related data, and LiveData for observing data changes. The project follows the MVVM architecture to ensure separation of concerns, making the code more modular, testable, and maintainable.

## Features

- Fetches a list of users from a remote API.
- Displays the list of users in a simple UI.
- Handles network errors gracefully.

## Libraries Used

- **Retrofit**: A type-safe HTTP client for Android and Java.
  - `com.squareup.retrofit2:retrofit:2.9.0`
  - `com.squareup.retrofit2:converter-gson:2.9.0`
- **AndroidX Lifecycle**: ViewModel and LiveData components for managing UI-related data in a lifecycle-conscious way.
  - `androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0`
  - `androidx.lifecycle:lifecycle-livedata-ktx:2.4.0`
- **Kotlin Coroutines**: For asynchronous programming.
  - `org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2`
  - `org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2`
  - `org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2`
- **Mockito**: For mocking dependencies in tests.
  - `org.mockito:mockito-core:3.9.0`
  - `org.mockito:mockito-inline:3.9.0`
  - `org.mockito:mockito-junit-jupiter:3.9.0`
- **JUnit**: For unit testing.
  - `junit:junit:4.13.2`
- **Retrofit Mock**: For creating mock implementations of Retrofit services.
  - `com.squareup.retrofit2:retrofit-mock:2.9.0`
- **AndroidX Test**: For testing LiveData and other Android components.
  - `androidx.arch.core:core-testing:2.1.0`

## Project Structure

The project follows the MVVM architecture, ensuring a clear separation of concerns:

- `ui` package: Contains UI-related classes such as `UserListFragment` and `UserListViewModel`.
- `data` package: Contains data models like `User`, `Address`, `Company`, and `Geo`.
- `network` package: Contains networking-related classes such as `UserWebService` and `RetrofitProvider`.

## Thought Process

### Architecture

The project uses the MVVM (Model-View-ViewModel) architecture, which helps to separate the UI logic from the business logic. This separation makes the code more modular and testable.

- **Model**: Represents the data layer of the application. In this project, the data models include `User`, `Address`, `Company`, and `Geo`.
- **View**: Represents the UI layer. In this project, it includes `UserListFragment`, which displays the list of users.
- **ViewModel**: Manages the UI-related data in a lifecycle-conscious way. In this project, `UserListViewModel` fetches the user data from the network and exposes it via LiveData.

### Networking

Retrofit is used for networking because it is a type-safe HTTP client that simplifies the process of making network requests and handling responses. Gson is used as the converter to parse JSON responses.

### Concurrency

Kotlin Coroutines are used to handle asynchronous operations. The `liveData` builder is used in the ViewModel to fetch data in a background thread and emit it to the UI thread.

### Testing

Testing is a crucial part of the development process. The project includes unit tests for the ViewModel using Mockito for mocking dependencies and Retrofit Mock for simulating network responses. The tests verify that the ViewModel correctly handles successful responses, failed responses, and network failures.

## Getting Started

### Prerequisites

- Android Studio
- Gradle

### Running the Project

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/UserListApplication.git
   ```
2. Open the project in Android Studio.
3. Sync the project with Gradle files.
4. Run the project on an emulator or physical device.

### Running Tests

To run the unit tests, use the following command in Android Studio:

```sh
./gradlew test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
