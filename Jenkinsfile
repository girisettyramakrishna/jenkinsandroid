pipeline {
    agent any

    environment {
        ANDROID_SDK_ROOT = "/home/psmadmin/Android/Sdk"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Setup local.properties') {
            steps {
                // create local.properties with SDK location
                sh 'echo sdk.dir=${ANDROID_SDK_ROOT} > local.properties'
            }
        }

        stage('Make Gradlew executable') {
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
                archiveArtifacts artifacts: 'app/build/outputs/apk/debug/*.apk', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed. Please check the logs.'
        }
    }
}
