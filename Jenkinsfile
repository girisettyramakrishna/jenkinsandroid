pipeline {
    agent any

    environment {
        ANDROID_HOME = "/home/psmadmin/Android/Sdk"
        PATH = "${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/cmdline-tools/latest/bin:${PATH}"
    }

    stages {
        stage('Prepare Workspace') {
            steps {
                // Clean previous builds
                deleteDir()
                // Checkout source code
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
                sh './gradlew assembleDebug'
            }
        }

        stage('Archive APK') {
            steps {
                archiveArtifacts artifacts: '**/app/build/outputs/apk/debug/*.apk', fingerprint: true
            }
        }
    }

    post {
        failure {
            echo 'Build failed. Please check the logs.'
        }
        success {
            echo 'Build succeeded. APK is archived.'
        }
    }
}
