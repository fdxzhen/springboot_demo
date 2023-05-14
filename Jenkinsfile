pipeline {
    agent any

    tools {
        maven 'Maven 3.9.2'
        jdk 'JDK 1.11'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy') {
            steps {
                sh 'java -jar target/task_job-1.0-SNAPSHOT.jar'
            }
        }
    }
}
