pipeline {
    agent any

    tools {
        jdk 'JDK25'
	        maven 'Maven3'
	    }

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://github.com/Revan-TY/DemoShop.git'
            }
        }

        stage('Build') {
            steps {
                withMaven {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Test') {
            steps {
                withMaven {
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
    }
}