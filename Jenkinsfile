pipeline {
    agent any

    environment {
        ANDROID_HOME = "/home/ubuntu/android-sdk"
        PATH+ANDROID = "${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/your-android-repo.git'
            }
        }

        stage('Set Permissions') {
            steps {
                sh 'chmod +x ./gradlew'
            }
        }

        stage('Build APK') {
            steps {
                sh './gradlew assembleDebug'
            }
        }

        stage('Archive APK') {
            steps {
                archiveArtifacts artifacts: '**/build/outputs/apk/debug/*.apk', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ APK build successful!'
        }
        failure {
            echo '❌ APK build failed.'
        }
    }
}
