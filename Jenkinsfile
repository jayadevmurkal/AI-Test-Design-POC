pipeline {
    agent any

    tools {
        jdk 'JDK 17'
        maven 'Maven 3.9.16'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Framework Generator V3') {
            steps {
                dir('framework-generator-v3') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Generate Selenium Framework') {
            steps {
                dir('framework-generator-v3') {
                    bat 'mvn exec:java "-Dexec.mainClass=ai.framework.FrameworkGeneratorApplication"'
                }
            }
        }

        stage('Execute Generated Test Suite') {
            steps {
                dir('framework-generator-v3/generated-output') {
                    bat 'mvn clean test'
                }
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: 'framework-generator-v3/generated-output/target/surefire-reports/*.xml'

            archiveArtifacts artifacts: 'framework-generator-v3/generated-output/target/surefire-reports/**,framework-generator-v3/generated-output/reports/**',
                             allowEmptyArchive: true
        }

        success {
            echo 'V3 Selenium CI Pipeline completed successfully.'
        }

        failure {
            echo 'V3 Selenium CI Pipeline failed. Check the stage logs.'
        }
    }
}