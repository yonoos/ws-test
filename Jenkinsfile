pipeline {
    agent any
    
     tools { 
        maven 'M3' 
     }
    stages {
    
    	stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Location') {
            steps {
                sh 'pwd'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                sh ''' echo  "del" '''
            }
        }
    }
}