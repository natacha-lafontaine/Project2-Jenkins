pipeline {
    agent any

    tools {
        maven "Maven386"
    }
    triggers {
        pollSCM('@midnight')
    }
    stages {
        stage('Compile') {
            steps {
                // Get the code from a GitHub repository
                git 'https://github.com/natacha-lafontaine/Project2-Jenkins.git'

                // To run Maven on a Windows agent
                bat "mvn clean package"
            }
        }
        stage('Test') {
            steps {
                // To run the Maven test on a Windows agent
                bat "mvn test"
            }
            post {
                // Record the test results and archive the war file.
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts 'target/*.war'
                }
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'b1a7aec0-8df5-42cd-a09e-e6f9a5edda90', path: '', url: 'http://ec2-34-226-123-209.compute-1.amazonaws.com:8080/')], contextPath: null, onFailure: false, war: 'target/*.war'
            }
        }
    }
}