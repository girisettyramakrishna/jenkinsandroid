pipeline {
    agent any

    environment {
        ANDROID_HOME = "/opt/android-sdk"
        JAVA_HOME = "/usr/lib/jvm/java-11-openjdk-amd64"
        GRADLE_HOME = "/opt/gradle/gradle-8.0"
    }

    stages {
        stage('Build APK') {
            steps {
                withEnv([
                    "PATH=${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:${JAVA_HOME}/bin:${GRADLE_HOME}/bin:${env.PATH}"
                ]) {
                    sh './gradlew assembleDebug'
                }
            }
        }
    }
}
