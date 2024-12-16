pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Milig01/TestJava.git', branch: 'main' // Замените URL и branch
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean install' //или ./gradlew clean build если gradle
            }
        }
        stage('Docker Build and Push') {
            steps {
                script {
                    dockerImage = docker.build("TestJava:${BUILD_NUMBER}", ".")  // Замените на свое имя образа
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials-id') {
                        dockerImage.push()
                    }
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}