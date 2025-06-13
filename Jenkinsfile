pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
               git 'https://github.com/mohantawar2830/RestAssuredAPI_Automation'
            }
        }
        stage('Build') {
            steps {
               sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
      post {
        success {
            echo "Build Success"
        }
        failure {
            echo "Build Failed"
        }
    }
    }
}
