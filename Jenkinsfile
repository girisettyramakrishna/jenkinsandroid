pipeline {
    agent any

    environment {
        ANDROID_HOME = "/home/ubuntu/android-sdk"
        PATH = "${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:${PATH}"
    }

    stages {
        stage('Clean') {
            steps {
                sh 'echo "Cleaning workspace..."'
            }
        }

        stage('Build Debug APK') {
            steps {
                sh './gradlew assembleDebug'
            }
        }

        stage('Archive APK') {
            steps {
                archiveArtifacts artifacts: 'app/build/outputs/apk/debug/*.apk', allowEmptyArchive: true
            }
        }
    }

    post {
        failure {
            echo 'Build failed!'
        }
    }
}
