pipeline {
    agent any

    environment {
        ANDROID_HOME = "/home/ubuntu/android-sdk"
        PATH+ANDROID = "${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools"
    }

    stages {
        stage('Environment Check') {
            steps {
                sh '''
                    echo "=== Build Environment ==="
                    echo "Java: $(java -version 2>&1 | head -n 1)"
                    echo "Android SDK: ${ANDROID_HOME}"
                    echo "sdk.dir=${ANDROID_HOME}" > local.properties
                '''
            }
        }

        stage('Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[
                        url: 'https://github.com/your-username/your-public-repo.git',
                        credentialsId: ''
                    ]]
                ])
                sh 'chmod +x gradlew'
            }
        }

        stage('Build') {
            parallel {
                stage('Debug Build') {
                    steps {
                        sh './gradlew assembleDebug --stacktrace --no-daemon'
                    }
                }
                stage('Release Build') {
                    when { branch 'main' }
                    steps {
                        sh './gradlew assembleRelease --stacktrace --no-daemon'
                    }
                }
            }
        }

        stage('Publish') {
            steps {
                archiveArtifacts artifacts: 'app/build/outputs/apk/**/*.apk', allowEmptyArchive: true
                stash name: 'apks', includes: 'app/build/outputs/apk/**/*.apk'
            }
        }
    }

    post {
        success {
            slackSend color: "good",
                     message: "SUCCESS: ${JOB_NAME} #${BUILD_NUMBER} \nAPKs: ${BUILD_URL}artifact/"
        }
        failure {
            slackSend color: "danger",
                     message: "FAILED: ${JOB_NAME} #${BUILD_NUMBER} \nLogs: ${BUILD_URL}console"
        }
    }
}
