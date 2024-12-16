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
       stage('Test') {
            steps {
                sh './mvnw test' //или ./gradlew test если gradle
            }
         }
        stage('Docker Build') {
          steps {
           script {
            dockerImage = docker.build("TestJava:${BUILD_NUMBER}", "./") // Замените image name
            }
          }
        }
       stage('Docker Push') {
          steps {
           script {
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