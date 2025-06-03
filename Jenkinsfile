pipeline {
    agent any

    environment {
        ANDROID_HOME = "/home/ubuntu/android-sdk"
        PATH = "${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/girisettyramakrishna/jenkinsandroid.git'
            }
        }

        stage('Set Permissions') {
            steps {
                sh 'chmod +x ./gradlew'
            }
        }

        stage('Configure SDK') {
            steps {
                sh '''
                    echo "sdk.dir=${ANDROID_HOME}" > local.properties
                '''
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
