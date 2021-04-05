pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {

        stage('pull from github') {
            steps {
                git 'https://github.com/mhmdmaani/mobile-project'
            }

        }
        stage('Build') {
            steps {
                sh 'java -version'
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn verify'
                sh 'mvn test'
            }
        }
        stage('package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('build docker image') {
            steps {
                sh 'docker build -t osamahkh/mobilestore:latest .'
            }
        }
        stage('push to docker hub') {
            steps {
                withDockerRegistry([credentialsId: "docker-hub-credentials",url:'']) {
                    sh 'docker push osamahkh/mobilestore:latest'
                }
            }
        }
    }
    post {
       always {
           echo 'sending email'
           emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                            recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                            subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
       }
    }
}
