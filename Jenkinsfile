pipeline {
    agent any
    
    environment {
        ANDROID_HOME = "/home/ubuntu/android-sdk"
        PATH = "$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools:$PATH"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', 
                url: 'https://github.com/girisettyramakrishna/jenkinsandroid.git'
            }
        }
        
        stage('Build') {
            steps {
                sh '''
                    chmod +x gradlew
                    ./gradlew assembleDebug
                '''
            }
        }
        
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'app/build/outputs/apk/debug/*.apk'
            }
        }
    }
}
