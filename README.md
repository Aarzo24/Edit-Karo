# Edit Karo

## Project Objective

The "Edit Karo" project aims to create a user-friendly mobile app for capturing and editing photos. Users can take new pictures or choose from their gallery, apply various filters and cropping tools, and save the enhanced images back to the gallery for easy sharing and storage.

## App Description and Functionality

"Edit Karo" simplifies photo editing with a range of powerful tools in a sleek, intuitive interface. Users can:

- **Capture or Select Images**: Use the camera or gallery to choose photos for editing.
- **Crop Images**: Adjust dimensions by zooming and confirming with a tick mark.
- **Apply Filters**: Choose from a variety of filters, apply them, and save the edited image to the gallery.

## Challenges

During development, several challenges were addressed:

- **Package Compatibility**: Resolved issues with outdated filter packages by updating or replacing them to ensure compatibility with new device operating systems.
- **Interface Integration**: Fine-tuned the transition between capturing and editing images, and optimized real-time processing to avoid lag.
- **Compilation Errors**: Addressed code compilation issues through systematic debugging and resolution of dependency conflicts.
- **Bug Fixing**: Identified and fixed unexpected bugs through extensive testing and iterative improvements.

These challenges were overcome with persistence and thorough problem-solving to deliver a robust, user-friendly photo editing app.

## Deployment

To deploy and run the "Edit Karo" app, follow these steps:

### Prerequisites

- For Android: [Android Studio](https://developer.android.com/studio)
- For iOS: [Xcode](https://developer.apple.com/xcode/)

### Clone the Repository

```bash
git clone https://github.com/your-username/edit-karo.git
cd edit-karo

## Deployment

To deploy and run the "Edit Karo" app, follow these steps:

### Configure the Project

1. **Environment Variables**:
   - Copy the `.env.example` file to a new file named `.env`.
   - Update the `.env` file with your specific environment variables and API keys.

### Build the App

- **For Android**:
  ```bash
  npx react-native run-android

