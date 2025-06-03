pipeline {
    agent any

    environment {
        JAVA_HOME = "/usr/lib/jvm/java-11-openjdk-amd64"
        ANDROID_HOME = "/home/ubuntu/android-sdk"
        GRADLE_HOME = "/opt/gradle/gradle-8.5"
        // Append extra paths without breaking Jenkins
        PATH+ANDROID = "${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools"
        PATH+JAVA = "${JAVA_HOME}/bin"
        PATH+GRADLE = "${GRADLE_HOME}/bin"
    }

    stages {

        stage('Checkout SCM') {
            steps {
                echo "✅ Checkout Source Code"
                checkout scm
            }
        }

        stage('Environment Check') {
            steps {
                echo "🔍 Checking Environment"
                sh 'java -version'
                sh 'gradle -v'
                sh 'echo PATH=$PATH'
                sh 'ls $ANDROID_HOME'
                sh 'ls $GRADLE_HOME'
            }
        }

        stage('Clean') {
            steps {
                echo "🧹 Cleaning the project"
                sh './gradlew clean'
            }
        }

        stage('Build Debug APK') {
            steps {
                echo "🛠️ Building APK"
                sh './gradlew assembleDebug'
            }
        }

        stage('Archive APK') {
            steps {
                echo "📦 Archiving APK"
                archiveArtifacts artifacts: '**/app/build/outputs/apk/debug/*.apk', fingerprint: true
            }
        }
    }

    post {
        success {
            echo "🎉 Build Success"
        }
        failure {
            echo "❌ Build Failed"
        }
    }
}
