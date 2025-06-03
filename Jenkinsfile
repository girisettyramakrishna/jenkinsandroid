pipeline {
    agent any

    environment {
        ANDROID_HOME = "/opt/android-sdk/latest"
        PATH = "${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/cmdline-tools/latest/bin:${PATH}"
    }

    stages {
        stage('Prepare Workspace') {
            steps {
                deleteDir()
                checkout scm
            }
        }

        stage('Setup local.properties') {
            steps {
                sh '''
                    echo "sdk.dir=$ANDROID_HOME" > local.properties
                '''
            }
        }

        stage('Build APK') {
            steps {
                sh '''
                    chmod +x ./gradlew
                    ./gradlew assembleDebug
                '''
            }
        }

        stage('Archive APK') {
            steps {
                archiveArtifacts artifacts: '**/app/build/outputs/apk/debug/*.apk', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build succeeded. APK is archived.'
        }
        failure {
            echo '❌ Build failed. Please check the logs.'
        }
    }
}
