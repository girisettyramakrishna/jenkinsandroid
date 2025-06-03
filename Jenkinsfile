pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Setup local.properties') {
            steps {
                sh 'echo "sdk.dir=/home/psmadmin/Android/Sdk" > local.properties'
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
                archiveArtifacts artifacts: '**/*.apk', fingerprint: true
            }
        }
    }
    post {
        failure {
            echo 'Build failed. Please check the logs.'
        }
    }
}
