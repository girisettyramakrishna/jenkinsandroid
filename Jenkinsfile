pipeline {
    agent any

    environment {
        JAVA_HOME = "/usr/lib/jvm/java-11-openjdk-amd64"
        ANDROID_HOME = "/home/ubuntu/android-sdk"
        GRADLE_HOME = "/opt/gradle/gradle-8.5"
        PATH+EXTRA = "${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools:${JAVA_HOME}/bin:${GRADLE_HOME}/bin"
    }

    stages {

        stage('Checkout SCM') {
            steps {
                echo "== Checking out source code =="
                checkout scm
            }
        }

        stage('Environment Check') {
            steps {
                echo "== Environment Variables =="
                sh 'java -version'
                sh 'gradle -v'
                sh 'echo $PATH'
                sh 'ls $ANDROID_HOME'
            }
        }

        stage('Clean') {
            steps {
                echo "== Cleaning project =="
                sh './gradlew clean'
            }
        }

        stage('Build Debug APK') {
            steps {
                echo "== Building APK =="
                sh './gradlew assembleDebug'
            }
        }

        stage('Archive APK') {
            steps {
                echo "== Archiving APK =="
                archiveArtifacts artifacts: '**/app/build/outputs/apk/debug/*.apk', fingerprint: true
            }
        }
    }

    post {
        failure {
            echo '❌ Build failed.'
        }
        success {
            echo '✅ Build succeeded.'
        }
    }
}
