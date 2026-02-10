# Nearby - Food Delivery 📍

Nearby is a benefits club application that allows users to find nearby establishments, view them on an interactive map, and redeem discount coupons by scanning QR Codes.

![App Screenshots](image/map-readme.png)

## ✨ Features

- 🗺️ **Interactive Map**: View partner establishments on a Google Maps map
- 📍 **Location**: Find establishments near your location
- 🏷️ **Categories**: Filter establishments by categories (Food, Cinema, Shopping, etc.)
- 🎟️ **Coupons**: View available coupons at each establishment
- 📱 **QR Code Scanner**: Scan QR Codes to redeem discount coupons
- 📋 **Details**: See detailed information about each establishment (address, phone, rules)

## 🛠️ Technologies Used

- **Kotlin** - Programming language
- **Jetpack Compose** - Modern and declarative UI
- **Google Maps Compose** - Maps integration
- **Ktor** - HTTP client for API communication
- **Kotlin Serialization** - Data serialization
- **Navigation Compose** - Screen navigation
- **Coil** - Image loading
- **ZXing** - QR Code reading
- **Material Design 3** - Design system

## 🚀 How to Run the Project

### 📋 Prerequisites

- **Node.js** (version 18 or higher) - For the backend
- **Android Studio** (latest version) - For mobile
- **JDK 11 or higher**
- **Android SDK** (API 24 or higher)
- **Android Device** or **Emulator** configured

---

## 🖥️ Backend (API)

The backend is a REST API developed with Node.js, Express, and Prisma.

### Running the Backend

1. **Navigate to the backend folder**
   ```bash
   cd backend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Configure the database**
   ```bash
   npx prisma migrate dev
   npx prisma db seed
   ```

4. **Start the server**
   ```bash
   npm start
   ```

The server will be running at `http://localhost:3333`

---

## 📱 Mobile (Android App) - **MAIN FOCUS**

Android application developed with Kotlin and Jetpack Compose.

### Step by Step

1. **Clone the repository**
   ```bash
   git clone https://github.com/thomascostta/nearby-food.git
   cd nearby-food
   ```

2. **Open the Mobile project in Android Studio**
   - Open Android Studio
   - Select "Open an Existing Project"
   - Navigate to the `mobile/` folder and select it
   - Wait for Gradle synchronization

3. **Configure the Google Maps API** ⚠️ **IMPORTANT**
   
   The application requires a Google Maps API key:
   
   **a) Get the key:**
   - Access the [Google Cloud Console](https://console.cloud.google.com/)
   - Create a new project or select an existing one
   - Enable **Maps SDK for Android**
   - Go to **Credentials** → **Create Credentials** → **API Key**
   - Copy the generated key
   
   **b) Configure in the project:**
   - Open `mobile/app/src/main/AndroidManifest.xml`
   - Locate `com.google.android.geo.API_KEY`
   - Replace `YOUR_GOOGLE_MAPS_API_KEY_HERE` with your key:
     ```xml
     <meta-data
         android:name="com.google.android.geo.API_KEY"
         android:value="YOUR_KEY_HERE" />
     ```
   
4. **Configure Backend connection**
   
   **For Android Emulator:**
   - Open `mobile/app/src/main/java/com/thomascosta/nearby/core/network/NearbyRemoteDataSource.kt`
   - Make sure `BASE_URL = LOCAL_HOST_EMULATOR_BASE_URL`
   - The emulator uses `10.0.2.2` to access localhost
   
   **For Physical Device:**
   - Find your machine's IP:
     - Linux/Mac: `ifconfig` or `ip addr`
     - Windows: `ipconfig`
   - Open `NearbyRemoteDataSource.kt` and change:
     ```kotlin
     private const val LOCAL_HOST_PHYSICAL_BASE_URL = "http://YOUR_IP:3333"
     const val BASE_URL = LOCAL_HOST_PHYSICAL_BASE_URL
     ```
   - Make sure the device is on the same Wi-Fi network

5. **Run the application**
   - Connect an Android device via USB (with USB debugging enabled) **or**
   - Start an Android emulator
   - Click the "Run" button (▶️) in Android Studio or press `Shift + F10`

6. **Test the application**
   - Grant location and camera permissions when prompted
   - Explore establishments on the map
   - Test the QR Code scanner to redeem coupons

## 📱 Minimum Requirements

- Android 7.0 (API 24) or higher
- Internet connection
- Location permission (to view nearby establishments)
- Camera (to scan QR Codes)

## 🔒 Security

**WARNING**: This project contains settings that must be customized:

1. **Google Maps API Key**: 
   - Never commit your key to public repositories
   - Use API restrictions in Google Cloud Console
   - Limit usage only to the package `com.thomascosta.nearby`

2. **Backend Configuration**:
   - The backend `.env` file is not versioned
   - Adjust the `BASE_URL` in mobile according to your environment (emulator/physical device)

3. **Best practices**:
   - Keep sensitive files in `.gitignore`
   - Use environment variables for sensitive data in production
   - Configure appropriate restrictions on APIs used

## 📄 Project Structure

```
nearby-food/
├── backend/                   # REST API (Node.js + Express)
│   ├── prisma/               # Database schema and migrations
│   ├── src/
│   │   ├── controllers/      # API controllers
│   │   ├── routes/           # API routes
│   │   └── server.ts         # Main server
│   └── package.json
│
└── mobile/                   # Android Application (Kotlin)
    └── app/
        └── src/main/java/com/thomascosta/nearby/
            ├── core/network/         # HTTP Client (Ktor)
            ├── data/model/           # Data models
            ├── ui/
            │   ├── component/        # Reusable components
            │   ├── screen/           # App screens
            │   │   ├── home/         # Main screen with map
            │   │   ├── market_details/  # Establishment details
            │   │   ├── qrcode_scanner/  # QR Code scanner
            │   │   └── welcome/      # Welcome screen
            │   ├── route/            # Navigation
            │   └── theme/            # Theme and styles
            └── MainActivity.kt       # Main activity
```

## 📝 License

This project was developed for educational purposes.

---

Developed with ❤️ during **NLW Pocket Mobile Android** by **Rocketseat**
