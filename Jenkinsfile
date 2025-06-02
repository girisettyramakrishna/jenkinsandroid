pipeline {
    agent any

    environment {
        ANDROID_HOME = "/home/ubuntu/android-sdk"
        JAVA_HOME = "/usr/lib/jvm/java-11-openjdk-amd64"
        GRADLE_HOME = "/opt/gradle/gradle-8.5"
        PATH = "${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:${JAVA_HOME}/bin:${GRADLE_HOME}/bin:${PATH}"
    }

    stages {
        stage('Environment Check') {
            steps {
                sh '''
                    echo "=== Environment Variables ==="
                    echo "Java version:"
                    java -version
                    echo "Android SDK path: $ANDROID_HOME"
                    echo "PATH: $PATH"
                    echo "sdk.dir=$ANDROID_HOME" > local.properties
                '''
            }
        }

        stage('Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    extensions: [],
                    userRemoteConfigs: [[
                        url: 'https://github.com/girisettyramakrishna/jenkinsandroid.git',
                        credentialsId: ''
                    ]]
                ])
                sh 'chmod +x gradlew'
            }
        }

        stage('Clean') {
            steps {
                sh './gradlew clean'
            }
        }

        stage('Build Debug APK') {
            steps {
                sh './gradlew assembleDebug --stacktrace --no-daemon'
            }
        }

        stage('Archive APK') {
            steps {
                archiveArtifacts artifacts: 'app/build/outputs/apk/**/*.apk', allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
        always {
            cleanWs()
        }
    }
}
