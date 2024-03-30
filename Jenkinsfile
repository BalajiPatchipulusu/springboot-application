pipeline {
    agent any
    
    tools {
        maven 'MAVEN'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/BalajiPatchipulusu/springboot-application.git'
            }
        }

        stage('Build') {
            steps {
                    script {
                        bat 'mvn clean package'
                    }
            }
        }

        stage('Test') {
            steps {
                    script {
                        bat 'mvn test'
                    }
            }
        }
    }
}
