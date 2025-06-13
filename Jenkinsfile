pipeline {
    agent any
    tools{
        maven 'Maven 3.9.10'
        jdk 'JDK17'
    }
    environment{
        JAVA_HOME = "${tool 'JDK17'}"
        PATH = "{env.JAVA_HOME}/bin
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/mohantawar2830/RestAssuredAPI_Automation'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
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
            echo 'Build finished (success or fail).'
        }
    }
}
