# Coroutines Image Filter

A simple Android app that downloads an image and applies a grayscale filter using Kotlin Coroutines.

## What this project demonstrates

- Running network work on `Dispatchers.IO`
- Running CPU-heavy image processing on `Dispatchers.Default`
- Updating UI on `Dispatchers.Main`
- Using View Binding in an Android app

## Project info

- **App name:** `CoroutinesImageFilter`
- **Application ID:** `com.example.coroutinesimagefilter`
- **Min SDK:** `31`
- **Target SDK:** `36`
- **Compile SDK:** `36`
- **Language level:** Java `11`
- **Coroutines:** `kotlinx-coroutines-core:1.3.0`, `kotlinx-coroutines-android:1.3.0`

## How it works

`MainActivity` launches a coroutine on the main thread and:

1. Downloads an image from a remote URL on `Dispatchers.IO`
2. Applies a grayscale filter on `Dispatchers.Default`
3. Displays the filtered bitmap on screen

Image filtering logic is implemented in `app/src/main/java/com/example/coroutinesimagefilter/Filter.kt`.

## Run locally

### Android Studio

1. Open this folder in Android Studio
2. Let Gradle sync complete
3. Run the `app` configuration on an emulator or device

### Command line

```bash
cd /home/boay274145/AndroidStudioProjects/CoroutineIntro
./gradlew assembleDebug
```

The generated APK is typically placed under:
`app/build/outputs/apk/debug/`

## Tests

Run unit tests:

```bash
cd /home/boay274145/AndroidStudioProjects/CoroutineIntro
./gradlew testDebugUnitTest
```

Run instrumented tests (requires connected device/emulator):

```bash
cd /home/boay274145/AndroidStudioProjects/CoroutineIntro
./gradlew connectedDebugAndroidTest
```

## Notes

- The app needs internet access to download the sample image.
- The current implementation uses a fixed image URL in `MainActivity`.

