pipeline {
    agent any
    stages {
        stage('Build') {
            parallel {
                stage('mvn build') {
                    steps {
                        echo "execute mvn process"
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