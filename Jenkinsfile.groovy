pipeline {
    agent any
    stages {
        stage('Build') {
            parallel {
                stage('mvn build') {
                    steps {
                        sh 'mvn clean install'
                    }
                }
                stage('Upload Artifacts') {
                    steps {
                        sh 'touch abc.txt'
                    }
                }
            }
        }
    }
    post {
        always {
            echo "post build stage"
        }
    }
}