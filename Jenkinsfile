pipeline {
    agent {
        docker {
            image 'docker:24.0.7-dind'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    tools {
        jdk 'Java 17'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Milig01/TestJava.git', branch: 'main' // Замените URL и branch
            }
        }
        stage('Build') {
            steps {
                sh 'chmod +x mvnw' // Only on Unix-like systems!
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