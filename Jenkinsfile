pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'main']],
                    userRemoteConfigs: [[url: 'https://github.com/balighbr/exspringboot.git']]
                ])
            }
        }
  stage('MVN CLEAN') {
              steps {
                 withMaven() {
                bat 'mvn clean compile'

             }
           }
          }
          stage('MVN COMPILE') {
                              steps {
                                  bat 'mvn compile'
                              }
                          }

                          stage('MVN PACKAGE') {
                              steps {
                                  bat 'mvn package'
                              }
                          }
                          stage('MVN TEST') {
                                                        steps {
                                                            bat 'mvn test'
                                                        }
                                                    }
                                                     stage('Docker login') {

                                                                                                           steps {
                                                                                                             bat 'echo "login Docker ...."'
                                                                                                             bat'docker login -u balighbr -p AZErty123@'
                                                                                                                        }  }
                                                                                           stage('Docker push') {

                                                                                                           steps {
                                                                                                               bat 'echo "Docker is pushing ...."'
                                                                                                           	bat 'docker push balighbr/demo3-0.0.1'
                                                                                                                        }  }
}}
