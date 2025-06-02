pipeline {
    agent any

    environment {
        ANDROID_HOME = "/home/ubuntu/android-sdk"
        JAVA_HOME = "/usr/lib/jvm/java-11-openjdk-amd64"
        GRADLE_HOME = "/opt/gradle/gradle-8.5"
        PATH = "${PATH}:${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:${JAVA_HOME}/bin:${GRADLE_HOME}/bin"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                sh './gradlew clean'
            }
        }

        stage('Build Debug APK') {
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
        failure {
            echo 'Build failed!'
        }
        success {
            echo 'Build succeeded!'
        }
    }
}
