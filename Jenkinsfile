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
                dir('path/to/project-directory') {
                    script {
                        bat 'mvn clean package'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                dir('path/to/project-directory') {
                    script {
                        bat 'mvn test'
                    }
                }
            }
        }
    }
}
