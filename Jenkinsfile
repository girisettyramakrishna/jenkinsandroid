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
                    echo "Java version:"
                    java -version
                    echo "Android SDK location: $ANDROID_HOME"
                    echo "sdk.dir=$ANDROID_HOME" > local.properties
                '''
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
