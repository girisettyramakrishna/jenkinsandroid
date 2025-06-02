pipeline {
    agent any
    environment {
        ANDROID_HOME = "/path/to/android/sdk"
        JAVA_HOME = "/path/to/java"
        GRADLE_HOME = "/path/to/gradle"
    }
    stages {
        stage('Build') {
            steps {
                withEnv(["PATH=${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:${JAVA_HOME}/bin:${GRADLE_HOME}/bin:${env.PATH}"]) {
                    sh './gradlew assembleDebug'
                }
            }
        }
    }
}
